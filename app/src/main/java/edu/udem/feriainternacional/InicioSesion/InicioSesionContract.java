package edu.udem.feriainternacional.InicioSesion;

import android.content.Context;
import android.content.Intent;

import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;

import edu.udem.feriainternacional.data.Usuario;

/**
 * Created by andrea on 12/02/17.
 */

public interface InicioSesionContract {


    //Maneja lo relacionado a UI

    interface View {


        void irAHome(Intent datosUsuario);

        void irAInicioSesion();

       // void mostrarProgreso();

        //void ocultarProgreso();

       // void cambiarTamañoBoton();

        void llamarApiGoogle(Intent intentInicioSesion);

        void mensajeInicioSesion(String nombre);

        void mensajeCerrarSesion();

        void mensajeDesconectarCuenta();

        void mensajeErrorInicioSesion();

    }

    // Maneja lo relacionado a las acciones del Usuario

    //TODO agregar interface Presenter con sus metodos

    interface AccionesUsuarioListener  {

        Intent iniciarSesion();

        void cerrarSesionGoogle();

        void desconectarCuenta();


    }

    //Maneja casos de uso de la logica de negocio, acceso a APIs y Bases de Datos

    interface InicioSesionInteractor {

        boolean getStatusInicioSesion();

        GoogleApiClient getGoogleApiClient();

        void preInicioSesion(Context contexto);

        void resultadoApiGoogle(Intent data);

        void checarPrevioInicioSesion();

        void manejarInicioSesion(GoogleSignInResult resultado);

    }



    //Maneja lo relacionado con el modelo, impl en clase persistente


    interface RepositorioDatos {

        void getTodoslosUsuarios();

        void getUsuario(double id);

        void agregarUsuario(Usuario usuario);

        void eliminarUsuario(double id);

        void actualizarUsuario(double id);

    }



}
