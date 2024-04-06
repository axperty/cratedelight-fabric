package com.axperty.cratedelight;

import com.axperty.cratedelight.block.BlockList;
import com.axperty.cratedelight.registry.BlockRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
Summary: This class represents the main entry point of the Crate Delight mod. It implements the ModInitializer interface,
allowing it to be recognized as a mod initializer by Fabric Loader. The mod initializer is responsible for
initializing the mod when the game starts.
 **/

public class CrateDelight implements ModInitializer {
    // Define the mod ID
    public static final String MODID = "cratedelight";
    
    // Define a logger for the mod
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    // Define a registry key for the item group
    public static final RegistryKey<ItemGroup> GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MODID, "group"));

    @Override
    // This method is called when the mod is initialized
    public void onInitialize() {
        // Output a message indicating that blocks are being registered
        System.out.println("[Crate Delight Fabric] Registering blocks...");

        // First register the item group with the fabric item group builder
        Registry.register(Registries.ITEM_GROUP, GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("Crate Delight"))
                .icon(() -> new ItemStack(BlockList.SALMON_CRATE))
                .build());

        // Then call a method to register blocks
        BlockRegistry.registerBlocks();

        // Once the blocks were registered, output a message indicating that blocks have been registered successfully
        System.out.println("[Crate Delight Fabric] Blocks registered successfully!");
    }
}
