package com.example.lenovo.rpl;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class Dummy extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dummy, container, false);

        String nama = this.getArguments().getString("dbnama");
        TextView text = view.findViewById(R.id.tulisan);

        text.setText(nama);
        return view;
    }
}
