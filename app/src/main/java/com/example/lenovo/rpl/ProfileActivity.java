package com.example.lenovo.rpl;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileActivity extends Fragment {
    ImageView profile;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);


//        i.putExtra("dbnim",dbnim);
//        i.putExtra("dbnama",dbnama);
//        i.putExtra("dbprodi",dbprodi);
//        i.putExtra("dbfakultas",dbfakultas);
//        i.putExtra("dbdpa",dbdpa);
//        i.putExtra("dbtlogin",dbtlogin);

        String nama = this.getArguments().getString("dbnama");
        String nim = this.getArguments().getString("dbnim");
        String prodi = this.getArguments().getString("dbprodi");
        String fakultas = this.getArguments().getString("dbfakultas");
        String dpa = this.getArguments().getString("dbdpa");
        String tlogin = this.getArguments().getString("dbtlogin");

        TextView tnama = view.findViewById(R.id.tv_name);
        TextView tnim = view.findViewById(R.id.tv_nim);
        TextView tuser = view.findViewById(R.id.ProUsername);
        TextView tprodi = view.findViewById(R.id.ProProdi);
        TextView tfakultas = view.findViewById(R.id.ProFakultas);
        TextView tdpa = view.findViewById(R.id.ProDPA);
        TextView ttlogin = view.findViewById(R.id.ProTotalLogin);

        tnama.setText(nama);
        tnim.setText(nim);
        tuser.setText(nim);
        tprodi.setText(prodi);
        tfakultas.setText(fakultas);
        tdpa.setText(dpa);
        ttlogin.setText(tlogin);

        return view;


    }
}
