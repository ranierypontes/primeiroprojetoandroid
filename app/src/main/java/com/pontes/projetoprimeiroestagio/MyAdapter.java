package com.pontes.projetoprimeiroestagio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ponte on 16/03/2017.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<Contato> listaDeContatos;
    private LayoutInflater inflater;
    private ItemClickListener interfaceClick;

    public void setItemClick(final ItemClickListener interfaceClick) {
        this.interfaceClick = interfaceClick;
    }

    public MyAdapter(List<Contato> listContacts, Context context) {
        this.inflater = LayoutInflater.from(context);
        this.listaDeContatos = listContacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_itens, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contato itens = listaDeContatos.get(position);
        holder.textNome.setText(itens.getNome());
    }

    @Override
    public int getItemCount() {
        return 0;
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textNome;
        private ImageView imageTelefone;

        public MyViewHolder(View view) {
            super(view);

            textNome = (TextView) view.findViewById(R.id.text_nome);
            imageTelefone = (ImageView) view.findViewById(R.id.image_call);
            imageTelefone.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.image_call) {
                interfaceClick.setOnclickListener(getAdapterPosition());
            }
        }

    }

}
