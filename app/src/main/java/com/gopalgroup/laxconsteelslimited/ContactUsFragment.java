package com.gopalgroup.laxconsteelslimited;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ContactUsFragment extends Fragment {

    private String address= "Plot No. 235, Sarkhej Bavla , NH8A, Village - Sarai, Taluka - Sanand, Ahmedabad, Gujarat 382220";

    private String facebook_page = "https://facebook.com/laxconSteelsLimited/";

    private String linkedin_page = "https://facebook.com/laxconSteelsLimited/";

    private String twitter = "https://twitter.com/LaxconSteelsLtd";


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);

        LinearLayout map_container = view.findViewById(R.id.map_container);

        TextView contact_call = view.findViewById(R.id.contact_call);

        ImageView social_media_facebook_button = view.findViewById(R.id.social_media_facebook);
        ImageView social_media_linkedin_button = view.findViewById(R.id.social_media_linkedin);
        ImageView social_media_twitter_button = view.findViewById(R.id.social_media_twitter);
        TextView website_link = view.findViewById(R.id.website_link);


        map_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + address;
//                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                startActivity(intent);

            }
        });


        contact_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01142952500"));
                startActivity(intent);
            }
        });


        social_media_facebook_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(facebook_page);

            }
        });


        social_media_linkedin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(linkedin_page);

            }
        });

        social_media_twitter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(twitter);
            }
        });

        website_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("http://laxconsteels.com");
            }
        });

        return view;
    }


    void openUrl(String url){
        Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}

