package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private final String AGED_BRIE = "Aged Brie";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private final String CONJURED = "Conjured Mana Cake";
    private final String SOME_OTHER_ITEM = "SomeOtherItemName";

    @Nested
    class DefaultItemTests{
        @Test
        void ShouldKeepItemQualityPositive() {
            // given
            Item[] items = new Item[] { new Item(SOME_OTHER_ITEM, 0, 0) };
            GildedRose app = new GildedRose(items);
            // when
            updateQualityHelper(1, app);
            // then
            assertEquals(0, app.items[0].quality);
        }
    }

    @Nested
    class AgedBrieTests {
        @Test
        void ShouldIncreaseAgedBrieQualityEachDay() {
            // given
            int quality = 1;
            int expected = 2;
            Item[] items = new Item[] { new Item(AGED_BRIE, 10, quality) };
            GildedRose app = new GildedRose(items);
            // when
            updateQualityHelper(1, app);
            // then
            assertEquals(expected, app.items[0].quality);
        }

        @Test
        void ShouldLimitAgedBrieQualityTo50() {
            // given
            int quality = 1;
            int expected = 50;
            Item[] items = new Item[] { new Item(AGED_BRIE, 51, quality) };
            GildedRose app = new GildedRose(items);
            // when
            updateQualityHelper(51, app);
            // then
            assertEquals(expected, app.items[0].quality);
        }
    }

    @Nested
    class SulfurasTests {
        @Test
        void ShouldNeverDecreaseSulfurasQuality() {
            // given
            int quality = 1;
            int expected = 1;
            Item[] items = new Item[] { new Item(SULFURAS, 10, quality) };
            GildedRose app = new GildedRose(items);
            // when
            updateQualityHelper(1, app);
            // then
            assertEquals(expected, app.items[0].quality);
        }
    }

    @Nested
    class BackstagePassesTests {
        @Test
        void ShouldIncreaseBackstagePassQualityEachDayWhenSellInAbove10() {
            // given
            int quality = 1;
            int expected = 2;
            Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 11, quality) };
            GildedRose app = new GildedRose(items);
            // when
            updateQualityHelper(1, app);
            // then
            assertEquals(expected, app.items[0].quality);
        }

        @Test
        void ShouldIncreaseBackstagePassQualityBy2EachDayWhenSellInAbove5() {
            // given
            int quality = 1;
            int expected = 3;
            Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 6, quality) };
            GildedRose app = new GildedRose(items);
            // when
            updateQualityHelper(1, app);
            // then
            assertEquals(expected, app.items[0].quality);
        }

        @Test
        void ShouldIncreaseBackstagePassQualityBy3EachDayWhenSellInAbove0() {
            // given
            int quality = 1;
            int expected = 4;
            Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 1, quality) };
            GildedRose app = new GildedRose(items);
            // when
            updateQualityHelper(1, app);
            // then
            assertEquals(expected, app.items[0].quality);
        }
    }

    @Nested
    class ConjuredTests {
        @Test
        void ShouldDecreaseConjuredQualityBy2EachDay() {
            // given
            int quality = 2;
            int expected = 0;
            Item[] items = new Item[] { new Item(CONJURED, 1, quality) };
            GildedRose app = new GildedRose(items);
            // when
            updateQualityHelper(1, app);
            // then
            assertEquals(expected, app.items[0].quality);
        }
    }

    // Introduce helper function that updates quality for n days
    private void updateQualityHelper(int days, GildedRose app){
        for(int i = 0; i < days; i++){
            app.updateQuality();
        }
    }
}
