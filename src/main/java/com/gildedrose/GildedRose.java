
package com.gildedrose;

import java.util.function.Function;

public class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    Function<Item, Item> agedBrieUpdater = item -> {
        item.sellIn = item.sellIn - 1;
        increaseQuality(item);
        if (item.sellIn < 0)
            increaseQuality(item);
        return item;
    };

    Function<Item, Item> backstagePassUpdater = item -> {
        item.sellIn = item.sellIn - 1;
        increaseQuality(item);
        if (item.sellIn < 10)
            increaseQuality(item);
        if (item.sellIn < 5)
            increaseQuality(item);
        if (item.sellIn < 0)
            item.quality = 0;
        return item;
    };

    Function<Item, Item> sulfurasUpdater = item -> item;

    Function<Item, Item> defaultUpdater = item -> {
        item.sellIn = item.sellIn - 1;
        decreaseQuality(item);
        if (item.sellIn < 0)
            decreaseQuality(item);
        return item;
    };

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            switch (item.name) {
                case AGED_BRIE:
                    agedBrieUpdater.apply(item);
                    break;
                case BACKSTAGE_PASSES:
                    backstagePassUpdater.apply(item);
                    break;
                case SULFURAS:
                    sulfurasUpdater.apply(item);
                    break;
                default:
                    defaultUpdater.apply(item);
                    break;
            }
        }
    }

    private static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
