
package com.gildedrose;

public class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (isQualityAboveZero(i)) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseQuality(i);
                    }
                }
            } else {
                if (isQualityBelowMaxValue(i)) {
                    increaseQuality(i);

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (isQualityBelowMaxValue(i)) {
                                increaseQuality(i);
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (isQualityBelowMaxValue(i)) {
                                increaseQuality(i);
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                decreaseSellIn(i);
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (isQualityAboveZero(i)) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseQuality(i);
                            }
                        }
                    } else {
                        items[i].quality = 0;
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
