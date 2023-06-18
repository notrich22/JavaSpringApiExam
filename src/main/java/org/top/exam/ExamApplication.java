package org.top.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamApplication {
    @Bean
    public FilterRegistrationBean<Middleware> loggingFilter() {
        FilterRegistrationBean<Middleware> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new Middleware());
        registrationBean.addUrlPatterns("/*"); // Укажите паттерны URL, на которые должен быть применен middleware

        return registrationBean;
    }
    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }

}
