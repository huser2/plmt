package com.plm.conn.qcontroller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QueueManagementController {
	private static final Logger logger = LoggerFactory
			.getLogger(QueueManagementController.class);

	@RequestMapping(value = {"/queues" }, method = RequestMethod.GET)
	public String qManagerQueues(Locale locale, Model model) {
		logger.info("Welcome qManagerQueues! The client locale is {}.", locale);
		return "queues";
	}
	
	@RequestMapping(value = {"/topics" }, method = RequestMethod.GET)
	public String qManagerTopics(Locale locale, Model model) {
		logger.info("Welcome qManagerTopics! The client locale is {}.", locale);
		return "topics";
	}
}
