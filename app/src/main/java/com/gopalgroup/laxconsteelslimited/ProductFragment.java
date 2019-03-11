package com.gopalgroup.laxconsteelslimited;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        ProductData mProductData = new ProductData("Bright Bar", R.drawable.bright_bar);
        productDataList.add(mProductData);

        mProductData = new ProductData("Flat Bar", R.drawable.flat_bar);
        productDataList.add(mProductData);

        mProductData = new ProductData("Flat Bar", R.drawable.flat_bar);
        productDataList.add(mProductData);

        mProductData = new ProductData("Flat Bar", R.drawable.flat_bar);
        productDataList.add(mProductData);

        mProductData = new ProductData("Flat Bar", R.drawable.flat_bar);
        productDataList.add(mProductData);


        mProductData = new ProductData("Bright Bar", R.drawable.bright_bar);
        productDataList.add(mProductData);

        mProductData = new ProductData("Flat Bar", R.drawable.flat_bar);
        productDataList.add(mProductData);

        mProductData = new ProductData("Flat Bar", R.drawable.flat_bar);
        productDataList.add(mProductData);

        mProductData = new ProductData("Flat Bar", R.drawable.flat_bar);
        productDataList.add(mProductData);

        mProductData = new ProductData("Flat Bar", R.drawable.flat_bar);
        productDataList.add(mProductData);


        ProductAdapter productAdapter = new ProductAdapter(getContext(), productDataList);
        recyclerView.setAdapter(productAdapter);


        return view;
    }
}
