package ifgoiano.edu.br.ceres.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ifgoiano.edu.br.ceres.R;

public class DecoracaoDaLinhaDoTempo extends RecyclerView.ItemDecoration {
    private Drawable horario;
    private Drawable verticalLine;
    private Drawable horizontalLine;
    private Context mContext;
    private int distancia;


    public DecoracaoDaLinhaDoTempo(Context context, int distancia) {
        mContext = context;
        this.distancia = distancia;
        verticalLine = ContextCompat.getDrawable(mContext, R.drawable.gray_line);
        horario = ContextCompat.getDrawable(mContext, R.drawable.time);
        horizontalLine = ContextCompat.getDrawable(mContext, R.drawable.horizontal_line);

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = distancia;
        outRect.right = distancia;
        outRect.bottom = 3 * distancia;
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = distancia;
        } else if (parent.getChildAdapterPosition(view) == 1) {
            outRect.top = 4 * distancia;
        }

        if (parent.getChildAdapterPosition(view) % 2 == 0) {
            outRect.left = 20;
        } else {
            outRect.right = 20;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawHorizontal(c, parent);
        drawVertical(c, parent);
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {
        final int areaSuperio = parent.getPaddingTop();
        final int areaInferior = parent.getHeight() - parent.getPaddingBottom();
        final int larguraPai = parent.getMeasuredWidth();

        verticalLine.setBounds(larguraPai / 2 - 1, areaSuperio, larguraPai / 2 + 1, areaInferior);
        verticalLine.draw(c);
    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        final int larguraPai = parent.getMeasuredWidth();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View filho = parent.getChildAt(i);

            final int top = filho.getTop() + (filho.getBottom() - filho.getTop()) / 2 - horario.getIntrinsicHeight() / 2;
            final int bottom = top + horario.getIntrinsicHeight();

            int linhaHorizontalEsquerda = filho.getRight();
            int linhaHorizontalDireita = larguraPai / 2;
            int linhaHorizontalSuperior = filho.getTop() + (filho.getBottom() - filho.getTop()) / 2;

            if (filho.getLeft() < larguraPai / 2) {
                linhaHorizontalEsquerda = larguraPai / 2;
                linhaHorizontalDireita = filho.getLeft();

            }

            horizontalLine.setBounds(linhaHorizontalEsquerda, linhaHorizontalSuperior, linhaHorizontalDireita, linhaHorizontalSuperior + 2);
            horizontalLine.draw(c);

            int drawableLeft = larguraPai / 2 - horario.getIntrinsicWidth() / 2;
            int drawableRight = larguraPai / 2 + horario.getIntrinsicWidth() / 2;

            horario.setBounds(drawableLeft, top, drawableRight, bottom);
            horario.draw(c);
        }
    }
}
