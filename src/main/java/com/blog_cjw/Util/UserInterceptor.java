package com.blog_cjw.Util;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor extends HandlerInterceptorAdapter {

    //컨트롤러 보다 먼저 수행. 인터셉터와 필터의 차이 필터는 Dispatch-servlet 이 실행 되기전에 실행되어 모두에게 적용.
    //인터셉터는 서블렛이 실행된후 판단하에 실행


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if(user == null){
            //로그인이 안되어 있는 상태일때, 로그인 폼으로 다시 돌려보냄
            response.sendRedirect("/user/login");
            return false;
        }

        return true;
    }


    //컨트롤러 넘어가기 직전 수행 메서드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
