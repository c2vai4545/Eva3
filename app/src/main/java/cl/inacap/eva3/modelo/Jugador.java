package cl.inacap.eva3.modelo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Jugador extends AppCompatActivity {

    private String nombre;
    private String apellido;
    private String equipo;
    private boolean actividad;
    public static final boolean disponible=true;

    public Jugador(String nombre, String apellido, String equipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.equipo = equipo;
        this.actividad = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public boolean isActividad() {
        return actividad;
    }

    public void setActividad(boolean actividad) {
        this.actividad = actividad;
    }

    @Override
    public String toString() {
        String jugando;
        if(actividad==disponible) jugando="Activo";
        else jugando="Retirado";
        return nombre+" "+apellido+": "+jugando;
    }
}