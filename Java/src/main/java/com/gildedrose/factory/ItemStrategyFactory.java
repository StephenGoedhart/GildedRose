package com.gildedrose.factory;

import com.gildedrose.strategy.*;
import com.gildedrose.utils.GildedRoseUtils;

public class ItemStrategyFactory {
    public static ItemStrategy createStrategy(String itemName){
        switch(itemName){
            case GildedRoseUtils.AGED_BRIE:
                return new AgedBrieItemStrategy();
            case GildedRoseUtils.BACKSTAGE_PASS:
                return new BackstagePassItemStrategy();
            case GildedRoseUtils.CONJURED:
                return new ConjuredItemStrategy();
            case GildedRoseUtils.SULFURAS:
                return new SulfurasItemStrategy();
            default:
                return new DefaultItemStrategy();
        }
    }
}
