package br.com.igti.projetohelloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

public class BatteryLowReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(Objects.equals(intent.getAction(), Intent.ACTION_BATTERY_LOW)){
            // TODO IMPLEMENTAR AGLO AQUI
            Log.d("BatteryLowReceiver","Atenção!!! Bateria Fraca");
        }
    }
}
