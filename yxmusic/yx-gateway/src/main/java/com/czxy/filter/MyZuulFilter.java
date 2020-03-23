package com.czxy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletResponse;


public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        System.out.println("网关执行了");

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletResponse httpResponse = currentContext.getResponse();

        //*表示允许所有域名跨域
        httpResponse.addHeader("Access-Control-Allow-Origin", "http://yunxiang.com");
        httpResponse.addHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept");
        //允许跨域的Http方法
        httpResponse.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
        httpResponse.addHeader("Access-Control-Max-Age", "0");
        httpResponse.addHeader("Access-Control-Allow-Credentials","true");
        httpResponse.addHeader("XDomainRequestAllowed","1");





        return true;
    }
}
