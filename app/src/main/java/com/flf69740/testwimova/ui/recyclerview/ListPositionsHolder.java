package com.flf69740.testwimova.ui.recyclerview;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.flf69740.testwimova.R;
import com.flf69740.testwimova.modele.MapPositions;
import java.util.Locale;

public class ListPositionsHolder extends RecyclerView.ViewHolder {

    private final TextView date;
    private final TextView latitude;
    private final TextView longitude;

    public ListPositionsHolder(@NonNull View itemView) {
        super(itemView);
        date = itemView.findViewById(R.id.map_position_card_date);
        latitude = itemView.findViewById(R.id.map_position_card_latitude);
        longitude = itemView.findViewById(R.id.map_position_card_longitude);
    }

    public void updateCard(MapPositions position){
        this.date.setText(position.getDate());
        this.latitude.setText(String.format(Locale.FRANCE,"%.2f", position.getLatitude()));
        this.longitude.setText(String.format(Locale.FRANCE,"%.2f", position.getLongitude()));
    }
}
