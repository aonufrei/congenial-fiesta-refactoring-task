package com.gildedrose;

import java.util.function.Consumer;

import static com.gildedrose.ItemUtils.decrementQuality;
import static com.gildedrose.ItemUtils.incrementQuality;

public enum ItemQualityUpdater {

    EMPTY_UPDATER(item -> {
    }),

    AGEDBRIE_UPDATER(item -> {
        ItemUtils.incrementQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            ItemUtils.incrementQuality(item);
        }
    }),

    BACKSTAGE_UPDATER(item -> {
        incrementQuality(item, it -> {
            if (item.sellIn < 11) {
                ItemUtils.incrementQuality(item);
            }

            if (item.sellIn < 6) {
                ItemUtils.incrementQuality(item);
            }
        });

        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = ItemConstants.MIN_QUALITY;
        }
    }),

    DEFAULT_UPDATER(item -> {
        ItemUtils.decrementQuality(item);

        item.sellIn--;
        if (item.sellIn < 0) {
            decrementQuality(item);
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
