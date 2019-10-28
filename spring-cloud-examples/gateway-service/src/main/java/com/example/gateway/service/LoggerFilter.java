package com.example.gateway.service;

import brave.Span;
import brave.Tracer;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

@Slf4j
@Component
public class LoggerFilter extends ZuulFilter {
    @Autowired
    Tracer tracer;

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        tracer.currentSpan().tag("operator", "wzh");
        System.out.println(tracer.currentSpan().context().traceIdString());
        return null;
    }
}
