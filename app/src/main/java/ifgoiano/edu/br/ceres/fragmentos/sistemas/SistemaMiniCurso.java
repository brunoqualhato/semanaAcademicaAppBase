package ifgoiano.edu.br.ceres.fragmentos.sistemas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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


public class SistemaMiniCurso extends Fragment implements LinhaDoTempoAdapter.ItemClickListener {

    RecyclerView mRecyclerView;


    List<MPalestra> mList = new ArrayList<>();
    LinhaDoTempoAdapter mAdapter;
    DecoracaoDaLinhaDoTempo mDecoracaoDaLinhaDoTempo;
    GestorDeEventos oGestorDeEventos = new GestorDeEventos();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sistema_mini_curso, container, false);


        mRecyclerView = view.findViewById(R.id.reciclerview);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(mDecoracaoDaLinhaDoTempo = new DecoracaoDaLinhaDoTempo(getContext(), 100));


        MPalestrante bruno = new MPalestrante(
                "Bruno Qualhato",
                "Trabalhou entre 2015 e 2017 como Freelancer, dedicado ao desenvolvimento Android nativo. Desde 2018 presta serviços a Terra Byte Sistemas de desenvolvimento de websites e apps, onde é responsável por desenvolver aplicativos conectados à esses websites. Cursa 5° período de Sistemas de Informação pelo Campus Ceres do IF Goiano. ",
                R.drawable.ic_person,
                "Bacharelando",
                "IFGoiano Campus Ceres"
        );
        mList.add(new MPalestra(
                "Desenvolvimento de jogos com Unity",
                "Lab 02 - Bloco C",
                "Horário:19:00 às 23:00 ",
                "4h",
                "23/05/2019", R.raw.bruno_qualhato, bruno
        ));


        MPalestrante Ronneesley = new MPalestrante(
                "Ronneesley M. Teles",
                "Bacharel em Sistemas de Informação pela Universidade Salgado de Oliveira (2009), Especialização em Tecnologia da Informação e Negócios Eletrônicos (2011) e Mestrado em Ciências da Computação (2011). Atua principalmente com: Computação Evolutiva, Aprendizado de Máquinas e Processamento Digital de Imagens. Professor no Instituto Federal Goiano Campus Ceres.",
                R.drawable.ic_person,
                "Doutorando",
                "UFG"
        );
        mList.add(new MPalestra(
                "(SIMTEC) Minicurso 2: Práticas de Deep Learning",
                "Lab 04 Bloco C ",
                "Horário:19:00 às 23:00 ",
                "4h",
                "23/05/2019", R.raw.ronneesley, Ronneesley
        ));


        MPalestrante vazio = new MPalestrante(
                " Robson Gonçalves Pinheiro",
                " Arquiteto de Aplicações (full stack) na Jalles Machado desde 2011, bacharel em Sistemas de Informações pela Universidade Estadual de Goiás (2008), especialista em Ciência de Dados pelo IGTI, professor contratado pela Universidade Estadual de Goiás. Já atuou como Analista de Sistemas pela Conceito ITA (2009-2011) e Analista/Desenvolvedor pela FUNAPE (2010-2011). ",
                R.drawable.ic_person,
                "----",
                "----"
        );
        mList.add(new MPalestra(
                " Desenvolvimento de aplicações híbridas utilizando Flutter",
                "-----",
                "Horário:19:00 às 23:00 ",
                "----",
                "23/05/2019", R.raw.robson, vazio));


        MPalestrante Andressa = new MPalestrante(
                "Andressa Soares, Igor Justino e Davi Faria",
                " Acadêmicos do curso de Bacharelado em Sistemas de Informação pelo Campus Ceres do IF Goiano e dirigentes da Start Informática, empresa da região do Vale do São Patrício que oferta cursos de informática básica, avançada e cursos profissionalizantes. ",
                R.drawable.ic_person,
                "Bacharelandos e Start Informatica",
                "IF Goiano Campus Ceres"
        );
        mList.add(new MPalestra(
                " (SIMTEC) Minicurso 4: Aprenda atrabalhar com imagens",
                "------",
                "Horário:19:00 às 23:00 ",
                "4h",
                "23/05/2019", R.raw.minicurso_davi_andressa, Andressa
        ));


        mAdapter = new LinhaDoTempoAdapter(getContext(), mList);
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        removerEventosPassados();
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
