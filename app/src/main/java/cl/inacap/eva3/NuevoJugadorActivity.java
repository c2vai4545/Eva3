package cl.inacap.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import cl.inacap.eva3.modelo.Jugador;
import cl.inacap.eva3.modelo.ListaJugadores;

public class NuevoJugadorActivity extends AppCompatActivity {

    private ListaJugadores listaJugadores=ListaJugadores.getInstancia();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_jugador);

    }

    public void ingresarNuevo(View view){



        String nombre=((EditText) findViewById(R.id.ingresarNombre)).getText().toString();
        String apellido=((EditText)findViewById(R.id.ingresarApellido)).getText().toString();
        String equipo="";
        String otroEquipo=((EditText)findViewById(R.id.otroEquipo)).getText().toString();

        RadioGroup rgEquipo = (RadioGroup) findViewById(R.id.rgEquipo);

        int idRg= rgEquipo.getCheckedRadioButtonId();
        switch (idRg) {
            case R.id.rNaPuq:
                equipo += "Nacional PUQ";
                break;
            case R.id.rSpurs:
                equipo +="Spurs";
                break;
            case R.id.rPanzers:
                equipo+="Panzers";
                break;
            case R.id.otro:

                if (otroEquipo.isEmpty()) {

                    Toast.makeText(this, "Debe ingresar un equipo.", Toast.LENGTH_SHORT).show();
                }else {
                    equipo += otroEquipo;
                }

                break;

        }
        if(nombre.isEmpty()) {

                Toast.makeText(this, "Debe ingresar un nombre.", Toast.LENGTH_SHORT).show();


            }
        if(apellido.isEmpty()) {

                Toast.makeText(this, "Debe ingresar un apellido.", Toast.LENGTH_SHORT).show();
            }
        Jugador jugador=new Jugador(nombre, apellido, equipo);
        listaJugadores.agregarJugador(jugador);
        finish();

            }
        }2

