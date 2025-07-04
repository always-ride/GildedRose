package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private String AGED_BRIE = "Aged Brie";

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
}
