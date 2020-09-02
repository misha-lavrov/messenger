package com.mishalavrov.messenger;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {
    @GetMapping("/greeting")
    public ModelAndView showCities(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Model model)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return new ModelAndView("greeting", params);
    }
}
