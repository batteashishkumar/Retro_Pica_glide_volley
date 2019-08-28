package com.example.retro_pica_glide_volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class Recyc_adapter extends RecyclerView.Adapter<Recyc_adapter.Holder> {

    Holder holder;
    private List<String> link;
    Context context;

    public Recyc_adapter(List<String> link, Context context) {
        this.link = link;
        this.context = context;

    }

    @Override
    public int getItemCount() {

        return link.size();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_list, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        new DownloadImageTask(holder.img0,link.get(position)).execute();
        pica(link.get(position), holder);
        gli(link.get(position), holder);
    }




    class Holder extends RecyclerView.ViewHolder {
        ImageView img0, img1, img2, img3;

        public Holder(View itemView) {
            super(itemView);
            img0 = (ImageView) itemView.findViewById(R.id.retro);
            img1 = (ImageView) itemView.findViewById(R.id.picasso);
            img2 = (ImageView) itemView.findViewById(R.id.glide);
        }

    }


    public void pica(String imageUri, Holder holder) {

        Picasso.with(context).load(imageUri).into(holder.img1);
    }

    public void gli(String imageuri, Holder holder) {
        Glide.with(context)
                .load(imageuri)
                .into(holder.img2);
    }


//    public void voll(String s, final Holder holder) {
//        RequestQueue requestQueue = Volley.newRequestQueue(context);
//        ImageRequest imageRequest = new ImageRequest(s, new Response.Listener<Bitmap>() {
//            @Override
//            public void onResponse(Bitmap response) {
//
//                holder.img3.setImageBitmap(response);
//            }
//        },
//                0,
//                0,
//                ImageView.ScaleType.CENTER_CROP,
//                Bitmap.Config.RGB_565,
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                        error.printStackTrace();
//                    }
//                }
//        );
//
//
//        requestQueue.add(imageRequest);
//
//    }


}
