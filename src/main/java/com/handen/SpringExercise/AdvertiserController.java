package com.handen.SpringExercise;

import com.handen.SpringExercise.model.Advertiser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AdvertiserController {
    //TODO загулить handle errors with Spring boot
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Advertiser getAdvertiser(@RequestParam(value="id", defaultValue = "-1") Integer id) {
        return new Advertiser(id, "name", "contactName", 0);
    }

    @RequestMapping(value = "/put")
    public void updateAdvertiser(@RequestParam(value = "id", defaultValue = "-1")Integer id,
                                 @RequestParam(value = "name", defaultValue = "", required = false) String name,
                                 @RequestParam(value = "contactName", defaultValue = "", required = false) String contactName,
                                 @RequestParam(value = "creditLimit", required = false) Integer creditLimit) {
        //TODO проверка аргументов на null
        System.out.println("PUT");
        System.out.println(id);
        System.out.println(name);
        System.out.println(contactName);
        System.out.println(creditLimit);
    }
    @RequestMapping(value = "/post")
    public void postAdvertiser(@RequestParam(value = "id", defaultValue = "-1")Integer id,
                               @RequestParam(value = "name", defaultValue = "") String name,
                               @RequestParam(value = "contactName", defaultValue = "") String contactName,
                               @RequestParam(value = "creditLimit", defaultValue = "0") Integer creditLimit) {
        System.out.println("POST");
        System.out.println(id);
        System.out.println(name);
        System.out.println(contactName);
        System.out.println(creditLimit);
    }

    @RequestMapping(value = "/delete")
    public void deleteAdvertiser(@RequestParam(value = "id", defaultValue = "-1") Integer id) {
        System.out.println("DELETE");
        System.out.println(id);
    }
    @RequestMapping(value = "/checkPerformTransaction", method = RequestMethod.GET)
    public boolean checkAbleToPerformTransaction(@RequestParam(value = "id", defaultValue = "-1") Integer id,
                                                 @RequestParam(value = "credits", defaultValue = "0") Integer credits) {
        System.out.println("CHECK");
        System.out.println(id);
        System.out.println(credits);
        return credits > 100;
    }
}