package com.runrundjangoninja.demo.controller;

import com.runrundjangoninja.demo.model.Gachik;
import com.runrundjangoninja.demo.service.GachikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class GachikController {
    private final GachikService gachikService;

    @Autowired
    public GachikController(GachikService gachikService) {
        this.gachikService = gachikService;
    }

    @GetMapping("/")
    public String showGachikList(Model model) {
        model.addAttribute("gachiks", gachikService.getAllSortedByRating());
        return "index";
    }

    @GetMapping("/addGachi")
    public String showAddGachi() {
        return "addGachi";
    }

    @PostMapping("/addGachi")
    public String addGachi(@RequestParam("name") String name,
                           @RequestParam("url") String url,
                           @RequestParam("rating") double rating) {
        try {
            Gachik newGachik = new Gachik(name, new URL(url), rating);
            gachikService.add(newGachik);
            return "redirect:/";
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "addGachi";
        }
    }
}
