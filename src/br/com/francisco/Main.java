package br.com.francisco;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Trie tree = new Trie("/home/Francisco/Repositorios/Trabalho-EDB2/out/artifacts/Program/words.txt");
        tree.delete("ele");
        tree.showAll();

//        Trie tree = new Trie(args[0]);
//
//        if (args.length == 2){
//            for (var value:tree.sugestions(args[1])) {
//                System.out.println(value);
//            }
//        } else if (args.length == 3) {
//            tree.sugestions(args[1], Integer.parseInt(args[2]));
//        }

    }
}
