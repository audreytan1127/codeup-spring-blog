package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Ad;
import edu.codeup.codeupspringblog.repositories.AdRepository;
import edu.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdController {

    private AdRepository adsDao;
    private EmailService emailService;

    public AdController(AdRepository adsDao) {
        this.adsDao = adsDao;
    }

    @GetMapping("/test")
    @ResponseBody
    public String returnTest() {
        return "Test";
    }

    @GetMapping("/ads")
    @ResponseBody
    public List<Ad> returnAds() {
        return adsDao.findAll();
    }

    @GetMapping("/ads/{id}")
    @ResponseBody
    public Ad returnAd(@PathVariable Long id) {
        return adsDao.getAdById(id);
    }

    @GetMapping("/ads/create")
    public String createAd(Model model) {
        // if we were editing an ad...
        // Ad adToEdit = adsDao.findById(1L).get();
        // model.addAttribute("ad", adToEdit);
        model.addAttribute("ad", new Ad());
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String insertAd(@ModelAttribute Ad ad) {
        Ad adToSave = new Ad(
                ad.getTitle(),
                ad.getDescription()
        );
        adsDao.save(adToSave);
        emailService.prepareAndSendAds(adToSave, "You created an ad!", "Here is some more info from your ad!");
        return "redirect:/ads";
    }

}
