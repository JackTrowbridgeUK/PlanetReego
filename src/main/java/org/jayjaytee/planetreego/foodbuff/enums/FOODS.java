package org.jayjaytee.planetreego.foodbuff.enums;

public enum FOODS {

    APPLE(10, 8),
    BREAD(7, 10),
    PORK(2, 2),
    GRILLED_PORK(9, 16),
    GOLDEN_APPLE(14, 8),
    COOKIE(10, 5),
    MELON(5, 4),
    RAW_BEEF(2, 2),
    COOKED_BEEF(9, 16),
    RAW_CHICKEN(2, 2),
    COOKED_CHICKEN(10, 17),
    ROTTEN_FLESH(2, 2),
    CARROT(5, 4),
    POTATO(2, 2),
    BAKED_POTATO(5, 4),
    GOLDEN_CARROT(14, 10),
    RABBIT(2, 2),
    COOKED_RABBIT(9, 16),
    RABBIT_STEW(12, 17),
    MUTTON(2, 2),
    COOKED_MUTTON(9, 10),
    CHORUS_FRUIT(12, 16),
    BEETROOT(5, 8),
    BEETROOT_SOUP(5, 10),
    MUSHROOM_STEW(15, 16);

    public final Integer saturation;
    public final Integer bar;


    private FOODS(Integer saturation, Integer bar){
        this.saturation = saturation;
        this.bar = bar;
    }
}
