package com.duyanh.learn_spring_framework.homework;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Scan the package for components (beans)
@ComponentScan
public class SimpleSpringContextLauncherApplication {
	public static void main(String[] args) {
      try(var context = 
            new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class);) {
         Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
         System.out.println(context.getBean(BusinessCalculationService.class).findMax());
      }
	}

}
