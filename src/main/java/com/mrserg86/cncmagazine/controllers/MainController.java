package com.mrserg86.cncmagazine.controllers;

import com.mrserg86.cncmagazine.USDRate;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Slf4j
@Controller

public class MainController {

    @Autowired
    private USDRate usdRate;

    public void setUsdRate(USDRate usdRate) {
        this.usdRate = usdRate;
    }

    public USDRate getUsdRate() {
        return usdRate;
    }

    @GetMapping("/")
    public String CNCMAgazine(Model model) throws IOException {
        model.addAttribute("clearUSDRate", usdRate.getClearUSDRate());
        return "CNCMagazine";
    }

}
