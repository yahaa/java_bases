package com.zihua.testEnum;

/**
 * Created by zihua on 17-3-24.
 */

enum Shrubbery {
    GROUND, CRAWLING, HANGING
}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s.ordinal());
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println(s.compareTo(Shrubbery.CRAWLING));
        }
    }

}
