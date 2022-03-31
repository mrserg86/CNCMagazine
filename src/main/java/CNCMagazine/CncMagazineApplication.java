package CNCMagazine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;


@SpringBootApplication
//@EnableScheduling
public class CncMagazineApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CncMagazineApplication.class, args);
	}

}
