package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private Map<String, Object> beans;

    public ApplicationContext() {
        beans = new HashMap<>();
    }

    public <T> T genBean(String beanName) {
        Object bean = beans.get(beanName);
        if (bean == null) {
            bean = switch (beanName) {
                case "testPostRepository" -> new TestPostRepository();
                default -> null;
            };
            beans.put(beanName, bean);
        }
        return (T) bean;
    }
}
