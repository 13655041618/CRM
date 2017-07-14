package com.wdq.crm.base;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wdq.crm.classes.service.ClassesService;
import com.wdq.crm.courseType.service.CourseTypeService;
import com.wdq.crm.department.service.DepartmentService;
import com.wdq.crm.post.service.PostService;
import com.wdq.crm.staff.service.StaffService;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by haier on 2017/7/14.
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
    private T t;
    @Override
    public T getModel() {
        return t;
    }
    public BaseAction() {
        //由于T是运行时才能实现的对象，因此无法直接new出来，通过反射来获取对象实例
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
        try {
            t = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    /**
     * spring注入多个service
     * 提供set方法是让spring注入
     * 提供get方法是给子类使用
     */
    private StaffService staffService;

    public StaffService getStaffService() {
        return staffService;
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }
    private PostService postService;

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }
    private CourseTypeService courseTypeService;

    public CourseTypeService getCourseTypeService() {
        return courseTypeService;
    }

    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }
    private DepartmentService departmentService;

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    private ClassesService classesService;

    public ClassesService getClassesService() {
        return classesService;
    }

    public void setClassesService(ClassesService classesService) {
        this.classesService = classesService;
    }

    /**
     * 分页格式数据
     */
    private int pageNum = 1;
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    private int pageSize = 2;  //固定值
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    /**
     * 简化值栈
     */
    public void push(Object o) {
        ActionContext.getContext().getValueStack().push(o);
    }

    public void set(String key, Object o) {
        ActionContext.getContext().getValueStack().set(key,o);
    }

    public void put(String key, Object value) {
        ActionContext.getContext().put(key,value);
    }

    public void putSession(String key, Object value) {
        ActionContext.getContext().getSession().put(key,value);
    }
    public void putApplication(String key, Object value) {
        ActionContext.getContext().getApplication().put(key,value);
    }
}
