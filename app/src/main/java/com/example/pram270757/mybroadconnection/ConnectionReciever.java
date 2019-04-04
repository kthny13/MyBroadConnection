package com.example.pram270757.mybroadconnection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class ConnectionReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
      if(intent.getAction().equals("com.example.pram270757.mybroadconnection.SOME_ACTION")){
          Toast.makeText(context,"SOME_ACTION is recieved",Toast.LENGTH_LONG).show();
      }
      else{
          ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
          NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
          boolean isConnected = activeNetwork != null &&
                  activeNetwork.isConnectedOrConnecting();
          if (isConnected) {
              try {
                  Toast.makeText(context, "Network is connected", Toast.LENGTH_LONG).show();
              } catch (Exception e) {
                  e.printStackTrace();
              }
          } else {
              Toast.makeText(context, "Network is changed or reconnected", Toast.LENGTH_LONG).show();
          }
      }

    }
}
