package com.search.typehead.service;

import com.search.typehead.model.TrieNode;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Trie {

    private static TrieNode root;

    private Trie(){
    }

    public static Trie getTrie(){
        if(root == null)
            root = new TrieNode(null);
        return new Trie();
    }

    public void add(String word){
        add(root, word, 0);
    }

    private void add(TrieNode r, String word, int pos){
        if(word.length() == pos){
            r.setComplete(true);
            return;
        }
        TrieNode temp = r.getChild(word.charAt(pos));
        if(temp == null)
            temp = r.addChild(word.charAt(pos));
        add(temp, word, pos+1);
    }

    public boolean contains(String word){
        return contains(root, word, 0);
    }

    private boolean contains(TrieNode root, String word, int pos){
        if(root == null)
            return false;
        if(pos == word.length()){
            return root.isComplete();
        }
        return contains(root.getChild(word.charAt(pos)), word, pos+1);
    }

    public List<String> getWordsWith(String s){
        List<String> res = new ArrayList<>();
        TrieNode r = nodeAt(root, s, 0);
        Stack<NodeWord> stack = new Stack<>();
        stack.add(new NodeWord(s, r));

        while (!stack.isEmpty()){
            NodeWord t = stack.pop();
            for (Map.Entry<Character, TrieNode> e: t.node.getChildren()) {
                if(e.getValue().isComplete()){
                    res.add(t.word + e.getKey());
                }
                stack.add(new NodeWord(t.word + e.getKey(), e.getValue()));
            }
        }
        return res;
    }

    public static class NodeWord{
        String word;
        TrieNode node;

        public NodeWord(String word, TrieNode node) {
            this.word = word;
            this.node = node;
        }
    }

    private TrieNode nodeAt(TrieNode r, String s, int pos){
        if(r == null){
            return null;
        }
        if(pos == s.length()){
            return r;
        }
        return nodeAt(r.getChild(s.charAt(pos)), s, pos + 1);
    }

}
