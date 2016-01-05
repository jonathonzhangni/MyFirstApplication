package com.example.johnnyzhang.myapplication.ui.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.johnnyzhang.myapplication.R;
import com.example.johnnyzhang.myapplication.ui.fragment.FragmentOne;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button bt1,replaceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment = (Button) findViewById(R.id.btReplaceFragment);
        replaceFragment.setOnClickListener(this);
        
        System.out.println("onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onRause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onRause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btReplaceFragment:
                loadFragment();
                break;
        }
    }

    private void loadFragment(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentOne fragmentOne = new FragmentOne();
        fragmentTransaction.replace(R.id.fragment_container, fragmentOne, "tag1");
        fragmentTransaction.commit();
    }


}
