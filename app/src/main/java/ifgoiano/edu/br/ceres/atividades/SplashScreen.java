package ifgoiano.edu.br.ceres.atividades;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import ifgoiano.edu.br.ceres.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        // Timer da splash screen
        int SPLASH_TIME_OUT = 3000;
        /*
         * Exibindo splash com um timer.
         */
        new Handler().postDelayed(() -> {
            // Esse método será executado sempre que o timer acabar
            // E inicia a activity principal
            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);

            // Fecha esta activity
            finish();
        }, SPLASH_TIME_OUT);
    }
}
