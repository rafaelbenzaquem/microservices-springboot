package academy.devdojo.core.model.course;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class CourseApplicationTests {

    @Value("${local.server.port}")
    protected int port;
    protected String baseURi = "http://localhost:";

}
