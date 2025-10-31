package com.duyanh.learn_spring_framework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeClass {
   private SomeDependency someDependency;
   
   public SomeClass(SomeDependency dependency) {
      this.someDependency = dependency;
      System.out.println("All denpendencies are ready!");
   }

   // @PostConstruct is executed after all beans are initialized and wired (dependencies injected) and before the application starts running and using the beans
   @PostConstruct 
   public void initialize() {
      someDependency.getReady();
   }

   // @PreDestroy is executed before the application is closed
   @PreDestroy
   public void cleanUp() {
      System.out.println("Cleaning up...");
   }
}

@Component
class SomeDependency {
   public void getReady() {
      System.out.println("Some logic using SomeDependency");
   }
}

@Configuration
// Scan the package for components (beans)
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
	public static void main(String[] args) {
	
      try(var context = 
            new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class);) {
         Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
      }
	}

}
