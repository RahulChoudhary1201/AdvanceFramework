package resusableComponents;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperation {

	static Properties prop = new Properties();

	public static String getPropertyValueByKey(String key) throws Exception {
		String configFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
		FileInputStream fis = new FileInputStream(configFilePath);
		prop.load(fis);
		String value = prop.getProperty(key).toString();

		if (StringUtils.isEmpty(value)) {
			throw new Exception("Value not specified for the key: " + key + " in properties file.");
		}
		return value;
	}

}
