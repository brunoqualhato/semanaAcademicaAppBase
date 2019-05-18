package ifgoiano.edu.br.ceres.util;

import android.app.Activity;
import android.app.AlertDialog;

import ifgoiano.edu.br.ceres.model.MPalestra;

public class CriadorDeAlertsDialogs {
    private GestorDeEventos oGestorDeEventos = new GestorDeEventos();
    private AlertDialog alerta;

    public void alertaAgendamentoDeEvento(final Activity activity, String titulo, String conteudo,
                                          String botaoPositivo, String botaoNegativo, final MPalestra mPalestra) {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //define o titulo
        builder.setTitle(titulo);
        //define a mensagem
        builder.setMessage(conteudo);
        //define um botão como positivo
        builder.setPositiveButton(botaoPositivo, (arg0, arg1) -> oGestorDeEventos.adicionarEvento(activity, mPalestra));
        //define um botão como negativo.
        builder.setNegativeButton(botaoNegativo, (arg0, arg1) -> alerta.dismiss());
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }
}
