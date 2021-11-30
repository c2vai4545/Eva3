package cl.inacap.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cl.inacap.eva3.modelo.Jugador;
import cl.inacap.eva3.modelo.ListaJugadores;

public class ListaJugadoresActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargarLista();
    }

    public void cargarLista(){
        lista=getListView();
        List<Jugador> autoList= ListaJugadores.getInstancia().getListaJugadores();

        ArrayAdapter<Jugador> listaAdapter = new ArrayAdapter<Jugador>(this,
                android.R.layout.simple_list_item_1,autoList);
        lista.setAdapter(listaAdapter);
    }

    private ListView getListView() {
    }


    @Override
    public void onListItemClick(ListView listView, View view, int posicion, long id){
        Intent intent=new Intent(ListaJugadoresActivity.this, DetallesActivity.class);
        intent.putExtra("idJugador", (int)id);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1){
            if(resultCode == RESULT_OK){
                cargarLista();
            }
        }
    }
}