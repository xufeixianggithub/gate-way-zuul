package com.xufx.gatewayzuul;

import com.xufx.filter.PreZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class GateWayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateWayZuulApplication.class, args);
	}

	/**
	 * 即使其它配置都写好的话，那么不添加这个 Bean 的方法的话，还是不会执行任何过滤的方法；
	 *
	 * @return
	 */
	@Bean
	public PreZuulFilter preZuulFilter() {
		return new PreZuulFilter();
	}
}

