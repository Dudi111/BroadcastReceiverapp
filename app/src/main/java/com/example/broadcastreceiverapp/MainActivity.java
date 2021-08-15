package com.example.broadcastreceiverapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public  class MainActivity extends AppCompatActivity {
    private static TextView text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.tvtext);

      registerLocalreceiver();
    }
    private void registerLocalreceiver(){
        broadcastreceiver broadcastreceiver=new broadcastreceiver();
        IntentFilter intentFilter=new IntentFilter("com.example.broadcastsender");
       registerReceiver(broadcastreceiver,intentFilter);

    }

    public static class broadcastreceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            text.setText(intent.getStringExtra("data"));
            Toast.makeText(context,"hiiii",Toast.LENGTH_SHORT).show();
        }
    }

}