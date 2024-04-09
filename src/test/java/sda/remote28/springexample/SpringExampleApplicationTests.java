package sda.remote28.springexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:jenkins.properties")
@SpringBootTest
class SpringExampleApplicationTests {

	@Value("${messageFromJenkins}")
	private String message;

	@Test
	void testValueWithJenkinsParametrisedBuild() {
		System.out.println("Test Started with value: " + message);
		assert message.equalsIgnoreCase("Java");
	}

}
