package com.gildedrose;

import java.util.function.Consumer;

import static com.gildedrose.ItemConstants.MAX_QUALITY;
import static com.gildedrose.ItemConstants.MIN_QUALITY;

public class ItemUtils {


    public static void incrementQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    public static void incrementQuality(Item item, Consumer<Item> callback) {
        incrementQuality(item);
        callback.accept(item);
    }

    public static void decrementQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }
}
