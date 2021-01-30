package com.search.typehead.service;

import com.search.typehead.model.TrieNode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeHeadSearchService {

    public void addWords(List<String> words){
        Trie t = Trie.getTrie();
        for (String word :
                words) {
            t.add(word);
        }
    }

    public boolean isAWord(String word){
        Trie t = Trie.getTrie();
        return t.contains(word);
    }

    public List<String> getRecommendation(String s){
        Trie t = Trie.getTrie();
        return t.getWordsWith(s);
    }



}
