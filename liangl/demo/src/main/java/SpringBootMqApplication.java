import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by cpekl-ddim-2 on 12/5/18.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.example.liangl")
public class SpringBootMqApplication implements CommandLineRunner {

    @Autowired
    JmsTemplate jmsTemplate;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMqApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jmsTemplate.send("my-destination",new Msg());
    }
}
