package com.mrserg86.cncmagazine.controllers;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Slf4j
@Controller
public class MainController {

    @GetMapping("/parsingByText")
    public String parsingByText(Model model) throws IOException {
        Document document = Jsoup.connect("https://cbr.ru/").get();
        String dirtyUSDRate = String.valueOf(document.getElementsContainingOwnText("₽"));
        String clearUSDRate = dirtyUSDRate.substring(dirtyUSDRate.length()-153,dirtyUSDRate.length()-143);
        log.info("clearUSDRate : " + clearUSDRate);
        model.addAttribute("clearUSDRate", clearUSDRate);
        return "CNCMagazine";
    }

    @GetMapping("/")
    public String parsingByTag(Model model) throws IOException {
        Document document = Jsoup.connect("https://cbr.ru/").get();

        //1. Найти HTML тэги, которые обозначены классом main-indicator-rate
        Elements dirtyUSDRateStep1 = document.getElementsByClass("main-indicator_rate");
        String clearUSDRate = null;

        //2. Из них, выбрать тот !тэг!, внтури которого есть тэг c классом "_dollar"
        for(int i=0; i < dirtyUSDRateStep1.size(); i++) {
            Element dirtyUSDRateStep2 = dirtyUSDRateStep1.get(i);
            Elements dirtyUSDRateStep3 = dirtyUSDRateStep2.getElementsByClass("_dollar");
            if ( ! dirtyUSDRateStep3.isEmpty()) {
                log.info("dirtyUSDRateStep2 : " + dirtyUSDRateStep2.text());

                //3. Из него выбираем содержимое первого тэга с классом mono-num
                //for(int j=0; j < dirtyUSDRateStep3.size(); j++) {
                    Elements dirtyUSDRateStep4 = dirtyUSDRateStep2.getElementsByClass("mono-num");
                    Element dirtyUSDRateStep5 = dirtyUSDRateStep4.get(0);

                    //4. Из полученного тэга получаем содержимое
                    clearUSDRate = dirtyUSDRateStep5.text();
            } else {
                clearUSDRate = "Ничего не найдено, видимо, доллар больше никому не нужен, ты в пролёте";
            }
        }
        log.info("clearUSDRate : " + clearUSDRate);
        model.addAttribute("clearUSDRate", clearUSDRate);
        return "CNCMagazine";
    }

}
