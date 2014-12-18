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

	@RequestMapping(value = { "/queues" }, method = RequestMethod.GET)
	public String configQueues(Locale locale, Model model)
			throws JMSException {
		logger.info("Welcome configQueues! The client locale is {}.", model);

		return "queues";
	}

	@RequestMapping(value = { "/properties" }, method = RequestMethod.GET)
	public String configProperties(Locale locale, Model model)
			throws JMSException {
		logger.info("Welcome configQueues! The client locale is {}.", model);

		return "properties";
	}
	
	@RequestMapping(value = { "/attributes" }, method = RequestMethod.GET)
	public String configAttributes(Locale locale, Model model)
			throws JMSException {
		logger.info("Welcome configQueues! The client locale is {}.", model);

		return "attributes";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public String config(Locale locale, Model model) {
		logger.info("Welcome updates! The client locale is {}.", locale);	

		return "config";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/mappings", method = RequestMethod.GET)
	public String configMappings(Locale locale, Model model) {
		logger.info("Welcome updates! The client locale is {}.", locale);	

		return "mappings";
	}


}
