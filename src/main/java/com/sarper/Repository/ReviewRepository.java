package com.sarper.Repository;

import com.sarper.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByMovieId(Long id);

    boolean existsByMovieIdAndUserId(Long movieId, Long userId);

    List<Review> findByUserId(Long userId);

}
