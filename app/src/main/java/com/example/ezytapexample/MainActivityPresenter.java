package com.example.ezytapexample;

import android.app.Activity;
import android.content.Context;

import com.example.ezytapexample.Model.DataModel;
import com.example.ezytapexample.Network.APIInterface;
import com.example.ezytapexample.Network.APIResponse;
import com.example.ezytapexample.Network.RequestClient;
import com.example.ezytapexample.Utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivityPresenter {


    Context mcontext;
    APIResponse apiResponse;
    public MainActivityPresenter(Context mContext, APIResponse apiResponse) {
        this.mcontext = mContext;
        this.apiResponse = apiResponse;
    }

    public void getData() {
        ((Activity) mcontext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                apiResponse.showProgress();
            }
        });

        try {
            if (Constants.isNetworkAvailable(mcontext)) {
                Call<DataModel> call = RequestClient.getClient().create(APIInterface.class).getData();
                call.enqueue(new Callback<DataModel>() {
                    @Override
                    public void onResponse(Call<DataModel> call, retrofit2.Response<DataModel> response) {
                        try {
                            DataModel responsebean = response.body();
                            apiResponse.dismissProgress();
                            apiResponse.onSuccess(responsebean);

                        } catch (Exception e) {
                            apiResponse.dismissProgress();
                            apiResponse.onServerError(mcontext.getResources().getString(R.string.server_error));
                        }
                    }

                    @Override
                    public void onFailure(Call<DataModel> call, Throwable t) {
                        call.cancel();

                        ((Activity) mcontext).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if (apiResponse != null) {
                                    apiResponse.dismissProgress();
                                }

                            }
                        });
                        apiResponse.onServerError(mcontext.getResources().getString(R.string.server_error));
                    }
                });
            } else {
                apiResponse.networkError(mcontext.getResources().getString(R.string.check_network));
            }
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse.onServerError(mcontext.getResources().getString(R.string.server_error));
        }


    }



}
