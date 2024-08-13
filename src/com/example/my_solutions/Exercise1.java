package com.example.my_solutions;

import com.example.domain.Director;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise1 {

    private static final MovieService movieService = InMemoryMovieService.getInstance();

    public static void main(String[] args) {
        // Find the number of movies of each director
        final Collection<Movie> movies = movieService.findAllMovies();
        var result = movies.stream()
                .map(Movie::getDirectors)
                .flatMap(directors -> directors.stream())
                .collect(Collectors.groupingBy(
                        Director::getName,
                        Collectors.counting()
                ));

        for(Map.Entry entry : result.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
