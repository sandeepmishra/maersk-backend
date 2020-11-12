package com.maersk.backend.service;

import com.maersk.backend.entity.Movie;
import com.maersk.backend.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private IMovieRepository iMovieRepository;

    public List<Movie> findByNameLike(String movieName){
        return iMovieRepository.findByNameStartsWith(movieName);
    }

    public Movie createMovie(Movie movie) {
        return iMovieRepository.save(movie);
    }
}
