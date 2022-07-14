package com.example.demodilam.controller;

import com.example.demodilam.payload.ForexResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ForexController {
    @GetMapping("/forex")
    public ForexResponse exchange(@RequestParam(value = "name", defaultValue = "world") String name,
                                  @RequestParam(value = "number", defaultValue = "0") int number){
        HashMap<String, Float> map = new HashMap<>();
        map.put("USD", 23000f);
        map.put("EUR", 25000f);
        map.put("JYP", 17000f);

        ForexResponse obj = new ForexResponse();
        if (map.containsKey(name)){
            Float value = map.get(name);
            obj.setValue(value * number);
            obj.setMsg("Chuyen doi thanh cong");
        }else{
            obj.setMsg("Chuyen doi that bai");
        }return obj;
    }
}
