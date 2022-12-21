package com.example.common.filter;

import com.alibaba.druid.util.Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/12/9 18:04
 * @desc
 */
@WebFilter(urlPatterns = "/druid/js/common.js")
public class RemoveDruidAdvertFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String text = Utils.readFromResource("support/http/resources/js/common.js");
        text = text.replace("this.buildFooter();", "");
        response.getWriter().write(text);
    }

}
