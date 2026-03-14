package com.github.snowflakebrave.ultra_expeditions.block;

import com.github.snowflakebrave.ultra_expeditions.UltraExpeditions;
import com.github.snowflakebrave.ultra_expeditions.item.UltraExpeditionsItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UltraExpeditionsBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(UltraExpeditions.MOD_ID);

    public static final DeferredBlock<Block> RECEIVER = registerBlock(
            "receiver",
            () -> new Block(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
            )
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        UltraExpeditionsItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
