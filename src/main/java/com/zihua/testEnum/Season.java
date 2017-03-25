package com.zihua.testEnum;

/**
 * Created by zihua on 17-3-24.
 */
public enum Season {
    SPRING("spring", 2, 5),
    SUMMER("summer", 6, 8),
    FALL("fall", 9, 11),
    WINTER("winter", 12, 1);
    private String name;
    private int start;
    private int end;

    private Season(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }


}
