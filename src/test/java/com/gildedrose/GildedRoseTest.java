package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    
    @Test
    void testItemNameDoesNotChange() {
        Item item = new Item("foo", 0, 0);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals("foo", item.name);
    }
}
