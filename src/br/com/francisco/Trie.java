package br.com.francisco;

import java.util.ArrayList;

public class Trie{
    TrieNode root;

    public Trie(String path) {
        root = new TrieNode();
        ArrayList<String> arrayList = ReadFile.readCSV(path);
        if (arrayList == null){
            return;
        } else{
            for (String value: arrayList) {
                insert(value);
            }
        }
    }


    private void insert(String value) {
        insert(root, value, value.substring(0,value.length()));
    }

    private void insert(TrieNode root, String value, String string) {
        if (value.length() > 0){
            char aux = value.charAt(0);
            if (root.getChildrem().containsKey(aux)){
                insert(root.getChildrem().get(aux), value.substring(1,value.length()),string);
            }else{
                root.getChildrem().put(value.charAt(0), new TrieNode());
                insert(root.getChildrem().get(aux),value.substring(1,value.length()), string);
            }
        }else {
            root.setEndOfWord(true);
        }
    }


    public void delete(String value) {
        if (value.length() == 0){
            return;
        }
        delete(value,root, null, 0, 0);
    }

    private void delete(String value, TrieNode root, TrieNode last, int count, int pos) {
        if (value.length() > count){
            TrieNode aux = null;
            if (root.getChildrem().containsKey(value.charAt(count))){
                if ((aux = root.getChildrem().get(value.charAt(count))).isEndOfWord()){
                    last = root;
                    pos = count;
                }
            }else {
                return;
            };
            delete(value, aux, last, count+1, pos);
        }else{
            if (last == null && root.isEndOfWord()){
                this.root.getChildrem().remove(value.charAt(0));
            } else if (root.getChildrem().isEmpty() && root.isEndOfWord()){
                last.getChildrem().remove(value.charAt(pos));
            } else if (root.isEndOfWord()){
               last.getChildrem().get(value.charAt(pos)).setEndOfWord(false);
            }
        }
    }


    public boolean search(String target){
        return search(target, this.root);
    }

    private boolean search(String target, TrieNode root) {
        if (target.length() > 0){
            if (root.getChildrem().containsKey(target.charAt(0))){
                return search(target.substring(1, target.length()), root.getChildrem().get(target.charAt(0)));
            }else{
                return false;
            }
        }
        return true & root.isEndOfWord();
    }


    public void sugestions(String commom, int num){
        ArrayList<String> arrayList = sugestions(commom);
        num = num > arrayList.size() ? arrayList.size() : num;
        for (int i = 0; i < num; i++){
            System.out.println(arrayList.get(i));
        }
    }

    public ArrayList<String> sugestions(String commom){
        return sugestions(this.root,commom, new ArrayList<String>(),"");
    }

    private ArrayList<String> sugestions(TrieNode root, String commom, ArrayList<String> strings, String s) {
        if (commom.length() > 0){
            if (root.getChildrem().containsKey(commom.charAt(0))){
               return sugestions(root.getChildrem().get(commom.charAt(0)), commom.substring(1,commom.length()), strings, s+commom.charAt(0));
            } else{
                return new ArrayList<String>();
            }
        } else {
            return sugest(root, strings, s);
        }
    }

    private ArrayList<String> sugest(TrieNode root, ArrayList<String> strings, String s) {
        if (root.isEndOfWord()){
            strings.add(s);
        }
        for (char value: root.getChildrem().keySet()){
            sugest(root.getChildrem().get(value), strings,s+value);
        }
        return strings;
    }


    public void showAll() {
        showAll(root, "");
    }

    private void showAll(TrieNode root, String string) {
        if (root.isEndOfWord()){
            System.out.println(string);
        }
        for (char value: root.getChildrem().keySet()){
            showAll(root.getChildrem().get(value), string+value);
        }
    }

}
