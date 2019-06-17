package com.Ajar.Blog.Pojo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdIsNull() {
            addCriterion("comment_article_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdIsNotNull() {
            addCriterion("comment_article_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdEqualTo(Integer value) {
            addCriterion("comment_article_id =", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdNotEqualTo(Integer value) {
            addCriterion("comment_article_id <>", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdGreaterThan(Integer value) {
            addCriterion("comment_article_id >", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_article_id >=", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdLessThan(Integer value) {
            addCriterion("comment_article_id <", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_article_id <=", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdIn(List<Integer> values) {
            addCriterion("comment_article_id in", values, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdNotIn(List<Integer> values) {
            addCriterion("comment_article_id not in", values, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_article_id between", value1, value2, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_article_id not between", value1, value2, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorNameIsNull() {
            addCriterion("comment_author_name is null");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorNameIsNotNull() {
            addCriterion("comment_author_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorNameEqualTo(Integer value) {
            addCriterion("comment_author_name =", value, "commentAuthorName");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorNameNotEqualTo(Integer value) {
            addCriterion("comment_author_name <>", value, "commentAuthorName");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorNameGreaterThan(Integer value) {
            addCriterion("comment_author_name >", value, "commentAuthorName");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_author_name >=", value, "commentAuthorName");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorNameLessThan(Integer value) {
            addCriterion("comment_author_name <", value, "commentAuthorName");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorNameLessThanOrEqualTo(Integer value) {
            addCriterion("comment_author_name <=", value, "commentAuthorName");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorNameIn(List<Integer> values) {
            addCriterion("comment_author_name in", values, "commentAuthorName");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorNameNotIn(List<Integer> values) {
            addCriterion("comment_author_name not in", values, "commentAuthorName");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorNameBetween(Integer value1, Integer value2) {
            addCriterion("comment_author_name between", value1, value2, "commentAuthorName");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorNameNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_author_name not between", value1, value2, "commentAuthorName");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNull() {
            addCriterion("comment_content is null");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNotNull() {
            addCriterion("comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andCommentContentEqualTo(String value) {
            addCriterion("comment_content =", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotEqualTo(String value) {
            addCriterion("comment_content <>", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThan(String value) {
            addCriterion("comment_content >", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_content >=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThan(String value) {
            addCriterion("comment_content <", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThanOrEqualTo(String value) {
            addCriterion("comment_content <=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLike(String value) {
            addCriterion("comment_content like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotLike(String value) {
            addCriterion("comment_content not like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentIn(List<String> values) {
            addCriterion("comment_content in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotIn(List<String> values) {
            addCriterion("comment_content not in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentBetween(String value1, String value2) {
            addCriterion("comment_content between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotBetween(String value1, String value2) {
            addCriterion("comment_content not between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeIsNull() {
            addCriterion("comment_create_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeIsNotNull() {
            addCriterion("comment_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeEqualTo(Date value) {
            addCriterion("comment_create_time =", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeNotEqualTo(Date value) {
            addCriterion("comment_create_time <>", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeGreaterThan(Date value) {
            addCriterion("comment_create_time >", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_create_time >=", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeLessThan(Date value) {
            addCriterion("comment_create_time <", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_create_time <=", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeIn(List<Date> values) {
            addCriterion("comment_create_time in", values, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeNotIn(List<Date> values) {
            addCriterion("comment_create_time not in", values, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeBetween(Date value1, Date value2) {
            addCriterion("comment_create_time between", value1, value2, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_create_time not between", value1, value2, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgIsNull() {
            addCriterion("comment_author_img is null");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgIsNotNull() {
            addCriterion("comment_author_img is not null");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgEqualTo(String value) {
            addCriterion("comment_author_img =", value, "commentAuthorImg");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgNotEqualTo(String value) {
            addCriterion("comment_author_img <>", value, "commentAuthorImg");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgGreaterThan(String value) {
            addCriterion("comment_author_img >", value, "commentAuthorImg");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgGreaterThanOrEqualTo(String value) {
            addCriterion("comment_author_img >=", value, "commentAuthorImg");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgLessThan(String value) {
            addCriterion("comment_author_img <", value, "commentAuthorImg");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgLessThanOrEqualTo(String value) {
            addCriterion("comment_author_img <=", value, "commentAuthorImg");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgLike(String value) {
            addCriterion("comment_author_img like", value, "commentAuthorImg");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgNotLike(String value) {
            addCriterion("comment_author_img not like", value, "commentAuthorImg");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgIn(List<String> values) {
            addCriterion("comment_author_img in", values, "commentAuthorImg");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgNotIn(List<String> values) {
            addCriterion("comment_author_img not in", values, "commentAuthorImg");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgBetween(String value1, String value2) {
            addCriterion("comment_author_img between", value1, value2, "commentAuthorImg");
            return (Criteria) this;
        }

        public Criteria andCommentAuthorImgNotBetween(String value1, String value2) {
            addCriterion("comment_author_img not between", value1, value2, "commentAuthorImg");
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