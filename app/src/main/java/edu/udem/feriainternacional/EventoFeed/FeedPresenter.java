package edu.udem.feriainternacional.EventoFeed;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by andrea on 18/02/17.
 */

public class FeedPresenter implements FeedContract.RecyclerItemClickListener, FeedContract.AccionesUsuarioListener, FeedContract.LoaderListener {

    private final String TAG = this.getClass().getSimpleName();


    private FeedContract.View mFeedView;
    private FeedContract.Interactor mFeedInteractor;


    public FeedPresenter(@NonNull FeedContract.View mFeedView) {
        this.mFeedView=mFeedView;
        mFeedInteractor=new FeedInteractorImpl("",this);
    }

    @Override
    public void onItemClickListener(int posicion) {

        mFeedView.mostrarMensaje();
        Log.e(TAG, "item"+posicion);
    }


    @Override
    public void onFinished(ArrayList<Object> itemLista) {

        mFeedView.setItems(itemLista);
        mFeedView.ocultarProgreso();

    }

    public void onResume()
    {
        mFeedView.mostrarProgreso();
        mFeedInteractor.getDataJSON("",this);
    }

}
