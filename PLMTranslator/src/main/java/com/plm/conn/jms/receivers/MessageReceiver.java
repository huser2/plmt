package com.plm.conn.jms.receivers;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.activemq.command.MessageId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.plm.conn.model.Completedjob;
import com.plm.conn.model.Failedjob;
import com.plm.conn.model.Queue;
import com.plm.conn.model.QueueService;

public class MessageReceiver implements MessageListener, ExceptionListener {

	private static final Logger logger = LoggerFactory
			.getLogger(MessageReceiver.class);

	private JmsTemplate jmsTemplate;

	@Autowired
	private QueueService queueSvc;

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

			MessageId msgId = incomeMsg.getMessageId();
			String queue_id = "";
			if (msgId != null) {
				queue_id = msgId.toString();
			} else {
				queue_id = "" + System.currentTimeMillis();
			}

			// save to main queue list
			Queue queue = new Queue();
			queue.setMsgId("1212121212");
			queue = queueSvc.save(queue);

			logger.info("queue id >>>" + queue.getQueueId());

			// completed Job
			Completedjob completed = new Completedjob();			
			completed.setQueue(queue);
			queueSvc.save(completed);
			
			
			// failed Job
			Failedjob failed = new Failedjob();			
			failed.setQueue(queue);
			queueSvc.save(failed);

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
