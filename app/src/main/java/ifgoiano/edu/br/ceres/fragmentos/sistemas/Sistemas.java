package ifgoiano.edu.br.ceres.fragmentos.sistemas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ifgoiano.edu.br.ceres.R;
import ifgoiano.edu.br.ceres.adapters.LinhaDoTempoAdapter;
import ifgoiano.edu.br.ceres.atividades.DetalhesEvento;
import ifgoiano.edu.br.ceres.model.MPalestra;
import ifgoiano.edu.br.ceres.model.MPalestrante;
import ifgoiano.edu.br.ceres.util.DecoracaoDaLinhaDoTempo;


public class Sistemas extends Fragment implements LinhaDoTempoAdapter.ItemClickListener {
    RecyclerView mRecyclerView;


    List<MPalestra> mList = new ArrayList<>();
    LinhaDoTempoAdapter mAdapter;
    DecoracaoDaLinhaDoTempo mDecoracaoDaLinhaDoTempo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sistemas, container, false);

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
                "(Palestra de Abertura) O Profissional do Futuro",
                "Auditório Multifuncional",
                "Horário: 19:00 às 23:00",
                "3h",
                "22/05/2019", R.raw.juliana_abertura, Juliana
        ));


        MPalestrante bruno = new MPalestrante(
                "Bruno Qualhato",
                "Trabalhou entre 2015 e 2017 como Freelancer, dedicado ao desenvolvimento Android nativo. Desde 2018 presta serviços a Terra Byte Sistemas de desenvolvimento de websites e apps, onde é responsável por desenvolver aplicativos conectados à esses websites. Cursa 5° período de Sistemas de Informação pelo Campus Ceres do IF Goiano. ",
                R.drawable.ic_person,
                "Bacharelando",
                "IFGoiano Campus Ceres"
        );
        mList.add(new MPalestra(
                "(SIMTEC) Minicurso 1: Desenvolvimento de jogos com Unity",
                "Laboratório 02 - Bloco C",
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
                "Laboratório 04 - Bloco C ",
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
                "(SIMTEC) Minicurso 3: Desenvolvimento de aplicações híbridas utilizando Flutter",
                "Laboratório de Dispositivos Móveis - Bloco E",
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
                "(SIMTEC) Minicurso 4: Aprenda atrabalhar com imagens",
                "Laboratório 01 - Bloco C ",
                "Horário:19:00 às 23:00 ",
                "4h",
                "23/05/2019", R.raw.minicurso_davi_andressa, Andressa
        ));


        MPalestrante mostra = new MPalestrante(
                "MOSTRA CIENTÍFICA",
                "-------",
                R.drawable.ic_person,
                "MOSTRA CIENTÍFICA",
                "MOSTRA CIENTÍFICA"
        );
        mList.add(new MPalestra(
                "(SIMTEC) MOSTRA CIENTÍFICA",
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
                "(IV SIMTEC) MESA REDONDA - Mulheres expoentes: tecnologia, cultura, ética e transparência",
                "Centro de Vivências",
                "Horário: 09:00 às 10:30",
                "2h",
                "25/05/2019", R.raw.semana, steam
        ));


        MPalestrante cosplay = new MPalestrante(
                "Concurso de Cosplayers",
                "",
                R.drawable.ic_person,
                "----",
                "------"
        );
        mList.add(new MPalestra(
                "Concurso de Cosplayers",
                "Miniauditório - Bloco E",
                "Horário: 10:30 às 11:00",
                "30min",
                "25/05/2019", R.raw.semana, cosplay
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
                "Miniauditório - Bloco E",
                "Horário: 11:00 às 12:00",
                "2h",
                "25/05/2019", R.raw.semana, fim
        ));


        mAdapter = new LinhaDoTempoAdapter(getContext(), mList);
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
//        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
//                getChildFragmentManager(), FragmentPagerItems.with(getActivity())
//                .add(getString(R.string.palestras), SistemasPalestras.class)
//                .add(getString(R.string.minicurso), SistemaMiniCurso.class)
//                .create());
//
//        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
//        viewPager.setAdapter(adapter);
//
//        SmartTabLayout viewPagerTab = (SmartTabLayout) view.findViewById(R.id.viewpagertab);
//        viewPagerTab.setDistributeEvenly(true);
//        viewPagerTab.setViewPager(viewPager);

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

}
