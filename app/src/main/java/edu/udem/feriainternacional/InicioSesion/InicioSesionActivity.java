package edu.udem.feriainternacional.InicioSesion;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.gms.common.SignInButton;

import edu.udem.feriainternacional.GlobalApp;
import edu.udem.feriainternacional.HomeActivity;

import edu.udem.feriainternacional.R;


public class InicioSesionActivity extends AppCompatActivity implements InicioSesionContract.View, View.OnClickListener {


    private final String TAG = this.getClass().getSimpleName();


    private InicioSesionPresenter mInicioSesionPresenter;

    private static final int RC_INICIO_SESION = 1000;
    private SignInButton btnInicioSesionGoogle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inicio_sesion);

        //Listeners boton
        btnInicioSesionGoogle= (SignInButton) findViewById(R.id.btnInicioSesionGoogle);
        btnInicioSesionGoogle.setOnClickListener(this);

        mInicioSesionPresenter= GlobalApp.getInstance().getInicioSesionPresenter();
        mInicioSesionPresenter.setView(this);

        mInicioSesionPresenter.preInicioSesion(this);

    }


    @Override
    protected void onStart() {
        super.onStart();

        mInicioSesionPresenter.checarPrevioInicioSesion();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==RC_INICIO_SESION)
        {
            mInicioSesionPresenter.resultadoApiGoogle(data);
        }


    }


    @Override
    public void onClick(View v) {

        if (v.getId()== btnInicioSesionGoogle.getId())
        {
            llamarApiGoogle(mInicioSesionPresenter.iniciarSesion());
        }

    }

    @Override
    public void irAHome(Intent datosUsuario) {

        startActivity(new Intent(this, HomeActivity.class),datosUsuario.getExtras());
        finish();

    }

    @Override
    public void irAInicioSesion() {
        startActivity(new Intent(this, InicioSesionActivity.class));
        finish();
    }


    @Override
    public void llamarApiGoogle(Intent intentInicioSesion) {

        startActivityForResult( intentInicioSesion, RC_INICIO_SESION);
    }


    @Override
    public void mensajeInicioSesion(String nombre) {

        Toast.makeText(this, "Hola " + nombre, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void mensajeCerrarSesion() {

        Toast.makeText(this, "Haz cerrado sesion", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void mensajeDesconectarCuenta() {

        Toast.makeText(this, "Haz desconectado tu cuenta", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void mensajeErrorInicioSesion() {

        Toast.makeText(this, "Error de Inicio de Sesion", Toast.LENGTH_SHORT).show();

    }


}
