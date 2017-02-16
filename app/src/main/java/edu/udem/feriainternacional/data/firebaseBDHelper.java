package edu.udem.feriainternacional.data;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by laboratorio on 2/15/17.
 */

public class firebaseBDHelper  {

    private FirebaseDatabase bd=FirebaseDatabase.getInstance();
    private DatabaseReference referenciabd = bd.getReference("Feria Internacional");

    public firebaseBDHelper() {

        referenciabd.setValue("Hello, World!");

    }


    public DatabaseReference getReferenciabd() {
        return referenciabd;
    }



}
