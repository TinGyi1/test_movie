package com.example.moive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<MovieItem> items = new ArrayList<>();
        items.add(new MovieItem("Pathasn(2023)" , "Shah Rukh Khan" ,"A Pakistani general hires a private terror outfit to conduct attacks in India while Pathaan, an Indian secret agent, is on a mission to form a special unit.", R.drawable.pathaan_film_poster));
        items.add(new MovieItem("The Terminal","Tom Hanks" , "Viktor Navorski gets stranded at an airport when a war rages in his country. He is forced by the officials to stay at the airport until his original identity is confirmed.", R.drawable.the_terminal));
        items.add(new MovieItem("Mishan Impossible","Naveen Polishetty","Tired of feeling insignificant, three boys set out to apprehend a notorious criminal. However, they end up getting embroiled with a child trafficking ring and cross paths with a journalist.",R.drawable.mishan_impossible));
        items.add(new MovieItem("Nice View","Jing Hao ","Nice View is a 2022 Chinese comedy-drama film directed by Wen Muye. It is Wen's second feature film. It mainly tells the story of a young man named Jing Hao who, in order to save his sister, desperately seizes the opportunity he found to start a business, changes his fate, and affects the people around him",R.drawable.nice_view_poster));
        items.add(new MovieItem("Wu Kong","Eddie Peng","Five hundred years before the Monkey King wreaks havoc on the heavenly kingdom, Wukong refuses to bow down to his destiny when he sets out to rebel against the gods.", R.drawable.wu_kong));
        items.add(new MovieItem("Love 020","Bai YuGaming ","expert and campus stud Xiao Nai finds himself falling for computer science major Bei Wei Wei because of her mastery of an online role-playing game.",R.drawable.love_020));
        items.add(new MovieItem("Green Snake","Tang Xiaoxi","While trying to free her sister from Fahai's clutches, Xio Qing winds up in a dystopian city and meets a mysterious man who can't recall his past life.",R.drawable.green_snake));
        items.add(new MovieItem("Raatchasi","Jyothika","A dogged headmistress teaches everyone a lesson in perseverance as she battles bureaucracy and corrupt officials to bring her government-run school up to scratch.",R.drawable.raatchasi));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MovieAdapter(getApplicationContext(),items));

    }
}