package com.handen.SpringExercise;

import com.handen.SpringExercise.model.Advertiser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
class AdvertiserController {

    @Autowired
    AdvertiserMapper mAdvertiserMapper;

    @RequestMapping(value = "/post")
    public void postAdvertiser(@RequestParam(value = "name", defaultValue = "") String name,
                               @RequestParam(value = "contactName", defaultValue = "") String contactName,
                               @RequestParam(value = "creditLimit", defaultValue = "0") Integer creditLimit) {
        mAdvertiserMapper.insertAdvertiser(new Advertiser(name, contactName, creditLimit));
    }

    @RequestMapping(value = "/put")
    public void updateAdvertiser(@RequestParam(value = "id", defaultValue = "-1")Integer id,
                                 @RequestParam(value = "name", defaultValue = "", required = false) String name,
                                 @RequestParam(value = "contactName", defaultValue = "", required = false) String contactName,
                                 @RequestParam(value = "creditLimit", required = false) Integer creditLimit) {
        //TODO проверка аргументов на null
        mAdvertiserMapper.updateAdvertiser(new Advertiser(id, name, contactName, creditLimit));
    }

    @RequestMapping(value = "/delete")
    public void deleteAdvertiser(@RequestParam(value = "id", defaultValue = "-1") Integer id) {
        mAdvertiserMapper.deleteAdvertiser(id);
    }

    //TODO загулить handle errors with Spring boot
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Advertiser getAdvertiser(@RequestParam(value="id", defaultValue = "-1") Integer id) {
        return mAdvertiserMapper.getAdvertiser(id);
    }

    @RequestMapping(value = "/checkPerformTransaction", method = RequestMethod.GET)
    public boolean checkAbleToPerformTransaction(@RequestParam(value = "id", defaultValue = "-1") Integer id,
                                                 @RequestParam(value = "credits", defaultValue = "0") Integer credits) {
        int advertiserCredits = mAdvertiserMapper.getCredits(id);
        return advertiserCredits >= credits;
    }

    @RequestMapping(value = "/getAll", method =  RequestMethod.GET)
    public List<Advertiser> getAllAdvertisers() {
        List<Advertiser> list = mAdvertiserMapper.getAllAdvertisers();
        return list;
    }
}