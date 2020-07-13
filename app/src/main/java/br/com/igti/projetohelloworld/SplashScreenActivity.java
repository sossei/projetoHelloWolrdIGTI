package br.com.igti.projetohelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        checkOpen();
    }
    private void checkOpen(){
        SharedPreferences pref= getSharedPreferences("preferences_projeto_hellowrold_igti", Context.MODE_PRIVATE);
        boolean isFirstTime = pref.getBoolean("key_firsttime",true);
        if(isFirstTime){
            openDelayed();
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("key_firsttime",false);
        }else{
            openActvity();
        }
    }
    private void openDelayed(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                openActvity();
            }
        }, 4000);
    }

    private void openActvity() {
        startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
    }
}
