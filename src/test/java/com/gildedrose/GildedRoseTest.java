package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRose.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    /* general tests */

    @Test
    void testItemNameDoesNotChange() {
        Item item = new Item("foo", 0, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals("foo", item.name);
    }

    @Test
    void testItemSellInIncreases() {
        Item item = new Item("foo", 1, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(0, item.sellIn);
    }

    @Test
    void testItemQualityDecreases() {
        Item item = new Item("foo", 0, 1);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    void testItemQualityIsNeverNegative() {
        Item item = new Item("foo", 0, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(0, item.quality);
    }

    /* aged brie tests */

    @Test
    void testItemQualityIsNeverMoreThan50() {
        Item item = new Item(AGED_BRIE, 0, 50);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(50, item.quality);
    }

    @Test
    void testAgedBrieIncreasesQuality() {
        Item item = new Item(AGED_BRIE, 0, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(2, item.quality);
    }

    /* sulfuras tests */

    @Test
    void testSulfurasSellInDoesNotIncrease() {
        Item item = new Item(SULFURAS, 0, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(0, item.sellIn);
    }

    @Test
    void testSulfurasQualityNeverDecreases() {
        Item item = new Item(SULFURAS, 0, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(0, item.quality);
    }

    /* backstage passes tests */

    @Test
    void testBackstagePassesIncreaseQuality() {
        Item item = new Item(BACKSTAGE_PASSES, 11, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(1, item.quality);
    }

    @Test
    void testBackstagePassesIncreaseQualityBy2WhenSellInIs10OrLess() {
        Item item = new Item(BACKSTAGE_PASSES, 10, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(2, item.quality);
    }

    @Test
    void testBackstagePassesIncreaseQualityBy3WhenSellInIs5OrLess() {
        Item item = new Item(BACKSTAGE_PASSES, 5, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(3, item.quality);
    }

    @Test
    void testBackstagePassesIncreaseQualityIs0WhenSellInIs0() {
        Item item = new Item(BACKSTAGE_PASSES, 0, 10);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(0, item.quality);
    }
}
