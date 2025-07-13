
package com.gildedrose;

public class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            switch (item.name) {
                case AGED_BRIE:
                    item.sellIn = item.sellIn - 1;

                    increaseQuality(item);

                    if (item.sellIn < 0) {
                        increaseQuality(item);
                    }
                    break;
                case BACKSTAGE_PASSES:
                    item.sellIn = item.sellIn - 1;

                    if (item.quality < 50) {
                        item.quality = item.quality + 1;

                        if (item.sellIn < 10) {
                            increaseQuality(item);
                        }

                        if (item.sellIn < 5) {
                            increaseQuality(item);
                        }
                    }

                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                    break;
                case SULFURAS:
                    // do nothing
                    break;
                default:
                    item.sellIn = item.sellIn - 1;

                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }

                    if (item.sellIn < 0) {
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                    }
                    break;
            }
        }
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
