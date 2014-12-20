package com.plm.conn.jms.receivers;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

import com.plm.conn.jms.ApplicationContextProvider;
import com.plm.conn.queue.CompletedQueueImpl;
import com.plm.conn.queue.FailedQueueImpl;
import com.plm.conn.queue.Queue;
import com.plm.conn.queue.QueueImpl;

public class MessageReceiver implements MessageListener, ExceptionListener {

	private static final Logger logger = LoggerFactory
			.getLogger(MessageReceiver.class);

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
		ActiveMQTextMessage incomeMsg = (ActiveMQTextMessage) message;
		logger.info(" Hello message received >>>>>>>>>>>>Success!" + incomeMsg);

		try {

			ActiveMQQueue receiver = (ActiveMQQueue) message
					.getJMSDestination();
			System.out.println(" message received ....." + receiver);

			Queue queue = new com.plm.conn.queue.Queue();
			queue.setMessageId(incomeMsg.getMessageId());
			queue.setDestination(incomeMsg.getDestination());
			queue.setGroupID(queue.getGroupID());
			queue.setConnection(incomeMsg.getConnection());
			queue.setJMSDeliveryMode(incomeMsg.getJMSDeliveryMode());
			queue.setJMSPriority(incomeMsg.getJMSPriority());
			queue.setJMSExpiration(incomeMsg.getJMSExpiration());
			queue.setJMSPriority(incomeMsg.getPriority());
			queue.setJMSType(incomeMsg.getJMSXMimeType());
			queue.setProducerId(incomeMsg.getProducerId());
			queue.setJMSCorrelationID(incomeMsg.getJMSCorrelationID());

			// save to main queue list
			QueueImpl queueObject = ApplicationContextProvider
					.getApplicationContext().getBean(QueueImpl.class);
			queueObject.saveQueue(queue);

			// completedJobs
			CompletedQueueImpl completed = ApplicationContextProvider
					.getApplicationContext().getBean(CompletedQueueImpl.class);
			completed.saveQueue(queue);

			FailedQueueImpl failed = ApplicationContextProvider
					.getApplicationContext().getBean(FailedQueueImpl.class);
			failed.saveQueue(queue);

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onException(JMSException exception) {
		 System.out.println("JMS Exception occured.  Shutting down client.");
		 exception.printStackTrace();
	}

}
