package com.axperty.cratedelight.registry;

import com.axperty.cratedelight.CrateDelight;
import com.axperty.cratedelight.block.BlockList;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
public class BlockRegistry {

    public static void registerBlocks() {
        // Apple Crate Registry
        BlockList.APPLE_CRATE = block("apple_crate",
                new Block(blockSettings(2.0f, 3.0f, BlockSoundGroup.WOOD)));

        // Berry Crate Registry
        BlockList.BERRY_CRATE = block("berry_crate",
                new Block(blockSettings(2.0f, 3.0f, BlockSoundGroup.WOOD)));

        // Glowberry Crate Registry
        BlockList.GLOWBERRY_CRATE = block("glowberry_crate",
                new Block(blockSettings(2.0f, 3.0f, BlockSoundGroup.WOOD).luminance((state) -> 8)));

        // Egg Crate Registry
        BlockList.EGG_CRATE = block("egg_crate",
                new Block(blockSettings(2.0f, 3.0f, BlockSoundGroup.WOOD)));

        // Salmon Crate Registry
        BlockList.SALMON_CRATE = block("salmon_crate",
                new Block(blockSettings(2.0f, 3.0f, BlockSoundGroup.WOOD)));

        // Cod Crate Registry
        BlockList.COD_CRATE = block("cod_crate",
                new Block(blockSettings(2.0f, 3.0f, BlockSoundGroup.WOOD)));

        // Golden Apple Crate Registry
        BlockList.GOLDEN_APPLE_CRATE = block("golden_apple_crate",
                new Block(blockSettings(2.0f, 3.0f, BlockSoundGroup.WOOD)));

        // Cocoa Beans Bag Registry
        BlockList.COCOABEANS_BAG = block("cocoabeans_bag",
                new Block(blockSettings(.8f, .8f, BlockSoundGroup.WOOL)));

        // Sugar Bag Registry
        BlockList.SUGAR_BAG = block("sugar_bag",
                new Block(blockSettings(.8f, .8f, BlockSoundGroup.WOOL)));

        // Gunpowder Bag Registry
        BlockList.GUNPOWDER_BAG = block("gunpowder_bag",
                new Block(blockSettings(2.0f, 3.0f, BlockSoundGroup.WOOD)));

        // Salt Bag Registry (for Expanded Delight)
        if (FabricLoader.getInstance().isModLoaded("expandeddelight")) {
            BlockList.SALT_BAG = block("salt_bag",
                    new Block(blockSettings(.7f, .8f, BlockSoundGroup.WOOL)));
        }

        // Cinnamon Bag Registry (for Expanded Delight)
        if (FabricLoader.getInstance().isModLoaded("expandeddelight")) {
            BlockList.GROUND_CINNAMON_BAG = block("ground_cinnamon_bag",
                    new Block(blockSettings(.7f, .8f, BlockSoundGroup.WOOL)));
        }

        // Wheat Flour Bag Registry (for Crate)
        if (FabricLoader.getInstance().isModLoaded("create")) {
            BlockList.WHEAT_FLOUR_BAG = block("wheat_flour_bag",
                    new Block(blockSettings(.7f, .8f, BlockSoundGroup.WOOL)));
        }

        // End Dust Bag Registry (for BetterEnd)
        if (FabricLoader.getInstance().isModLoaded("betterend")) {
            BlockList.ENDER_DUST_BAG = block("ender_dust_bag",
                    new Block(blockSettings(.7f, .8f, BlockSoundGroup.WOOL)));
        }

    }
    private static FabricBlockSettings blockSettings(float hardness, float resistance, BlockSoundGroup sound) {
        return FabricBlockSettings.create().strength(hardness, resistance).sounds(sound);
    }

    private static Block block(String name, Block block) {
        blockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CrateDelight.MODID, name), block);
    }

    private static Item blockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(CrateDelight.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(CrateDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Block withoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(CrateDelight.MODID, name), block);
    }
}
