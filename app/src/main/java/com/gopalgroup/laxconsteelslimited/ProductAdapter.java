package com.gopalgroup.laxconsteelslimited;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    private Context context;
    private List<ProductData> productDataList;




    public ProductAdapter(Context context, List<ProductData> productDataList) {
        this.context = context;
        this.productDataList = productDataList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card_item, parent, false);


        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder viewHolder, final int i) {

        viewHolder.imageView.setImageResource(productDataList.get(i).getProductImage());
        viewHolder.productName.setText(productDataList.get(i).getProductName());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDescription.class);

                intent.putExtra("productName", productDataList.get(i).getProductName());
                intent.putExtra("productImage", productDataList.get(i).getProductImage());

                ContextCompat.startActivity(context,intent,null);

            }
        });

    }

    @Override
    public int getItemCount() {
        return productDataList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView productName;
        CardView cardView;


        ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.productImage);

            productName = itemView.findViewById(R.id.productName);

            cardView = itemView.findViewById(R.id.cardView);
        }
    }



}
