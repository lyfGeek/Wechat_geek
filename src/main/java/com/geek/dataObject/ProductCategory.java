package com.geek.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author geek
 */
@Entity
@Data
@DynamicUpdate
public class ProductCategory implements Serializable {

    @Id// 主键。
    @GeneratedValue// 自增。
    private Integer categoryId;// 类目 id。
    private String categoryName;// 类目名字。
    private Integer categoryType;// 类目编号。
    private Date create_time;
    private Date update_time;

}

/*
2020-04-14 22:19:51.443 ERROR 6112 --- [nio-8080-exec-4] o.a.c.c.C.[.[.[.[dispatcherServlet]      : Servlet.service() for servlet [dispatcherServlet] in context with path [/sell] threw exception [Request processing failed; nested exception is java.lang.IllegalArgumentException: No converter found for return value of type: class com.geek.VO.ResultVO] with root cause

java.lang.IllegalArgumentException: No converter found for return value of type: class com.geek.VO.ResultVO
	at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor.writeWithMessageConverters(AbstractMessageConverterMethodProcessor.java:187) ~[spring-webmvc-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.handleReturnValue(RequestResponseBodyMethodProcessor.java:174) ~[spring-webmvc-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite.handleReturnValue(HandlerMethodReturnValueHandlerComposite.java:81) ~[spring-web-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:113) ~[spring-webmvc-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:827) ~[spring-webmvc-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:738) ~[spring-webmvc-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:85) ~[spring-webmvc-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:963) ~[spring-webmvc-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:897) ~[spring-webmvc-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:970) ~[spring-webmvc-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:861) ~[spring-webmvc-4.3.8.RELEASE.jar:4.3.8.RELEASE]

 */
