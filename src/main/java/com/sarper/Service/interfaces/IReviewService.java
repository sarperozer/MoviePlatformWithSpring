package com.sarper.Service.interfaces;

import com.sarper.Dto.ReviewRequest;
import com.sarper.Dto.ReviewResponse;
import com.sarper.Model.Review;

import java.util.List;

public interface IReviewService {
    ReviewResponse addReview(ReviewRequest reviewRequest);

    List<ReviewResponse> getReviewsOfMovie(Long id);
}
