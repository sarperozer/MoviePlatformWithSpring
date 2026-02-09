package com.sarper.Service.interfaces;

import com.sarper.Dto.ReviewDto;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IReviewService {
    ReviewDto addReview(ReviewDto reviewDto, Long movieId, Authentication authentication);

    List<ReviewDto> getReviewsOfMovie(Long id);

    List<ReviewDto> getReviewsOfUser(Long userId);
}
