package com.example.lenovo.rpl;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;

import com.example.lenovo.rpl.moddel.profilelist;
import com.example.lenovo.rpl.moddel.profilelist;
import com.example.lenovo.rpl.remote.ApiClient;
import com.example.lenovo.rpl.remote.ApiInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText ambilNIM ,ambilPass; //Deklarasi object dari class EdiText
    String nim,pass, dbnim, dbnama, dbpass, dbjk, dbprodi, dbfakultas, dbdpa, dbtlogin;
    ApiInterface mApiInterface;
    Button login;
    Context mContext=this;
    ProgressDialog loading;
    int statusCode;
    //Activity context = this;



    Button buttonlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);


        buttonlogin = (Button) findViewById(R.id.buttonlogin);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLogin();

            }
        });

    }

    private void requestLogin(){
        ambilNIM = (EditText) findViewById(R.id.NIM);
        ambilPass = (EditText) findViewById(R.id.password);
        nim = ambilNIM.getText().toString();
        pass = ambilPass.getText().toString();
        mApiInterface.getUser(nim, pass)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(Login.this, "Response Sukses"+ nim+" "+pass, Toast.LENGTH_SHORT).show();
                        if (response.isSuccessful()){
                            Toast.makeText(Login.this, "Response Suksesful " , Toast.LENGTH_SHORT).show();

                            //loading.dismiss();
                            try {
                                Toast.makeText(mContext, "Response TRY", Toast.LENGTH_SHORT).show();
                                JSONObject hasil = new JSONObject(response.body().string());
                                if (hasil.getString("isSuccess").equals("TRUE")  ){
                                    dbnim = hasil.getJSONObject("mahasiswa").getString("nim");
                                    dbnama = hasil.getJSONObject("mahasiswa").getString("nama");
                                    dbpass = hasil.getJSONObject("mahasiswa").getString("pass");
                                    dbprodi = hasil.getJSONObject("mahasiswa").getString("prodi");
                                    dbfakultas = hasil.getJSONObject("mahasiswa").getString("fakultas");
                                    dbdpa = hasil.getJSONObject("mahasiswa").getString("dpa");
                                    dbtlogin = hasil.getJSONObject("mahasiswa").getString("total_login");

                                    Toast.makeText(Login.this, "Response Sukses"+ dbnim+" "+dbnama+
                                            " "+ dbpass+" "+ dbprodi +" "+ dbfakultas, Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(Login.this, Navigation.class);
                                    Bundle extras = new Bundle();

                                    extras.putString("dbnim",dbnim);
                                    extras.putString("dbnama",dbnama);
                                    extras.putString("dbprodi",dbprodi);
                                    extras.putString("dbfakultas",dbfakultas);
                                    extras.putString("dbdpa",dbdpa);
                                    extras.putString("dbtlogin",dbtlogin);

                                    i.putExtras(extras);
                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                                    startActivity(i);


                                    finish();
                                } else {
//                                    // Jika login gagal
                                    Toast.makeText(Login.this, "Akun Tidak Ada ", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                Toast.makeText(mContext, "Response Gagal 1", Toast.LENGTH_SHORT).show();
//                                e.printStackTrace();
                            } catch (IOException e) {
                                Toast.makeText(mContext, "Response Gagal 2", Toast.LENGTH_SHORT).show();
//                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(Login.this, "Response Gagal 130", Toast.LENGTH_SHORT).show();

                            //loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(mContext, "Response Gagal Load"+ nim+" "+pass, Toast.LENGTH_SHORT).show();
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
//                        loading.dismiss();

//                        dbnim = "16650034";
//                        dbnama = "Syafaat Adi N";
//                        dbpass = "111";
//                        dbprodi = "Teknik Informatika";
//                        dbfakultas = "Sains dan Teknologi";
//                        dbdpa = "Agung Fatwanto,Ph.d.";
//                        dbtlogin = "999";
//
//                        Intent i = new Intent(getApplicationContext(), Navigation.class);
//                        Bundle extras = new Bundle();
//
//                        extras.putString("dbnim",dbnim);
//                        extras.putString("dbnama",dbnama);
//                        extras.putString("dbprodi",dbprodi);
//                        extras.putString("dbfakultas",dbfakultas);
//                        extras.putString("dbdpa",dbdpa);
//                        extras.putString("dbtlogin",dbtlogin);
//
//                        i.putExtras(extras);
//
//                        startActivity(i);
                    }
                });
    }
}
