package ar.com.camd.bidfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BidfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BidfinderApplication.class, args);
	}

}
