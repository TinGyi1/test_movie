package com.example.moive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        //List<MovieItem> items = new ArrayList<>();

        Toast.makeText(MainActivity.this,"API Call", Toast.LENGTH_SHORT).show();

        ApiRequest apiRequest = ApiCall.getApiRequest();



        ApiCall.getApiRequest().getMovieList("jaw","fdb70bd1").enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Success", Toast.LENGTH_SHORT).show();
                    List<Movie> list = response.body().getSearch();
                    List<MovieItem> items = new ArrayList<>();
                    for (Movie movie : list) {
                        String title = movie.getTitle();
                        String year = movie.getYear();
                        String imdbID = movie.getImdbID();
                        String posterResId =movie.getPoster();

                        items.add(new MovieItem(title, year, imdbID, posterResId));
                    }

                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(new MovieAdapter(getApplicationContext(),items));

                }else
                    Toast.makeText(MainActivity.this,response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}