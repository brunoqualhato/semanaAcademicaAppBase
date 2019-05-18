package ifgoiano.edu.br.ceres.fragmentos.biologia;

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


public class Biologia extends Fragment implements LinhaDoTempoAdapter.ItemClickListener {

    RecyclerView mRecyclerView;
    List<MPalestra> mList = new ArrayList<>();
    LinhaDoTempoAdapter mAdapter;
    DecoracaoDaLinhaDoTempo mDecoracaoDaLinhaDoTempo;
    GestorDeEventos oGestorDeEventos = new GestorDeEventos();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_biologia, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_bio);
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


        MPalestrante Nascimento = new MPalestrante(
                "Rhuâna Thayna B. Nascimento",
                "",
                R.drawable.ic_person,
                " Doutorado",
                "Conágua Ambiental / Unievangélica"
        );

        mList.add(new MPalestra(
                "(IX SIMBIO ) - Palestra: O Biógolo no campo da Consultoria Ambiental: Diagnóstico e Monitoramento de Empreendimentos Hidroelétricos ",
                "Miniauditório - Bloco E",
                "Horário: 19:00 às 20:00", "1h",
                "23/05/2019", R.raw.ruana_dra, Nascimento
        ));


        MPalestrante lorena = new MPalestrante(
                "Lorena Lana Camelo Antunes",
                "",
                R.drawable.ic_person,
                " ",
                "UNB"
        );

        mList.add(new MPalestra(
                " (IX SIMBIO ) - Palestra: Áreas  de atuação  do Biólogo na Botânica",
                "Miniauditório - Bloco E",
                "Horário: 21:00 às 23:00 ", "3h",
                "23/05/2019", R.raw.lorena_lana, lorena
        ));


        MPalestrante mostra = new MPalestrante(
                "MOSTRA CIENTÍFICA",
                "",
                R.drawable.ic_person,
                " MOSTRA CIENTÍFICA",
                "MOSTRA CIENTÍFICA"
        );
        mList.add(new MPalestra(
                "(IX SIMBIO ) - MOSTRA CIENTÍFICA ",
                "Quadra Coberta",
                "Horário: 19:00 às 20:00  ", "1h",
                "24/05/2019", R.raw.semana, mostra
        ));


        MPalestrante matias = new MPalestrante(
                "Matias Noll",
                "",
                R.drawable.ic_person,
                " ",
                "Mini Auditório Bloco E"
        );
        mList.add(new MPalestra(
                " (IX SIMBIO) -  Palestra: Construção do parágrafo científico visando publicações em revistas indexadas",
                "Miniauditório - Bloco E",
                "Horário: 20:00 às 23:00 ", "3h",
                "26/05/2019", R.raw.matias_noll, matias
        ));


        MPalestrante MOSTRA = new MPalestrante(
                "MOSTRA CIENTÍFICA",
                "",
                R.drawable.ic_person,
                " MOSTRA CIENTÍFICA",
                "MOSTRA CIENTÍFICA"
        );
        mList.add(new MPalestra(
                "(IX SIMBIO) - (VII SIMPLIQUI) MESA REDONDA - Mulheres expoentes: tecnologia, cultura,ética e transparência",
                "Miniauditório - Bloco E",
                "Horário: 09:00 às 11:00", "2h",
                "24/05/2019", R.raw.semana, MOSTRA
        ));


        MPalestrante fim = new MPalestrante(
                "",
                "",
                R.drawable.ic_person,
                " AUDITÓRIO MULTIFUNCIONAL",
                "-----"
        );
        mList.add(new MPalestra(
                "PREMIAÇÃO E ENCERRAMENTO",
                "Miniauditório - Bloco E",
                "Horário: 11:00 às 12:00 ", "",
                "25/05/2019", R.raw.semana, fim
        ));


        mAdapter = new LinhaDoTempoAdapter(getContext(), mList);
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        //  removerEventosPassados();
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
