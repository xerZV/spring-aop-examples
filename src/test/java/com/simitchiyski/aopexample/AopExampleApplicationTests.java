package com.simitchiyski.aopexample;

import com.simitchiyski.aopexample.aspects.TracingAspect;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AopExampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AopExampleApplicationTests {

	@Autowired
	private DataService dataService;

	@Autowired
	TracingAspect tracingAspect;

	@Test
	void contextLoads() {
		assertNotNull(this.dataService);
	}

	@Test
	void testGetDataByKey() {
		assertEquals("value1", this.dataService.getDataByKey("key1"));
	}


	@Test
	void testSayHello() {
		this.dataService.sayHello();
	}

}
