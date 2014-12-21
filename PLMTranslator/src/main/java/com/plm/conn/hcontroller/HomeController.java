package com.plm.conn.hcontroller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.plm.conn.model.Queue;
import com.plm.conn.model.QueueService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private QueueService queueSvc;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		InetAddress inet = null;
		try {
			inet = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("hostName", inet.getHostName());
		model.addAttribute("ipAddress", inet.getHostAddress());
		model.addAttribute("tcpBrokerURL", "tcp://" + inet.getHostAddress()
				+ ":16161/");
		model.addAttribute("stompBrokerURL", "stomp://" + inet.getHostAddress()
				+ ":61613/");

		Queue queue = new Queue();
		queue.setMsgidProd("1212121212");
		queueSvc.addQueue(queue);
		
		logger.info(""+queueSvc.getAll().size());
		
		

		return "home";
	}

}
