package edu.udem.feriainternacional.EventoFeed;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import edu.udem.feriainternacional.EventoFeed.adapter.AdapterExample;
import edu.udem.feriainternacional.FragmentBase;
import edu.udem.feriainternacional.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EventoFeedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventoFeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class EventoFeedFragment extends FragmentBase implements  FeedContract.ViewRecycler {



    private final String TAG = this.getClass().getSimpleName();


    private FeedPresenter mFeedPresenter;

    public EventoFeedFragment() { }

    @Override
    protected int getLayout() {
        return R.layout.fragment_base;
    }

    /**
     * Metodo Fabrica para instancia Fragment
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventoFeedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventoFeedFragment newInstance(String param1, String param2) {

        EventoFeedFragment fragment = new EventoFeedFragment();
        /*
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        */

        return fragment;
    }


    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return getGridLayoutManager();
    }

    @Override
    public RecyclerView.Adapter getAdapter(ArrayList<Object> itemLista) {
        return new AdapterExample(itemLista,R.layout.item_evento);
    }



    private GridLayoutManager getGridLayoutManager() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                getActivity(),
                2,
                GridLayoutManager.VERTICAL,
                false);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int posicion) {
                //stagger rows custom
                return (posicion % 3 == 0 ? 2 : 1);
            }
        });


        return gridLayoutManager;
    }




}
