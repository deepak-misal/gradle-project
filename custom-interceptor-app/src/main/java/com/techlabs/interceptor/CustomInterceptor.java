package com.techlabs.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CustomInterceptor implements Interceptor{

	@Override
	public void destroy() {
		System.out.println("CustomInterceptor destroy() is called...");
		
	}

	@Override
	public void init() {
		System.out.println("CustomInterceptor init() is called...");
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("CustomInterceptor, before invocation.invoke()...");
        System.out.println(java.time.LocalTime.now());
        String result = invocation.invoke();
        System.out.println(java.time.LocalTime.now());
        System.out.println("CustomInterceptor, after invocation.invoke()...");
        
        return result;
	}

}
