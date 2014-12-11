package com.plm.conn.beans;

import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class ActiveMQBrowser{

	private static final Logger logger = LoggerFactory
			.getLogger(ActiveMQBrowser.class);

	private JmsTemplate jmsTemplate;
	private ActiveMQConnection connection;
	private ActiveMQSession session;

	
 
	
	public ActiveMQConnection getBrowserConnection() throws JMSException {
		this.connection = (ActiveMQConnection) jmsTemplate
				.getConnectionFactory().createConnection();
		return connection;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	
	public ActiveMQSession getActiveMQSession() throws JMSException {
		this.session = (ActiveMQSession) getBrowserConnection()
				.createSession(false, Session.AUTO_ACKNOWLEDGE);
		return session;
	}

}
