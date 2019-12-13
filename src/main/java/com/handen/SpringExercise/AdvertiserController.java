package com.handen.SpringExercise;

import com.handen.SpringExercise.model.Advertiser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
class AdvertiserController {

    @Autowired
    AdvertiserMapper mAdvertiserMapper;

    @PostMapping
    public void postAdvertiser(@RequestBody Advertiser advertiser) {
        System.out.println("POST REQUEST");
        System.out.println("Name: " + advertiser.getName());
        System.out.println("ContactName: " + advertiser.getContactName());
        System.out.println("Credits: " + advertiser.getCreditLimit());
        mAdvertiserMapper.insertAdvertiser(advertiser);
    }

    @PutMapping(value = "/{id}/**")
    public void updateAdvertiser(@PathVariable Integer id,
                                 @RequestBody Advertiser advertiser) {
        mAdvertiserMapper.updateAdvertiser(id, advertiser);
    }

    @DeleteMapping(value = "/{id}/**")
    public void deleteAdvertiser(@PathVariable Integer id) {
        mAdvertiserMapper.deleteAdvertiser(id);
    }

    @RequestMapping(value = "/{id}/**")
    public Advertiser getAdvertiser(@PathVariable Integer id) {
        return mAdvertiserMapper.getAdvertiser(id);
    }

    @RequestMapping(value = "{id}/checkPerformTransaction")
    public boolean checkAbleToPerformTransaction(@PathVariable Integer id,
                                                 @RequestParam(value = "credits", defaultValue = "0") Integer credits) {
        int advertiserCredits = mAdvertiserMapper.getCredits(id);
        return advertiserCredits >= credits;
    }

    @RequestMapping
    public List<Advertiser> getAllAdvertisers() {
        return mAdvertiserMapper.getAllAdvertisers();
    }
}