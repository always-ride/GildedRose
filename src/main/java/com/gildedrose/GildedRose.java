
package com.gildedrose;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

public class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";

    Item[] items;

    Function<Item, Item> agedBrieUpdater = item -> new Item(
            item.name,
            item.sellIn - 1,
            Math.min(50, item.quality + (item.sellIn <= 0 ? 2 : 1)));

    Function<Item, Item> backstagePassUpdater = item -> new Item(
            item.name,
            item.sellIn - 1,
            Math.min(50, item.sellIn <= 0 ? 0 : item.quality + (item.sellIn <= 5 ? 3 : item.sellIn <= 10 ? 2 : 1)));

    Function<Item, Item> sulfurasUpdater = item -> new Item(
            item.name,
            item.sellIn,
            item.quality);

    Function<Item, Item> conjuredUpdater = item -> new Item(
            item.name,
            item.sellIn - 1,
            Math.max(0, item.quality - (item.sellIn <= 0 ? 4 : 2)));

    Function<Item, Item> defaultUpdater = item -> new Item(
            item.name,
            item.sellIn - 1,
            Math.max(0, item.quality - (item.sellIn <= 0 ? 2 : 1)));

    Map<String, Function<Item, Item>> itemUpdaters = Map.of(
            AGED_BRIE, agedBrieUpdater,
            BACKSTAGE_PASSES, backstagePassUpdater,
            SULFURAS, sulfurasUpdater,
            CONJURED, conjuredUpdater
    );

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        items = Arrays.stream(items)
                .map(item -> itemUpdaters
                    .getOrDefault(item.name, defaultUpdater)
                    .apply(item))
                .toArray(Item[]::new);
    }
}
