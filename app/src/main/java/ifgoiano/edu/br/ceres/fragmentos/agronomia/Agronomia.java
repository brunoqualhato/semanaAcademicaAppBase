package ifgoiano.edu.br.ceres.fragmentos.agronomia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import ifgoiano.edu.br.ceres.R;
import ifgoiano.edu.br.ceres.adapters.LinhaDoTempoAdapter;
import ifgoiano.edu.br.ceres.atividades.DetalhesEvento;
import ifgoiano.edu.br.ceres.model.MPalestra;
import ifgoiano.edu.br.ceres.model.MPalestrante;
import ifgoiano.edu.br.ceres.util.DecoracaoDaLinhaDoTempo;
import ifgoiano.edu.br.ceres.util.GestorDeEventos;

public class Agronomia extends Fragment implements LinhaDoTempoAdapter.ItemClickListener {

    RecyclerView mRecyclerView;
    List<MPalestra> mList = new ArrayList<>();
    LinhaDoTempoAdapter mAdapter;
    DecoracaoDaLinhaDoTempo mDecoracaoDaLinhaDoTempo;
    GestorDeEventos oGestorDeEventos = new GestorDeEventos();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agronomia, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_agro);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(mDecoracaoDaLinhaDoTempo = new DecoracaoDaLinhaDoTempo(getContext(), 100));


        MPalestrante Juliana = new MPalestrante(
                "Juliana Ribeiro de Alencar",
                "Graduada em Tecnologia em Programação de Computadores/Tecnologia da Informação (2005) e pós-graduação em Gestão de Projetos (2014). É coordenadora do Bizmeet, veículo de informação premiado e reconhecido a nível internacional, o qual se tornou uma das principais referências em tecnologia da capital federal. ",
                R.drawable.ic_person,
                "Diretora de Inovação",
                "BizMeet"
        );
        mList.add(new MPalestra(
                "(Palestra de Abertura) - O Profissional do Futuro",
                "Auditório Multifuncional",
                "Horário: 19:00 às 23:00",
                "3h",
                "22/05/2019", R.raw.juliana_abertura, Juliana
        ));


        MPalestrante flavia = new MPalestrante(
                "Dra. Flávia Rabelo Barbosa",
                "",
                R.drawable.ic_person,
                "Doutorado",
                "Embrapa Arroz e Feijão"
        );
        mList.add(new MPalestra(
                "(VIIIAGRÁRIAS) Palestra: Manejo integrado de pragas com ênfase no controle biológico.",
                " Auditório Multifuncional",
                "Horário: 08:00 às 09:00 ",
                "1h",
                "23/05/2019", R.raw.flavia_rabelo, flavia
        ));


        MPalestrante Rizia = new MPalestrante(
                "Rizia SIlva Andrade",
                "",
                R.drawable.ic_person,
                "Mestrado",
                "UFG"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) Palestra: Como transformar a pesquisa em negócio",
                "Auditório Multifuncional",
                "Horário: 09:00 às 10:00", "1h",
                "23/05/2019", R.raw.rizia, Rizia
        ));


        MPalestrante MesaRedonda = new MPalestrante(
                "MESA REDONDA",
                "",
                R.drawable.ic_person,
                "MESA REDONDA",
                "MESA REDONDA"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) MESA REDONDA: Atualidades em controle biológico de pragas.",
                "Auditório Multifuncional",
                "Horário: 10:00 às 11:00",
                "1h",
                "23/05/2019", R.raw.semana, MesaRedonda
        ));


        MPalestrante almoco = new MPalestrante(
                "ALMOÇO",
                "",
                R.drawable.ic_person,
                "ALMOÇO",
                "ALMOÇO"
        );
        mList.add(new MPalestra(
                "ALMOÇO",
                "",
                "Horário: 11:00 às 13:00", "2h",
                "23/05/2019",
                R.raw.semana,
                almoco
        ));


        MPalestrante Daline = new MPalestrante(
                "Daline Benites Bottega",
                "",
                R.drawable.ic_person,
                "Doutorado",
                "IF Goiano Campus Iporá"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) Palestra: Resistência de tomateiro a lepidópteros-praga.",
                "Auditório Multifuncional",
                "Horário: 13:00 às 14:00 ", "1h",
                "23/05/2019",
                R.raw.daline_benite, Daline
        ));


        MPalestrante Douglas = new MPalestrante(
                "Douglas Henrique Bottura Maccagnan",
                "",
                R.drawable.ic_person,
                "Doutorado",
                "UEG Campus Iporá"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) Palestra: Uso do comportamento acústico de insetos no manejo de pragas: perspectivas atuais e futuras.",
                "Auditório Multifuncional",
                "Horário: 14:00 às 15:00 ", "1h",
                "23/05/2019",
                R.raw.douglas, Douglas
        ));


        MPalestrante mesa_redonda = new MPalestrante(
                "MESA REDONDA",
                "",
                R.drawable.ic_person,
                " MESA REDONDA",
                " MESA REDONDA"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) MESA REDONDA: Desafios atuais em MIP no Brasil.",
                "Auditório Multifuncional",
                "Horário: 15:00 às 16:00", "1h",
                "23/05/2019", R.raw.semana, mesa_redonda
        ));


        MPalestrante Djalma = new MPalestrante(
                "Fernando T. Hernandez",
                "",
                R.drawable.ic_person,
                "",
                "UNESP"
        );
        mList.add(new MPalestra(
                "(VI AGRÁRIAS) Palestra: Inovação na agricultura",
                "Auditório Multifuncional",
                "Horário: 08:00 às 09:00 ", "1h",
                "24/05/2019", R.raw.tangerino, Djalma
        ));

        MPalestrante SENAR = new MPalestrante(
                "Salomão de Souza Medeiros",
                "",
                R.drawable.ic_person,
                "",
                "INSA/MCTI"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) Palestra: Perspectiva para gestão dos Recursos Hídricos",
                "Auditório Multifuncional",
                "Horário: 09:00 às 10:00", "1h",
                "24/05/2019", R.raw.salomao_souza, SENAR
        ));


        MPalestrante saalomao = new MPalestrante(
                "Frederico Antonio Louleiro\n" +
                                "Fernando T. Hernandez\n"+
                                "Salomão de Souza Medeiros",
                "",
                R.drawable.ic_person,
                " Especialização",
                "INSA / MCTI" +
                        "\n" +
                        "IF Goiano" +
                        "\n" +
                        "UNESP"
        );

        mList.add(new MPalestra(
                " (VIII AGRÁRIAS) - MESA REDONDA - Gestão da água na agricultura",
                "Auditório Multifuncional",
                "Horário: 10:00 às 11:00", "1h",
                "24/05/2019", R.raw.salomao_frederico_fernando, saalomao
        ));


        //aumoco do dia 23
        mList.add(new MPalestra(
                "ALMOÇO",
                "",
                "Horário: 11:00 às 13:00", "2h",
                "24/05/2019", R.raw.semana, almoco
        ));


        MPalestrante Leyton = new MPalestrante(
                "Leyton Tavares",
                "",
                R.drawable.ic_person,
                "",
                "Cooper-Rubi"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS)Palestra: Herbicidas e controle de plantas daninhas ",
                "Auditório Multifuncional",
                "Horário: 14:00 às 15:00", "1h",
                "24/05/2019", R.raw.semana, Leyton
        ));


        MPalestrante mostra = new MPalestrante(
                "MOSTRA CIENTÍFICA",
                "",
                R.drawable.ic_person,
                "",
                "MOSTRA CIENTÍFICA"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) MOSTRA CIENTÍFICA",
                "Quadra Coberta",
                "Horário: 15:00 às 16:00", "1h",
                "24/05/2019", R.raw.semana, mostra
        ));

        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) MOSTRA CIENTÍFICA",
                "Auditório Multifuncional",
                "Horário: 19:00 às 20:00", "1h",
                "24/05/2019", R.raw.semana, mostra
        ));


        MPalestrante STEM = new MPalestrante(
                "STEM",
                "",
                R.drawable.ic_person,
                " AUDITÓRIO MULTIFUNCIONAL",
                "STEM"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) MESA REDONDA - Mulheres expoentes: tecnologia, cultura, ética e transparência",
                "Auditório Multifuncional",
                "Horário: 09:00 às 11:00", "2h",
                "25/05/2019", R.raw.semana, STEM
        ));

        MPalestrante encerramento = new MPalestrante(
                "PREMIAÇÃO E ENCERRAMENTO",
                "",
                R.drawable.ic_person,
                " AUDITÓRIO MULTIFUNCIONAL",
                "Mini Auditório Bloco E"
        );
        mList.add(new MPalestra(
                "PREMIAÇÃO E ENCERRAMENTO",
                "Miniauditório - Bloco E",
                "Horário: 11:00 às 12:00", "----",
                "25/05/2019", R.raw.semana, encerramento
        ));
        mAdapter = new LinhaDoTempoAdapter(getContext(), mList);
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);


        // removerEventosPassados();
        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        ArrayList<MPalestra> mPalestras = new ArrayList<>();
        mPalestras.add(mList.get(position));

        Intent intent = new Intent(getActivity(), DetalhesEvento.class);

        intent.putExtra("dados", mPalestras);
        startActivity(intent);

        // Toast.makeText(getContext(), mAdapter.getItem(position).getNomePalestra(), Toast.LENGTH_SHORT).show();
    }

    void removerEventosPassados() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Date date = new Date();

            if (oGestorDeEventos.removerEventosPassados(dateFormat.format(date), "27/05/2019")) {
                mAdapter.removerPosicao(3);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
