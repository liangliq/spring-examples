import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by cpekl-ddim-2 on 12/5/18.
 */
public class Msg implements MessageCreator {
    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("test message");
    }
}
