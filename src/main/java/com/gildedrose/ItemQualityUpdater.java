package com.gildedrose;

import java.util.function.Consumer;

public enum ItemQualityUpdater {

    EMPTY_UPDATER(item -> {
    }),

    AGEDBRIE_UPDATER(item -> {
        ItemUtils.incrementQuality(item);
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0) {
            ItemUtils.incrementQuality(item);
        }
    }),

    BACKSTAGE_UPDATER(item -> {
        ItemUtils.incrementQuality(item, it -> {
            if (item.getSellIn() < 11) {
                ItemUtils.incrementQuality(item);
            }

            if (item.getSellIn() < 6) {
                ItemUtils.incrementQuality(item);
            }
        });

        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0) {
            item.setQuality(ItemConstants.MIN_QUALITY);;
        }
    }),

    DEFAULT_UPDATER(item -> {
        ItemUtils.decrementQuality(item);

        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0) {
            ItemUtils.decrementQuality(item);
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
