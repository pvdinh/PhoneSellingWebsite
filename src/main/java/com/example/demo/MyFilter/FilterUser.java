package com.example.demo.MyFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterUser implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpServletRequest.getSession();
        if(httpSession.getAttribute("user") == null){
            httpServletRequest.setAttribute("alertLogin","Đăng nhập trước khi thêm sản phẩm vào giỏ hàng.");
            RequestDispatcher requestDispatcher=httpServletRequest.getRequestDispatcher("/login/index");
            requestDispatcher.forward(servletRequest, servletResponse);
        }else filterChain.doFilter(servletRequest,servletResponse);
    }
}
