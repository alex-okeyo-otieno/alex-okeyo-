package com.abc.sqlitedatabasefullexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="contact_db";
    private static final int DATABASE_VERSION=1;


    public static final String CREATE_TABLE="create table "+ContractContact.ContactEntry.TABLE_TITLE+ "("
            +ContractContact.ContactEntry.CONTACT_ID + "number," +ContractContact.ContactEntry.NAME +"text," +
            ContractContact.ContactEntry.EMAIL + "text);";

    public static final String DROP_TABLE="drop table if exists " +ContractContact.ContactEntry.TABLE_TITLE ;



    public ContactHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("Database operation","Database created");


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        Log.d("Database operation","Table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);

    }

    public void addContactI(String id,String name,String email,SQLiteDatabase db){
        ContentValues contentValues =new ContentValues();
        contentValues.put(ContractContact.ContactEntry.CONTACT_ID,id);
        contentValues.put(ContractContact.ContactEntry.NAME,name);
        contentValues.put(ContractContact.ContactEntry.EMAIL,email);

        db.insert(ContractContact.ContactEntry.TABLE_TITLE,null,contentValues);
        Log.d("Database operation","One row affected");


    }

    public Cursor ReadContacts(SQLiteDatabase database){
        String [] projections={ContractContact.ContactEntry.CONTACT_ID,ContractContact.ContactEntry.NAME,ContractContact.ContactEntry.EMAIL};
        Cursor cursor=database.query(ContractContact.ContactEntry.TABLE_TITLE,projections,null,null,null,null,null);
        return cursor;

    }

    public void UpdateContacts(int id,String name,String email,SQLiteDatabase database){
        ContentValues contentValues=new ContentValues();
        contentValues.put(ContractContact.ContactEntry.CONTACT_ID,id);
        contentValues.put(ContractContact.ContactEntry.NAME,name);
        contentValues.put(ContractContact.ContactEntry.EMAIL,email);

        String selection=ContractContact.ContactEntry.CONTACT_ID+" = "+ id;

        database.update(ContractContact.ContactEntry.TABLE_TITLE,contentValues,selection,null);



    }
    public  void DeleteContact(int id,SQLiteDatabase database){
        String selection=ContractContact.ContactEntry.CONTACT_ID+" = "+id;

        database.delete(ContractContact.ContactEntry.TABLE_TITLE,selection,null);
    }
}
