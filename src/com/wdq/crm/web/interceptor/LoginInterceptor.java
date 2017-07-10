package com.wdq.crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by haier on 2017/7/9.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    public String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object loginStaff = ActionContext.getContext().getSession().get("loginStaff");
        if (loginStaff == null) {
            //获取当前运行的action
            Object action = actionInvocation.getAction();
            if (action instanceof ActionSupport) {
                ActionSupport actionSupport = (ActionSupport) action;
                actionSupport.addFieldError("", "请登录");
                return "login";
            }
        }
        return actionInvocation.invoke();//如果session中有对象则表示已登录，直接放行到下一个action
    }
}
