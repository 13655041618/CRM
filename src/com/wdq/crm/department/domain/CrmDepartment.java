package com.wdq.crm.department.domain;

import com.wdq.crm.post.domain.CrmPost;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by haier on 2017/7/8.
 */
public class CrmDepartment {
    private String depId;
    private String depName;

    private Set<CrmPost> postSet = new HashSet<CrmPost>();

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Set<CrmPost> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<CrmPost> postSet) {
        this.postSet = postSet;
    }
}
