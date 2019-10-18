package com.simitchiyski.aopexample;

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


	@Test
	void contextLoads() {
		assertNotNull(this.dataService);
	}

	@Test
	void testGetDataByKey(){
		assertEquals("value1", this.dataService.getDataByKey("key1"));
		this.dataService.sayHello();
	}

}
