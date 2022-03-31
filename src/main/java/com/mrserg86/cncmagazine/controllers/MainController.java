package com.mrserg86.cncmagazine.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MainController {

    @GetMapping("/CNCMagazine")
    public String CNCMagazine(Model model) throws IOException {
        Document document = Jsoup.connect("https://cbr.ru/").get();
        //System.out.println(document.title());
        //System.out.println(document.toString());
        //System.out.println(document.getElementsContainingOwnText("₽"));
        String dirtyUSDRate = String.valueOf(document.getElementsContainingOwnText("₽"));
        //System.out.println(dirtyRate);
        String clearUSDRate = dirtyUSDRate.substring(dirtyUSDRate.length()-153,dirtyUSDRate.length()-143);
        System.out.println(clearUSDRate);
        model.addAttribute("clearUSDRate", clearUSDRate);
        return "CNCMagazine";
    }

}
