package com.sample.mongodb_crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongodbCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbCrudApplication.class, args);
    }

    /*@Bean
    CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address("England", "London", "NE9");
            String email = "sdkjhfs@mail.com";
            Student student = new Student(
                    "Jamila",
                    "Ahmed",
                    email,
                    Gender.FEMALE,
                    address,
                    List.of("IT"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );

            repository.findStudentByEmail(email)
                    .ifPresentOrElse(s -> {
                                System.out.println(s + " already exists");
                            },
                            () -> {
                                System.out.println("Inserting student " + student);
                                repository.insert(student);
                            });

            //usingMongoTemplateAndQuery(repository, mongoTemplate, email, student);
        };
    }*/

    private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        mongoTemplate.find(query, Student.class);

        repository.insert(student);
    }
}
