package com.gildedrose;

import java.util.Arrays;
import java.util.function.Consumer;

import static com.gildedrose.ItemConstants.*;

class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(this::updateItemQuality);
    }

    public void updateItemQuality(Item item) {
        getSpecificUpdater(item.name).accept(item);
    }

    public Consumer<Item> getSpecificUpdater(String itemName) {
        switch (itemName) {
            case AGEDBRIE:
                return ItemQualityUpdater.AGEDBRIE_UPDATER.getUpdater();
            case BACKSTAGE:
                return ItemQualityUpdater.BACKSTAGE_UPDATER.getUpdater();
            case SULFURAS:
                return ItemQualityUpdater.EMPTY_UPDATER.getUpdater();
            default:
                return ItemQualityUpdater.DEFAULT_UPDATER.getUpdater();
        }
    }

    public Item[] getItems() {
        return items;
    }
}
