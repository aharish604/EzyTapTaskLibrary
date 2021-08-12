package com.example.ezytapexample.Utils;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.ezytapexample.R;

public class Constants {

    public static String BASE_URL = "https://demo.ezetap.com/";

    public static ProgressDialog showProgressDialog(Context mContext, String message) {
        ProgressDialog pdLoadDialog = null;
        try {
            pdLoadDialog = ProgressDialog.show(mContext, null, null, true);
            pdLoadDialog.setContentView(R.layout.elemento_progress_splash);
            pdLoadDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            pdLoadDialog.show();
            pdLoadDialog.setCancelable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pdLoadDialog;
    }

    public static void displayLongToast(Context mContext, String message) {

        if(!message.equalsIgnoreCase("friend list")) {
            try {
                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("data toast:-"+mContext.getClass().toString());

        }
    }




}
