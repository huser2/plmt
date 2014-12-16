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
import com.plm.conn.obj.FailedJobsDao;
import com.plm.conn.obj.Queue;
import com.plm.conn.obj.QueueDao;

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

			Queue queue = new Queue();
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
			QueueDao queueObject = ApplicationContextProvider
					.getApplicationContext().getBean(QueueDao.class);
			queueObject.saveQueue(queue);

			// completedJobs
			CompletedJobsDao completed = ApplicationContextProvider
					.getApplicationContext().getBean(CompletedJobsDao.class);
			completed.saveQueue(queue);

			FailedJobsDao failed = ApplicationContextProvider
					.getApplicationContext().getBean(FailedJobsDao.class);
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
