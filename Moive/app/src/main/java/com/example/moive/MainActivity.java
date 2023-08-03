package com.example.moive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    List<MovieItem> items = new ArrayList<>();

   SearchView searchView;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        searchView = findViewById(R.id.searchview);

        ApiCall.getApiRequest().getMovieList("jaw","fdb70bd1").enqueue(new Callback<MovieResponse>()

        {

            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Success", Toast.LENGTH_SHORT).show();
                    List<Movie> list = response.body().getSearch();
                    items = new ArrayList<>();
                    if (list != null){
                        for (Movie movie : list) {
                            String title = movie.getTitle();
                            String year = movie.getYear();
                            String imdbID = movie.getImdbID();
                            String posterResId =movie.getPoster();

                            items.add(new MovieItem(title, year, imdbID, posterResId));
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "This Movie Name does not have in database ", Toast.LENGTH_SHORT).show();
                    }


                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(new MovieAdapter(getApplicationContext(),items, MainActivity.this));

                }else
                    Toast.makeText(MainActivity.this,response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() >= 3){
                    getMovieList(query);
                }else {
                    Toast.makeText(MainActivity.this, "Please enter mini 3 length!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
//                if (newText.length() >= 3){
//                    getMovieList(newText);
//                }else {
//                    Toast.makeText(MainActivity.this, "Please enter mini 3 length!", Toast.LENGTH_SHORT).show();
//                }

                return false;
            }
        });

    }

    private void getMovieList(String query) {
        ApiCall.getApiRequest().getMovieList(query ,"fdb70bd1").enqueue(new Callback<MovieResponse>()

        {

            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Success", Toast.LENGTH_SHORT).show();
                    List<Movie> list = response.body().getSearch();
                    items = new ArrayList<>();
                    if (list != null){
                        for (Movie movie : list) {
                            String title = movie.getTitle();
                            String year = movie.getYear();
                            String imdbID = movie.getImdbID();
                            String posterResId =movie.getPoster();

                            items.add(new MovieItem(title, year, imdbID, posterResId));
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "This Movie Name does not have in database ", Toast.LENGTH_SHORT).show();
                    }


                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(new MovieAdapter(getApplicationContext(),items, MainActivity.this));

                }else
                    Toast.makeText(MainActivity.this,response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }



    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this,MovieDetailview.class);
        intent.putExtra("Title", items.get(position).getTitle() );
        intent.putExtra("Year", items.get(position).getYear());
        startActivity(intent);


    }
}