package aws.twitter.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import aws.twitter.Application;

public class ApplicationITTest {
	private static ConfigurableApplicationContext context;

	@BeforeClass
	public static void start() throws Exception {
		Callable<ConfigurableApplicationContext> callable = () -> SpringApplication.run(Application.class);
		Future<ConfigurableApplicationContext> future = Executors.newSingleThreadExecutor().submit(callable);
		context = future.get(60, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void stop() {
		if (context != null) {
			context.close();
		}
	}

	@Test
	public void testAnotherTwitterDataa() {
		ResponseEntity<String> entity = getRestTemplate().getForEntity("http://localhost:8080/twitterData",
				String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).hasSize(20443);
	}
//	TEST IT TEST DONNE REEL
//	TEST MOCKITO  : 
	@Test
	public void testAnotherTwitterDataMap() {
		ResponseEntity<String> entity = getRestTemplate().getForEntity("http://localhost:8080/twitterDataMap",
				String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).hasSize(7234);
	}
	@Test
	public void testAnotherTwitterDataHashTag() {
		ResponseEntity<String> entity = getRestTemplate().getForEntity("http://localhost:8080/twitterDataHashtag",
				String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).hasSize(6174);
	}
	@Test
	public void testAnotherTwitterData() {
		ResponseEntity<String> entity = getRestTemplate().getForEntity("http://localhost:8080/twitterDataAll",
				String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).hasSize(25924);
	}
	
	private RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
			}
		});
		return restTemplate;

	}
}