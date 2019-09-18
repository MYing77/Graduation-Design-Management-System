package com.ysj.core.po;

import java.util.ArrayList;
import java.util.List;

public class ScoreProportionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScoreProportionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProportionIdIsNull() {
            addCriterion("proportion_id is null");
            return (Criteria) this;
        }

        public Criteria andProportionIdIsNotNull() {
            addCriterion("proportion_id is not null");
            return (Criteria) this;
        }

        public Criteria andProportionIdEqualTo(String value) {
            addCriterion("proportion_id =", value, "proportionId");
            return (Criteria) this;
        }

        public Criteria andProportionIdNotEqualTo(String value) {
            addCriterion("proportion_id <>", value, "proportionId");
            return (Criteria) this;
        }

        public Criteria andProportionIdGreaterThan(String value) {
            addCriterion("proportion_id >", value, "proportionId");
            return (Criteria) this;
        }

        public Criteria andProportionIdGreaterThanOrEqualTo(String value) {
            addCriterion("proportion_id >=", value, "proportionId");
            return (Criteria) this;
        }

        public Criteria andProportionIdLessThan(String value) {
            addCriterion("proportion_id <", value, "proportionId");
            return (Criteria) this;
        }

        public Criteria andProportionIdLessThanOrEqualTo(String value) {
            addCriterion("proportion_id <=", value, "proportionId");
            return (Criteria) this;
        }

        public Criteria andProportionIdLike(String value) {
            addCriterion("proportion_id like", value, "proportionId");
            return (Criteria) this;
        }

        public Criteria andProportionIdNotLike(String value) {
            addCriterion("proportion_id not like", value, "proportionId");
            return (Criteria) this;
        }

        public Criteria andProportionIdIn(List<String> values) {
            addCriterion("proportion_id in", values, "proportionId");
            return (Criteria) this;
        }

        public Criteria andProportionIdNotIn(List<String> values) {
            addCriterion("proportion_id not in", values, "proportionId");
            return (Criteria) this;
        }

        public Criteria andProportionIdBetween(String value1, String value2) {
            addCriterion("proportion_id between", value1, value2, "proportionId");
            return (Criteria) this;
        }

        public Criteria andProportionIdNotBetween(String value1, String value2) {
            addCriterion("proportion_id not between", value1, value2, "proportionId");
            return (Criteria) this;
        }

        public Criteria andTScoreProportionIsNull() {
            addCriterion("t_score_proportion is null");
            return (Criteria) this;
        }

        public Criteria andTScoreProportionIsNotNull() {
            addCriterion("t_score_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andTScoreProportionEqualTo(Double value) {
            addCriterion("t_score_proportion =", value, "tScoreProportion");
            return (Criteria) this;
        }

        public Criteria andTScoreProportionNotEqualTo(Double value) {
            addCriterion("t_score_proportion <>", value, "tScoreProportion");
            return (Criteria) this;
        }

        public Criteria andTScoreProportionGreaterThan(Double value) {
            addCriterion("t_score_proportion >", value, "tScoreProportion");
            return (Criteria) this;
        }

        public Criteria andTScoreProportionGreaterThanOrEqualTo(Double value) {
            addCriterion("t_score_proportion >=", value, "tScoreProportion");
            return (Criteria) this;
        }

        public Criteria andTScoreProportionLessThan(Double value) {
            addCriterion("t_score_proportion <", value, "tScoreProportion");
            return (Criteria) this;
        }

        public Criteria andTScoreProportionLessThanOrEqualTo(Double value) {
            addCriterion("t_score_proportion <=", value, "tScoreProportion");
            return (Criteria) this;
        }

        public Criteria andTScoreProportionIn(List<Double> values) {
            addCriterion("t_score_proportion in", values, "tScoreProportion");
            return (Criteria) this;
        }

        public Criteria andTScoreProportionNotIn(List<Double> values) {
            addCriterion("t_score_proportion not in", values, "tScoreProportion");
            return (Criteria) this;
        }

        public Criteria andTScoreProportionBetween(Double value1, Double value2) {
            addCriterion("t_score_proportion between", value1, value2, "tScoreProportion");
            return (Criteria) this;
        }

        public Criteria andTScoreProportionNotBetween(Double value1, Double value2) {
            addCriterion("t_score_proportion not between", value1, value2, "tScoreProportion");
            return (Criteria) this;
        }

        public Criteria andLeaderScoreProportionIsNull() {
            addCriterion("leader_score_proportion is null");
            return (Criteria) this;
        }

        public Criteria andLeaderScoreProportionIsNotNull() {
            addCriterion("leader_score_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderScoreProportionEqualTo(Double value) {
            addCriterion("leader_score_proportion =", value, "leaderScoreProportion");
            return (Criteria) this;
        }

        public Criteria andLeaderScoreProportionNotEqualTo(Double value) {
            addCriterion("leader_score_proportion <>", value, "leaderScoreProportion");
            return (Criteria) this;
        }

        public Criteria andLeaderScoreProportionGreaterThan(Double value) {
            addCriterion("leader_score_proportion >", value, "leaderScoreProportion");
            return (Criteria) this;
        }

        public Criteria andLeaderScoreProportionGreaterThanOrEqualTo(Double value) {
            addCriterion("leader_score_proportion >=", value, "leaderScoreProportion");
            return (Criteria) this;
        }

        public Criteria andLeaderScoreProportionLessThan(Double value) {
            addCriterion("leader_score_proportion <", value, "leaderScoreProportion");
            return (Criteria) this;
        }

        public Criteria andLeaderScoreProportionLessThanOrEqualTo(Double value) {
            addCriterion("leader_score_proportion <=", value, "leaderScoreProportion");
            return (Criteria) this;
        }

        public Criteria andLeaderScoreProportionIn(List<Double> values) {
            addCriterion("leader_score_proportion in", values, "leaderScoreProportion");
            return (Criteria) this;
        }

        public Criteria andLeaderScoreProportionNotIn(List<Double> values) {
            addCriterion("leader_score_proportion not in", values, "leaderScoreProportion");
            return (Criteria) this;
        }

        public Criteria andLeaderScoreProportionBetween(Double value1, Double value2) {
            addCriterion("leader_score_proportion between", value1, value2, "leaderScoreProportion");
            return (Criteria) this;
        }

        public Criteria andLeaderScoreProportionNotBetween(Double value1, Double value2) {
            addCriterion("leader_score_proportion not between", value1, value2, "leaderScoreProportion");
            return (Criteria) this;
        }

        public Criteria andReviewScoreProportionIsNull() {
            addCriterion("review_score_proportion is null");
            return (Criteria) this;
        }

        public Criteria andReviewScoreProportionIsNotNull() {
            addCriterion("review_score_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andReviewScoreProportionEqualTo(Double value) {
            addCriterion("review_score_proportion =", value, "reviewScoreProportion");
            return (Criteria) this;
        }

        public Criteria andReviewScoreProportionNotEqualTo(Double value) {
            addCriterion("review_score_proportion <>", value, "reviewScoreProportion");
            return (Criteria) this;
        }

        public Criteria andReviewScoreProportionGreaterThan(Double value) {
            addCriterion("review_score_proportion >", value, "reviewScoreProportion");
            return (Criteria) this;
        }

        public Criteria andReviewScoreProportionGreaterThanOrEqualTo(Double value) {
            addCriterion("review_score_proportion >=", value, "reviewScoreProportion");
            return (Criteria) this;
        }

        public Criteria andReviewScoreProportionLessThan(Double value) {
            addCriterion("review_score_proportion <", value, "reviewScoreProportion");
            return (Criteria) this;
        }

        public Criteria andReviewScoreProportionLessThanOrEqualTo(Double value) {
            addCriterion("review_score_proportion <=", value, "reviewScoreProportion");
            return (Criteria) this;
        }

        public Criteria andReviewScoreProportionIn(List<Double> values) {
            addCriterion("review_score_proportion in", values, "reviewScoreProportion");
            return (Criteria) this;
        }

        public Criteria andReviewScoreProportionNotIn(List<Double> values) {
            addCriterion("review_score_proportion not in", values, "reviewScoreProportion");
            return (Criteria) this;
        }

        public Criteria andReviewScoreProportionBetween(Double value1, Double value2) {
            addCriterion("review_score_proportion between", value1, value2, "reviewScoreProportion");
            return (Criteria) this;
        }

        public Criteria andReviewScoreProportionNotBetween(Double value1, Double value2) {
            addCriterion("review_score_proportion not between", value1, value2, "reviewScoreProportion");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}