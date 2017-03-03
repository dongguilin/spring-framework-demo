package com.guilin.spring.common.demo.chapter1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * Created by guilin on 2017/3/3.
 * Spring EL
 */
@Configuration
@ComponentScan
@PropertySource("classpath:chapter1/test.properties")
public class ElConfig {

    //注入普通字符串
    @Value("I Love You!")
    private String normal;

    //注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;

    //注入表达式结果
    @Value("#{T (java.lang.Math).random()*100.0}")
    private double randomNumber;

    //注入其他Bean属性
    @Value("#{demoService.another}")
    private String fromAnother;

    //注入文件资源
    @Value("classpath:chapter1/test.txt")
    private Resource testFile;

    //注入网址资源
    @Value("http://www.baidu.com")
    private Resource testUrl;

    //注入配置文件属性
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    public String getNormal() {
        return normal;
    }

    public String getOsName() {
        return osName;
    }

    public double getRandomNumber() {
        return randomNumber;
    }

    public String getFromAnother() {
        return fromAnother;
    }

    public Resource getTestFile() {
        return testFile;
    }

    public Resource getTestUrl() {
        return testUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
