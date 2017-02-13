package edu.udem.feriainternacional.Perfil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.udem.feriainternacional.GlobalApp;
import edu.udem.feriainternacional.InicioSesion.InicioSesionActivity;
import edu.udem.feriainternacional.InicioSesion.InicioSesionPresenter;
import edu.udem.feriainternacional.R;

public class PerfilActivity extends AppCompatActivity implements PerfilContract.View, View.OnClickListener {



    private final String TAG = this.getClass().getSimpleName();


    TextView txtNombre;
    TextView txtCorreo;
    Button btnCerrarSesionGoogle;

    private InicioSesionPresenter mInicioSesionPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        txtNombre=(TextView) findViewById(R.id.txtNombre);
        btnCerrarSesionGoogle =(Button) findViewById(R.id.btnCerrarSesionGoogle);
        btnCerrarSesionGoogle.setOnClickListener(this);

        Intent datosUsuario=getIntent();
       // mostrarInfoUsuario(datosUsuario);

        mInicioSesionPresenter= GlobalApp.getInstance().getInicioSesionPresenter();

    }

    @Override
    public void mostrarInfoUsuario(Intent datosUsuario) {

        double id =Double.parseDouble(datosUsuario.getStringExtra("id"));
        String nombre=datosUsuario.getStringExtra("nombre");
        String correo=datosUsuario.getStringExtra("correo");
        String urlFotoPerfil=datosUsuario.getStringExtra("img");

        txtNombre.setText(nombre);
        txtCorreo.setText(correo);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()== btnCerrarSesionGoogle.getId())
        {

            mInicioSesionPresenter.cerrarSesionGoogle();
            finish();
        }
    }


}
