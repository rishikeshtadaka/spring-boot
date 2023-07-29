package com.ecommerce.productservices;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

@SpringBootApplication
@Slf4j//this is used for logging and it provides log variable
public class ProductServicesApplication {

	public static void main(String[] args) {
		Environment environment=SpringApplication.run(ProductServicesApplication.class, args).getEnvironment();
		logApplicationStartup(environment);
	}
	private static void logApplicationStartup(Environment environment){
		String serverPort=environment.getProperty("server.port");
		String contextPath=environment.getProperty("server.servlet.context-path");
		if(StringUtils.isBlank(contextPath))
			contextPath="/";

		String hostAddress="localhost";
		try{
			hostAddress= InetAddress.getLocalHost().getHostAddress();
		}
		catch (UnknownHostException unknownHostException){
			log.warn("the host name could not be determined, using 'localhost' as fallback");
		}
		log.info("Spring version:{},Spring-Boot version:{}", SpringVersion.getVersion(), SpringBootVersion.getVersion());

		String[] profiles=environment.getActiveProfiles();
		if(profiles.length==0){
			log.info("No active profile set, falling back to default profiles:{}", Arrays.toString(environment.getDefaultProfiles()));
			profiles= environment.getActiveProfiles();
		}
		log.info("\n------------------------------------------------------------\n\t"
				+"Application '{}' is running! Access URLs:\n\t" + "Local:\t\t{}://localhost:{}{}\n\t"
				+"External:\t{}://{}:{}{}\n\t"
				+"Profiles(s):\t{}\n------------------------------------------------------------------",
				environment.getProperty("spring.application.name"),"http",serverPort,contextPath,"http",hostAddress,serverPort,contextPath,profiles
		);
	}

}
