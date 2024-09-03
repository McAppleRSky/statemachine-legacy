package ru.mrs.statemachine.configuration;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

//@Configuration
//@EnableWebMvc
public class WebConfigurer /*implements WebMvcConfigurer*/ {

    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }
    /*@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
//        super.configurePathMatch(configurer);

        configurer.setUseSuffixPatternMatch(false);
    }*/

    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }*/

}
