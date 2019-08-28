package com.example.broadcastreceiveractividad1;


import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;




public class MainActivity extends AppCompatActivity {
    MensajeRecibido mensaje = new MensajeRecibido();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
        && checkSelfPermission(Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS},1000);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intel = new IntentFilter("provider.Telephony.SMS_RECEIVED");
        registerReceiver(mensaje,intel);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mensaje);
    }



}
