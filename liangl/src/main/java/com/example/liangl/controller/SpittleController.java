package com.example.liangl.controller;

import com.example.liangl.data.SpittleRepository;
import com.example.liangl.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by cpekl-ddim-2 on 11/5/18.
 */

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE+"";

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    /*@RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }*/

    /*@RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max",defaultValue = MAX_LONG_AS_STRING ) long max,
                                  @RequestParam(value = "count",defaultValue = "20") int count){
        return spittleRepository.findSpittles(max, count);
    }*/

    @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model
    ) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittles";
    }

}