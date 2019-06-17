package com.Ajar.Blog.Pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class LinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LinkExample() {
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

        public Criteria andLinkIdIsNull() {
            addCriterion("link_id is null");
            return (Criteria) this;
        }

        public Criteria andLinkIdIsNotNull() {
            addCriterion("link_id is not null");
            return (Criteria) this;
        }

        public Criteria andLinkIdEqualTo(Integer value) {
            addCriterion("link_id =", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotEqualTo(Integer value) {
            addCriterion("link_id <>", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThan(Integer value) {
            addCriterion("link_id >", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("link_id >=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThan(Integer value) {
            addCriterion("link_id <", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThanOrEqualTo(Integer value) {
            addCriterion("link_id <=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdIn(List<Integer> values) {
            addCriterion("link_id in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotIn(List<Integer> values) {
            addCriterion("link_id not in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdBetween(Integer value1, Integer value2) {
            addCriterion("link_id between", value1, value2, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("link_id not between", value1, value2, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinlNameIsNull() {
            addCriterion("linl_name is null");
            return (Criteria) this;
        }

        public Criteria andLinlNameIsNotNull() {
            addCriterion("linl_name is not null");
            return (Criteria) this;
        }

        public Criteria andLinlNameEqualTo(String value) {
            addCriterion("linl_name =", value, "linlName");
            return (Criteria) this;
        }

        public Criteria andLinlNameNotEqualTo(String value) {
            addCriterion("linl_name <>", value, "linlName");
            return (Criteria) this;
        }

        public Criteria andLinlNameGreaterThan(String value) {
            addCriterion("linl_name >", value, "linlName");
            return (Criteria) this;
        }

        public Criteria andLinlNameGreaterThanOrEqualTo(String value) {
            addCriterion("linl_name >=", value, "linlName");
            return (Criteria) this;
        }

        public Criteria andLinlNameLessThan(String value) {
            addCriterion("linl_name <", value, "linlName");
            return (Criteria) this;
        }

        public Criteria andLinlNameLessThanOrEqualTo(String value) {
            addCriterion("linl_name <=", value, "linlName");
            return (Criteria) this;
        }

        public Criteria andLinlNameLike(String value) {
            addCriterion("linl_name like", value, "linlName");
            return (Criteria) this;
        }

        public Criteria andLinlNameNotLike(String value) {
            addCriterion("linl_name not like", value, "linlName");
            return (Criteria) this;
        }

        public Criteria andLinlNameIn(List<String> values) {
            addCriterion("linl_name in", values, "linlName");
            return (Criteria) this;
        }

        public Criteria andLinlNameNotIn(List<String> values) {
            addCriterion("linl_name not in", values, "linlName");
            return (Criteria) this;
        }

        public Criteria andLinlNameBetween(String value1, String value2) {
            addCriterion("linl_name between", value1, value2, "linlName");
            return (Criteria) this;
        }

        public Criteria andLinlNameNotBetween(String value1, String value2) {
            addCriterion("linl_name not between", value1, value2, "linlName");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIsNull() {
            addCriterion("link_url is null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIsNotNull() {
            addCriterion("link_url is not null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlEqualTo(String value) {
            addCriterion("link_url =", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotEqualTo(String value) {
            addCriterion("link_url <>", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThan(String value) {
            addCriterion("link_url >", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("link_url >=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThan(String value) {
            addCriterion("link_url <", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThanOrEqualTo(String value) {
            addCriterion("link_url <=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLike(String value) {
            addCriterion("link_url like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotLike(String value) {
            addCriterion("link_url not like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIn(List<String> values) {
            addCriterion("link_url in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotIn(List<String> values) {
            addCriterion("link_url not in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlBetween(String value1, String value2) {
            addCriterion("link_url between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotBetween(String value1, String value2) {
            addCriterion("link_url not between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeIsNull() {
            addCriterion("link_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeIsNotNull() {
            addCriterion("link_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeEqualTo(Date value) {
            addCriterion("link_update_time =", value, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeNotEqualTo(Date value) {
            addCriterion("link_update_time <>", value, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeGreaterThan(Date value) {
            addCriterion("link_update_time >", value, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("link_update_time >=", value, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeLessThan(Date value) {
            addCriterion("link_update_time <", value, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("link_update_time <=", value, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeIn(List<Date> values) {
            addCriterion("link_update_time in", values, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeNotIn(List<Date> values) {
            addCriterion("link_update_time not in", values, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("link_update_time between", value1, value2, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("link_update_time not between", value1, value2, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeIsNull() {
            addCriterion("link_create_time is null");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeIsNotNull() {
            addCriterion("link_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeEqualTo(Date value) {
            addCriterion("link_create_time =", value, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeNotEqualTo(Date value) {
            addCriterion("link_create_time <>", value, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeGreaterThan(Date value) {
            addCriterion("link_create_time >", value, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("link_create_time >=", value, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeLessThan(Date value) {
            addCriterion("link_create_time <", value, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("link_create_time <=", value, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeIn(List<Date> values) {
            addCriterion("link_create_time in", values, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeNotIn(List<Date> values) {
            addCriterion("link_create_time not in", values, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeBetween(Date value1, Date value2) {
            addCriterion("link_create_time between", value1, value2, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("link_create_time not between", value1, value2, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkStatusIsNull() {
            addCriterion("link_status is null");
            return (Criteria) this;
        }

        public Criteria andLinkStatusIsNotNull() {
            addCriterion("link_status is not null");
            return (Criteria) this;
        }

        public Criteria andLinkStatusEqualTo(Integer value) {
            addCriterion("link_status =", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotEqualTo(Integer value) {
            addCriterion("link_status <>", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusGreaterThan(Integer value) {
            addCriterion("link_status >", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("link_status >=", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusLessThan(Integer value) {
            addCriterion("link_status <", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusLessThanOrEqualTo(Integer value) {
            addCriterion("link_status <=", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusIn(List<Integer> values) {
            addCriterion("link_status in", values, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotIn(List<Integer> values) {
            addCriterion("link_status not in", values, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusBetween(Integer value1, Integer value2) {
            addCriterion("link_status between", value1, value2, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("link_status not between", value1, value2, "linkStatus");
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