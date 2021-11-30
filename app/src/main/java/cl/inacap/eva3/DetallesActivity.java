package cl.inacap.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cl.inacap.eva3.modelo.Jugador;
import cl.inacap.eva3.modelo.ListaJugadores;

public class DetallesActivity extends AppCompatActivity {

    public Jugador jugador;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        intent = getIntent();
        int id=(Integer) intent.getExtras().get("idJugador");
        jugador= ListaJugadores.getInstancia().getJugador(id);

        TextView txtNombre=(TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(jugador.getNombre());

        TextView txtApellido=(TextView) findViewById(R.id.txtApellido);
        txtApellido.setText(jugador.getApellido()+" "+jugador.getApellido());

        TextView txtEquipo=(TextView) findViewById(R.id.txtEquipo);
        txtEquipo.setText(jugador.getEquipo()+" "+jugador.getEquipo());

        TextView txtActividad=(TextView) findViewById(R.id.txtActividad);
        Button cambiar=(Button) findViewById(R.id.actividad);

        if(jugador.isActividad()==jugador.disponible){
            txtActividad.setText("Activo");
            cambiar.setText("Marcar como Retirado");
        }
        else {
            txtActividad.setText("Retirado");
            cambiar.setText("Marcar como Activo");

        }
    }

    public void cambiarActividad(View view){
        jugador.setActividad(!jugador.isActividad());
        setResult(RESULT_OK,intent);
        finish();
    }

}