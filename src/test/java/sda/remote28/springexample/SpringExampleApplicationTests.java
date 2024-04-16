package sda.remote28.springexample;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:jenkins.properties")
class SpringExampleApplicationTests {

	@Value("${messageFromJenkins}")
	private List<String> message;

	@BeforeEach
	public void setup() throws IOException {
		// append all URLs
		final Stream<String> urlStream = MyClass.fetchFilesAsList(message);
	}

	@Test
	void testValueWithJenkinsParametrisedBuild() {
		System.out.println("Test Started with value: " + message);
		assert message.size() > 0;
	}

}
