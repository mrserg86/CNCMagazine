package CNCMagazine.controllers;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Slf4j
@Controller
public class MainController {

    @GetMapping("/")
    public String CNCMagazine(Model model) throws IOException {
        Document document = Jsoup.connect("https://cbr.ru/").get();
        String dirtyUSDRate = String.valueOf(document.getElementsContainingOwnText("₽"));
        String clearUSDRate = dirtyUSDRate.substring(dirtyUSDRate.length()-153,dirtyUSDRate.length()-143);
        log.info(clearUSDRate);
        model.addAttribute("clearUSDRate", clearUSDRate);
        return "CNCMagazine";
    }

}
