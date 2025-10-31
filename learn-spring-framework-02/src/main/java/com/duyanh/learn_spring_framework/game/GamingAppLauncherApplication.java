package com.duyanh.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Scan the package for components (beans)
@ComponentScan("com.duyanh.learn_spring_framework.game")
public class GamingAppLauncherApplication {


	public static void main(String[] args) {
		
      try(var context = 
            new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class);) {
         context.getBean(GamingConsole.class).up();
         context.getBean(GameRunner.class).run();
      }
	}

}
