package com.sarper.Service;

import com.sarper.Dto.ReviewDto;
import com.sarper.Model.Movie;
import com.sarper.Model.Review;
import com.sarper.Model.User;
import com.sarper.Repository.MovieRepository;
import com.sarper.Repository.ReviewRepository;
import com.sarper.Repository.UserRepository;
import com.sarper.Service.interfaces.IReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ReviewDto addReview(ReviewDto reviewDto, Long movieId, Authentication authentication) {
        Review review = new Review();

        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        if (reviewRepository.existsByMovieIdAndUserId(movieId, user.getId())) {
            throw new RuntimeException("You already reviewed this movie");
        }

        BeanUtils.copyProperties(reviewDto, review);
        review.setMovie(movie);
        review.setUser(user);

        reviewRepository.save(review);

        return reviewDto;
    }

    @Override
    public List<ReviewDto> getReviewsOfMovie(Long id) {
        List<Review> reviews = reviewRepository.findByMovieId(id);
        List<ReviewDto> reviewDtos = new ArrayList<>();

        for (Review r : reviews) {
            ReviewDto reviewDto = new ReviewDto();
            BeanUtils.copyProperties(r, reviewDto);
            reviewDtos.add(reviewDto);
        }

        return reviewDtos;
    }

    @Override
    public List<ReviewDto> getReviewsOfUser(Long userId) {
        List<Review> reviews = reviewRepository.findByUserId(userId);
        List<ReviewDto> reviewDtos = new ArrayList<>();

        for (Review r : reviews) {
            ReviewDto reviewDto = new ReviewDto();
            BeanUtils.copyProperties(r, reviewDto);
            reviewDtos.add(reviewDto);
        }

        return reviewDtos;
    }
}
