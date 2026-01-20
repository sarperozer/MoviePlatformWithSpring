package com.sarper.Service;

import com.sarper.Dto.ReviewRequest;
import com.sarper.Dto.ReviewResponse;
import com.sarper.Model.Movie;
import com.sarper.Model.Review;
import com.sarper.Model.User;
import com.sarper.Repository.MovieRepository;
import com.sarper.Repository.ReviewRepository;
import com.sarper.Repository.UserRepository;
import com.sarper.Service.interfaces.IReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ReviewResponse addReview(ReviewRequest reviewRequest) {
        Review review = new Review();
        ReviewResponse reviewResponse = new ReviewResponse(reviewRequest.getStars(), reviewRequest.getComment());

        BeanUtils.copyProperties(reviewRequest, review);

        Optional<Movie> movie = movieRepository.findById(reviewRequest.getMovieId());
        Optional<User> user = userRepository.findById(reviewRequest.getUserId());

        review.setUser(user.get());
        review.setMovie(movie.get());

        reviewRepository.save(review);

        return reviewResponse;
    }

    @Override
    public List<ReviewResponse> getReviewsOfMovie(Long id) {
        List<Review> reviews = reviewRepository.findByMovieId(id);
        List<ReviewResponse> reviewResponses = new ArrayList<>();

        for (Review r : reviews) {
            ReviewResponse reviewResponse = new ReviewResponse();
            BeanUtils.copyProperties(r, reviewResponse);
            reviewResponses.add(reviewResponse);
        }

        return reviewResponses;
    }
}
