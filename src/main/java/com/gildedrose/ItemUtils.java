package com.gildedrose;

import java.util.function.Consumer;

import static com.gildedrose.ItemConstants.MAX_QUALITY;

public class ItemUtils {


    public static void incrementQuantity(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    public static void incrementQuantity(Item item, Consumer<Item> callback) {
        incrementQuantity(item);
        callback.accept(item);
    }
}
