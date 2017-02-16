package edu.udem.feriainternacional.InicioSesion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import edu.udem.feriainternacional.data.Usuario;
import edu.udem.feriainternacional.data.UsuarioRepositorio;


/**
 * Created by andrea on 12/02/17.
 */

public class InicioSesionPresenter implements InicioSesionContract.AccionesUsuarioListener, InicioSesionContract.InicioSesionInteractor, GoogleApiClient.OnConnectionFailedListener  {


    //Llamar clase que maneja el repositorio de datos, m- miembro

    //TODO HACER CLASE PERSISTENTE
    //private final UsuarioRepositorio mUsuarioRepositorio;

    //Usuario usuario;


    private final String TAG = this.getClass().getSimpleName();

    private InicioSesionContract.View mInicioSesionView;

    private GoogleApiClient mGoogleApiCliente;

    private boolean statusInicioSesion=false;

    private UsuarioRepositorio usuarioRepositorio;


    public void setView(@NonNull InicioSesionContract.View mInicioSesionView)
    {
        this.mInicioSesionView = mInicioSesionView;
    }


    @Override
    public Intent iniciarSesion(){

        Intent intentInicioSesion = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiCliente);
        return intentInicioSesion;
    }

    @Override
    public void cerrarSesionGoogle() {

        Log.d(TAG,"cerrar sesion" + mGoogleApiCliente.isConnected());

        mGoogleApiCliente.connect();
        mGoogleApiCliente.registerConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {


          @Override
          public void onConnected(@Nullable Bundle bundle) {

              //Salir de Firebase y Google
              //FirebaseAuth.getInstance().signOut();
              if (mGoogleApiCliente.isConnected()) {
                  Auth.GoogleSignInApi.signOut(mGoogleApiCliente).setResultCallback(new ResultCallback<Status>() {
                      @Override
                      public void onResult(@NonNull Status status) {
                          if (status.isSuccess()) {
                              Log.d(TAG, "Usuario cerro sesion");
                             mInicioSesionView.irAInicioSesion();
                             mInicioSesionView.mensajeCerrarSesion();
                          }
                      }
                  });
              }
          }

            @Override
            public void onConnectionSuspended(int i) {

                Log.d(TAG, "onConnectionSuspended");

            }
        });
    }


    @Override
    public void desconectarCuenta() {

        Auth.GoogleSignInApi.revokeAccess(mGoogleApiCliente).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {

                        //Viewdesconectar cuenta
                        mInicioSesionView.mensajeDesconectarCuenta();

                    }
                });

    }


    @Override
    public boolean getStatusInicioSesion() {
        return statusInicioSesion;

    }

    @Override
    public GoogleApiClient getGoogleApiClient() {


            return mGoogleApiCliente;
    }

    @Override
    public void preInicioSesion(Context contexto) {

        //Configurar inicio sesion para pedir el ID, txtCorreo y perfil basico de usuario
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        //Crear el Apli Cliente de google para acceder a API de inicio sesion de Google
        mGoogleApiCliente = new GoogleApiClient.Builder(contexto)
                .enableAutoManage((FragmentActivity) contexto /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

    }

    @Override
    public void checarPrevioInicioSesion() {

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiCliente);
        if (opr.isDone()) {
            // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
            // and the GoogleSignInResult will be available instantly.
            Log.d(TAG, "cached sign-in");
            GoogleSignInResult resultado = opr.get();
            manejarInicioSesion(resultado);



        } else {

            Log.d(TAG, "silent sign in ");
            // If the user has not previously signed in on this device or the sign-in has expired,
            // this asynchronous branch will attempt to sign in the user silently.  Cross-device
            // single sign-on will occur in this branch.
            //    showProgressDialog();
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(GoogleSignInResult googleSignInResult) {
                    //hideProgressDialog();
                    manejarInicioSesion(googleSignInResult);
                }
            });
        }


    }


    @Override
    public void resultadoApiGoogle(Intent data) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        manejarInicioSesion(result);
    }


    @Override
    public void manejarInicioSesion(GoogleSignInResult resultado) {

        if (resultado.isSuccess()) {
            // Inicio sesion correctamente, entrar a aplicacion
            GoogleSignInAccount cuenta = resultado.getSignInAccount();


            Usuario usuario=new Usuario(cuenta.getId(),cuenta.getDisplayName(),cuenta.getEmail(),cuenta.getPhotoUrl());
            //agregar usuario o checar si ya tiene cuenta *
            usuarioRepositorio=new UsuarioRepositorio(usuario);
            usuarioRepositorio.nuevoUsuario();

            Intent datosUsuario= new Intent();

            datosUsuario.putExtra("id",cuenta.getId());
            datosUsuario.putExtra("nombre", cuenta.getDisplayName());
            datosUsuario.putExtra("correo", cuenta.getEmail());
            datosUsuario.putExtra("img",cuenta.getPhotoUrl());



            mInicioSesionView.mensajeInicioSesion(cuenta.getDisplayName());

            mInicioSesionView.irAHome(datosUsuario);





            statusInicioSesion=true;



        } else {
            // Cerrar sesion o no entro correctamente
            //  updateUI(false);

            statusInicioSesion=false;
            //Toast.makeText(this, "Error inicio de sesion", Toast.LENGTH_SHORT).show();

        }

    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }
}
