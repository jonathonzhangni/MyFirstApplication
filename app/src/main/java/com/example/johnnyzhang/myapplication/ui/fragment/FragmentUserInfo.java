package com.example.johnnyzhang.myapplication.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.johnnyzhang.myapplication.R;

import org.w3c.dom.Text;

/**
 * Created by johnny.zhang on 4/1/2016.
 */

public class FragmentUserInfo extends Fragment{
    private TextView tvname,tvphone;
    private String name,phone;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_info,container,false);

        name = getArguments().getString("name");
        phone = getArguments().getString("phone");

        tvname = (TextView) view.findViewById(R.id.tvgetname2);
        tvname.setText(name);

        tvphone = (TextView) view.findViewById(R.id.tvgetphone2);
        tvphone.setText(phone);

        return view;
    }
}
