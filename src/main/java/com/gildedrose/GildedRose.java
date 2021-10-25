package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0 && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    items[i].quality = items[i].quality - 1;
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11 && items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }

                        if (items[i].sellIn < 6 && items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (items[i].name.equals("Aged Brie")) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                } else {
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        items[i].quality = items[i].quality - items[i].quality;
                    } else {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    }
                }
            }
        }
    }

    private static final String AGEDBRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public void updateQualityV2() {
        for (Item item: items) {
            if (!item.name.equals(AGEDBRIE) && !item.name.equals(BACKSTAGE)) {
                if (item.quality > 0 && !item.name.equals(SULFURAS)) {
                    item.quality--;
                }
            } else {
                if (item.quality < 50) {
                    item.quality++;

                    if (item.name.equals(BACKSTAGE)) {
                        if (item.sellIn < 11 && item.quality < 50) {
                            item.quality++;
                        }

                        if (item.sellIn < 6 && item.quality < 50) {
                            item.quality++;
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (item.name.equals(AGEDBRIE)) {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                } else {
                    if (item.name.equals(BACKSTAGE)) {
                        item.quality = 0;
                    } else {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS)) {
                                item.quality--;
                            }
                        }
                    }
                }
            }
        }
    }
}
