package com.abc.sqlitedatabasefullexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button bnSave,bnView,bnUpdate,bnDelete;

    OpenDbOperation openDbOperation;
    public interface OpenDbOperation{
        public void operationPerformed(int method);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.frgment_home,container,false);

        bnSave=view.findViewById(R.id.btn_add_contact);
        bnView=view.findViewById(R.id.btn_view);
        bnUpdate=view.findViewById(R.id.btn_update);
        bnDelete=view.findViewById(R.id.btn_delete);
        bnSave.setOnClickListener(this);
        bnView.setOnClickListener(this);
        bnUpdate.setOnClickListener(this);
        bnDelete.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_contact:
                openDbOperation.operationPerformed(0);
                break;
            case R.id.btn_view:
                openDbOperation.operationPerformed(1);
                break;
            case R.id.btn_update:
                openDbOperation.operationPerformed(2);
                break;
            case R.id.btn_delete:
                openDbOperation.operationPerformed(3);
                break;



        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity=(Activity) context;

        try {
            openDbOperation=(OpenDbOperation)activity;

        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"Must implement the interface methods");

        }
    }
}
