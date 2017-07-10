package com.wdq.crm.post.domain;

import com.wdq.crm.department.domain.CrmDepartment;
import com.wdq.crm.staff.domain.CrmStaff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by haier on 2017/7/8.
 */
public class CrmPost {
    private String postId;
    private String postName;

    private CrmDepartment department;
    private Set<CrmStaff> staffSet = new HashSet<CrmStaff>();

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public CrmDepartment getDepartment() {
        return department;
    }

    public void setDepartment(CrmDepartment department) {
        this.department = department;
    }

    public Set<CrmStaff> getStaffSet() {
        return staffSet;
    }

    public void setStaffSet(Set<CrmStaff> staffSet) {
        this.staffSet = staffSet;
    }
}
