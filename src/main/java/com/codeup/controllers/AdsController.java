package com.codeup.controllers;

import com.codeup.models.Ad;
import com.codeup.svcs.AdSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by canidmars on 6/20/17.
 */

@Controller
public class AdsController {

    private AdSvc adsDao;

    @Autowired
    public AdsController(AdSvc adsDao) {
        this.adsDao = adsDao;
    }


     @GetMapping("/ads")
     public String index(Model model) {
         List<Ad> ads = adsDao.findAll();
         model.addAttribute("ads", ads);
         return "ads/index";
     }

     //ToDo: create form binding for Ads along with Instructor and on Posts for exercises

     @GetMapping("/ads/{id}")
     @ResponseBody
     public String show(@PathVariable long id) {
         return "viewing ad #" + id;
     }

     @GetMapping("/ads/create")
     public String showAdForm(Model model) {
        model.addAttribute("ad", new Ad());
        return "ads/create";
     }

     @PostMapping("/ads/create")
     public String saveAd(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description, Model model) {
        Ad ad = new Ad(title, description);
        model.addAttribute("ad", ad);
        return "ads/create";
     }
}
