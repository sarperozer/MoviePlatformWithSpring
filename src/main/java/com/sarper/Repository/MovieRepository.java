package com.sarper.Repository;

import com.sarper.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenreContainingIgnoreCase(String genre);

    List<Movie> findByDirectorNameContainingIgnoreCase(String directorName);

    List<Movie> findByGenreContainingIgnoreCaseAndDirectorNameContainingIgnoreCase(String genre, String director);

}
