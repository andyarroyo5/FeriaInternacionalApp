package edu.udem.feriainternacional;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import edu.udem.feriainternacional.EventoFeed.FeedContract;
import edu.udem.feriainternacional.EventoFeed.FeedPresenter;
import edu.udem.feriainternacional.EventoFeed.adapter.AdapterExample;


public abstract class FragmentBase extends Fragment implements FeedContract.View,FeedContract.RecyclerItemClickListener{


    private final String TAG = this.getClass().getSimpleName();

    private FeedPresenter mFeedPresenter;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    RecyclerView.Adapter adapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Override
    public void onResume() {
        super.onResume();
        //mFeedPresenter.onResume();
       // mostrarMensaje();
    }

    private OnFragmentInteractionListener mListener;

    public FragmentBase() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayout(), container, false);
        progressBar=(ProgressBar) rootView.findViewById(R.id.progressBar);
        recyclerView=(RecyclerView) rootView.findViewById(R.id.recyclerViewBase);

        mFeedPresenter =new FeedPresenter(this);
        mostrarMensaje();
        setupRecyclerView();

        return rootView;
    }


    @Override
    public void setItems(ArrayList<Object> itemLista) {

        adapter = getAdapter(itemLista);
        recyclerView.setAdapter(adapter);

        if(adapter instanceof AdapterExample)
            ((AdapterExample) adapter).setRecyclerItemClickListener(this);
        /*else if(adapter instanceof AdapterExampleTypes)
            ((AdapterExampleTypes) adapter).setRecyclerItemClickListener(this);*/

    }

    @Override
    public void setupRecyclerView() {

        if(getLayoutManager() != null)
            recyclerView.setLayoutManager(getLayoutManager());
    }

    @Override
    public void mostrarMensaje() {
        Toast.makeText(getActivity(), "Ver Item", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarProgreso() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);

    }

    @Override
    public void ocultarProgreso() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);

    }


    @Override
    public void onItemClickListener(int posicion) {
        mFeedPresenter.onItemClickListener(posicion);
    }

    protected abstract int getLayout();

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract RecyclerView.Adapter getAdapter(ArrayList<Object> item);


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
