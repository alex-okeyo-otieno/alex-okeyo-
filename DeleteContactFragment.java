package com.abc.sqlitedatabasefullexample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteContactFragment extends Fragment {
    private EditText delete_id;
    private Button btn_delete_id;


    public DeleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_delete_contact, container, false);

        delete_id=view.findViewById(R.id.txt_contact_id);
        btn_delete_id=view.findViewById(R.id.btn_delete_contact);
        btn_delete_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();

            }
        });
        return view;
    }
    public  void deleteContact(){

        ContactHelper contactHelper=new ContactHelper(getActivity());
        SQLiteDatabase sqLiteDatabase=contactHelper.getWritableDatabase();

        int Id=Integer.parseInt(delete_id.getText().toString());
        contactHelper.DeleteContact(Id,sqLiteDatabase);
        contactHelper.close();
        delete_id.setText("");

        Toast.makeText(getActivity(),"Contact deleted..",Toast.LENGTH_SHORT).show();


    }

}
