package com.zihua.byyl;

/**
 * Created by zihua on 17-3-30.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class JCC {
    private Map<String, Integer> vars = new HashMap<String, Integer>();
    private Scanner input;
    private File file;
    private Scanner pInput = new Scanner(System.in);

    public JCC(String fileName) {
        readFile(fileName);
    }

    public void readFile(String fileName) {
        try {
            file = new File(fileName);
            input = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("file can't find !");
        }
    }

    public void exec() {
        while (input.hasNext()) {
            String s = input.nextLine();
            s = s.toLowerCase();
            findVar(s);
        }
    }

    public void addVar(String var) {
        int value = 1;
        if (vars.containsKey(var)) value += vars.get(var);
        vars.put(var, value);
    }

    public void findVar(String s) {
        String[] word = s.split("[ ,;().]+");
        if (word[0].equals("const")) {
            for (int i = 1; i < word.length; i++) {
                String[] t = word[i].split("=");
                addVar(t[0]);
            }
        } else if (word[0].equals("var")) {
            for (int i = 1; i < word.length; i++) {
                String var = word[i];
                addVar(var);
            }
        } else if (word[0].equals("procedure")) {
            for (int i = 1; i < word.length; i++) {
                if (word[i].length() > 0) {
                    addVar(word[i]);
                }
            }

        } else {
            for (int i = 0; i < word.length; i++) {
                if (word[i].length() > 0) {
                    String[] ts = word[i].split("[ ,;():+=*-/%!#<>]+");
                    for (String tt : ts) {
                        if (vars.containsKey(tt)) {
                            addVar(tt);
                        }
                    }
                }
            }
        }
    }

    public void printVars() {
        Iterator<Map.Entry<String, Integer>> its = vars.entrySet().iterator();
        while (its.hasNext()) {
            Map.Entry<String, Integer> entry = its.next();
            System.out.println("(" + entry.getKey() + ": " + entry.getValue() + ")");
        }
    }

    public static void main(String[] args) {
        for (String fileName : args) {
            JCC jcc = new JCC(fileName);
            jcc.exec();
            jcc.printVars();
        }

    }

}