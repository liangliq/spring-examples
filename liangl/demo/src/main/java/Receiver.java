import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by cpekl-ddim-2 on 12/5/18.
 */
@Component
public class Receiver {
    @JmsListener(destination = "my-destination")
    public void  receivedMessage(String message){
        System.out.println("Received"+message);
    }
}