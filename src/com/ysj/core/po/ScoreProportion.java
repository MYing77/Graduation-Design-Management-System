package com.ysj.core.po;

public class ScoreProportion {
    private String proportionId;

    private Double tScoreProportion;

    private Double leaderScoreProportion;

    private Double reviewScoreProportion;

    public String getProportionId() {
        return proportionId;
    }

    public void setProportionId(String proportionId) {
        this.proportionId = proportionId == null ? null : proportionId.trim();
    }

    public Double gettScoreProportion() {
        return tScoreProportion;
    }

    public void settScoreProportion(Double tScoreProportion) {
        this.tScoreProportion = tScoreProportion;
    }

    public Double getLeaderScoreProportion() {
        return leaderScoreProportion;
    }

    public void setLeaderScoreProportion(Double leaderScoreProportion) {
        this.leaderScoreProportion = leaderScoreProportion;
    }

    public Double getReviewScoreProportion() {
        return reviewScoreProportion;
    }

    public void setReviewScoreProportion(Double reviewScoreProportion) {
        this.reviewScoreProportion = reviewScoreProportion;
    }
}