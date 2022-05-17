package com.example.bth_9;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bth_9.model.Contact;

import java.util.ArrayList;

public class DanhBa extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSIONS = 1001;
    ListView lvDanhBa;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        addControl();
        showAllContactFromDevice();
    }

    private void showAllContactFromDevice() {
        //Lấy Liên hệ thông qua ContactContract
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri,null,null,null,null);
        dsDanhBa.clear();
        while(cursor.moveToNext()){
            //Lấy thông tin tên trong ds
            String tenCotName = ContactsContract.Contacts.DISPLAY_NAME;
            //Lấy thông tin sđt trong ds
            String tenCotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            //Lấy vị trí cột Name
            int viTriCotName = cursor.getColumnIndex(tenCotName);
            int vitriCotPhone = cursor.getColumnIndex(tenCotPhone);
            //Lấy dữ liệu trong các cột
            String name = cursor.getString(viTriCotName);
            String phone = cursor.getString(vitriCotPhone);
            //Đưa vào mảng
            Contact contact = new Contact(name,phone);
            dsDanhBa.add(contact);
            adapterDanhBa.notifyDataSetChanged();
        }
    }

    private void addControl() {
        lvDanhBa = findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<>(DanhBa.this, android.R.layout.simple_list_item_1,dsDanhBa);
        lvDanhBa.setAdapter(adapterDanhBa);
    }
}