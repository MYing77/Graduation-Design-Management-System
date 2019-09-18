package com.ysj.core.po;

import java.util.ArrayList;
import java.util.List;

public class SelectTitleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SelectTitleExample() {
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

        public Criteria andTitlIdIsNull() {
            addCriterion("titl_id is null");
            return (Criteria) this;
        }

        public Criteria andTitlIdIsNotNull() {
            addCriterion("titl_id is not null");
            return (Criteria) this;
        }

        public Criteria andTitlIdEqualTo(Long value) {
            addCriterion("titl_id =", value, "titlId");
            return (Criteria) this;
        }

        public Criteria andTitlIdNotEqualTo(Long value) {
            addCriterion("titl_id <>", value, "titlId");
            return (Criteria) this;
        }

        public Criteria andTitlIdGreaterThan(Long value) {
            addCriterion("titl_id >", value, "titlId");
            return (Criteria) this;
        }

        public Criteria andTitlIdGreaterThanOrEqualTo(Long value) {
            addCriterion("titl_id >=", value, "titlId");
            return (Criteria) this;
        }

        public Criteria andTitlIdLessThan(Long value) {
            addCriterion("titl_id <", value, "titlId");
            return (Criteria) this;
        }

        public Criteria andTitlIdLessThanOrEqualTo(Long value) {
            addCriterion("titl_id <=", value, "titlId");
            return (Criteria) this;
        }

        public Criteria andTitlIdIn(List<Long> values) {
            addCriterion("titl_id in", values, "titlId");
            return (Criteria) this;
        }

        public Criteria andTitlIdNotIn(List<Long> values) {
            addCriterion("titl_id not in", values, "titlId");
            return (Criteria) this;
        }

        public Criteria andTitlIdBetween(Long value1, Long value2) {
            addCriterion("titl_id between", value1, value2, "titlId");
            return (Criteria) this;
        }

        public Criteria andTitlIdNotBetween(Long value1, Long value2) {
            addCriterion("titl_id not between", value1, value2, "titlId");
            return (Criteria) this;
        }

        public Criteria andTScoreIsNull() {
            addCriterion("t_score is null");
            return (Criteria) this;
        }

        public Criteria andTScoreIsNotNull() {
            addCriterion("t_score is not null");
            return (Criteria) this;
        }

        public Criteria andTScoreEqualTo(Double value) {
            addCriterion("t_score =", value, "tScore");
            return (Criteria) this;
        }

        public Criteria andTScoreNotEqualTo(Double value) {
            addCriterion("t_score <>", value, "tScore");
            return (Criteria) this;
        }

        public Criteria andTScoreGreaterThan(Double value) {
            addCriterion("t_score >", value, "tScore");
            return (Criteria) this;
        }

        public Criteria andTScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("t_score >=", value, "tScore");
            return (Criteria) this;
        }

        public Criteria andTScoreLessThan(Double value) {
            addCriterion("t_score <", value, "tScore");
            return (Criteria) this;
        }

        public Criteria andTScoreLessThanOrEqualTo(Double value) {
            addCriterion("t_score <=", value, "tScore");
            return (Criteria) this;
        }

        public Criteria andTScoreIn(List<Double> values) {
            addCriterion("t_score in", values, "tScore");
            return (Criteria) this;
        }

        public Criteria andTScoreNotIn(List<Double> values) {
            addCriterion("t_score not in", values, "tScore");
            return (Criteria) this;
        }

        public Criteria andTScoreBetween(Double value1, Double value2) {
            addCriterion("t_score between", value1, value2, "tScore");
            return (Criteria) this;
        }

        public Criteria andTScoreNotBetween(Double value1, Double value2) {
            addCriterion("t_score not between", value1, value2, "tScore");
            return (Criteria) this;
        }

        public Criteria andTCommentsIsNull() {
            addCriterion("t_comments is null");
            return (Criteria) this;
        }

        public Criteria andTCommentsIsNotNull() {
            addCriterion("t_comments is not null");
            return (Criteria) this;
        }

        public Criteria andTCommentsEqualTo(String value) {
            addCriterion("t_comments =", value, "tComments");
            return (Criteria) this;
        }

        public Criteria andTCommentsNotEqualTo(String value) {
            addCriterion("t_comments <>", value, "tComments");
            return (Criteria) this;
        }

        public Criteria andTCommentsGreaterThan(String value) {
            addCriterion("t_comments >", value, "tComments");
            return (Criteria) this;
        }

        public Criteria andTCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("t_comments >=", value, "tComments");
            return (Criteria) this;
        }

        public Criteria andTCommentsLessThan(String value) {
            addCriterion("t_comments <", value, "tComments");
            return (Criteria) this;
        }

        public Criteria andTCommentsLessThanOrEqualTo(String value) {
            addCriterion("t_comments <=", value, "tComments");
            return (Criteria) this;
        }

        public Criteria andTCommentsLike(String value) {
            addCriterion("t_comments like", value, "tComments");
            return (Criteria) this;
        }

        public Criteria andTCommentsNotLike(String value) {
            addCriterion("t_comments not like", value, "tComments");
            return (Criteria) this;
        }

        public Criteria andTCommentsIn(List<String> values) {
            addCriterion("t_comments in", values, "tComments");
            return (Criteria) this;
        }

        public Criteria andTCommentsNotIn(List<String> values) {
            addCriterion("t_comments not in", values, "tComments");
            return (Criteria) this;
        }

        public Criteria andTCommentsBetween(String value1, String value2) {
            addCriterion("t_comments between", value1, value2, "tComments");
            return (Criteria) this;
        }

        public Criteria andTCommentsNotBetween(String value1, String value2) {
            addCriterion("t_comments not between", value1, value2, "tComments");
            return (Criteria) this;
        }

        public Criteria andReplyScoreIsNull() {
            addCriterion("reply_score is null");
            return (Criteria) this;
        }

        public Criteria andReplyScoreIsNotNull() {
            addCriterion("reply_score is not null");
            return (Criteria) this;
        }

        public Criteria andReplyScoreEqualTo(Double value) {
            addCriterion("reply_score =", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreNotEqualTo(Double value) {
            addCriterion("reply_score <>", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreGreaterThan(Double value) {
            addCriterion("reply_score >", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("reply_score >=", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreLessThan(Double value) {
            addCriterion("reply_score <", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreLessThanOrEqualTo(Double value) {
            addCriterion("reply_score <=", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreIn(List<Double> values) {
            addCriterion("reply_score in", values, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreNotIn(List<Double> values) {
            addCriterion("reply_score not in", values, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreBetween(Double value1, Double value2) {
            addCriterion("reply_score between", value1, value2, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreNotBetween(Double value1, Double value2) {
            addCriterion("reply_score not between", value1, value2, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsIsNull() {
            addCriterion("reply_comments is null");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsIsNotNull() {
            addCriterion("reply_comments is not null");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsEqualTo(String value) {
            addCriterion("reply_comments =", value, "replyComments");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsNotEqualTo(String value) {
            addCriterion("reply_comments <>", value, "replyComments");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsGreaterThan(String value) {
            addCriterion("reply_comments >", value, "replyComments");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("reply_comments >=", value, "replyComments");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsLessThan(String value) {
            addCriterion("reply_comments <", value, "replyComments");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsLessThanOrEqualTo(String value) {
            addCriterion("reply_comments <=", value, "replyComments");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsLike(String value) {
            addCriterion("reply_comments like", value, "replyComments");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsNotLike(String value) {
            addCriterion("reply_comments not like", value, "replyComments");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsIn(List<String> values) {
            addCriterion("reply_comments in", values, "replyComments");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsNotIn(List<String> values) {
            addCriterion("reply_comments not in", values, "replyComments");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsBetween(String value1, String value2) {
            addCriterion("reply_comments between", value1, value2, "replyComments");
            return (Criteria) this;
        }

        public Criteria andReplyCommentsNotBetween(String value1, String value2) {
            addCriterion("reply_comments not between", value1, value2, "replyComments");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateIsNull() {
            addCriterion("seltitl_state is null");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateIsNotNull() {
            addCriterion("seltitl_state is not null");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateEqualTo(String value) {
            addCriterion("seltitl_state =", value, "seltitlState");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateNotEqualTo(String value) {
            addCriterion("seltitl_state <>", value, "seltitlState");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateGreaterThan(String value) {
            addCriterion("seltitl_state >", value, "seltitlState");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateGreaterThanOrEqualTo(String value) {
            addCriterion("seltitl_state >=", value, "seltitlState");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateLessThan(String value) {
            addCriterion("seltitl_state <", value, "seltitlState");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateLessThanOrEqualTo(String value) {
            addCriterion("seltitl_state <=", value, "seltitlState");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateLike(String value) {
            addCriterion("seltitl_state like", value, "seltitlState");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateNotLike(String value) {
            addCriterion("seltitl_state not like", value, "seltitlState");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateIn(List<String> values) {
            addCriterion("seltitl_state in", values, "seltitlState");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateNotIn(List<String> values) {
            addCriterion("seltitl_state not in", values, "seltitlState");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateBetween(String value1, String value2) {
            addCriterion("seltitl_state between", value1, value2, "seltitlState");
            return (Criteria) this;
        }

        public Criteria andSeltitlStateNotBetween(String value1, String value2) {
            addCriterion("seltitl_state not between", value1, value2, "seltitlState");
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