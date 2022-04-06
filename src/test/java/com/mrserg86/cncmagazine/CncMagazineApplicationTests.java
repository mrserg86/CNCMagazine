package com.mrserg86.cncmagazine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.io.IOException;

@SpringBootTest
class CncMagazineApplicationTests {

	@Test
	void contextLoads() throws IOException {
			Document document = Jsoup.connect("https://cbr.ru/").get();
			System.out.println(document.title());
			System.out.println(document.toString());
			System.out.println(document.getElementsContainingOwnText("₽"));
			String dirtyUSDRate = String.valueOf(document.getElementsContainingOwnText("₽"));
			System.out.println(dirtyUSDRate);
			String clearUSDRate = dirtyUSDRate.substring(dirtyUSDRate.length()-153,dirtyUSDRate.length()-143);
			System.out.println(clearUSDRate);
		}

}
