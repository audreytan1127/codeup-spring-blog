package edu.codeup.codeupspringblog.services;

import edu.codeup.codeupspringblog.repositories.AdRepository;
import edu.codeup.codeupspringblog.repositories.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class CountService {
    private ContactRepository contactsDao;
    private AdRepository adsDao;
    public long returnAdsContactsCount(){
        return contactsDao.count() + adsDao.count();
    }
}
