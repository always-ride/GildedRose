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
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void testItemSellInIncreases() {
        Item item = new Item("foo", 1, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void testItemQualityDecreases() {
        Item item = new Item("foo", 0, 1);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testItemQualityIsNeverNegative() {
        Item item = new Item("foo", 0, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    /* aged brie tests */

    @Test
    void testAgedBrieQualityIsNeverMoreThan50() {
        Item item = new Item(AGED_BRIE, 0, 50);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testAgedBrieIncreasesQuality() {
        Item item = new Item(AGED_BRIE, 0, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    /* sulfuras tests */

    @Test
    void testSulfurasSellInDoesNotIncrease() {
        Item item = new Item(SULFURAS, 0, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void testSulfurasQualityNeverDecreases() {
        Item item = new Item(SULFURAS, 0, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    /* backstage passes tests */

    @Test
    void testBackstagePassesIncreaseQuality() {
        Item item = new Item(BACKSTAGE_PASSES, 11, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void testBackstagePassesIncreaseQualityBy2WhenSellInIs10OrLess() {
        Item item = new Item(BACKSTAGE_PASSES, 10, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void testBackstagePassesIncreaseQualityBy3WhenSellInIs5OrLess() {
        Item item = new Item(BACKSTAGE_PASSES, 5, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void testBackstagePassesQualityIs0WhenSellInIs0() {
        Item item = new Item(BACKSTAGE_PASSES, 0, 10);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    /* conjured tests */

    @Test
    void testConjuresDegradesTwiceAsFast() {
        Item item = new Item(CONJURED, 0, 10);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
}
