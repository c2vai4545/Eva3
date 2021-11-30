package cl.inacap.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import cl.inacap.eva3.modelo.Jugador;
import cl.inacap.eva3.modelo.ListaJugadores;

public class MainActivity extends AppCompatActivity {

    private ListaJugadores lista=ListaJugadores.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void verLista(View view){
        ArrayList<Jugador> jugadores=lista.getListaJugadores();
        if(jugadores.size()>0) {

            Intent intent = new Intent(this, ListaJugadoresActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"No hay jugadores disponibles",Toast.LENGTH_SHORT).show();
        }
    }
    public void ingresarNuevo(View view){
        Intent intent=new Intent(this,NuevoJugadorActivity.class);
        startActivity(intent);
    }

    public void eliminarNoDisponible(View view){
        lista.eliminarRetirados();
        Toast.makeText(this,"Los jugadores retirados han sido eliminados",Toast.LENGTH_SHORT).show();
    }
}