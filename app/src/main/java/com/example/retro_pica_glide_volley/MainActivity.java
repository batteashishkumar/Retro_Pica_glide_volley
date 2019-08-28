package com.example.retro_pica_glide_volley;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static MainActivity instance;
    private static RequestQueue requestQueue;
Recyc_adapter adapter;
    RecyclerView recyc;
    TextView txt;
    StringBuilder sb=null;
    String uri = "https://api.androidhive.info/json/glide.json";
    List<String> bitimagearray ;
    ImageView image1;
    ListView list;

    ArrayList<Bitmap> image_bitmaps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bitimagearray = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);


        recyc=findViewById(R.id.recyc);
        recyc.setHasFixedSize(true);
        recyc.setLayoutManager(new LinearLayoutManager(this));




     //   txt=findViewById(R.i//d.txt);
        sb=new StringBuilder();
        instance=this;
    }
    public static RequestQueue getsingleInstance() {
        return requestQueue;
    }
    public static MainActivity getInstance() {
        return instance;
    }


    public void call(View view){
        HttpPostAsyncTask asyncTask=new HttpPostAsyncTask(uri,MainActivity.this);
        asyncTask.execute();
    }
    public void get_names_links(List<String> name , List<String> link){
        recyc.setAdapter(new Recyc_adapter(link,this));

    }
}