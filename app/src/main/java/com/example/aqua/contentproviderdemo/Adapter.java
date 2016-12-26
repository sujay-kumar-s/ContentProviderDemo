package com.example.aqua.contentproviderdemo;

import android.content.Context;
import android.database.Cursor;
import android.inputmethodservice.Keyboard;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aqua on 12/23/2016.
 */

public class Adapter extends RecyclerView.Adapter {
    Cursor cursor;
    Context ctx;
    Adapter(Cursor cursor, Context ctx)
    {
        this.cursor=cursor;
        this.ctx=ctx;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ctx).inflate(R.layout.row,null,false);
        RowHolder rowHolder=new RowHolder(v);


        return rowHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        cursor.moveToPosition(position);
        String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
        String number=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        RowHolder rowHolder= (RowHolder) holder;
        rowHolder.nametv.setText(name);
        rowHolder.numbertv.setText(number);
        Log.d("contact",name+" =============>"+number);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }
    class RowHolder extends RecyclerView.ViewHolder
    {
        TextView nametv;
        TextView numbertv;
        public RowHolder(View itemView) {
            super(itemView);
            nametv= (TextView) itemView.findViewById(R.id.nametv);
            numbertv= (TextView) itemView.findViewById(R.id.numbertv);
        }
    }
}
