package br.com.igti.projetohelloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Tela2Activity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(Objects.equals(intent.getAction(), Intent.ACTION_BATTERY_CHANGED)){
                Toast.makeText(getApplicationContext(), "Atenção!!! Bateria Fraca", Toast.LENGTH_SHORT).show();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        configurandoListView();

    }

    private void configurandoBoradcastReceiver() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        this.registerReceiver(broadcastReceiver, filter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        configurandoBoradcastReceiver();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    private void configurandoListView() {
        List<String> items = recuperandoListaMembros();
        ListView lv = findViewById(R.id.lista_membros);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lv.setAdapter(adapter);
    }

    private List<String> recuperandoListaMembros() {
        Intent intent = getIntent();
        String[] membros = intent.getStringArrayExtra("membros");
        if (membros != null)
            return Arrays.asList(membros);
        else
            return new ArrayList<>();
    }
}
