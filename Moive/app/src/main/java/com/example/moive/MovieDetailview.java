package com.example.moive;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.time.Year;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailview extends AppCompatActivity  {

    ImageView imageView;
    TextView title_txt,year_txt,genre_txt,writer_txt,actors_txt,plot_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detailview);

        String title = getIntent().getStringExtra("Title");
        String year = getIntent().getStringExtra("Year");

        title_txt= findViewById(R.id.title);
        year_txt= findViewById(R.id.year);
        genre_txt=findViewById(R.id.genre);
        writer_txt=findViewById(R.id.writer);
        actors_txt= findViewById(R.id.actors);
        plot_txt=findViewById(R.id.plot);
        imageView=findViewById(R.id.poster);


        ApiCall.getApiRequest().getMovieDetailList(title, year,"fdb70bd1").enqueue(new Callback<MovieDetailRespone>() {

            @Override
            public void onResponse(Call<MovieDetailRespone> call, Response<MovieDetailRespone> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MovieDetailview.this,"Success",Toast.LENGTH_SHORT).show();
                    MovieDetailRespone data = response.body();

                    title_txt.setText("Title : " + data.getTitle());
                    year_txt.setText("Year : "+data.getYear());
                    genre_txt.setText("Genre : "+data.getGenre());
                    writer_txt.setText("Writer : "+data.getWriter());
                    actors_txt.setText("Actors : "+data.getActors());
                    plot_txt.setText(data.getPlot());

                    Glide.with(MovieDetailview.this)
                            .load(data.getPoster())
                            .error(R.drawable.error404) // Set the default image resource ID here
                            .into(imageView);

                }else {
                    Toast.makeText(MovieDetailview.this,"Server Error",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<MovieDetailRespone> call, Throwable t) {
                Toast.makeText(MovieDetailview.this,"NO Internet",Toast.LENGTH_SHORT).show();

            }
        });






    }
}