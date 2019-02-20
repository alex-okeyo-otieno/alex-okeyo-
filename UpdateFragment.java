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
public class UpdateFragment extends Fragment {

    private EditText txt_id,txt_name,txt_email;
    private Button btn_update_save;


    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view= inflater.inflate(R.layout.fragment_update, container, false);
        txt_id=view.findViewById(R.id.txt_update_contact_id);
        txt_email=view.findViewById(R.id.txt_update_email);
        txt_name=view.findViewById(R.id.txt_update_name);

        btn_update_save=view.findViewById(R.id.btn_update);
        btn_update_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateContact();

            }
        });

        return view;
    }
    private void UpdateContact(){
        int id=Integer.parseInt(txt_id.getText().toString());
        String name=txt_name.getText().toString();
        String email=txt_email.getText().toString();

        ContactHelper contactHelper=new ContactHelper(getActivity());
        SQLiteDatabase database=contactHelper.getWritableDatabase();

        contactHelper.UpdateContacts(id,name,email,database);

        contactHelper.close();
        Toast.makeText(getActivity(),"Contact Updated successfully",Toast.LENGTH_SHORT).show();
        txt_id.setText("");
        txt_name.setText("");
        txt_email.setText("");


    }

}
