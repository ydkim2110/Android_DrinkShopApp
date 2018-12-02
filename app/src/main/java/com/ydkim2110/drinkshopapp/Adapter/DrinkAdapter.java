package com.ydkim2110.drinkshopapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.ydkim2110.drinkshopapp.Interface.IItemClickListener;
import com.ydkim2110.drinkshopapp.Model.Drink;
import com.ydkim2110.drinkshopapp.R;

import java.util.List;

/**
 * Created by Kim Yongdae on 2018-12-02
 * email : ydkim2110@gmail.com
 */
public class DrinkAdapter extends RecyclerView.Adapter<DrinkViewHolder> {

    private static final String TAG = "DrinkAdapter";

    private Context mContext;
    private List<Drink> mDrinkList;

    public DrinkAdapter(Context context, List<Drink> drinkList) {
        mContext = context;
        mDrinkList = drinkList;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.drink_item_layout, parent, false);

        return new DrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {

        holder.txt_price.setText(new StringBuilder("$").append(mDrinkList.get(position).Price));
        holder.txt_drink_name.setText(mDrinkList.get(position).Name);

        Picasso.with(mContext)
                .load(mDrinkList.get(position).Link)
                .into(holder.img_product);

        holder.setIItemClickListener(new IItemClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Clicked!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDrinkList.size();
    }
}