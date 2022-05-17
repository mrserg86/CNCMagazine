package com.mrserg86.cncmagazine.controllers;

import com.mrserg86.cncmagazine.services.USDRate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private USDRate usdRate;

    @GetMapping("/")
    public String cncMagazine() {
        return "CNCMagazine";
    }

    @GetMapping("/authenticated")
    public String au(Model model) throws IOException {
        model.addAttribute("USDRate", usdRate.getClearUSDRate());
        return "authenticated";
    }

}
