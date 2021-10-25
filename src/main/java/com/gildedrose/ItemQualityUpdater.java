package com.gildedrose;

import java.util.function.Consumer;

import static com.gildedrose.ItemUtils.incrementQuantity;

public enum ItemQualityUpdater {

    EMPTY_UPDATER(item -> {
    }),

    AGEDBRIE_UPDATER(item -> {
        incrementQuantity(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            incrementQuantity(item);
        }
    }),

    BACKSTAGE_UPDATER(item -> {
        incrementQuantity(item, it -> {
            if (item.sellIn < 11) {
                incrementQuantity(item);
            }

            if (item.sellIn < 6) {
                incrementQuantity(item);
            }
        });

        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }),

    DEFAULT_UPDATER(item -> {
        item.quality--;

        item.sellIn--;
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality--;
            }
        }
    });

    private final Consumer<Item> updater;

    ItemQualityUpdater(Consumer<Item> updater) {
        this.updater = updater;
    }

    public Consumer<Item> getUpdater() {
        return updater;
    }

}
