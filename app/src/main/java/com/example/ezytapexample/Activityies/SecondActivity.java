package com.example.ezytapexample.Activityies;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.ezytapexample.Model.DataModel;
import com.example.ezytapexample.R;

import static java.security.AccessController.getContext;

public class SecondActivity extends AppCompatActivity {

    DataModel uidata=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getSerializableExtra("uidata") != null) {
                uidata = (DataModel) intent.getSerializableExtra("uidata");
            }
        }

        TextView tv = findViewById(R.id.displayui);
        ImageView img_view = findViewById(R.id.logo);

        String uiviews="";

        for(DataModel.Uidatum obj : uidata.getUidata())
        {

            uiviews = uiviews+"\n"+obj.getUitype();

        }

        tv.setText(uiviews);

        Glide.with(SecondActivity.this)
                .load(uidata.getLogoUrl())
                .into(img_view);

    }
}