package com.gildedrose.strategy;

import com.gildedrose.Item;
import com.gildedrose.utils.GildedRoseUtils;

public class DefaultItemStrategy implements ItemStrategy{
    @Override
    public void updateQuality(Item item) {
        item.quality = item.quality > GildedRoseUtils.MIN_QUALITY ? item.quality - 1 : GildedRoseUtils.MIN_QUALITY;
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn -= 1;
    }
}
