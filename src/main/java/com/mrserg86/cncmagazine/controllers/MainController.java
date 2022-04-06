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

    @GetMapping("/parsingByTag")
    public String parsingByTag(Model model) throws IOException {
        Document document = Jsoup.connect("https://cbr.ru/").get();
        Elements dirtyUSDRateStep1 = document.getElementsByClass("main-indicator_rate");
        Element clearUSDRate = new Element("s");
        for(int i=0; i < dirtyUSDRateStep1.size(); i++) {
            Element dirtyUSDRateStep2 = dirtyUSDRateStep1.get(i);
            Elements dirtyUSDRateStep3 = dirtyUSDRateStep2.getElementsByClass("_dollar");
            if ( ! dirtyUSDRateStep3.isEmpty()) {
                for(int j=0; j < dirtyUSDRateStep3.size(); j++) {
                    Element dirtyUSDRateStep4 = dirtyUSDRateStep3.get(j);
                    Elements dirtyUSDRateStep5 = dirtyUSDRateStep4.getElementsByClass("mono-num");
                    if (! dirtyUSDRateStep5.isEmpty()) {
                        clearUSDRate = dirtyUSDRateStep5.get(1);
                    }
                }
            }
        }
        model.addAttribute("clearUSDRate", clearUSDRate);
        return "CNCMagazine";
    }

}