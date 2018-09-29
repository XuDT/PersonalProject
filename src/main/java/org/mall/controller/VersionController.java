package org.mall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * 获取git.properties文件
 * */
@RestController
public class VersionController {
    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public Properties versionInformation() {
        Properties properties = null;
        try {
            //获取文件
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("git.properties");
            properties = new Properties();
            //读取git.properties
            properties.load(inputStream);
        }catch (IOException e){
        }
        return properties;
    }
}

