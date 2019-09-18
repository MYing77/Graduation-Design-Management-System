package com.ysj.core.po;

import java.util.ArrayList;
import java.util.List;

public class TitleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TitleExample() {
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

        public Criteria andTitlNameIsNull() {
            addCriterion("titl_name is null");
            return (Criteria) this;
        }

        public Criteria andTitlNameIsNotNull() {
            addCriterion("titl_name is not null");
            return (Criteria) this;
        }

        public Criteria andTitlNameEqualTo(String value) {
            addCriterion("titl_name =", value, "titlName");
            return (Criteria) this;
        }

        public Criteria andTitlNameNotEqualTo(String value) {
            addCriterion("titl_name <>", value, "titlName");
            return (Criteria) this;
        }

        public Criteria andTitlNameGreaterThan(String value) {
            addCriterion("titl_name >", value, "titlName");
            return (Criteria) this;
        }

        public Criteria andTitlNameGreaterThanOrEqualTo(String value) {
            addCriterion("titl_name >=", value, "titlName");
            return (Criteria) this;
        }

        public Criteria andTitlNameLessThan(String value) {
            addCriterion("titl_name <", value, "titlName");
            return (Criteria) this;
        }

        public Criteria andTitlNameLessThanOrEqualTo(String value) {
            addCriterion("titl_name <=", value, "titlName");
            return (Criteria) this;
        }

        public Criteria andTitlNameLike(String value) {
            addCriterion("titl_name like", value, "titlName");
            return (Criteria) this;
        }

        public Criteria andTitlNameNotLike(String value) {
            addCriterion("titl_name not like", value, "titlName");
            return (Criteria) this;
        }

        public Criteria andTitlNameIn(List<String> values) {
            addCriterion("titl_name in", values, "titlName");
            return (Criteria) this;
        }

        public Criteria andTitlNameNotIn(List<String> values) {
            addCriterion("titl_name not in", values, "titlName");
            return (Criteria) this;
        }

        public Criteria andTitlNameBetween(String value1, String value2) {
            addCriterion("titl_name between", value1, value2, "titlName");
            return (Criteria) this;
        }

        public Criteria andTitlNameNotBetween(String value1, String value2) {
            addCriterion("titl_name not between", value1, value2, "titlName");
            return (Criteria) this;
        }

        public Criteria andTIdIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(String value) {
            addCriterion("t_id =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(String value) {
            addCriterion("t_id <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(String value) {
            addCriterion("t_id >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(String value) {
            addCriterion("t_id >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(String value) {
            addCriterion("t_id <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(String value) {
            addCriterion("t_id <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLike(String value) {
            addCriterion("t_id like", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotLike(String value) {
            addCriterion("t_id not like", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<String> values) {
            addCriterion("t_id in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<String> values) {
            addCriterion("t_id not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(String value1, String value2) {
            addCriterion("t_id between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(String value1, String value2) {
            addCriterion("t_id not between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeIsNull() {
            addCriterion("titl_describe is null");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeIsNotNull() {
            addCriterion("titl_describe is not null");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeEqualTo(String value) {
            addCriterion("titl_describe =", value, "titlDescribe");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeNotEqualTo(String value) {
            addCriterion("titl_describe <>", value, "titlDescribe");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeGreaterThan(String value) {
            addCriterion("titl_describe >", value, "titlDescribe");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("titl_describe >=", value, "titlDescribe");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeLessThan(String value) {
            addCriterion("titl_describe <", value, "titlDescribe");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeLessThanOrEqualTo(String value) {
            addCriterion("titl_describe <=", value, "titlDescribe");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeLike(String value) {
            addCriterion("titl_describe like", value, "titlDescribe");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeNotLike(String value) {
            addCriterion("titl_describe not like", value, "titlDescribe");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeIn(List<String> values) {
            addCriterion("titl_describe in", values, "titlDescribe");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeNotIn(List<String> values) {
            addCriterion("titl_describe not in", values, "titlDescribe");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeBetween(String value1, String value2) {
            addCriterion("titl_describe between", value1, value2, "titlDescribe");
            return (Criteria) this;
        }

        public Criteria andTitlDescribeNotBetween(String value1, String value2) {
            addCriterion("titl_describe not between", value1, value2, "titlDescribe");
            return (Criteria) this;
        }

        public Criteria andTitlTypeIsNull() {
            addCriterion("titl_type is null");
            return (Criteria) this;
        }

        public Criteria andTitlTypeIsNotNull() {
            addCriterion("titl_type is not null");
            return (Criteria) this;
        }

        public Criteria andTitlTypeEqualTo(String value) {
            addCriterion("titl_type =", value, "titlType");
            return (Criteria) this;
        }

        public Criteria andTitlTypeNotEqualTo(String value) {
            addCriterion("titl_type <>", value, "titlType");
            return (Criteria) this;
        }

        public Criteria andTitlTypeGreaterThan(String value) {
            addCriterion("titl_type >", value, "titlType");
            return (Criteria) this;
        }

        public Criteria andTitlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("titl_type >=", value, "titlType");
            return (Criteria) this;
        }

        public Criteria andTitlTypeLessThan(String value) {
            addCriterion("titl_type <", value, "titlType");
            return (Criteria) this;
        }

        public Criteria andTitlTypeLessThanOrEqualTo(String value) {
            addCriterion("titl_type <=", value, "titlType");
            return (Criteria) this;
        }

        public Criteria andTitlTypeLike(String value) {
            addCriterion("titl_type like", value, "titlType");
            return (Criteria) this;
        }

        public Criteria andTitlTypeNotLike(String value) {
            addCriterion("titl_type not like", value, "titlType");
            return (Criteria) this;
        }

        public Criteria andTitlTypeIn(List<String> values) {
            addCriterion("titl_type in", values, "titlType");
            return (Criteria) this;
        }

        public Criteria andTitlTypeNotIn(List<String> values) {
            addCriterion("titl_type not in", values, "titlType");
            return (Criteria) this;
        }

        public Criteria andTitlTypeBetween(String value1, String value2) {
            addCriterion("titl_type between", value1, value2, "titlType");
            return (Criteria) this;
        }

        public Criteria andTitlTypeNotBetween(String value1, String value2) {
            addCriterion("titl_type not between", value1, value2, "titlType");
            return (Criteria) this;
        }

        public Criteria andTitlStateIsNull() {
            addCriterion("titl_state is null");
            return (Criteria) this;
        }

        public Criteria andTitlStateIsNotNull() {
            addCriterion("titl_state is not null");
            return (Criteria) this;
        }

        public Criteria andTitlStateEqualTo(String value) {
            addCriterion("titl_state =", value, "titlState");
            return (Criteria) this;
        }

        public Criteria andTitlStateNotEqualTo(String value) {
            addCriterion("titl_state <>", value, "titlState");
            return (Criteria) this;
        }

        public Criteria andTitlStateGreaterThan(String value) {
            addCriterion("titl_state >", value, "titlState");
            return (Criteria) this;
        }

        public Criteria andTitlStateGreaterThanOrEqualTo(String value) {
            addCriterion("titl_state >=", value, "titlState");
            return (Criteria) this;
        }

        public Criteria andTitlStateLessThan(String value) {
            addCriterion("titl_state <", value, "titlState");
            return (Criteria) this;
        }

        public Criteria andTitlStateLessThanOrEqualTo(String value) {
            addCriterion("titl_state <=", value, "titlState");
            return (Criteria) this;
        }

        public Criteria andTitlStateLike(String value) {
            addCriterion("titl_state like", value, "titlState");
            return (Criteria) this;
        }

        public Criteria andTitlStateNotLike(String value) {
            addCriterion("titl_state not like", value, "titlState");
            return (Criteria) this;
        }

        public Criteria andTitlStateIn(List<String> values) {
            addCriterion("titl_state in", values, "titlState");
            return (Criteria) this;
        }

        public Criteria andTitlStateNotIn(List<String> values) {
            addCriterion("titl_state not in", values, "titlState");
            return (Criteria) this;
        }

        public Criteria andTitlStateBetween(String value1, String value2) {
            addCriterion("titl_state between", value1, value2, "titlState");
            return (Criteria) this;
        }

        public Criteria andTitlStateNotBetween(String value1, String value2) {
            addCriterion("titl_state not between", value1, value2, "titlState");
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