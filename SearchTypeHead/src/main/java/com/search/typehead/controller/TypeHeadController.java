package com.search.typehead.controller;

import com.search.typehead.service.TypeHeadSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TypeHeadController {

    TypeHeadSearchService typeHeadSearchService;

    public TypeHeadController(TypeHeadSearchService typeHeadSearchService) {
        this.typeHeadSearchService = typeHeadSearchService;
    }

    @PostMapping("/add")
    public boolean addWord(String word, @RequestBody List<String> words){
        typeHeadSearchService.addWords(words);
        return true;
    }

    @GetMapping("/check/{word}")
    public boolean checkWord(@PathVariable("word") String word){
        return typeHeadSearchService.isAWord(word);
    }

    @GetMapping("/recommend/{word}")
    public List<String> getRecommendation(@PathVariable("word") String word){
        return typeHeadSearchService.getRecommendation(word);
    }




}
