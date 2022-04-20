package com.opsc7311.introfirestore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    // creating variables for our ArrayList and context
    private ArrayList<City> coursesArrayList;
    private Context context;

    // creating constructor for our adapter class
    public CityAdapter(ArrayList<City> coursesArrayList, Context context) {
        this.coursesArrayList = coursesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.city_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CityAdapter.ViewHolder holder, int position) {
        // setting data to our text views from our modal class.
        City city = coursesArrayList.get(position);
        holder.cityName.setText(city.getCity());
        holder.Day1.setText(city.getDay1());
        holder.Day2.setText(city.getDay2());
        holder.Day3.setText(city.getDay3());
        holder.Day4.setText(city.getDay4());
        holder.Day5.setText(city.getDay5());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list.
        return coursesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private final TextView cityName;
        private final TextView Day1;
        private final TextView Day2;
        private final TextView Day3;
        private final TextView Day4;
        private final TextView Day5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            cityName = itemView.findViewById(R.id.idCityName);
            Day1 = itemView.findViewById(R.id.idCityDay1);
            Day2 = itemView.findViewById(R.id.idCityDay2);
            Day3 = itemView.findViewById(R.id.idCityDay3);
            Day4 = itemView.findViewById(R.id.idCityDay4);
            Day5 = itemView.findViewById(R.id.idCityDay5);
        }
    }
}
