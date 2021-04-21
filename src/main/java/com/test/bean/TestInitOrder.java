package com.test.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestInitOrder implements BeanFactoryPostProcessor ,BeanPostProcessor,BeanFactoryAware{
    public TestInitOrder(){
        System.out.println("构造函数--slh");
    }
    @PostConstruct
    public void testConstruct() {
        System.out.println("testPostConstruct--slh");
    }



    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("---->");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanFactorPost接口的beanpost");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanFactorPost接口的beanpost");
        return bean;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("--->BeanFactoryAware");
    }
}
