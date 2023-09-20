package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Contact;
import edu.codeup.codeupspringblog.repositories.ContactRepository;
import edu.codeup.codeupspringblog.services.CountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContactController {
    private ContactRepository contactsDao;
    private CountService countService;
    public ContactController(ContactRepository contactsDao, CountService countService){
        this.contactsDao = contactsDao;
        this.countService = countService;
    }
    @GetMapping("/contacts/justin")
    @ResponseBody
    public List<Contact> returnContacts(){
        return contactsDao.findAllByName("Justin");
    }
    @GetMapping("/contacts")
    @ResponseBody
    public List<Contact> returnAllContacts(){
    return contactsDao.findAll();
    }
    @GetMapping("/contacts/view")
    public String returnContactsView(Model model){
        model.addAttribute("contacts", contactsDao.findAll());
        return "/contacts/index";
    }
    @GetMapping("/contacts/ads/count")
    @ResponseBody
    public long returnContactsAdsCount(){
        return countService.returnAdsContactsCount();
    }

}
