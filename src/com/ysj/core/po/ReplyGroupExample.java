package com.ysj.core.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReplyGroupExample() {
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

        public Criteria andReplyLeaderIsNull() {
            addCriterion("reply_leader is null");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderIsNotNull() {
            addCriterion("reply_leader is not null");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderEqualTo(String value) {
            addCriterion("reply_leader =", value, "replyLeader");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderNotEqualTo(String value) {
            addCriterion("reply_leader <>", value, "replyLeader");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderGreaterThan(String value) {
            addCriterion("reply_leader >", value, "replyLeader");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("reply_leader >=", value, "replyLeader");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderLessThan(String value) {
            addCriterion("reply_leader <", value, "replyLeader");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderLessThanOrEqualTo(String value) {
            addCriterion("reply_leader <=", value, "replyLeader");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderLike(String value) {
            addCriterion("reply_leader like", value, "replyLeader");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderNotLike(String value) {
            addCriterion("reply_leader not like", value, "replyLeader");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderIn(List<String> values) {
            addCriterion("reply_leader in", values, "replyLeader");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderNotIn(List<String> values) {
            addCriterion("reply_leader not in", values, "replyLeader");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderBetween(String value1, String value2) {
            addCriterion("reply_leader between", value1, value2, "replyLeader");
            return (Criteria) this;
        }

        public Criteria andReplyLeaderNotBetween(String value1, String value2) {
            addCriterion("reply_leader not between", value1, value2, "replyLeader");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceIsNull() {
            addCriterion("reply_place is null");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceIsNotNull() {
            addCriterion("reply_place is not null");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceEqualTo(String value) {
            addCriterion("reply_place =", value, "replyPlace");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceNotEqualTo(String value) {
            addCriterion("reply_place <>", value, "replyPlace");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceGreaterThan(String value) {
            addCriterion("reply_place >", value, "replyPlace");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("reply_place >=", value, "replyPlace");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceLessThan(String value) {
            addCriterion("reply_place <", value, "replyPlace");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceLessThanOrEqualTo(String value) {
            addCriterion("reply_place <=", value, "replyPlace");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceLike(String value) {
            addCriterion("reply_place like", value, "replyPlace");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceNotLike(String value) {
            addCriterion("reply_place not like", value, "replyPlace");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceIn(List<String> values) {
            addCriterion("reply_place in", values, "replyPlace");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceNotIn(List<String> values) {
            addCriterion("reply_place not in", values, "replyPlace");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceBetween(String value1, String value2) {
            addCriterion("reply_place between", value1, value2, "replyPlace");
            return (Criteria) this;
        }

        public Criteria andReplyPlaceNotBetween(String value1, String value2) {
            addCriterion("reply_place not between", value1, value2, "replyPlace");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeIsNull() {
            addCriterion("reply_datetime is null");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeIsNotNull() {
            addCriterion("reply_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeEqualTo(Date value) {
            addCriterion("reply_datetime =", value, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeNotEqualTo(Date value) {
            addCriterion("reply_datetime <>", value, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeGreaterThan(Date value) {
            addCriterion("reply_datetime >", value, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reply_datetime >=", value, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeLessThan(Date value) {
            addCriterion("reply_datetime <", value, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("reply_datetime <=", value, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeIn(List<Date> values) {
            addCriterion("reply_datetime in", values, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeNotIn(List<Date> values) {
            addCriterion("reply_datetime not in", values, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeBetween(Date value1, Date value2) {
            addCriterion("reply_datetime between", value1, value2, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("reply_datetime not between", value1, value2, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andBatchIsNull() {
            addCriterion("batch is null");
            return (Criteria) this;
        }

        public Criteria andBatchIsNotNull() {
            addCriterion("batch is not null");
            return (Criteria) this;
        }

        public Criteria andBatchEqualTo(Short value) {
            addCriterion("batch =", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotEqualTo(Short value) {
            addCriterion("batch <>", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThan(Short value) {
            addCriterion("batch >", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThanOrEqualTo(Short value) {
            addCriterion("batch >=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThan(Short value) {
            addCriterion("batch <", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThanOrEqualTo(Short value) {
            addCriterion("batch <=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchIn(List<Short> values) {
            addCriterion("batch in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotIn(List<Short> values) {
            addCriterion("batch not in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchBetween(Short value1, Short value2) {
            addCriterion("batch between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotBetween(Short value1, Short value2) {
            addCriterion("batch not between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andReplyStudentIsNull() {
            addCriterion("reply_student is null");
            return (Criteria) this;
        }

        public Criteria andReplyStudentIsNotNull() {
            addCriterion("reply_student is not null");
            return (Criteria) this;
        }

        public Criteria andReplyStudentEqualTo(String value) {
            addCriterion("reply_student =", value, "replyStudent");
            return (Criteria) this;
        }

        public Criteria andReplyStudentNotEqualTo(String value) {
            addCriterion("reply_student <>", value, "replyStudent");
            return (Criteria) this;
        }

        public Criteria andReplyStudentGreaterThan(String value) {
            addCriterion("reply_student >", value, "replyStudent");
            return (Criteria) this;
        }

        public Criteria andReplyStudentGreaterThanOrEqualTo(String value) {
            addCriterion("reply_student >=", value, "replyStudent");
            return (Criteria) this;
        }

        public Criteria andReplyStudentLessThan(String value) {
            addCriterion("reply_student <", value, "replyStudent");
            return (Criteria) this;
        }

        public Criteria andReplyStudentLessThanOrEqualTo(String value) {
            addCriterion("reply_student <=", value, "replyStudent");
            return (Criteria) this;
        }

        public Criteria andReplyStudentLike(String value) {
            addCriterion("reply_student like", value, "replyStudent");
            return (Criteria) this;
        }

        public Criteria andReplyStudentNotLike(String value) {
            addCriterion("reply_student not like", value, "replyStudent");
            return (Criteria) this;
        }

        public Criteria andReplyStudentIn(List<String> values) {
            addCriterion("reply_student in", values, "replyStudent");
            return (Criteria) this;
        }

        public Criteria andReplyStudentNotIn(List<String> values) {
            addCriterion("reply_student not in", values, "replyStudent");
            return (Criteria) this;
        }

        public Criteria andReplyStudentBetween(String value1, String value2) {
            addCriterion("reply_student between", value1, value2, "replyStudent");
            return (Criteria) this;
        }

        public Criteria andReplyStudentNotBetween(String value1, String value2) {
            addCriterion("reply_student not between", value1, value2, "replyStudent");
            return (Criteria) this;
        }

        public Criteria andReplyMemberIsNull() {
            addCriterion("reply_member is null");
            return (Criteria) this;
        }

        public Criteria andReplyMemberIsNotNull() {
            addCriterion("reply_member is not null");
            return (Criteria) this;
        }

        public Criteria andReplyMemberEqualTo(String value) {
            addCriterion("reply_member =", value, "replyMember");
            return (Criteria) this;
        }

        public Criteria andReplyMemberNotEqualTo(String value) {
            addCriterion("reply_member <>", value, "replyMember");
            return (Criteria) this;
        }

        public Criteria andReplyMemberGreaterThan(String value) {
            addCriterion("reply_member >", value, "replyMember");
            return (Criteria) this;
        }

        public Criteria andReplyMemberGreaterThanOrEqualTo(String value) {
            addCriterion("reply_member >=", value, "replyMember");
            return (Criteria) this;
        }

        public Criteria andReplyMemberLessThan(String value) {
            addCriterion("reply_member <", value, "replyMember");
            return (Criteria) this;
        }

        public Criteria andReplyMemberLessThanOrEqualTo(String value) {
            addCriterion("reply_member <=", value, "replyMember");
            return (Criteria) this;
        }

        public Criteria andReplyMemberLike(String value) {
            addCriterion("reply_member like", value, "replyMember");
            return (Criteria) this;
        }

        public Criteria andReplyMemberNotLike(String value) {
            addCriterion("reply_member not like", value, "replyMember");
            return (Criteria) this;
        }

        public Criteria andReplyMemberIn(List<String> values) {
            addCriterion("reply_member in", values, "replyMember");
            return (Criteria) this;
        }

        public Criteria andReplyMemberNotIn(List<String> values) {
            addCriterion("reply_member not in", values, "replyMember");
            return (Criteria) this;
        }

        public Criteria andReplyMemberBetween(String value1, String value2) {
            addCriterion("reply_member between", value1, value2, "replyMember");
            return (Criteria) this;
        }

        public Criteria andReplyMemberNotBetween(String value1, String value2) {
            addCriterion("reply_member not between", value1, value2, "replyMember");
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