package com.mishalavrov.messenger;

import com.mishalavrov.messenger.domain.Message;
import com.mishalavrov.messenger.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public ModelAndView showCities(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model)
    {
        model.put("name", name);
        return new ModelAndView("greeting", model);
    }

    @GetMapping
    public ModelAndView main(Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return new ModelAndView("main", model);
    }

    @PostMapping
    public ModelAndView add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return new ModelAndView("main", model);
    }

    @PostMapping("filter")
    public ModelAndView filter(@RequestParam String tag, Map<String, Object> model) {
        Iterable<Message> messages;
        if(tag != null && !tag.isEmpty()){
            messages = messageRepo.findByTag(tag);
        } else {
            messages = messageRepo.findAll();
        }
        model.put("messages", messages);
        return new ModelAndView("main", model);
    }
}
