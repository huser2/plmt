package com.plm.conn.beans;

import java.io.IOException;
import java.io.OutputStream;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import com.plm.conn.model.PlmAttributeList;

public class Test {

	public static void main(String[] args) throws JsonParseException,
			IOException {
		// TODO Auto-generated method stub
		String str = "{\"attributes\"" + ":[{" + "\"attributeId" + "\":\"32\""
				+ "," + "\"attributeName" + "\":\"32\"" + "," + "\"plmName\""
				+ ":" + "\"Team Center\"" + "},{" + "\"attributeId"
				+ "\":\"32\"" + "," + "\"attributeName" + "\":\"32\"" + ","
				+ "\"plmName\"" + ":" + "\"Team Center\"" + "}]}";

		System.out.println(" str ::" + str);

		org.json.JSONObject obj = new org.json.JSONObject(str);
		ObjectMapper mapper = new ObjectMapper();
		JSONArray arr = obj.getJSONArray("attributes");
		for (int i = 0; i < arr.length(); i++) {
			JSONObject jsonObject = arr.getJSONObject(i);
			PlmAttributeList listObj = mapper.readValue(jsonObject.toString(),
					PlmAttributeList.class);
			System.out.println("tokens..." + listObj.getAttributeId());
		}
	}
}
