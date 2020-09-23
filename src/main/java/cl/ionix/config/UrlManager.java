package cl.ionix.config;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UrlManager {

	public String parseUrlApiQueryParams(String url, Map<String, String> data) {

		log.info("parseUrlApi in:" + url + "---" + data);

		int c = 0;

		for (Map.Entry<String, String> entry : data.entrySet()) {

			if (c == 0) {
				url = url.concat("?" + entry.getKey() + "=" + entry.getValue());
			} else {
				if (!entry.getValue().equalsIgnoreCase(""))
					url = url.concat("&" + entry.getKey() + "=" + entry.getValue());
			}

			c++;
		}

		log.info("parseUrlApi out:" + url);

		return url;
	}

	public String parseUrlApiPathParams(String url, Map<String, String> data) {

		log.info("parseUrlApi in:" + url + "---" + data);

		for (Map.Entry<String, String> entry : data.entrySet()) {
			Pattern pattern = Pattern.compile("\\{" + entry.getKey() + "\\}");
			Matcher m = pattern.matcher(url);
			url = m.replaceAll(data.get(entry.getKey()));
		}

		log.info("parseUrlApi out:" + url);

		return url;
	}
}