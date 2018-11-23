package com.ziyata.explorejakarta;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterJakarta extends RecyclerView.Adapter<AdapterJakarta.ViewHolder> {
    Context context;
    String[] namaWisata,isiWisata;
    int[] gambarWisata;

    public AdapterJakarta(Context context, String[] namaWisata, String[] isiWisata, int[] gambarWisata) {
        this.context = context;
        this.namaWisata = namaWisata;
        this.isiWisata = isiWisata;
        this.gambarWisata = gambarWisata;
    }

    @NonNull
    @Override
    public AdapterJakarta.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    { View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_jakarta,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterJakarta.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaWisata[i]);
        Glide.with(context).load(gambarWisata[i]).into(viewHolder.imgGambarWisata);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailJakartaActivity.class);
                intent.putExtra("nw",namaWisata[i]);
                intent.putExtra("iw",isiWisata[i]);
                intent.putExtra("gw",gambarWisata[i]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarWisata.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNama;
        ImageView imgGambarWisata;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtListTitle);
            imgGambarWisata = itemView.findViewById(R.id.imgList);
        }
    }
}
