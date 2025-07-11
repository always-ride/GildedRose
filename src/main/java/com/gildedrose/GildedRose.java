
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
            
            if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES)) {
                if (isQualityAboveZero(i)) {
                    if (!item.name.equals(SULFURAS)) {
                        decreaseQuality(i);
                    }
                }
            } else {
                if (isQualityBelowMaxValue(i)) {
                    increaseQuality(i);

                    if (item.name.equals(BACKSTAGE_PASSES)) {
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
                }
            }

            if (!item.name.equals(SULFURAS)) {
                decreaseSellIn(i);
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES)) {
                        if (isQualityAboveZero(i)) {
                            if (!item.name.equals(SULFURAS)) {
                                decreaseQuality(i);
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (isQualityBelowMaxValue(i)) {
                        increaseQuality(i);
                    }
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
