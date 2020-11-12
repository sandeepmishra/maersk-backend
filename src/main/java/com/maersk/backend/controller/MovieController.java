package com.maersk.backend.controller;


import com.maersk.backend.service.MovieService;
import com.maersk.backend.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }

    @GetMapping
    public List<Movie> getMovieByName(@RequestParam String movieName){
        System.out.println("Param "+movieName);
        System.out.println(movieService.findByNameLike(movieName));
        return movieService.findByNameLike(movieName);
    }
}
