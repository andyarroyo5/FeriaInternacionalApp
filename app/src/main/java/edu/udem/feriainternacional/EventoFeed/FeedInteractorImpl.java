package edu.udem.feriainternacional.EventoFeed;

import android.os.Handler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import edu.udem.feriainternacional.data.Evento;

/**
 * Created by andrea on 18/02/17.
 */

public class FeedInteractorImpl implements FeedContract.Interactor {


    private final String TAG = this.getClass().getSimpleName();
    private ArrayList<Object> items;

    public FeedInteractorImpl(String url, FeedContract.LoaderListener loaderListener)
    {
        items=new ArrayList<Object>();
        getDataJSON(url, loaderListener);
    }


    public ArrayList<Object> getItems() {return items; }

    public void setItems(ArrayList<Object> items) {
        this.items = items;
    }


    @Override
    public void getDataJSON(String url, final FeedContract.LoaderListener loaderListener) {


        //TODO BORRAR imports innecesarios
        Date date = new Date();
        Calendar fechaInicio = Calendar.getInstance();
        fechaInicio.setTime(date);
        fechaInicio.set(Calendar.HOUR_OF_DAY, 6);// for 6 hour
        fechaInicio.set(Calendar.MINUTE, 0);// for 0 min
        fechaInicio.set(Calendar.SECOND, 0);// for 0 sec
        System.out.println(fechaInicio.getTime());

        fechaInicio.getFirstDayOfWeek();
        Calendar fechafinal= new GregorianCalendar();
        fechafinal.getTime();
        System.out.println(fechafinal.getTime());
        fechafinal.set(2017,Calendar.NOVEMBER,24);
        System.out.println(fechafinal);

        Evento e1= new Evento(0,"evento Corea","CCU","Evento Inicial",fechaInicio,fechafinal);
        Evento e2= new Evento(1,"evento 2 Corea","CCU","Evento 2 Inicial",fechaInicio,fechafinal);

        items.add(e1);
        items.add(e2);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loaderListener.onFinished(getItems());
            }
        }, 2000);


    }

}
