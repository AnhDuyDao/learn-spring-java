package com.duyanh.learn_spring_framework.homework;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

// @Component
@Repository
@Primary
public class MongoDbDataService implements DataService {
   public int[] retrieveData() {
      return new int[] { 11, 22, 33, 44, 55 };
   }
}
