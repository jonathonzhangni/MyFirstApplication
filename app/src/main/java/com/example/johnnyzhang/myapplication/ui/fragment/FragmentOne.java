package com.example.johnnyzhang.myapplication.ui.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.johnnyzhang.myapplication.R;

/**
 * Created by johnny.zhang on 4/1/2016.
 */

public class FragmentOne extends Fragment implements View.OnClickListener {
    private Button btSentMessage;
    private EditText etname, etphone;
    private String name, phone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        btSentMessage = (Button) view.findViewById(R.id.btSentMessage);
        btSentMessage.setOnClickListener(this);

        etname = (EditText) view.findViewById(R.id.etname);
        etphone = (EditText) view.findViewById(R.id.etphone);

        System.out.println("onCreate1");

        return view;
    }


    public void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("onRause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onRause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btSentMessage:
                name = etname.getText().toString();
                phone = etphone.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("phone", phone);
                myFragment(bundle);

                break;
        }
    }

    private void myFragment(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentUserInfo fragmentUserInfo = new FragmentUserInfo();
        fragmentUserInfo.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragment_container, fragmentUserInfo, "tag1");

        //
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

}
