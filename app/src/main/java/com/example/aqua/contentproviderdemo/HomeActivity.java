package com.example.aqua.contentproviderdemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ContentResolver cr;
    ArrayList nlist;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cr=getContentResolver();
        recyclerView= (RecyclerView) findViewById(R.id.recyclerviewrv);

        Cursor cursor=cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HomeActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
       // String[] columns={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};
/*
        String contactName=null;
        if(cursor.moveToFirst())
        {

            contactName=cursor.getString(0);


        }
        System.out.println(contactName);

while(cursor.moveToNext())
{

   contactName= cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

    System.out.println(contactName);
    nlist.add(contactName);

}*/


        Adapter adapter=new Adapter(cursor,HomeActivity.this);
        recyclerView.setAdapter(adapter);

    }
}
