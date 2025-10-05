package com.jakeberryman.goofsterpack.datagen.loot;

import com.jakeberryman.goofsterpack.block.ModBlocks;
import com.jakeberryman.goofsterpack.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
//        this.dropSelf(ModBlocks.TEST_BLOCK.get());
//
//        this.add(ModBlocks.TEST_ORE.get(),
//                block -> createRedstoneLikeOreDrops(ModBlocks.TEST_ORE.get(), ModItems.TEST_ITEM.get(), 4, 5));



        ModBlocks.ORE_DATA_MAP.forEach((block, data) -> {
            this.add(block.get(),
                    thisBlock -> {
                        if(data.getSecond().maxDrop == 1 && data.getSecond().minDrop == 1){
                            return createOreDrops(thisBlock, data.getSecond().getItem());
                        } else if (data.getSecond().mineralType.contains("redstone") || data.getSecond().mineralType.contains("certus")) {
                            return createRedstoneLikeOreDrops(thisBlock, data.getSecond().getItem(), data.getSecond().minDrop, data.getSecond().maxDrop);
                        } else {
                            return createMutliOreDrops(thisBlock, data.getSecond().getItem(), data.getSecond().minDrop, data.getSecond().maxDrop);
                        }
                    }
            );
        });
    }

    protected LootTable.Builder createOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createMutliOreDrops(Block pBlock, Item item, float min, float max) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createRedstoneLikeOreDrops(Block pBlock, Item item, float min, float max) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}