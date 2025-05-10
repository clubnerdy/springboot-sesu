package com.example.loginexample._core.interceptor;

import com.example.loginexample._core.error.ex.Exception401;
import com.example.loginexample.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("sessionUser");

        if (uri.equals("/")) {
            if (sessionUser == null) throw new Exception401("로그인이 필요한 서비스입니다.");
        }

        return true;
    }
}
