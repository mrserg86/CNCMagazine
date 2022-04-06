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
        log.info(clearUSDRate);
        model.addAttribute("clearUSDRate", clearUSDRate);
        return "CNCMagazine";
    }

    @GetMapping("/parsingByTag")
    public String parsingByTag(Model model) throws IOException {
        Document document = Jsoup.connect("https://cbr.ru/").get();
        Elements dirtyUSDRate = document.getElementsByClass("main-indicator_rate");
//        log.info("dirtyUSDRate : " + dirtyUSDRate);
        for(int i=0, i <= dirtyUSDRate.)
        return "CNCMagazine";
    }

}
