package com.flf69740.testwimova.ui.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flf69740.testwimova.R;
import com.flf69740.testwimova.modele.MapPositions;

import java.util.ArrayList;
import java.util.List;

public class ListPositionsAdapter extends RecyclerView.Adapter<ListPositionsHolder> {

    private List<MapPositions> mapPositions;

    public ListPositionsAdapter() {}

    @NonNull
    @Override
    public ListPositionsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_main_map_position_card, parent, false);
        return new ListPositionsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPositionsHolder holder, int position) {
        holder.updateCard(this.mapPositions.get(position));
    }

    @Override
    public int getItemCount() {
        if (mapPositions != null) {
            return this.mapPositions.size();
        } else {
            return 0;
        }
    }

    public void AddAllPositions(List<MapPositions> positions){
        this.mapPositions = positions;
    }

    public void addAPosition(MapPositions position){
        if (mapPositions == null) {
            mapPositions = new ArrayList<>();
        }
        mapPositions.add(0, position);
    }

    public void clearAllPositions(){
        mapPositions.clear();
    }
}
