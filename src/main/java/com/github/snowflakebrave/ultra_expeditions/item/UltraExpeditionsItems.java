package com.github.snowflakebrave.ultra_expeditions.item;

import com.github.snowflakebrave.ultra_expeditions.UltraExpeditions;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UltraExpeditionsItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraExpeditions.MOD_ID);

    public static final DeferredItem<Item> WEAK_PRISM = ITEMS.register("weak_prism", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
