package com.amirmohammed.athrdiny;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PaintImagesAdapter extends RecyclerView.Adapter<PaintImagesAdapter.PaintHolder>{

    List<Integer> images;

    public PaintImagesAdapter(List<Integer> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public PaintHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PaintHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paint, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PaintHolder holder, int position) {
        holder.imageView.setImageResource(images.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PaintingActivity.class);
//                intent.putExtra("image", images.get(position));
                PaintView.image = images.get(position);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }


    class PaintHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public PaintHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_paint_image);
        }
    }
}
