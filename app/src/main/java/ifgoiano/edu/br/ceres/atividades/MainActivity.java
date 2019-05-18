package ifgoiano.edu.br.ceres.atividades;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;

import ifgoiano.edu.br.ceres.R;
import ifgoiano.edu.br.ceres.fragmentos.agronomia.Agronomia;
import ifgoiano.edu.br.ceres.fragmentos.biologia.Biologia;
import ifgoiano.edu.br.ceres.fragmentos.quimica.Quimica;
import ifgoiano.edu.br.ceres.fragmentos.sistemas.Sistemas;
import ifgoiano.edu.br.ceres.fragmentos.zootecnia.Zootecnia;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_agro:
                //   removerToolBar();

                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.slide_up, 0, 0, R.animator.slide_down)
                        .replace(R.id.container_layout, new Agronomia())
                        .commit();
                return true;
            case R.id.navigation_zoo:
                //   removerToolBar();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.slide_up, 0, 0, R.animator.slide_down)
                        .replace(R.id.container_layout, new Zootecnia())
                        .commit();

                return true;
            case R.id.navigation_bio:
                //  removerToolBar();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.slide_up, 0, 0, R.animator.slide_down)
                        .replace(R.id.container_layout, new Biologia())
                        .commit();
                return true;
            case R.id.navigation_qui:
                //  removerToolBar();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.slide_up, 0, 0, R.animator.slide_down)
                        .replace(R.id.container_layout, new Quimica())
                        .commit();
                return true;
            case R.id.navigation_sis:
                // getSupportActionBar().hide();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.slide_up, 0, 0, R.animator.slide_down)
                        .replace(R.id.container_layout, new Sistemas())
                        .commit();

                return true;


        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        boolean aBoolean = prefs.getBoolean("tutorialCompleto", false);


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.slide_up, 0, 0, R.animator.slide_down)
                .add(R.id.container_layout, new Agronomia())
                .commit();

//        if(aBoolean){
//
//        }else {
//            new TutorialEntreTelas(this,
//                    "Atalhos",
//                    "Nesse local você verá todos os eventos pertencentes a cada curso",
//                    navigation, new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                prefs.edit().putBoolean("tutorialCompleto",true).apply();
//
//                }
//            });
//        }
        // criarAtalhos(this);
    }

    void removerToolBar() {
        getSupportActionBar().show();
    }


    void criarAtalhos(Activity activity) {
        ShortcutManager shortcutManager = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                shortcutManager = activity.getSystemService(ShortcutManager.class);
                ShortcutInfo shortcut = new ShortcutInfo.Builder(activity, "id")
                        .setShortLabel("descricao curta")
                        .setLongLabel("Descricao longa")
                        .setIcon(Icon.createWithResource(activity, R.drawable.ic_agro)) //icone do atalho
                        .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com.br")))
                        .build();

                shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
            }
        }


    }

}
