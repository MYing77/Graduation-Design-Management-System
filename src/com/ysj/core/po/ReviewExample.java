package com.ysj.core.po;

import java.util.ArrayList;
import java.util.List;

public class ReviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReviewExample() {
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

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(String value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(String value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(String value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(String value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(String value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(String value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLike(String value) {
            addCriterion("s_id like", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotLike(String value) {
            addCriterion("s_id not like", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<String> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<String> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(String value1, String value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(String value1, String value2) {
            addCriterion("s_id not between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andMemberTIdIsNull() {
            addCriterion("member_t_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberTIdIsNotNull() {
            addCriterion("member_t_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberTIdEqualTo(String value) {
            addCriterion("member_t_id =", value, "memberTId");
            return (Criteria) this;
        }

        public Criteria andMemberTIdNotEqualTo(String value) {
            addCriterion("member_t_id <>", value, "memberTId");
            return (Criteria) this;
        }

        public Criteria andMemberTIdGreaterThan(String value) {
            addCriterion("member_t_id >", value, "memberTId");
            return (Criteria) this;
        }

        public Criteria andMemberTIdGreaterThanOrEqualTo(String value) {
            addCriterion("member_t_id >=", value, "memberTId");
            return (Criteria) this;
        }

        public Criteria andMemberTIdLessThan(String value) {
            addCriterion("member_t_id <", value, "memberTId");
            return (Criteria) this;
        }

        public Criteria andMemberTIdLessThanOrEqualTo(String value) {
            addCriterion("member_t_id <=", value, "memberTId");
            return (Criteria) this;
        }

        public Criteria andMemberTIdLike(String value) {
            addCriterion("member_t_id like", value, "memberTId");
            return (Criteria) this;
        }

        public Criteria andMemberTIdNotLike(String value) {
            addCriterion("member_t_id not like", value, "memberTId");
            return (Criteria) this;
        }

        public Criteria andMemberTIdIn(List<String> values) {
            addCriterion("member_t_id in", values, "memberTId");
            return (Criteria) this;
        }

        public Criteria andMemberTIdNotIn(List<String> values) {
            addCriterion("member_t_id not in", values, "memberTId");
            return (Criteria) this;
        }

        public Criteria andMemberTIdBetween(String value1, String value2) {
            addCriterion("member_t_id between", value1, value2, "memberTId");
            return (Criteria) this;
        }

        public Criteria andMemberTIdNotBetween(String value1, String value2) {
            addCriterion("member_t_id not between", value1, value2, "memberTId");
            return (Criteria) this;
        }

        public Criteria andReviewScoreIsNull() {
            addCriterion("review_score is null");
            return (Criteria) this;
        }

        public Criteria andReviewScoreIsNotNull() {
            addCriterion("review_score is not null");
            return (Criteria) this;
        }

        public Criteria andReviewScoreEqualTo(Integer value) {
            addCriterion("review_score =", value, "reviewScore");
            return (Criteria) this;
        }

        public Criteria andReviewScoreNotEqualTo(Integer value) {
            addCriterion("review_score <>", value, "reviewScore");
            return (Criteria) this;
        }

        public Criteria andReviewScoreGreaterThan(Integer value) {
            addCriterion("review_score >", value, "reviewScore");
            return (Criteria) this;
        }

        public Criteria andReviewScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_score >=", value, "reviewScore");
            return (Criteria) this;
        }

        public Criteria andReviewScoreLessThan(Integer value) {
            addCriterion("review_score <", value, "reviewScore");
            return (Criteria) this;
        }

        public Criteria andReviewScoreLessThanOrEqualTo(Integer value) {
            addCriterion("review_score <=", value, "reviewScore");
            return (Criteria) this;
        }

        public Criteria andReviewScoreIn(List<Integer> values) {
            addCriterion("review_score in", values, "reviewScore");
            return (Criteria) this;
        }

        public Criteria andReviewScoreNotIn(List<Integer> values) {
            addCriterion("review_score not in", values, "reviewScore");
            return (Criteria) this;
        }

        public Criteria andReviewScoreBetween(Integer value1, Integer value2) {
            addCriterion("review_score between", value1, value2, "reviewScore");
            return (Criteria) this;
        }

        public Criteria andReviewScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("review_score not between", value1, value2, "reviewScore");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsIsNull() {
            addCriterion("review_comments is null");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsIsNotNull() {
            addCriterion("review_comments is not null");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsEqualTo(String value) {
            addCriterion("review_comments =", value, "reviewComments");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsNotEqualTo(String value) {
            addCriterion("review_comments <>", value, "reviewComments");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsGreaterThan(String value) {
            addCriterion("review_comments >", value, "reviewComments");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("review_comments >=", value, "reviewComments");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsLessThan(String value) {
            addCriterion("review_comments <", value, "reviewComments");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsLessThanOrEqualTo(String value) {
            addCriterion("review_comments <=", value, "reviewComments");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsLike(String value) {
            addCriterion("review_comments like", value, "reviewComments");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsNotLike(String value) {
            addCriterion("review_comments not like", value, "reviewComments");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsIn(List<String> values) {
            addCriterion("review_comments in", values, "reviewComments");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsNotIn(List<String> values) {
            addCriterion("review_comments not in", values, "reviewComments");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsBetween(String value1, String value2) {
            addCriterion("review_comments between", value1, value2, "reviewComments");
            return (Criteria) this;
        }

        public Criteria andReviewCommentsNotBetween(String value1, String value2) {
            addCriterion("review_comments not between", value1, value2, "reviewComments");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNull() {
            addCriterion("reply_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNotNull() {
            addCriterion("reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyIdEqualTo(String value) {
            addCriterion("reply_id =", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotEqualTo(String value) {
            addCriterion("reply_id <>", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThan(String value) {
            addCriterion("reply_id >", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("reply_id >=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThan(String value) {
            addCriterion("reply_id <", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThanOrEqualTo(String value) {
            addCriterion("reply_id <=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLike(String value) {
            addCriterion("reply_id like", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotLike(String value) {
            addCriterion("reply_id not like", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdIn(List<String> values) {
            addCriterion("reply_id in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotIn(List<String> values) {
            addCriterion("reply_id not in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdBetween(String value1, String value2) {
            addCriterion("reply_id between", value1, value2, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotBetween(String value1, String value2) {
            addCriterion("reply_id not between", value1, value2, "replyId");
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