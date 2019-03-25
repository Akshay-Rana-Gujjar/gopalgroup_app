package com.gopalgroup.laxconsteelslimited;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, null);


        RecyclerView recyclerView = view.findViewById(R.id.recycleview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        List<ProductData> productDataList = new ArrayList<>();

        /*
        [
        "Bright Bars",
        "Precision Shaft Quality Bars",
        "Hexagonal Bright Bars",
        "Square Bright Bars",
        "Hrap Equal Angles",
        "Forged & Turned Round Bars",
        "Hrap Flat Bars",
        "Hot Rolled Round Cornered",
        "Hot Rolled Round Bars",
        "Continuous Cast Billets/Blooms",
        "Forging Quality Ingots",
        "Cold Drawn Flat Bars",
        "Hrap Unequal Angles",
        "Threaded Bars",
        "Duplex Steels"
        ]
        */

        String[] All_products = {

                "Bright Bars",
                "Precision Shaft Quality Bars",
                "Hexagonal Bright Bars",
                "Square Bright Bars",
                "Hrap Equal Angles",
                "Forged & Turned Round Bars",
                "Hrap Flat Bars",
                "Hot Rolled Round Cornered",
                "Hot Rolled Round Bars",
                "Continuous Cast Billets/Blooms",
                "Forging Quality Ingots",
                "Cold Drawn Flat Bars",
                "Hrap Unequal Angles",
                "Threaded Bars",
                "Duplex Steels"
        };

        for (String product : All_products){
            ProductData mProductData = new ProductData(product, getProductImageByName(product));
            productDataList.add(mProductData);
        }

        ProductAdapter productAdapter = new ProductAdapter(getContext(), productDataList);
        recyclerView.setAdapter(productAdapter);


        return view;
    }

    public int getProductImageByName(String productName){
        String image_filename = productName.replace("/","_").replace("& ", "").replace(" ", "_");
        image_filename = image_filename.toLowerCase();
        int image_drawable = getResources().getIdentifier(image_filename, "drawable", getContext().getPackageName());
        return  image_drawable;
    }
}
