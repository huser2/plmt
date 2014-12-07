package com.plm.conn.settings;

import java.util.Locale;
import java.util.Properties;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plm.conn.properties.QueueProperties;

@Controller
public class SettingsController {
	private static final Logger logger = LoggerFactory
			.getLogger(SettingsController.class);

	
	@RequestMapping(value = { "/qprops" }, method = RequestMethod.GET)
	public String settingsQueues(Locale locale, Model model)
			throws JMSException {

		logger.info("Welcome settingsQueues! The client locale is {}.", model);
		QueueProperties prop  =  new QueueProperties();
		Properties props =  new Properties();
		props.setProperty("Test", "Hello");
		prop.setProperties(props);
		
		System.out.println(" inside bean................................."+prop);
		model.addAttribute("props", QueueProperties.getPropertyMap());

		return "qprops";
	}

}
