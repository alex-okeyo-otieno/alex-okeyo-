package com.abc.sqlitedatabasefullexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ReadContacts extends Fragment {

    private TextView txt_display;

    public ReadContacts(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_read_contacts,container,false);

       txt_display=view.findViewById(R.id.txt_display);
        readContact();
        return view;
    }

    public void  readContact(){
        ContactHelper contactHelper=new ContactHelper(getActivity());
        SQLiteDatabase sqLiteDatabase=contactHelper.getReadableDatabase();

        Cursor cursor=contactHelper.ReadContacts(sqLiteDatabase);

        String info="";

        while(cursor.moveToNext()){

            String id=Integer.toString(cursor.getInt(cursor.getColumnIndex(ContractContact.ContactEntry.CONTACT_ID)));
            String name=getString(cursor.getColumnIndex(ContractContact.ContactEntry.NAME));
            String email=getString(cursor.getColumnIndex(ContractContact.ContactEntry.EMAIL));
            info=info+"\n\n ID : "+id+"\n Name : "+name+"\n Email : "+email;
        }
            txt_display.setText(info);
        contactHelper.close();
    }

}
