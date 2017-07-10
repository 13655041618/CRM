package com.wdq.crm.coursetype.domain;

import com.wdq.crm.classes.domain.CrmClasses;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by haier on 2017/7/8.
 */
public class CrmCoursetype {
    /**
     * CREATE TABLE `crm_course_type` (
     `courseTypeId` varchar(255) NOT NULL PRIMARY KEY,
     `courseCost` double DEFAULT NULL,
     `total` int(11) DEFAULT NULL,
     `courseName` varchar(500) DEFAULT NULL,
     `remark` varchar(5000) DEFAULT NULL
     );
     */
    private String courseTypeId;
    private Double courseCost;
    private Integer total;
    private String courseName;
    private String remark;
    private Set<CrmClasses> classesSet = new HashSet<CrmClasses>();

    public Set<CrmClasses> getClassesSet() {
        return classesSet;
    }

    public void setClassesSet(Set<CrmClasses> classesSet) {
        this.classesSet = classesSet;
    }

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public Double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Double courseCost) {
        this.courseCost = courseCost;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
