
package com.bibliotheque.batch;

import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@Configuration
@EnableBatchProcessing
public class WSUtils {
 
    private static String servicesUrl;

	public static void setBaseUrl(String baseUrl) {
		servicesUrl = baseUrl;
	}

	public static URL getUrl(String suffix) {
		try {
			return new URL(servicesUrl + suffix);
		} catch (MalformedURLException e) {
			return null;
		}
	}
}
    

