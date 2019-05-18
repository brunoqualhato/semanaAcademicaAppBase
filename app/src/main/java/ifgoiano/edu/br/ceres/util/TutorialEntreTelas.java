package ifgoiano.edu.br.ceres.util;

import android.support.design.widget.BottomNavigationView;
import android.view.View;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import ifgoiano.edu.br.ceres.R;
import ifgoiano.edu.br.ceres.atividades.MainActivity;

public class TutorialEntreTelas {
    private ShowcaseView sv;

    public TutorialEntreTelas(MainActivity mainActivity, String atalhos, String descricao, BottomNavigationView navigation, View.OnClickListener onClickListener) {

        sv = new ShowcaseView.Builder(mainActivity)
                .withMaterialShowcase()
                .setTarget(new ViewTarget(navigation))
                .setContentTitle(atalhos)
                .setContentText(descricao)
                .setStyle(R.style.CustomShowcaseTheme3)
                .replaceEndButton(R.layout.botao_custom_para_tutorial)
                .setOnClickListener(onClickListener)

                .build();

    }
}
