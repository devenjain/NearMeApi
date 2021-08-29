package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class NearMeApiApplication {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
//		return new RestTemplate;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NearMeApiApplication.class, args);
	}
	
	@PostConstruct
	public static void trustSelfSignedSSL()
	  {
	  try
	  {
	  final SSLContext ctx = SSLContext.getInstance("TLS");
	  final X509TrustManager tm = new X509TrustManager()
	  {

	  public void checkClientTrusted(final X509Certificate[] xcs, final String string) throws CertificateException
	  {
	  // do nothing
	  }

	  public void checkServerTrusted(final X509Certificate[] xcs, final String string) throws CertificateException
	  {
	  // do nothing
	  }

	  public java.security.cert.X509Certificate[] getAcceptedIssuers()
	  {
	  return null;
	  }

	@Override
	public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
			throws java.security.cert.CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
			throws java.security.cert.CertificateException {
		// TODO Auto-generated method stub
		
	}

	
	public java.security.cert.X509Certificate[] getAcceptedIssuers1() {
		// TODO Auto-generated method stub
		return null;
	}
	  };
	  ctx.init(null, new TrustManager[]
	  { tm }, null);
	  SSLContext.setDefault(ctx);
	  }
	  catch (final Exception ex)
	  {
	  ex.printStackTrace();
	  }
	  }

}
