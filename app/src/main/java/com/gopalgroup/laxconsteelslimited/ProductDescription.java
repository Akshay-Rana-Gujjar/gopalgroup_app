package com.gopalgroup.laxconsteelslimited;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.io.InputStream;

public class ProductDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);

        TextView product_description_textview = findViewById(R.id.productDescription);

        String title = getIntent().getStringExtra("productName");
        int titleImage = getIntent().getIntExtra("productImage", R.drawable.bright_bars);

        ImageView title_image = findViewById(R.id.toolbarImage);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbar);

        title_image.setImageResource(titleImage);

        collapsingToolbarLayout.setTitle(title);

        product_description_textview.setText(loadDescriptionFromAsset(title));

    }

    public String loadDescriptionFromAsset(String filename) {
        String description_filename = filename.replace("/","_").replace("& ", "").replace(" ", "_");
        description_filename = description_filename.toLowerCase();
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open(description_filename+".txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            Toast.makeText(this, "Description not found", Toast.LENGTH_SHORT).show();
            return null;
        }
        return json;
    }
}
