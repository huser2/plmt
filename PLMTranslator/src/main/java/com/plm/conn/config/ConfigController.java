package com.plm.conn.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.broker.region.RegionBroker;
import org.apache.activemq.command.ActiveMQDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plm.conn.beans.ActiveMQBrowser;
import com.plm.conn.model.Completedjob;
import com.plm.conn.model.Failedjob;
import com.plm.conn.model.Queue;
import com.plm.conn.model.QueueService;

@Controller
public class ConfigController {

	@Autowired
	private QueueService queueSvc;

	private static final Logger logger = LoggerFactory
			.getLogger(ConfigController.class);

	@RequestMapping(value = { "/queues" }, method = RequestMethod.GET)
	public String configQueues(Locale locale, Model model) throws JMSException {
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

	@RequestMapping(value = "/completed.list", method = RequestMethod.GET)	
	public @ResponseBody Model configCompleted(Locale locale, Model model) {
		logger.info("return completed list", locale);
		List compList = new ArrayList();
		compList.add("Test");
		compList.add("Test2");
		
		model.addAttribute("completedObjs",compList);
		return model;
	}

	@RequestMapping(value = "/failed.list", method = RequestMethod.GET)
	public @ResponseBody Model configFailed(Locale locale, Model model) {
		logger.info("return failed list", locale);
		List compList = new ArrayList();
		compList.add("Test");
		compList.add("Test2");
		model.addAttribute("failedObjs",compList);
		return model;
	}

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public String configMessages(Locale locale, Model model) {
		logger.info("Display Messages", locale);

		//List<Completedjob> completedList = queueSvc.getCompletedQueues();
		//List<Failedjob> failedList = queueSvc.getFailedQueues();

		//model.addAttribute("completedList", completedList);
		//model.addAttribute("failedList", failedList);

		return "messages";
	}

}
