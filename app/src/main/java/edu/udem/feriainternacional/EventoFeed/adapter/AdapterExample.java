package edu.udem.feriainternacional.EventoFeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


import edu.udem.feriainternacional.EventoFeed.FeedContract;
import edu.udem.feriainternacional.R;
import edu.udem.feriainternacional.data.Evento;

/**
 * Created by andrea on 18/02/17.
 */

public class AdapterExample extends RecyclerView.Adapter<AdapterExample.eventoViewHolder>  {


    private ArrayList<Object> itemLista;
    private int itemLayout;
    private FeedContract.RecyclerItemClickListener recyclerItemClickListener;


    public void setRecyclerItemClickListener(FeedContract.RecyclerItemClickListener recyclerItemClickListener) {
            this.recyclerItemClickListener = recyclerItemClickListener;
            }

    public AdapterExample() {
    }

    public AdapterExample(ArrayList<Object> itemLista, int itemLayout) {
        this.itemLista = itemLista;
        this.itemLayout = itemLayout;
    }

    @Override
    public eventoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new eventoViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final eventoViewHolder holder, final int position) {
        final Evento evento = (Evento) itemLista.get(position);
        holder.titulo.setText(evento.getTitulo());

    }


    @Override
    public int getItemCount() {
        return itemLista.size();
    }



    public class eventoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

      //TODO investigar o implementar ButterKnife
        //@Bind(R.id.txt_title)
        public View mView;
        TextView titulo;
        TextView lugar;
        TextView descripcion;
        TextView fechaInicio;
        TextView fechaFinaloHorario;



        public eventoViewHolder(View itemView) {
            super(itemView);
            //ButterKnife.bind(this, itemView);
            this.mView=itemView;
            titulo=(TextView) mView.findViewById(R.id.evento_titulo);

            mView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (recyclerItemClickListener != null)
              recyclerItemClickListener.onItemClickListener(getAdapterPosition());
        }

    }
}
