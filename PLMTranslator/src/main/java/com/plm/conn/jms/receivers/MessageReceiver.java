package com.plm.conn.jms.receivers;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.ActiveMQQueueReceiver;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

import com.plm.conn.jms.ApplicationContextProvider;
import com.plm.conn.obj.CompletedJobsDao;
import com.plm.conn.obj.Queue;

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
		ActiveMQTextMessage test = (ActiveMQTextMessage) message;
		logger.info(" Hello message received >>>>>>>>>>>>Success!"
				+ test);
		
		
		try {
			
			ActiveMQQueue receiver = (ActiveMQQueue) message.getJMSDestination();
			System.out.println(" message received ....."+receiver);
			
			Queue queue = new Queue();
			queue.setMessageId(test.getMessageId());
			queue.setDestination(test.getDestination());
			queue.setGroupID(queue.getGroupID());
			queue.setConnection(test.getConnection());
			queue.setJMSDeliveryMode(test.getJMSDeliveryMode());
			queue.setJMSPriority(test.getJMSPriority());
			
			 CompletedJobsDao complObject = ApplicationContextProvider.getApplicationContext().getBean(CompletedJobsDao.class);
			 complObject.saveQueue(queue);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onException(JMSException exception) {
		// TODO Auto-generated method stub
		
	}

}
