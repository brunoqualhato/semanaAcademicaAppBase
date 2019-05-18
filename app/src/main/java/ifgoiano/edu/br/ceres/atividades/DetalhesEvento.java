package ifgoiano.edu.br.ceres.atividades;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alespero.expandablecardview.ExpandableCardView;

import java.util.ArrayList;
import java.util.Calendar;

import ifgoiano.edu.br.ceres.R;
import ifgoiano.edu.br.ceres.model.MPalestra;
import ifgoiano.edu.br.ceres.util.CriadorDeAlertsDialogs;

public class DetalhesEvento extends AppCompatActivity {
    CriadorDeAlertsDialogs oCriadorDeAlertsDialogs = new CriadorDeAlertsDialogs();
    ExpandableCardView mExpandableCardViewPalestrante, mExpandableCardViewLocalizacao, mExpandableCardViewCalendario;
    MPalestra mPalestra = new MPalestra();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_evento);

        Bundle intent = getIntent().getExtras();
        ArrayList<MPalestra> array = (ArrayList<MPalestra>) intent.getSerializable("dados");
        TextView titulo = findViewById(R.id.titulo);
        for (int i = 0; i < array.size(); i++) {
            mPalestra.setNomePalestra(array.get(i).getNomePalestra());
            mPalestra.setDataPalestra(array.get(i).getDataPalestra());
            mPalestra.setHorarioPalestra(array.get(i).getHorarioPalestra());
            mPalestra.setLocalPalestra(array.get(i).getLocalPalestra());
            mPalestra.setFotoLocal(array.get(i).getFotoLocal());
            mPalestra.setmPalestrante(array.get(i).getmPalestrante());
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(null);


        titulo.setText(mPalestra.getNomePalestra());
        titulo.setSelected(true);
        titulo.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        titulo.setSingleLine(true);


        ImageView photoView = findViewById(R.id.img_logo_detalhe);
        photoView.setImageResource(mPalestra.getFotoLocal());


        mExpandableCardViewLocalizacao = findViewById(R.id.main_localizacao);
        mExpandableCardViewPalestrante = findViewById(R.id.main_palestrante);
        mExpandableCardViewCalendario = findViewById(R.id.main_data);


        mExpandableCardViewPalestrante.setOnExpandedListener((v, isExpanded) -> {
            TextView nomePalestrande = v.findViewById(R.id.txt_miniCurriculo);
            TextView miniCurriculo = v.findViewById(R.id.txt_curriculo);

            nomePalestrande.setText(mPalestra.getmPalestrante().getNomePalestrante());
            miniCurriculo.setText(mPalestra.getmPalestrante().getMiniCurriculo());
        });


        mExpandableCardViewLocalizacao.setOnExpandedListener((v, isExpanded) -> {

            if (isExpanded) {
                TextView txtloc = v.findViewById(R.id.txt_localizacao);
                txtloc.setText(mPalestra.getLocalPalestra());

//                ImagePopup imagePopup = new ImagePopup(v.getContext());
//                imagePopup.setWindowHeight(800); // Optional
//                imagePopup.setWindowWidth(800); // Optional
//                imagePopup.setBackgroundColor(Color.WHITE);  // Optional
//                imagePopup.setFullScreen(true);// Optional
//                imagePopup.setHideCloseIcon(false);  // Optional
//                imagePopup.setImageOnClickClose(false);  // Optional

//                ImageView map = v.findViewById(R.id.map);
//                map.setImageResource(mPalestra.getFotoLocal());
//                imagePopup.initiatePopup(map.getDrawable());
//                map.setOnClickListener(v1 -> imagePopup.viewPopup());

            }
        });


        mExpandableCardViewCalendario.setOnExpandedListener((v, isExpanded) -> {
            CalendarView mCalendarView = v.findViewById(R.id.calendario_evento);

            String[] partes = mPalestra.getDataPalestra().split("/");
            int day = Integer.parseInt(partes[0]);
            int month = Integer.parseInt(partes[1]);
            int year = Integer.parseInt(partes[2]);

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, (month - 1));
            calendar.set(Calendar.DAY_OF_MONTH, day);

            long milliTime = calendar.getTimeInMillis();
            mCalendarView.setDate(milliTime);


            if (isExpanded) {

                Button btn = v.findViewById(R.id.btn_agendar_evento);
                btn.setOnClickListener(v12 -> oCriadorDeAlertsDialogs.alertaAgendamentoDeEvento(
                        DetalhesEvento.this
                        , "Atenção !!",
                        "Você deseja ser alertado sobre esse evento?"
                        , "Sim !!",
                        "Não", mPalestra
                ));


            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
