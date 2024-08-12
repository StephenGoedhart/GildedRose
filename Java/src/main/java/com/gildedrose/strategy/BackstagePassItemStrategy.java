package com.gildedrose.strategy;

import com.gildedrose.Item;
import com.gildedrose.utils.GildedRoseUtils;

public class BackstagePassItemStrategy implements ItemStrategy{
    @Override
    public void updateQuality(Item item) {
        if (item.quality < GildedRoseUtils.MAX_QUALITY) {
            if (item.sellIn < 0) {
                item.quality = 0;
            } else if (item.sellIn < GildedRoseUtils.SIX_DAYS) {
                item.quality = Math.min(GildedRoseUtils.MAX_QUALITY, item.quality + 3);
            } else if (item.sellIn < GildedRoseUtils.ELEVEN_DAYS) {
                item.quality = Math.min(GildedRoseUtils.MAX_QUALITY, item.quality + 2);
            } else {
                item.quality = Math.min(GildedRoseUtils.MAX_QUALITY, item.quality + 1);
            }
        }
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn -= 1;
    }
}
