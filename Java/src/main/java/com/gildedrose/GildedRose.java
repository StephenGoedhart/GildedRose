package com.gildedrose;

import com.gildedrose.factory.ItemStrategyFactory;
import com.gildedrose.strategy.ItemStrategy;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateStock() {
        for (Item item : items) {
            ItemStrategy strategy = ItemStrategyFactory.createStrategy(item.name);
            strategy.updateQuality(item);
            strategy.updateSellIn(item);
        }
    }
}
