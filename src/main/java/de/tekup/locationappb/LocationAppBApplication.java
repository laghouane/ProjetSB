package de.tekup.locationappb;

import de.tekup.locationappb.security.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class LocationAppBApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationAppBApplication.class, args);
	}

}
