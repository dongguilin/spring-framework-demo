package com.guilin.spring.jax.ws.chapter1;

import com.guilin.spring.jax.ws.chapter1.service.SpitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * Created by guilin on 2017/4/16.
 */
@Configuration
@ComponentScan
@PropertySource("classpath:chapter1/application.properties")
public class RMIConfig {

    private static final Logger LOG = LoggerFactory.getLogger(RMIConfig.class);

    /**
     * 使用RmiServiceExporter将SpitterServiceImpl发布为RMI服务
     * <p>
     * 默认，RmiServiceExporter会尝试绑定到本地机器1099端口上的RMI注册表。如果在这个端口没有发现RMI注册表，
     * RMIServiceExporter将会启动一个注册表。
     * </p>
     *
     * @param spitterService
     * @return
     */
    @Bean
    public RmiServiceExporter rmiExporter(SpitterService spitterService) {
        RmiServiceExporter rmiExporter = new RmiServiceExporter();
        //RmiServiceExporter将SpitterService发布为一个RMI服务
        rmiExporter.setService(spitterService);
        //设置RMI服务名
        rmiExporter.setServiceName("spitterService");
        //设置些服务所实现的接口
        rmiExporter.setServiceInterface(SpitterService.class);
        //rmiExporter.setRegistryHost("192.168.60.123");
        //rmiExporter.setServicePort(2000);
        LOG.info("RMI服务：{}", rmiExporter.getService());
        return rmiExporter;
    }


    /**
     * 使用RmiProxyFactoryBean生成SpitterService的RMI代理
     *
     * @return
     */
    @Bean
    public RmiProxyFactoryBean spitterService() {
        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
        rmiProxy.setServiceUrl("rmi://localhost/spitterService");//服务URL
        rmiProxy.setServiceInterface(SpitterService.class);//服务提供的接口

        rmiProxy.setLookupStubOnStartup(false);
        rmiProxy.setRefreshStubOnConnectFailure(true);
        rmiProxy.afterPropertiesSet();
        SpitterService service = (SpitterService) rmiProxy.getObject();
        System.out.println(service);
        return rmiProxy;
    }

}
