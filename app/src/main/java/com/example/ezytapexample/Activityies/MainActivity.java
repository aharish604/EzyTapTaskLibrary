package com.example.ezytapexample.Activityies;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezytapexample.MainActivityPresenter;
import com.example.ezytapexample.Model.DataModel;
import com.example.ezytapexample.Network.APIResponse;
import com.example.ezytapexample.R;
import com.example.ezytapexample.Utils.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements APIResponse {

    MainActivityPresenter presenter = null;
    ProgressDialog progressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntializeObjetcs();

        Button btn = findViewById(R.id.getdata);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }


    private void IntializeObjetcs() {
        presenter = new MainActivityPresenter(MainActivity.this, this);

        presenter.getData();
    }

    @Override
    public void onSuccess(Object object) {

        DataModel bean = (DataModel) object;

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("uidata", bean);
        startActivity(intent);

    }

    @Override
    public void onServerError(String error) {
        dismissProgress();
        Constants.displayLongToast(MainActivity.this, error);
    }


    @Override
    public void showProgress() {
        progressDialog = Constants.showProgressDialog(MainActivity.this, "");
    }

    @Override
    public void dismissProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void networkError(String error) {
        dismissProgress();
        Constants.displayLongToast(MainActivity.this, error.toString());
    }

}