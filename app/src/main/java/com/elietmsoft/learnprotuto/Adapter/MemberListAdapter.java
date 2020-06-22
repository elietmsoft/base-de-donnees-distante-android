package com.elietmsoft.learnprotuto.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.elietmsoft.learnprotuto.Controller.Controle;
import com.elietmsoft.learnprotuto.Model.Membre;
import com.elietmsoft.learnprotuto.R;
import com.elietmsoft.learnprotuto.Util.MesOutils;
import java.util.ArrayList;

public class MemberListAdapter extends BaseAdapter {

    private ArrayList<Membre> members;
    private LayoutInflater inflater;
    private Controle controle;
    private Context contexte;

    public MemberListAdapter(Context contexte,ArrayList<Membre> members){
        this.members = members;
        this.contexte = contexte;
        this.inflater=LayoutInflater.from(contexte);
        this.controle=Controle.getInstance(null);
    }

    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public Object getItem(int position) {
        return members.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;

        if(view == null){
            holder=new ViewHolder();
            view = inflater.inflate(R.layout.member_item,null);
            holder.txtId = (TextView)view.findViewById(R.id.txtID);
            holder.txtNoms = (TextView)view.findViewById(R.id.txtNoms);
            holder.txtDateAdhesion = (TextView)view.findViewById(R.id.txtDateAdhesion);
            holder.txtSexe = (TextView)view.findViewById(R.id.txtSexe);
            holder.btnOperation=(ImageButton)view.findViewById(R.id.btnOperation);
            view.setTag(holder);
        }else{
            holder=(ViewHolder)view.getTag();
        }
        holder.txtId.setText(""+members.get(position).getId());
        holder.txtNoms.setText(members.get(position).getNoms());
        holder.txtDateAdhesion.setText(MesOutils.convertDateToString(members.get(position).getDateAdhesion()));
        holder.txtSexe.setText(members.get(position).getSexe());
        holder.btnOperation.setTag(position);
        holder.btnOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                int position=(int)v.getTag();
                notifyDataSetChanged();//rafraichissement de la liste*/
            }
        });
        return view;
    }
    private class ViewHolder{
        ImageButton btnOperation;
        TextView txtNoms;
        TextView txtDateAdhesion;
        TextView txtSexe;
        TextView txtId;
    }
}
