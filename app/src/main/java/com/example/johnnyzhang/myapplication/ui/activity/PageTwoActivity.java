package com.example.johnnyzhang.myapplication.ui.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.johnnyzhang.myapplication.R;
import com.example.johnnyzhang.myapplication.ui.fragment.FragmentOne;
import com.example.johnnyzhang.myapplication.ui.fragment.FragmentTwo;

/**
 * Created by johnny.zhang on 4/1/2016.
 */

public class PageTwoActivity extends Activity implements View.OnClickListener {

    private Button bt2,btReplaceFragment2;
    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagetwo);

        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
        btReplaceFragment2 = (Button) findViewById(R.id.btReplaceFragment2);
        btReplaceFragment2.setOnClickListener(this);


        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        FragmentTwo newFragment = new FragmentTwo();
// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
        transaction.replace(R.id.fragment_container2, newFragment);
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt2:
                Intent openPage1 = new Intent(PageTwoActivity.this, MainActivity.class);
                startActivity(openPage1);
                this.finish();
                break;

            case R.id.btReplaceFragment2:
                //Bundle args = new Bundle();
                // args.put

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentOne fragmentOne = new FragmentOne();


                fragmentTransaction.replace(R.id.fragment_container2, fragmentOne, "tag1");
                fragmentTransaction.commit();
                break;
        }
    }
}
