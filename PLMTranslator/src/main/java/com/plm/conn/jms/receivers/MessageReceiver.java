package com.plm.conn.jms.receivers;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

public class MessageReceiver implements MessageListener,ExceptionListener {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void send(final Object Object) {
		jmsTemplate.convertAndSend(Object);
	}

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		logger.info(" Hello message received >>>>>>>>>>>>Success!"
				+ message);
		System.out.println(" message received ....."+message);

	}

	@Override
	public void onException(JMSException exception) {
		// TODO Auto-generated method stub
		
	}

}
