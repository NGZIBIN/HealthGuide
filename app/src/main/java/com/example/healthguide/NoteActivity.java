package com.example.healthguide;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NoteActivity extends AppCompatActivity {
    ListView lvData;

    SQLiteDatabase db;
    NoteBDHelper noteDB;
    Cursor cursor;
    NoteAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        lvData = findViewById(R.id.lvData);

        noteDB = new NoteBDHelper(getApplicationContext());
        db = noteDB.getReadableDatabase();
        cursor = noteDB.getAllDataForList();
        listAdapter = new NoteAdapter(getApplicationContext(), R.layout.row);
        lvData.setAdapter(listAdapter);
        if (cursor.moveToFirst()) {
            do {
                String desc, date;
                Integer id;
                id = cursor.getInt(0);
                desc = cursor.getString(1);
                date = cursor.getString(2);


                Note note = new Note(id, desc, date);
                listAdapter.add(note);
                listAdapter.notifyDataSetChanged();

            }
            while (cursor.moveToNext());
        }


        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if(ActivityCompat.checkSelfPermission(NoteActivity.this,
                                Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                            ActivityCompat.requestPermissions(NoteActivity.this,
                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
                        return;
}
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                        intent.setType("image/*");
                        startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            final ImageView imageView = findViewById(R.id.imageView);
            final List<Bitmap> bitmaps = new ArrayList<>();
            ClipData clipData = data.getClipData();

            if (clipData != null) {
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    Uri imageUrl = clipData.getItemAt(i).getUri();

                    try {
                        InputStream is = getContentResolver().openInputStream(imageUrl);
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        bitmaps.add(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                Uri imageUri = data.getData();

                try {
                    InputStream is = getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    bitmaps.add(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            new Thread(new Runnable() {
                @Override
                public void run() {

                    for(final Bitmap b : bitmaps){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                imageView.setImageBitmap(b);
                            }
                        });
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    public void addNote(View view){
        LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewDialog = inflater.inflate(R.layout.dialog, null);

        final EditText etInputDesc = viewDialog.findViewById(R.id.Desc);
        final EditText etInputDate = viewDialog.findViewById(R.id.shopDate);
        final ImageView btnDatePicker = viewDialog.findViewById(R.id.btnDate);

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        etInputDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                };
                // Create the DatePicker Dialog
                Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog myDateDialog = new DatePickerDialog(NoteActivity.this,
                        myDateListener, mYear, mMonth, mDay);
                myDateDialog.show();

            }
        });

        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String cDate = date.format(new Date());
        etInputDate.setText(cDate);

        AlertDialog.Builder myBuilder = new AlertDialog.Builder(NoteActivity.this);
        myBuilder.setView(viewDialog);
        myBuilder.setTitle("Add New");
        myBuilder.setCancelable(false);
        myBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int total = 0;
                String addDesc = etInputDesc.getText().toString();
                String addDate = etInputDate.getText().toString();


                if(addDesc.isEmpty()){
                    etInputDesc.setError("Please enter a Description");
                }
                else if(addDate.isEmpty()){
                    etInputDate.setError("Please enter a Date");
                }
                else{
                    NoteBDHelper helper = new NoteBDHelper(NoteActivity.this);
                    ArrayList<Note> data = helper.getAllData();

                    long row = helper.insertData(addDesc, addDate);
                    helper.close();

                    if(row != -1){

                        Toast.makeText(NoteActivity.this,"Added Successfully!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        myBuilder.setNegativeButton("Cancel", null);
        AlertDialog myDialog = myBuilder.create();
        myDialog.show();

    }
}
