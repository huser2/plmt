package com.plm.conn.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plm.conn.model.PlmAttributeList;
import com.plm.conn.model.PlmAttributeMapping;
import com.plm.conn.model.PlmAttributeMappingPK;
import com.plm.conn.model.PlmTypeList;
import com.plm.conn.model.QueueService;

@Controller
public class AttributeMappingContoller {

	@Autowired
	private QueueService queueSvc;

	private static final Logger logger = LoggerFactory
			.getLogger(AttributeMappingContoller.class);

	@RequestMapping(value = "/attributemapping.list", method = RequestMethod.POST)
	public @ResponseBody String configPlmAttributeMappingList(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("return attributemapping :");

		JSONArray jsonRet = new JSONArray();
		if (!request.getParameterMap().isEmpty()) {
			String[] str = (String[]) request.getParameterMap().get(
					"selected_plm");
			String plmName = str[0];
			List<?> list = queueSvc
					.getPlmAttributeMappingListbyPlmName(plmName);
			int i = 0;
			for (Object obj : list) {
				PlmAttributeMapping attList = (PlmAttributeMapping) obj;
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
System.out.println("ma-----------------------------------------"+jsonRet.toString());
		return ret.toString();

	}

	@RequestMapping(value = "/plmtype.mappingtable.list", method = RequestMethod.GET)
	public @ResponseBody String configPlmTypeList(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("return plmtype.mappingtable.list :");

		JSONArray json = new JSONArray();
		if (!request.getParameterMap().isEmpty()) {
			String[] str = (String[]) request.getParameterMap().get(
					"selected_plm");
			String plmName = str[0];
			List<?> list = queueSvc.getPlmObjectTypeListbyPlmName(plmName);

			int i = 0;
			for (Object obj : list) {
				PlmTypeList attList = (PlmTypeList) obj;
				json.put(i, attList.getTypeId());
				i++;
			}
		}

		return json.toString();

	}
	
	@RequestMapping(value = "/plmattribute.mappingtable.list", method = RequestMethod.GET)
	public @ResponseBody String configPlmAttrMappingList(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("return plmtype.mappingtable.list :");

		JSONArray json = new JSONArray();
		if (!request.getParameterMap().isEmpty()) {
			String[] str = (String[]) request.getParameterMap().get(
					"selected_plm");
			String plmName = str[0];
			List<?> list = queueSvc.getPlmAttributeListbyPlmName(plmName);

			int i = 0;
			for (Object obj : list) {
				PlmAttributeList attList = (PlmAttributeList) obj;
				json.put(i, attList.getAttributeId());
				i++;
			}
		}

		return json.toString();

	}
	
	
	@RequestMapping(value = { "/saveNewMapping" }, method = RequestMethod.POST)
	public @ResponseBody String configSaveAttributeMapping(HttpServletRequest request,
			ModelMap model, Locale locale) throws JMSException,
			JsonParseException, JsonMappingException, IOException {
		logger.info("Welcome saveNewMapping! The client locale is {}.",
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
				PlmAttributeMapping listObj = mapper.readValue(
						jsonObject.toString(), PlmAttributeMapping.class);				
				
				queueSvc.savePlmAttributeMappingList(listObj);
			}
		}

		JSONObject ret = new JSONObject();
		ret.put("status", "success");

		return ret.toString();
	}
	
	@RequestMapping(value = { "/deleteNewMapping" }, method = RequestMethod.POST)
	public @ResponseBody String configDeleteAttribute(
			HttpServletRequest request, ModelMap model, Locale locale)
			throws JMSException, JsonParseException, JsonMappingException,
			IOException {
		logger.info("Welcome deleteNewMapping! The client locale is {}.");

		if (!request.getParameterMap().isEmpty()) {
			Map<?, ?> postMap = request.getParameterMap();
			Set<?> set = postMap.keySet();
			Object obj = null;
			for (Iterator<?> iterator = set.iterator(); iterator.hasNext();) {
				obj = (Object) iterator.next();
			}

			org.json.JSONObject jobj = new org.json.JSONObject(obj.toString());
			ObjectMapper mapper = new ObjectMapper();
			JSONArray arr = jobj.getJSONArray("attributes");
			for (int i = 0; i < arr.length(); i++) {
				JSONObject jsonObject = arr.getJSONObject(i);
				PlmAttributeList listObj = mapper.readValue(
						jsonObject.toString(), PlmAttributeList.class);
				queueSvc.deletePlmAttributeList(listObj);
			}
		}

		JSONObject ret = new JSONObject();
		ret.put("status", "success");
		return ret.toString();
	}

}
