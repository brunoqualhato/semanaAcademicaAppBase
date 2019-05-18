package ifgoiano.edu.br.ceres.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class MPalestra implements Serializable {
    public static final Parcelable.Creator<MPalestra> CREATOR = new Parcelable.Creator<MPalestra>() {
        @Override
        public MPalestra createFromParcel(Parcel in) {
            return new MPalestra(in);
        }

        @Override
        public MPalestra[] newArray(int size) {
            return new MPalestra[size];
        }
    };
    private String nomePalestra;
    private String localPalestra;
    private String horarioPalestra;
    private int fotoLocal;
    private String dataPalestra;
    private MPalestrante mPalestrante;
    private String cargaHoraria;

    public MPalestra() {

    }

    public MPalestra(String nomePalestra, String localPalestra, String horarioPalestra, String ch, String dataPalestra, int fotoLocal, MPalestrante mPalestrante) {
        this.nomePalestra = nomePalestra;
        this.localPalestra = localPalestra;
        this.horarioPalestra = horarioPalestra;
        this.cargaHoraria = ch;
        this.dataPalestra = dataPalestra;
        this.fotoLocal = fotoLocal;
        this.mPalestrante = mPalestrante;
    }

    protected MPalestra(Parcel in) {
        nomePalestra = in.readString();
        localPalestra = in.readString();
        horarioPalestra = in.readString();
        fotoLocal = in.readInt();
    }

    public String getNomePalestra() {
        return nomePalestra;
    }

    public void setNomePalestra(String nomePalestra) {
        this.nomePalestra = nomePalestra;
    }

    public String getLocalPalestra() {
        return localPalestra;
    }

    public void setLocalPalestra(String localPalestra) {
        this.localPalestra = localPalestra;
    }

    public String getHorarioPalestra() {
        return horarioPalestra;
    }

    public void setHorarioPalestra(String horarioPalestra) {
        this.horarioPalestra = horarioPalestra;
    }

    public int getFotoLocal() {
        return fotoLocal;
    }

    public void setFotoLocal(int fotoLocal) {
        this.fotoLocal = fotoLocal;
    }

    public MPalestrante getmPalestrante() {
        return mPalestrante;
    }

    public void setmPalestrante(MPalestrante mPalestrante) {
        this.mPalestrante = mPalestrante;
    }

    public String getDataPalestra() {
        return dataPalestra;
    }

    public void setDataPalestra(String dataPalestra) {
        this.dataPalestra = dataPalestra;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
