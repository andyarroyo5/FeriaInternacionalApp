package edu.udem.feriainternacional.EventoFeed;

import android.support.annotation.NonNull;

import edu.udem.feriainternacional.RecyclerViewContract;

/**
 * Created by andrea on 18/02/17.
 */

public class EventoFeedPresenter implements FeedContract.AccionesUsuarioListener,FeedContract.RecyclerItemClickListener {


    private FeedContract.View mEventoFeedView;
    private FeedContract.Interactor mEventoFeedInteractor;


    //Adjuntar vista e inicializar interactor para usar metodos
    public EventoFeedPresenter(@NonNull FeedContract.View mEventoFeedView) {

        this.mEventoFeedView=mEventoFeedView;
       // mEventoFeedInteractor=new FeedInteractorImpl("",this);
    }



    @Override
    public void onItemClickListener(int posicion) {

        mEventoFeedView.mostrarMensaje();

    }
}
