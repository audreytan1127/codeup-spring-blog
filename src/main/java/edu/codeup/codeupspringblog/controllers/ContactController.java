package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Contact;
import edu.codeup.codeupspringblog.repositories.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContactController {
    private ContactRepository contactsDao;
    public ContactController(ContactRepository contactsDao){
        this.contactsDao = contactsDao;
    }
    @GetMapping("/contacts")
    @ResponseBody
    public List<Contact> returnContacts(){
    return contactsDao.findAll();
    }
}
