package com.gildedrose;

import java.util.function.Consumer;

import static com.gildedrose.ItemConstants.MAX_QUALITY;
import static com.gildedrose.ItemConstants.MIN_QUALITY;

public class ItemUtils {

    public static boolean incrementQuality(Item item) {
        boolean canBeIncremented = item.getQuality() < MAX_QUALITY;
        if (canBeIncremented) {
            item.setQuality(item.getQuality() + 1);
        }
        return canBeIncremented;
    }

    public static void incrementQuality(Item item, Consumer<Item> callback) {
        if (incrementQuality(item)) {
            callback.accept(item);
        }
    }

    public static void decrementQuality(Item item) {
        if (item.getQuality() > MIN_QUALITY) {
            item.setQuality(item.getQuality() - 1);
        }
    }


}
