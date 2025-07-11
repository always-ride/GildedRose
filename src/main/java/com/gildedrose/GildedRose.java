
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
            updateItem(items[i], i);
        }
    }

    private void updateItem(Item item, int i) {
        if (item.name.equals(AGED_BRIE)) {
            if (isQualityBelowMaxValue(i)) {
                increaseQuality(i);
            }
        }
        else if (item.name.equals(BACKSTAGE_PASSES)) {
            if (isQualityBelowMaxValue(i)) {
                increaseQuality(i);
            }
            if (item.sellIn < 11) {
                if (isQualityBelowMaxValue(i)) {
                    increaseQuality(i);
                }
            }

            if (item.sellIn < 6) {
                if (isQualityBelowMaxValue(i)) {
                    increaseQuality(i);
                }
            }
        }
        else {
            if (isQualityAboveZero(i)) {
                if (!item.name.equals(SULFURAS)) {
                    decreaseQuality(i);
                }
            }
        }

        if (!item.name.equals(SULFURAS)) {
            decreaseSellIn(i);
        }

        if (item.name.equals(AGED_BRIE)) {
            if (item.sellIn < 0) {
                if (isQualityBelowMaxValue(i)) {
                    increaseQuality(i);
                }
            }
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            if (item.sellIn < 0) {
                item.quality = 0;
            }
        } else if (!item.name.equals(SULFURAS)) {
            if (item.sellIn < 0) {
                if (isQualityAboveZero(i)) {
                    decreaseQuality(i);
                }
            }
        }
    }

    private boolean isQualityBelowMaxValue(int i) {
        return items[i].quality < 50;
    }

    private boolean isQualityAboveZero(int i) {
        return items[i].quality > 0;
    }

    private void decreaseSellIn(int i) {
        items[i].sellIn = items[i].sellIn - 1;
    }

    private void decreaseQuality(int i) {
        items[i].quality = items[i].quality - 1;
    }

    private void increaseQuality(int i) {
        items[i].quality = items[i].quality + 1;
    }
}
