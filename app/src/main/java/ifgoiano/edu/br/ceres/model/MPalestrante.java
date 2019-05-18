package ifgoiano.edu.br.ceres.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class MPalestrante implements Serializable {
    public static final Parcelable.Creator<MPalestrante> CREATOR = new Parcelable.Creator<MPalestrante>() {
        @Override
        public MPalestrante createFromParcel(Parcel in) {
            return new MPalestrante(in);
        }

        @Override
        public MPalestrante[] newArray(int size) {
            return new MPalestrante[size];
        }
    };
    private String nomePalestrante;
    private String miniCurriculo;
    private int fotoPalestrante;
    private String titulacao;
    private String instituicao;

    public MPalestrante(String nomePalestrante, String miniCurriculo, int fotoPalestrante, String titulacao, String instituicao) {
        this.nomePalestrante = nomePalestrante;
        this.miniCurriculo = miniCurriculo;
        this.fotoPalestrante = fotoPalestrante;
        this.titulacao = titulacao;
        this.instituicao = instituicao;
    }

    protected MPalestrante(Parcel in) {
        nomePalestrante = in.readString();
        miniCurriculo = in.readString();
        fotoPalestrante = in.readInt();
    }

    public String getNomePalestrante() {
        return nomePalestrante;
    }

    public void setNomePalestrante(String nomePalestrante) {
        this.nomePalestrante = nomePalestrante;
    }

    public String getMiniCurriculo() {
        return miniCurriculo;
    }

    public void setMiniCurriculo(String miniCurriculo) {
        this.miniCurriculo = miniCurriculo;
    }

    public int getFotoPalestrante() {
        return fotoPalestrante;
    }

    public void setFotoPalestrante(int fotoPalestrante) {
        this.fotoPalestrante = fotoPalestrante;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
}
