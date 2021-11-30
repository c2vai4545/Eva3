package cl.inacap.eva3.modelo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class ListaJugadores extends AppCompatActivity {

    private static ListaJugadores instancia =new ListaJugadores();
    private ArrayList<Jugador> listaJugadores;

    private ListaJugadores(){
        listaJugadores=new ArrayList<>();
        agregarJugador(new Jugador("Carlos","Nuñez","NacionalPUQ"));

    }
    public static ListaJugadores getInstancia(){
        return instancia;
    }
    public void agregarJugador(Jugador jugador){
        listaJugadores.add(jugador);
    }
    public Jugador getJugador(int id){
        return listaJugadores.get(id);
    }
    public ArrayList<Jugador> getListaJugadores(){
        return listaJugadores;
    }

    public void eliminarRetirados(){
        for (int i=0; i<listaJugadores.size();i++){
            if(!listaJugadores.get(i).isActividad()==Jugador.disponible){//no Esta Disponible
                listaJugadores.remove(i);
                i--;
            }
        }
    }
}