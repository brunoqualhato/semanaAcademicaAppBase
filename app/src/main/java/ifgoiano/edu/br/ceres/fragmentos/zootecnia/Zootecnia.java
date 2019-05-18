package ifgoiano.edu.br.ceres.fragmentos.zootecnia;

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


public class Zootecnia extends Fragment implements LinhaDoTempoAdapter.ItemClickListener {

    RecyclerView mRecyclerView;
    List<MPalestra> mList = new ArrayList<>();
    LinhaDoTempoAdapter mAdapter;
    DecoracaoDaLinhaDoTempo mDecoracaoDaLinhaDoTempo;
    GestorDeEventos oGestorDeEventos = new GestorDeEventos();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zootecnia, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_zoo);
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


        MPalestrante Marco = new MPalestrante(
                "Marco Cano",
                "",
                R.drawable.ic_person,
                "Mestrado",
                "Fazenda Nova Granada"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) Palestra: Cria, recria e abate de bovinos de corte ",
                "Miniauditório - Bloco E",
                "Horário: 08:00 às 09:00 ", "1h",
                "23/05/2019", R.raw.semana, Marco
        ));


        MPalestrante Fernanda = new MPalestrante(
                "Fernanda Gomes de Paula",
                "",
                R.drawable.ic_person,
                "Doutorado",
                "UFG"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS)  Palestra: Sistemas de produção usados na piscicultura brasileira",
                "Miniauditório - Bloco E",
                "Horário: 09:00 às 10:00 ", "1h",
                "23/05/2019", R.raw.semana, Fernanda
        ));


        MPalestrante ALMOCO = new MPalestrante(
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
                "23/05/2019", R.raw.semana, ALMOCO
        ));


        MPalestrante Eliane = new MPalestrante(
                " Eliane Sayuri Miyagi Okada",
                "",
                R.drawable.ic_person,
                "Doutorado",
                "UFG"
        );
        mList.add(new MPalestra(
                " (VIII AGRÁRIAS) Palestra: Qualidade da carne de diferentes espécies ",
                "Miniauditório - Bloco E",
                "Horário: 13:00 às 14:00 ", "1h",
                "23/05/2019", R.raw.semana, Eliane
        ));

        MPalestrante Guilherme = new MPalestrante(
                " Guilherme Brunno de Medeiros Leal",
                "",
                R.drawable.ic_person,
                "Doutorado",
                "UFG"
        );
        mList.add(new MPalestra(
                " (VIII AGRÁRIAS)  Palestra: Sistemas intensivos de produção de suínos ",
                "Miniauditório - Bloco E",
                "Horário: 14:00 às 15:00 ", "1h",
                "23/05/2019", R.raw.semana, Guilherme
        ));


        MPalestrante Debora = new MPalestrante(
                " Débora",
                "",
                R.drawable.ic_person,
                "Doutorado",
                ""
        );
        mList.add(new MPalestra(
                " (VIII AGRÁRIAS) Palestra: Controle de qualidade do leite ",
                "Miniauditório - Bloco E",
                "Horário: 15:00 às 16:00 ", "1h",
                "23/05/2019", R.raw.semana, Debora
        ));

        MPalestrante AGROCRIA = new MPalestrante(
                " Flávio Henrique Vidal Azevedo",
                "",
                R.drawable.ic_person,
                "Doutorado",
                "AGROCRIA"
        );
        mList.add(new MPalestra(
                "   (VIII AGRÁRIAS) Palestra: Suplementação a pasto de bovinos ",
                "Miniauditório - Bloco E",
                "Horário: 08:00 às 09:00 ", "1h",
                "24/05/2019", R.raw.semana, AGROCRIA
        ));

        MPalestrante ZOETIS = new MPalestrante(
                " Diego Oliveira Helrigle ",
                "",
                R.drawable.ic_person,
                "Especialização",
                "ZOETIS"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) Palestra: IATF em bovinos de corte ",
                "Miniauditório - Bloco E",
                "Horário: 09:00 às 10:00", "1h",
                "24/05/2019", R.raw.semana, ZOETIS
        ));


        MPalestrante PERSONAL = new MPalestrante(
                "Ana Silva Pires Soubbia ",
                "",
                R.drawable.ic_person,
                "Doutorado",
                "PERSONAL PEC"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) Palestra: Manejo racional de bovinos ",
                "Miniauditório - Bloco E",
                "Horário: 10:00 às 11:00", "1h",
                "24/05/2019", R.raw.semana, PERSONAL
        ));

        MPalestrante MOSTRA = new MPalestrante(
                "MOSTRA CIENTÍFICA ",
                "",
                R.drawable.ic_person,
                "MOSTRA CIENTÍFICA",
                "MOSTRA CIENTÍFICA PEC"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) MOSTRA CIENTÍFICA",
                "Quadra Coberta",
                "Horário: 19:00 ÀS 20:00", "1h",
                "24/05/2019", R.raw.semana, MOSTRA
        ));


        MPalestrante STEM = new MPalestrante(
                "STEM ",
                "",
                R.drawable.ic_person,
                "AUDITÓRIO MULTIFUNCIONAL",
                "STEM"
        );
        mList.add(new MPalestra(
                "(VIII AGRÁRIAS) MESA REDONDA - Mulheres expoentes: tecnologia, cultura, ética e transparência",
                "Mini Auditório BLOCO - E",
                "Horário: 09:00 às 11:00", "2h",
                "25/05/2019", R.raw.semana, STEM
        ));


        MPalestrante fim = new MPalestrante(
                " ",
                "",
                R.drawable.ic_person,
                "AUDITÓRIO MULTIFUNCIONAL",
                "IFGoiano Ceres"
        );
        mList.add(new MPalestra(
                "PREMIAÇÃO E ENCERRAMENTO",
                "Miniauditório - Bloco E",
                "Horário:  11:00 às 12:00", "",
                "25/05/2019", R.raw.semana, fim
        ));


        mAdapter = new LinhaDoTempoAdapter(getContext(), mList);
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        //    removerEventosPassados();
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
