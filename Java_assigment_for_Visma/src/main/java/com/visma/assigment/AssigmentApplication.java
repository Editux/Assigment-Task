package com.visma.assigment;
/*                  Assigment for Java Internship at Visma
                    Goal : Is to Create a Spingboot application that allows to create a book, filter,delete from JSON file.
                    Author: Edita Komarova
*
*
*
* */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication(scanBasePackages = "com.visma.assigment")
public class AssigmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssigmentApplication.class, args);
    }


}
