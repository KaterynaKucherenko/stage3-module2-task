package com.mjc.school.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.mjc.school.repository")
@ComponentScan("com.mjc.school.service")
@ComponentScan("com.mjc.school.controller")
@ComponentScan("com.mjc.school.main")
@EnableAspectJAutoProxy
public class AppConfiguration {

}
