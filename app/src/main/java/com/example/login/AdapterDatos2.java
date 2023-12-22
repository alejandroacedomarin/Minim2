package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.ModelosDeClases.Badges;
import com.example.login.ModelosDeClases.ProductoVo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterDatos2 extends RecyclerView.Adapter<AdapterDatos2.ViewHolderDatos>{
    private ArrayList<Badges> listaBadges;
    private Context context;
    private View.OnClickListener listener;
    public AdapterDatos2(ArrayList<Badges> listaBadges, Context context){
        this.listaBadges=listaBadges;
        this.context = context;
        //listaProductos=new ArrayList<>();
    }



    @NonNull
    @Override
    public AdapterDatos2.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_insignias, parent,false);

        return new AdapterDatos2.ViewHolderDatos(view);
    }



    @Override
    public void onBindViewHolder(@NonNull AdapterDatos2.ViewHolderDatos holder, int position) {

        holder.etiN.setText(listaBadges.get(position).getNaame().toString());


        Picasso.get().load(listaBadges.get(position).getAavatar()).resize(250, 250).into(holder.foto);


    }

    @Override
    public int getItemCount() {
        return listaBadges.size();
    }
    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView etiN;
        ImageView foto;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            etiN=(TextView) itemView.findViewById(R.id.n_productt);



            foto=(ImageView) itemView.findViewById(R.id.idImagenn);

        }


    }
}
