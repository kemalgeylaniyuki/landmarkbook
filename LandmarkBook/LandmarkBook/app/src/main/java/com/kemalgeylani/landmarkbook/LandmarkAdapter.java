package com.kemalgeylani.landmarkbook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kemalgeylani.landmarkbook.databinding.RecyclerRowBinding;
import java.util.ArrayList;
import java.util.Objects;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.Landmarkholder> {

    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public Landmarkholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new Landmarkholder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Landmarkholder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.recyclerVeiwTextView.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                //intent.putExtra("landmark",landmarkArrayList.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setSentLandmark(landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }

    public class Landmarkholder extends RecyclerView.ViewHolder{

        private RecyclerRowBinding binding;

        public Landmarkholder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
