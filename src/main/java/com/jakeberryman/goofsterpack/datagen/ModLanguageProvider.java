package com.jakeberryman.goofsterpack.datagen;

import com.jakeberryman.goofsterpack.block.ModBlocks;
import com.jakeberryman.goofsterpack.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        // Automatically add items from your DeferredRegister
        ModItems.ITEMS.getEntries().forEach(this::addItemAuto);

        // Automatically add blocks from your DeferredRegister
        ModBlocks.BLOCKS.getEntries().forEach(block -> {
            // Skip blocks that have a corresponding BlockItem
            // (they're already handled by the item registration)
            if (!hasBlockItem(block)) {
                addBlockAuto(block);
            }
        });
    }

    // Automatically generate item name from registry name
    private void addItemAuto(RegistryObject<Item> item) {
        addItem(item, formatName(item.getId().getPath()));
    }

    // Automatically generate block name from registry name
    private void addBlockAuto(RegistryObject<Block> block) {
        addBlock(block, formatName(block.getId().getPath()));
    }

    private String formatName(String registryName) {
        String[] words = registryName.split("_");
        StringBuilder formatted = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                formatted.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return formatted.toString().trim();
    }

    private boolean hasBlockItem(RegistryObject<Block> block) {
        String blockName = block.getId().getPath();
        return ModItems.ITEMS.getEntries().stream()
                .anyMatch(item -> item.getId().getPath().equals(blockName)
                        && item.get() instanceof BlockItem);
    }
}