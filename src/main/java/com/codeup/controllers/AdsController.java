package com.codeup.controllers;

import com.codeup.models.Ad;
import com.codeup.svcs.AdSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by canidmars on 6/20/17.
 */
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
}
