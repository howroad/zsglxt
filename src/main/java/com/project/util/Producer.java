package com.project.util;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service("producer")
public class Producer {

	@Autowired
    private JmsTemplate jmsTemplate;
    //Ŀ�ĵض��е���֤������Ҫ��������з�����Ϣ
    @Autowired
    private ActiveMQQueue destinationQueue;
    //���ض��Ķ��з�����Ϣ
    public void sendMsgQueue(String msg) {
    	System.out.println(msg);
        jmsTemplate.send(destinationQueue, new MessageCreator() {
            
            public Message createMessage(Session session) throws JMSException {
                return (Message) session.createTextMessage(msg);
            }
        });
    }

}
