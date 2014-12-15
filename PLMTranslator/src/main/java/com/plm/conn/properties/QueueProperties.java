package com.plm.conn.properties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class QueueProperties extends PropertyPlaceholderConfigurer {
 
	private static Map<String, String> propertiesMap;
	// Default as in PropertyPlaceholderConfigurer
	private int springSystemPropertiesMode = SYSTEM_PROPERTIES_MODE_FALLBACK;

	@Override
	protected void loadProperties(Properties arg0) throws IOException {
		// TODO Auto-generated method stub
		super.loadProperties(arg0);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		super.setProperties(properties);
	}

	@Override
	public void setSystemPropertiesMode(int systemPropertiesMode) {
		super.setSystemPropertiesMode(systemPropertiesMode);
		springSystemPropertiesMode = systemPropertiesMode;
	}

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		super.processProperties(beanFactory, props);

		propertiesMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String valueStr = resolvePlaceholder(keyStr, props,
					springSystemPropertiesMode);
			propertiesMap.put(keyStr, valueStr);
		}
	}

	public static String getProperty(String name) {
		return propertiesMap.get(name).toString();
	}

	public static Map getPropertyMap() {
		return propertiesMap;
	}

}
