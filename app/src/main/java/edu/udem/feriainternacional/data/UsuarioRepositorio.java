package edu.udem.feriainternacional.data;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.udem.feriainternacional.InicioSesion.InicioSesionContract;

import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by laboratorio on 2/15/17.
 */

public class UsuarioRepositorio implements InicioSesionContract.RepositorioDatos {



    private firebaseBDHelper firebaseBDHelper=new firebaseBDHelper();
    private DatabaseReference referenciabd;
    private Usuario usuario;

    public UsuarioRepositorio(Usuario usuario) {
        referenciabd=firebaseBDHelper.getReferenciabd();
        this.usuario=usuario;
    }
/*
    public void listenerUsuarios(){

       //En Actividad de POST
        ValueEventListener usuarioListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Usuario object and use the values to update the UI
              //  Usuario usuario = dataSnapshot.getValue(Usuario.class);
                Log.d(TAG, "Entro a data change : " + usuario.getNombre());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Usuario failed, log a message
                Log.w(TAG, "Failed to read value", databaseError.toException());
                // ...
            }
        };


        referenciabd.addValueEventListener(usuarioListener);
    }*/

    public void nuevoUsuario (){

        referenciabd.child("usuarios").child("id").setValue(usuario.getId());
        referenciabd.child("usuarios").child("nombre").setValue(usuario.getNombre());
        referenciabd.child("usuarios").child("correo").setValue(usuario.getCorreo());

    }

    @Override
    public void getTodoslosUsuarios() {

    }

    @Override
    public void getUsuario(double id) {

    }

    @Override
    public void agregarUsuario(Usuario usuario) {

    }

    @Override
    public void eliminarUsuario(double id) {

    }

    @Override
    public void actualizarUsuario(double id) {

    }
}
