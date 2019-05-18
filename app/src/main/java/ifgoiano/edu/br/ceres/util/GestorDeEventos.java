package ifgoiano.edu.br.ceres.util;

import android.app.Activity;
import android.content.Intent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import ifgoiano.edu.br.ceres.model.MPalestra;

public class GestorDeEventos {

    /*TODO função para adicionar eventos no calendario*/
    public void adicionarEvento(Activity activity, MPalestra mPalestra) {
        String[] partesDaData = mPalestra.getDataPalestra().split("/");
        int ano = Integer.parseInt(partesDaData[2]);
        int mes = Integer.parseInt(partesDaData[1]);
        int data = Integer.parseInt(partesDaData[0]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, ano);
        calendar.set(Calendar.MONTH, (mes - 1));
        calendar.set(Calendar.DAY_OF_MONTH, data);

        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", calendar.getTimeInMillis());
        intent.putExtra("allDay", false);
        intent.putExtra("rrule", "FREQ=YEARLY");
        intent.putExtra("endTime", calendar.getTimeInMillis() + 60 * 60 * 1000);
        intent.putExtra("title", mPalestra.getNomePalestra());
        activity.startActivity(intent);
    }

    public boolean removerEventosPassados(String inicio, String fim) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date dataAtual = sdf.parse(inicio);
        Date dataFinal = sdf.parse(fim);

        System.out.println("Data atual: " + sdf.format(dataAtual));
        System.out.println("Data Final : " + sdf.format(dataFinal));

        if (dataAtual.compareTo(dataFinal) > 0) {
            return true;
            //System.out.println("DataAtual é depois de DataFinal");
        }
        if (dataAtual.compareTo(dataFinal) < 0) {
            return false;
            //System.out.println("DataInicial é anterior a DataFinal");
        }
        if (dataAtual.compareTo(dataFinal) == 0) {
            return false;
            //System.out.println("DataInicial é igual a DataFinal");
        }
        return false;
    }
}
