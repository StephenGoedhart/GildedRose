package com.gildedrose.strategy;

import com.gildedrose.Item;

public interface ItemStrategy {
    void updateQuality(Item item);
    void updateSellIn(Item item);
}
