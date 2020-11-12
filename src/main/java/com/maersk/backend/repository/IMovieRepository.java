package com.maersk.backend.repository;

import com.maersk.backend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findByNameStartsWith(String name);
}
