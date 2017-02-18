package edu.udem.feriainternacional.EventoFeed;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import edu.udem.feriainternacional.data.Evento;

/**
 * Created by andrea on 18/02/17.
 */

public interface FeedContract {



    interface View{

       // void detalleItem();
        void setItems(ArrayList<Object> itemLista);
        void mostrarMensaje();
        void mostrarProgreso();
        void ocultarProgreso();
        void setupRecyclerView();
    }

    interface ViewRecycler {

        RecyclerView.LayoutManager getLayoutManager();

        RecyclerView.Adapter getAdapter(ArrayList<Object> itemLista);
    }


    interface RecyclerItemClickListener {
        void onItemClickListener(int posicion);

    }

    interface AccionesUsuarioListener{


    }


    interface  Interactor{

        void getDataJSON(String url, LoaderListener listener);


    }


    interface LoaderListener{

        void onFinished(ArrayList<Object> itemLista);

    }


    interface  Repositorio{


    }




}
