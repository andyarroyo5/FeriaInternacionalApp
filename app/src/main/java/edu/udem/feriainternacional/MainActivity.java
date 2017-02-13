package edu.udem.feriainternacional;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.udem.feriainternacional.InicioSesion.InicioSesionActivity;


public class MainActivity extends AppCompatActivity {




    private static final String TAG = "MainActivity";

    TextView txtNombre;
    TextView txtCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        txtNombre =(TextView) findViewById(R.id.txtNombre);
        txtCorreo =(TextView) findViewById(R.id.txtMail);

        Button cerrarSesion=(Button)findViewById(R.id.btnCerrarSesionGoogle);
       /* cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), InicioSesionActivity.class),InicioSesionActivity.RC_CERRAR_SESION);
            }
        });*/

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

     /*   if(resultCode== InicioSesionActivity.RC_INICIO_SESION_PERMITIDO)
        {
           informacionUsuario(data);
        }*/


    }


    //Guardar informacion del usuario TODO CAMBIAR A SHARED PREFERENCES
    public void informacionUsuario(Intent data)
    {
        double id =Double.parseDouble(data.getStringExtra("id"));
        String nombre=data.getStringExtra("txtNombre");
        String correo=data.getStringExtra("txtCorreo");
        String urlFotoPerfil=data.getStringExtra("img");

        txtNombre.setText(nombre);
        txtCorreo.setText(correo);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
