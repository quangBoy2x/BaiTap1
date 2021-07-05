package com.example.baitap1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvData;
    Button btnAdd, btnDelete;
    public static ArrayList<Contact> contacts = new ArrayList<>();
    DataBase dataBase = new DataBase(this);
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map();
        dataBase.addContact(new Contact("siêu giang béo", "0337030504", 0));
        dataBase.addContact(new Contact("huy", "0337030504", 1));
        dataBase.addContact(new Contact("siêu quang huy", "0386356200", 1));
        contacts = (ArrayList<Contact>) dataBase.getAll();
        adapter = new ContactAdapter(this, contacts);
        lvData.setAdapter(adapter);


        //khi bấm nút xóa
        btnDelete.setOnClickListener(v -> {
            DeleteData();
        });



    }

    private void DeleteData() {

        new AlertDialog.Builder(this).setTitle("Xóa dữ liệu").setMessage("Bạn chắc chắn muốn xóa?")
                .setPositiveButton("có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(int i = 0;i<contacts.size();i++){
                            if(contacts.get(i).getStatus() == 1){
                                //check box nào được chọn thì xóa nó đi
                                Log.d("deletedata", contacts.get(i).toString());
                                dataBase.delete(contacts.get(i));
//                                contacts.remove(contacts.get(i));
//                                adapter.notifyDataSetChanged();
                            }
                        }
                        contacts = (ArrayList<Contact>) dataBase.getAll();
                        for(int i = 0;i<contacts.size();i++){
                            contacts.get(i).setStatus(0);
                        }
                        adapter = new ContactAdapter(MainActivity.this, contacts);
                        lvData.setAdapter(adapter);

                    }

                })
                .setNegativeButton("Không", null)
                .show();


    }

    private void Map(){
        lvData = (ListView) findViewById(R.id.lvData);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
    }


}