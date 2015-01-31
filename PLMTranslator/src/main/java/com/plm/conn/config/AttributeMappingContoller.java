package com.plm.conn.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plm.conn.model.PlmAttributeList;
import com.plm.conn.model.PlmAttributeMapping;
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

	@RequestMapping(value = "/plmattribute.list", method = RequestMethod.GET)
	public @ResponseBody String configPlmAttributeList(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("return plmattribute :");

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

		return ret.toString();

	}
}
