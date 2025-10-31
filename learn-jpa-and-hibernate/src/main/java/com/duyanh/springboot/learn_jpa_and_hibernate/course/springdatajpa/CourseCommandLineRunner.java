package com.duyanh.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import com.duyanh.springboot.learn_jpa_and_hibernate.course.Course;
import com.duyanh.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.duyanh.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Jpa!", "Markle"));
        repository.save(new Course(2, "Learn Azure Jpa!", "Duy Anh"));
        repository.save(new Course(3, "Learn DevOps Jpa!", "Taylor"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("Duy Anh"));

        System.out.println(repository.findByName("Learn DevOps Jpa!"));
    }
}
