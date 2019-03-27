/*
 * Copyright 2019. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tairanchina.csp.dew.notification;


import com.ecfront.dew.common.$;
import com.ecfront.dew.common.Resp;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class NotifyTest {

    private static CountDownLatch cdl = new CountDownLatch(6);

    @Test
    public void testDD() {
        NotifyConfig ddConfig = new NotifyConfig();
        ddConfig.setType(NotifyConfig.TYPE_DD);
        ddConfig.setDefaultReceivers(new HashSet<String>() {
            {
                add("18657120203");
            }
        });
        ddConfig.setArgs(new HashMap<String, Object>() {
            {
                put("url", "https://oapi.dingtalk.com/robot/send?access_token=8ff65c48001c1981df7d326b5cac497e5ca27190d5e7ab7fe9168ad69b103455");
            }
        });
        Notify.init(new HashMap<String, NotifyConfig>() {
            {
                put("dd", ddConfig);
            }
        }, flag -> "test");

        Resp<Void> result = Notify.send("dd", "测试消息，带符号$$ com.trc.test.web.WebController.customHttpState(WebController.java:73)\n"
                + "com.trc.test.web.WebController$$FastClassBySpringCGLIB$$2ae0c170.invoke(<generated>)\n"
                + "org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:204)\n"
                + "org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:736)\n"
                + "org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)\n"
                + "org.springframework.validation.beanvalidation.MethodValidationInterceptor.invoke(MethodValidationInterceptor.java:150)\n"
                + "org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)\n"
                + "org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:671)\n"
                + "com.trc.test.web.WebController$$EnhancerBySpringCGLIB$$34293e67.customHttpState(<generated>)\n"
                + "sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n"
                + "sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n"
                + "sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n"
                + "java.lang.reflect.Method.invoke(Method.java:497)\n"
                + "org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205)\n"
                + "org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:133)\n"
                + "org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:97)\n"
                + "org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:827)\n"
                + "org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:738)\n"
                + "org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:85)\n"
                + "org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:967)\n"
                + "org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:901)\n"
                + "org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:970)\n"
                + "org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:861)\n"
                + "javax.servlet.http.HttpServlet.service(HttpServlet.java:635)\n"
                + "org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:846)\n"
                + "javax.servlet.http.HttpServlet.service(HttpServlet.java:742)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n"
                + "org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n"
                + "org.springframework.boot.web.filter.ApplicationContextHeaderFilter.doFilterInternal(ApplicationContextHeaderFilter.java:55)\n"
                + "org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n"
                + "org.springframework.boot.actuate.trace.WebRequestTraceFilter.doFilterInternal(WebRequestTraceFilter.java:111)\n"
                + "org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n"
                + "org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99)\n"
                + "org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n"
                + "org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:109)\n"
                + "org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n"
                + "org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:81)\n"
                + "org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n"
                + "org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:197)\n"
                + "org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n"
                + "org.springframework.boot.actuate.autoconfigure.MetricsFilter.doFilterInternal(MetricsFilter.java:106)\n"
                + "org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n"
                + "io.micrometer.spring.web.servlet.WebMvcMetricsFilter.doFilterInternal(WebMvcMetricsFilter.java:106)\n"
                + "org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n"
                + "com.tairanchina.csp.dew.DewStartup$DewStartupFilter.doFilter(DewStartup.java:42)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n"
                + "org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n"
                + "org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:198)\n"
                + "org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\n"
                + "org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:496)\n"
                + "org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:140)\n"
                + "org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:81)\n"
                + "org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:87)\n"
                + "org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:342)\n"
                + "org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:803)\n"
                + "org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66)\n"
                + "org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:790)\n"
                + "org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1468)\n"
                + "org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n"
                + "java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n"
                + "java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n"
                + "org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n"
                + "java.lang.Thread.run(Thread.java:745)\n");
        Assert.assertTrue(result.ok());
    }

    // @Test
    public void testMail() {
        NotifyConfig mailConfig = new NotifyConfig();
        mailConfig.setType(NotifyConfig.TYPE_MAIL);
        mailConfig.setDefaultReceivers(new HashSet<String>() {
            {
                add("i@sunisle.org");
            }
        });
        mailConfig.setArgs(new HashMap<String, Object>() {
            {
                put("from", "test@ecfront.com");
                put("host", "smtp.exmail.qq.com");
                put("port", 465);
                put("username", ""); // 登录用户
                put("password", ""); // 登录密码
                put("secure", "ssl");
            }
        });
        Notify.init(new HashMap<String, NotifyConfig>() {
            {
                put("mail", mailConfig);
            }
        }, flag -> "test");

        Resp<Void> result = Notify.send("mail", "test");
        Assert.assertTrue(result.ok());
    }

    @Test
    public void testHttp() throws IOException, InterruptedException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        HttpContext context = server.createContext("/notify");
        context.setHandler(NotifyTest::handleRequest);
        server.start();

        NotifyConfig httpConfig = new NotifyConfig();
        httpConfig.setType(NotifyConfig.TYPE_HTTP);
        httpConfig.setArgs(new HashMap<String, Object>() {
            {
                put("url", "http://127.0.0.1:8080/notify");
            }
        });
        httpConfig.setDefaultReceivers(new HashSet<String>() {
            {
                add("jzy");
            }
        });

        NotifyConfig strategyConfig = new NotifyConfig();
        strategyConfig.setType(NotifyConfig.TYPE_HTTP);
        strategyConfig.setArgs(new HashMap<String, Object>() {
            {
                put("url", "http://127.0.0.1:8080/notify");
            }
        });
        strategyConfig.setDefaultReceivers(new HashSet<String>() {
            {
                add("jzy");
            }
        });
        strategyConfig.setDndTimeReceivers(new HashSet<String>() {
            {
                add("gudaoxuri");
            }
        });
        NotifyConfig.Strategy strategy = new NotifyConfig.Strategy();
        strategy.setMinIntervalSec(2);
        // 模拟跨天免扰
        Calendar calendar = Calendar.getInstance();
        String startTime = new SimpleDateFormat("HH:mm").format(calendar.getTime());
        calendar.add(Calendar.HOUR, -1);
        String endTime = new SimpleDateFormat("HH:mm").format(calendar.getTime());
        strategy.setDndTime(startTime + "-" + endTime);
        strategy.setForceSendTimes(4);
        strategyConfig.setStrategy(strategy);

        Map<String, NotifyConfig> notifyConfigMap = new HashMap<>();
        notifyConfigMap.put("http", httpConfig);
        notifyConfigMap.put("strategy", strategyConfig);

        Notify.init(notifyConfigMap, flag -> "test");

        // Http test
        Resp<Void> result = Notify.send("http", "hi", "正常消息");
        Assert.assertTrue(result.ok());
        Notify.sendAsync("http", "hi", "异步消息");
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            result = Notify.send("http", e, "错误消息");
            Assert.assertTrue(result.ok());
        }
        result = Notify.send("http", "hi", "指定通知人", new HashSet<String>() {
            {
                add("sunisle");
            }
        });
        Assert.assertTrue(result.ok());

        result = Notify.send("strategy", "免扰时间，不发送", "免扰消息");
        Assert.assertTrue(result.getMessage().contains("Do Not Disturb time"));
        result = Notify.send("strategy", "2s只会发一次,此条消息不应被收到", "免扰消息");
        Assert.assertTrue(result.getMessage().contains("Notify frequency"));
        result = Notify.send("strategy", "2s只会发一次,此条消息不应被收到", "免扰消息");
        Assert.assertTrue(result.getMessage().contains("Notify frequency"));
        Thread.sleep(2100);
        result = Notify.send("strategy", "免扰时间，不发送", "免扰消息");
        Assert.assertTrue(result.getMessage().contains("Do Not Disturb time"));
        Thread.sleep(2100);
        result = Notify.send("strategy", "免扰时间，达到4次(包含1次延迟通知)，发送", "策略消息");
        Assert.assertTrue(result.ok());
        cdl.await(10, TimeUnit.SECONDS);
    }


    private static void handleRequest(HttpExchange exchange) throws IOException {
        String body = new BufferedReader(new InputStreamReader(exchange.getRequestBody())).lines().collect(Collectors.joining("\n"));
        JsonNode json = $.json.toJson(body);
        if (json.get("title").asText().equals("正常消息test")
                && json.get("content").asText().equals("hi")
                && json.get("receivers").get(0).asText().equals("jzy")) {
            cdl.countDown();
        } else if (json.get("title").asText().equals("异步消息test")
                && json.get("content").asText().equals("hi")) {
            cdl.countDown();
        } else if (json.get("title").asText().equals("错误消息test")
                && json.get("content").asText().contains("java.lang.ArithmeticException: / by zero")) {
            cdl.countDown();
        } else if (json.get("title").asText().equals("指定通知人test")
                && json.get("receivers").get(0).asText().equals("jzy")
                && json.get("receivers").get(1).asText().equals("sunisle")) {
            cdl.countDown();
        } else if (json.get("title").asText().equals("延时通知test")
                && json.get("receivers").get(0).asText().equals("gudaoxuri")
                && json.get("content").asText().equals("在最近的[4]秒内发生了[4]次通知请求。")) {
            cdl.countDown();
        } else if (json.get("title").asText().equals("策略消息test")
                && json.get("receivers").get(0).asText().equals("gudaoxuri")) {
            cdl.countDown();
        } else {
            throw new RuntimeException("error");
        }
        System.out.println($.json.toJsonString(json));
        String response = "ok";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
