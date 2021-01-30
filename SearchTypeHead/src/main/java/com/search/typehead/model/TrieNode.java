package com.search.typehead.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TrieNode {

    private Character c;
    private boolean isComplete;
    private Map<Character, TrieNode> children;

    public TrieNode(Character c) {
        this.c = c;
        children = new HashMap<>();
    }

    public TrieNode getChild(Character c){
        return this.children.getOrDefault(c, null);
    }

    public boolean isComplete() {
        return isComplete;
    }

    public TrieNode setComplete(boolean complete) {
        isComplete = complete;
        return this;
    }

    public TrieNode addChild(Character c){
        TrieNode value = new TrieNode(c);
        this.children.put(c, value);
        return value;
    }

    public TrieNode removeChild(Character c){
        this.children.remove(c);
        return this;
    }

    public Character getC() {
        return c;
    }

    public TrieNode setC(Character c) {
        this.c = c;
        return this;
    }

    public Set<Map.Entry<Character, TrieNode>> getChildren(){
        return this.children.entrySet();
    }
}
