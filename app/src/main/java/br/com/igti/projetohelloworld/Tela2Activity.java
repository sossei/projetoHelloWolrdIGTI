package br.com.igti.projetohelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tela2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        configurandoListView();
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
