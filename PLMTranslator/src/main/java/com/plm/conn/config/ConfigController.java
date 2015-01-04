package com.plm.conn.config;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.derby.catalog.GetProcedureColumns;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plm.conn.model.Completedjob;
import com.plm.conn.model.Failedjob;
import com.plm.conn.model.PlmAttributeList;
import com.plm.conn.model.PlmMapping;
import com.plm.conn.model.QueueService;

@Controller
public class ConfigController {

	@Autowired
	private QueueService queueSvc;

	private static final Logger logger = LoggerFactory
			.getLogger(ConfigController.class);

	@RequestMapping(value = { "/addConnection" }, method = RequestMethod.POST)
	public @ResponseBody String configAddConnection(
			@ModelAttribute("plmMapping") PlmMapping plmMapping,
			BindingResult result, ModelMap model) throws JMSException {
		logger.info("Welcome addConnection!  saving mapping for the plm:"
				+ plmMapping.getPlm());
		String status = "success";
		String msg = "";
		try {
			InetAddress inet = InetAddress.getByName(plmMapping
					.getPlmHostname());
			if (inet == null) {
				inet = InetAddress.getByAddress(plmMapping.getPlmIpaddress()
						.getBytes());
			}
			if (inet.isReachable(2000)) {
				plmMapping.setPlmStatus("Active");
			} else {
				plmMapping.setPlmStatus("In-Active");

			}

			inet = InetAddress.getByName(plmMapping.getWncHostname());
			if (inet == null) {
				inet = InetAddress.getByAddress(plmMapping.getWncIpaddress()
						.getBytes());
			}
			if (inet.isReachable(2000)) {
				plmMapping.setWncStatus("Active");
			} else {
				plmMapping.setWncStatus("In-Active");
			}
			queueSvc.savePlmMapping(plmMapping);
		} catch (Exception e) {
			status = "error";
			if (e instanceof DataIntegrityViolationException) {
				msg = "Cannot add same PLM application '" + plmMapping.getPlm()
						+ "' mapping again!.";
			}

		}

		JSONObject json = new JSONObject();
		json.put("status", status);
		if (status.equalsIgnoreCase("error")) {
			json.put("message", msg);
		}
		return json.toString();
	}

	@RequestMapping(value = { "/deleteConnection" }, method = RequestMethod.POST)
	public @ResponseBody String configDeleteConnection(
			HttpServletRequest request, ModelMap model) throws JMSException {
		logger.info("Welcome addConnection!  deleting mapping for the plm:"
				+ request.getParameterMap());
		Map map = request.getParameterMap();
		if (map.keySet() != null) {
			Set set = map.keySet();
			for (Iterator iterator = set.iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				Object[] obj = (Object[]) map.get(key);
				String plmName = "";
				if (obj instanceof String[]) {
					plmName = (String) obj[0];
					PlmMapping mapping = queueSvc.getPlmMapping(plmName);
					queueSvc.deletePlmMapping(mapping);
				}
				logger.info(key + "return" + plmName);
			}

		}
		JSONObject json = new JSONObject();
		json.put("status", "");
		json.put("msg", "");
		return json.toString();
	}

	@RequestMapping(value = { "/plm.list" }, method = RequestMethod.GET)
	public @ResponseBody String configPlmList(Locale locale, Model model)
			throws JMSException {
		logger.info("Welcome plm.list! The client locale is {}.", model);

		JSONObject json = new JSONObject();
		json.put("status", "success");
		JSONArray jsonArr = new JSONArray();

		JSONObject obj = null;
		List<PlmMapping> mappings = queueSvc.getPlmMapping();
		for (Iterator<PlmMapping> iterator = mappings.iterator(); iterator
				.hasNext();) {
			PlmMapping plmMapping = (PlmMapping) iterator.next();
			obj = new JSONObject();
			obj.put("id", plmMapping.getPlm());
			obj.put("text", plmMapping.getPlm());
			jsonArr.put(obj);
			json.put("items", jsonArr);
		}
		obj = new JSONObject();
		obj.put("id", "Windchill");
		obj.put("text", "Windchill");
		jsonArr.put(obj);
		json.put("items", jsonArr);

		logger.info("Welcome plm.list! The client locale is {}.",
				json.toString());
		return json.toString();
	}

	@RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public String configAdmin(Locale locale, Model model) throws JMSException {
		logger.info("Welcome configQueues! The client locale is {}.", model);

		return "admin";
	}

	@RequestMapping(value = { "/manageAttrs" }, method = RequestMethod.GET)
	public String configAttributes(Locale locale, Model model)
			throws JMSException {
		logger.info("Welcome manageAttrs! The client locale is {}.", model);
		return "manageAttrs";
	}

	@RequestMapping(value = { "/manageTypes" }, method = RequestMethod.GET)
	public String configTypes(Locale locale, Model model) throws JMSException {
		logger.info("Welcome manageAttrs! The client locale is {}.", model);
		return "manageTypes";
	}

	@RequestMapping(value = { "/mapAttrs" }, method = RequestMethod.GET)
	public String configMapAttrs(Locale locale, Model model)
			throws JMSException {
		logger.info("Welcome manageAttrs! The client locale is {}.", model);
		return "mapAttrs";
	}

	@RequestMapping(value = { "/saveAttribute" }, method = RequestMethod.POST)
	public @ResponseBody String configSaveAttribute(HttpServletRequest request,
			ModelMap model, Locale locale) throws JMSException,
			JsonParseException, JsonMappingException, IOException {
		logger.info("Welcome saveAttribute! The client locale is {}.",
				request.getParameterMap());

		if (!request.getParameterMap().isEmpty()) {
			Map postMap = request.getParameterMap();
			Set set = postMap.keySet();
			Object obj = null;
			for (Iterator iterator = set.iterator(); iterator.hasNext();) {
				obj = (Object) iterator.next();
			}

			org.json.JSONObject jobj = new org.json.JSONObject(obj.toString());
			ObjectMapper mapper = new ObjectMapper();
			JSONArray arr = jobj.getJSONArray("attributes");
			for (int i = 0; i < arr.length(); i++) {
				JSONObject jsonObject = arr.getJSONObject(i);
				PlmAttributeList listObj = mapper.readValue(
						jsonObject.toString(), PlmAttributeList.class);
				queueSvc.savePlmAttributeList(listObj);
			}
		}

		return "mapAttrs";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/connect", method = RequestMethod.POST)
	public @ResponseBody String config(Locale locale, Model model) {
		logger.info("Welcome connect! The client locale is {}.", locale);
		List<PlmMapping> plmMappings = queueSvc.getPlmMapping();
		JSONArray jsonRet = new JSONArray();
		int i = 0;
		for (PlmMapping plmMapping : plmMappings) {
			try {
				InetAddress inet = InetAddress.getByName(plmMapping
						.getPlmHostname());
				if (inet == null) {
					inet = InetAddress.getByAddress(plmMapping
							.getPlmIpaddress().getBytes());
				}
				if (inet.isReachable(2000)) {
					plmMapping.setPlmStatus("Active");
				} else {
					plmMapping.setPlmStatus("In-Active");

				}

				inet = InetAddress.getByName(plmMapping.getWncHostname());
				if (inet == null) {
					inet = InetAddress.getByAddress(plmMapping
							.getWncIpaddress().getBytes());
				}
				if (inet.isReachable(2000)) {
					plmMapping.setWncStatus("Active");
				} else {
					plmMapping.setWncStatus("In-Active");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			JSONObject json = new JSONObject(plmMapping);
			// json.get("")
			json.put("recid", i);
			jsonRet.put(json);
			i++;
		}

		JSONObject ret = new JSONObject();
		ret.put("status", "success");
		ret.put("total", jsonRet.length());
		ret.put("records", jsonRet);

		return ret.toString();
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/mappings", method = RequestMethod.GET)
	public String configMappings(Locale locale, Model model) {
		logger.info("Welcome updates! The client locale is {}.", locale);

		return "mappings";
	}

	@RequestMapping(value = "/completed.list", method = RequestMethod.POST)
	public @ResponseBody String configCompleted(Locale locale, Model model) {
		logger.info("return completed list", locale);
		List<?> completed = queueSvc.getCompletedQueues();
		JSONArray jsonRet = new JSONArray();
		int i = 0;
		for (Object obj : completed) {
			Completedjob completedjob = (Completedjob) obj;
			completedjob.setQueue(null);
			JSONObject json = new JSONObject(completedjob);
			// json.get("")
			json.put("recid", i);
			jsonRet.put(json);
			i++;
		}
		JSONObject ret = new JSONObject();
		ret.put("status", "success");
		ret.put("total", jsonRet.length());
		ret.put("records", jsonRet);

		return ret.toString();
	}

	@RequestMapping(value = "/failed.list", method = RequestMethod.POST)
	public @ResponseBody String configFailed(Locale locale, Model model) {
		logger.info("return failed list", locale);

		List<?> failed = queueSvc.getFailedQueues();
		JSONArray jsonRet = new JSONArray();
		int i = 0;
		for (Object obj : failed) {
			Failedjob failedjob = (Failedjob) obj;
			failedjob.setQueue(null);
			JSONObject json = new JSONObject(failedjob);
			// json.get("")
			json.put("recid", i);
			jsonRet.put(json);
			i++;
		}
		JSONObject ret = new JSONObject();
		ret.put("status", "success");
		ret.put("total", jsonRet.length());
		ret.put("records", jsonRet);

		return ret.toString();

	}

	@RequestMapping(value = "/plmattributes.list", method = RequestMethod.POST)	
	public @ResponseBody String configPlmAttributesList(HttpServletRequest request,HttpServletResponse response) {
		logger.info("return plm Attributes list selected_plm :");
		
		
		
		JSONArray jsonRet = new JSONArray();
		if(!request.getParameterMap().isEmpty()){
			String[] str = (String[]) request.getParameterMap().get("selected_plm");
			String plmName = str[0];
			System.out.println(" attr :"+plmName);
			List<?> list = queueSvc.getPlmAttributeListbyPlmName(plmName);			
			int i = 0;
			for (Object obj : list) {
				PlmAttributeList attList = (PlmAttributeList) obj;
				JSONObject json = new JSONObject(attList);
				// json.get("")
				json.put("recid", i);
				jsonRet.put(json);
				i++;
			}
		}
		
		
		JSONObject ret = new JSONObject();
		ret.put("status", "success");
		ret.put("total", jsonRet.length());
		ret.put("records", jsonRet);

		return ret.toString();

	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/queues", method = RequestMethod.GET)
	public String configMessages(Locale locale, Model model) {
		logger.info("Display Messages", locale);

		// List<Completedjob> completedList = queueSvc.getCompletedQueues();
		// List<Failedjob> failedList = queueSvc.getFailedQueues();

		// model.addAttribute("completedList", completedList);
		// model.addAttribute("failedList", failedList);

		return "queues";
	}

}
