package com.gildedrose.strategy;

import com.gildedrose.Item;
import com.gildedrose.utils.GildedRoseUtils;

public class ConjuredItemStrategy implements ItemStrategy{
    @Override
    public void updateQuality(Item item) {
        item.quality = item.quality < GildedRoseUtils.MAX_QUALITY ? item.quality - 2 : GildedRoseUtils.MAX_QUALITY;
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn -= 1;
    }
}
