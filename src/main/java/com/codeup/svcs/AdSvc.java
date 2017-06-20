package com.codeup.svcs;

import com.codeup.models.Ad;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by canidmars on 6/20/17.
 */

@Service("adSvc")
public class AdSvc {

    private List<Ad> ads;

    public AdSvc() {
        createAds();
    }

    public List<Ad> findAll() {
        return ads;
    }

    public Ad save(Ad ad) {
        ad.setId(ads.size() + 1);
        ads.add(ad);
        return ad;
    }

    public Ad findOne(long id) {
        return ads.get((int) (id - 1));
    }

    private void createAds() {
        // create some ad objects and add them to the ads list
        // with the save method
    }
}
