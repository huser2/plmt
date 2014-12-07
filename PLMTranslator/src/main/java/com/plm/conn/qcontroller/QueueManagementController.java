package com.plm.conn.qcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.broker.region.RegionBroker;
import org.apache.activemq.command.ActiveMQDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plm.conn.beans.ActiveMQBrowser;

@Controller
public class QueueManagementController {
	private static final Logger logger = LoggerFactory
			.getLogger(QueueManagementController.class);
	
	

	@RequestMapping(value = {"/queues" }, method = RequestMethod.GET)
	public String qManagerQueues(Locale locale, Model model) throws JMSException {
		logger.info("Welcome qManagerQueues! The client locale is {}.", model);
		
		return "queues";
	}
	
	@RequestMapping(value = {"/topics" }, method = RequestMethod.GET)
	public String qManagerTopics(Locale locale, Model model) {
		logger.info("Welcome qManagerTopics! The client locale is {}.", locale);
		return "topics";
	}
}
