package com.abc.sqlitedatabasefullexample;

import android.content.Context;
import android.provider.ContactsContract;

public final class ContractContact {

    private ContractContact(){}
    public static class ContactEntry{
        public static final String TABLE_TITLE="contact_info";
        public static final String CONTACT_ID="contact_id";
        public static final String NAME="name";
        public static final String EMAIL="email";

    }


}
