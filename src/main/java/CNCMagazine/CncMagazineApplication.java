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

		//Document document = Jsoup.connect("https://cbr.ru/").get();
		//System.out.println(document.title());
		//System.out.println(document.toString());
		//System.out.println(document.getElementsContainingOwnText("₽"));
		//String dirtyUSDRate = String.valueOf(document.getElementsContainingOwnText("₽"));
		//System.out.println(dirtyRate);
		//String clearUSDRate = dirtyUSDRate.substring(dirtyUSDRate.length()-153,dirtyUSDRate.length()-143);
		//System.out.println(clearUSDRate);
	}

}
