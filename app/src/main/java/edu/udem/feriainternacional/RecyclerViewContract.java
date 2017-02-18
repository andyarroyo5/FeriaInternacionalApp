package edu.udem.feriainternacional;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by andrea on 18/02/17.
 */

public interface RecyclerViewContract {



    interface ViewRecycler {

        void setupRecyclerView();

        RecyclerView.LayoutManager getLayoutManager();

        RecyclerView.Adapter getAdapter(ArrayList<Object> itemLista);
    }


    interface RecyclerItemClickListener {
        void onItemClickListener(int posicion);

    }
}
