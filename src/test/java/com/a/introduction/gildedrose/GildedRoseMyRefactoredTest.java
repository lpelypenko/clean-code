package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseMyRefactoredTest {

    public static final int NOT_EXPIRED_SELL_IN = 15;
    public static final int DEFAULT_QUALITY = 3;
    public static final String DEFAULT_ITEM = "DEFAULT_ITEM";
    public static final int EXPIRED_SELL_IN = -1;
    public static final String AGED_BRIE = "Aged Brie";
    public static final int MAX_QUALITY = 50;
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final int SELL_IN_GREATER_THAN_10 = 15;
    public static final int SELL_IN_BETWEEN_5_AND_10 = 7;
    public static final int SELL_LESS_THAN_5 = 5;
    public static final int SELL_IN_ZERO = 0;

    private static GildedRose createGildedRoseWithOneItem(String itemType, int sellIn, int quality) {
        Item item = new Item(itemType, sellIn, quality);
        Item[] items = new Item[]{item};
        return new GildedRose(items);
    }

    private static void assertItem(Item expected, Item actual) {
        assertEquals(expected.name, actual.name);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.quality, actual.quality);
    }

    @Test
    public void notExpiredDefaultItemQualityDecreaseByOne() {
        GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 1);
        assertItem(expected, app.items[0]);
    }

    @Test
    public void expiredDefaultItemQualityDecreaseByTwo() {
        GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, EXPIRED_SELL_IN, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 2);
        assertItem(expected, app.items[0]);
    }

    @Test
    public void notExpiredAgedBrieQualityIncreasesByOne() {
        GildedRose app = createGildedRoseWithOneItem(AGED_BRIE, NOT_EXPIRED_SELL_IN, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(AGED_BRIE, NOT_EXPIRED_SELL_IN - 1, DEFAULT_QUALITY + 1);
        assertItem(expected, app.items[0]);
    }

    @Test
    public void expiredAgedBrieQualityIncreaseByTwo() {
        GildedRose app = createGildedRoseWithOneItem(AGED_BRIE, EXPIRED_SELL_IN, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(AGED_BRIE, EXPIRED_SELL_IN - 1, DEFAULT_QUALITY + 2);
        assertItem(expected, app.items[0]);
    }

    @Test
    public void notExpiredAgedBrieQualityDoesNotGoBeyondMaximum() {
        GildedRose app = createGildedRoseWithOneItem(AGED_BRIE, NOT_EXPIRED_SELL_IN, MAX_QUALITY);
        app.updateQuality();
        Item expected = new Item(AGED_BRIE, NOT_EXPIRED_SELL_IN - 1, MAX_QUALITY);
        assertItem(expected, app.items[0]);
    }

    @Test
    public void notExpiredBackstagePassesQualityIncreaseByOne() {
        GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, SELL_IN_GREATER_THAN_10, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(BACKSTAGE_PASSES, SELL_IN_GREATER_THAN_10 - 1, DEFAULT_QUALITY + 1);
        assertItem(expected, app.items[0]);
    }

    @Test
    public void lessThanTenDaysBackstagePassesQualityIncreaseByTwo() {
        GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, SELL_IN_BETWEEN_5_AND_10, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(BACKSTAGE_PASSES, SELL_IN_BETWEEN_5_AND_10 - 1, DEFAULT_QUALITY + 2);
        assertItem(expected, app.items[0]);
    }

    @Test
    public void lessThanFiveDaysBackstagePassesQualityIncreaseByThree() {
        GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, SELL_LESS_THAN_5, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(BACKSTAGE_PASSES, SELL_LESS_THAN_5 - 1, DEFAULT_QUALITY + 3);
        assertItem(expected, app.items[0]);
    }

    @Test
    public void negativeSellInBackstagePassesQualityDropsToZero() {
        GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, SELL_IN_ZERO, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(BACKSTAGE_PASSES, SELL_IN_ZERO - 1, 0);
        assertItem(expected, app.items[0]);
    }
}