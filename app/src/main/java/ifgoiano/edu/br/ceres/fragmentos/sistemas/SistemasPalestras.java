package ifgoiano.edu.br.ceres.fragmentos.sistemas;

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

public class SistemasPalestras extends Fragment implements LinhaDoTempoAdapter.ItemClickListener {


    RecyclerView mRecyclerView;

    List<MPalestra> mList = new ArrayList<>();
    LinhaDoTempoAdapter mAdapter;
    DecoracaoDaLinhaDoTempo mDecoracaoDaLinhaDoTempo;
    GestorDeEventos oGestorDeEventos = new GestorDeEventos();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sistemas_palestras, container, false);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.reciclerview);
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


        MPalestrante mostra = new MPalestrante(
                "MOSTRA CIÊNTIFICA",
                "-------",
                R.drawable.ic_person,
                "MOSTRA CIÊNTIFICA",
                "MOSTRA CIÊNTIFICA"
        );
        mList.add(new MPalestra(
                "(SIMTEC) MOSTRA CIÊNTIFICA",
                "Quadra Coberta",
                "Horário: 19:00 às 20:00",
                "1h",
                "24/05/2019", R.raw.semana, mostra
        ));


        MPalestrante san = new MPalestrante(
                "Sanderson Oliveira de Macedo",
                "Possui graduação em Ciência da Computação pela Pontifícia Universidade Católica de Goiás (2009) e mestrado em Ciência da Computação pela Universidade Federal de Goiás (2012). Atualmente é Professor 40h com dedicação exclusiva no Instituto Federal de Educação, Ciência e Tecnologia de Goiás. ",
                R.drawable.ic_person,
                "Mestrado",
                "IFG Campus Goiânia"
        );
        mList.add(new MPalestra(
                "(SIMTEC) Palestra 2: Como impulsionar suas ideias na Campus Party",
                "Auditório Multifuncional",
                "Horário: 20:00 às 23:00",
                "3h",
                "24/05/2019", R.raw.sanderson, san
        ));


        MPalestrante steam = new MPalestrante(
                "STEM",
                "------",
                R.drawable.ic_person,
                "AUDITÓRIO MULTIFUNCIONAL",
                "STEM"
        );
        mList.add(new MPalestra(
                " (IV SIMTEC) MESA REDONDA - Mulheres expoentes: tecnologia, cultura,ética e transparência",
                "Centro de vivencia",
                "Horário: 09:00 às 11:00",
                "2h",
                "25/05/2019", R.raw.semana, steam
        ));


        MPalestrante fim = new MPalestrante(
                "----",
                "---------",
                R.drawable.ic_person,
                "----",
                "------"
        );
        mList.add(new MPalestra(
                "PREMIAÇÃO E ENCERRAMENTO",
                "Centro de vivencia",
                "Horário: 11:00 às 12:00",
                "2h",
                "25/05/2019", R.raw.semana, fim
        ));

        mAdapter = new LinhaDoTempoAdapter(getContext(), mList);
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        //   removerEventosPassados();
        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        ArrayList<MPalestra> mPalestras = new ArrayList<>();
        mPalestras.add(mList.get(position));

        Intent intent = new Intent(getActivity(), DetalhesEvento.class);

        intent.putExtra("dados", mPalestras);
        startActivity(intent);

        //  Toast.makeText(getContext(), mAdapter.getItem(position).getNomePalestra(), Toast.LENGTH_SHORT).show();
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
