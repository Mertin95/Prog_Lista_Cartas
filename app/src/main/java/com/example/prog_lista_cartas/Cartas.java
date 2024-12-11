package com.example.prog_lista_cartas;

import android.os.Parcel;
import android.os.Parcelable;

//modelo de las cartas que guardaremos en la aplicacion
public class Cartas implements Parcelable {
    private String nombre;
    private String tipo;

    public Cartas(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "Cartas{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    protected Cartas(Parcel in){
        nombre = in.readString();
        tipo = in.readString();
    }

    @Override
    public  void writeToParcel (Parcel dest, int flags){
        dest.writeString(nombre);
        dest.writeString(tipo);
    }

    @Override
    public int describeContents(){
        return 0;
    }

    public static final Creator<Cartas> CREATOR = new Creator<Cartas>() {
        @Override
        public Cartas createFromParcel(Parcel in) {
            return new Cartas(in);
        }

        @Override
        public Cartas[] newArray(int size) {
            return new Cartas[size];
        }
    };
}


