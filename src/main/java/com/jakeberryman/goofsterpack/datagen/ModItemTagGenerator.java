package com.jakeberryman.goofsterpack.datagen;

import com.jakeberryman.goofsterpack.Goofsterpack;
import com.jakeberryman.goofsterpack.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Goofsterpack.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        ModBlocks.ORE_DATA_MAP.forEach((block, data) -> {
            String mineralType = data.getSecond().getMineralType();
            String stoneType = data.getFirst().getStoneType();
            this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "ores/" + mineralType)))
                    .add(block.get().asItem());
            this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "ores_in_ground/" + stoneType)))
                    .add(block.get().asItem());
            this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "ores")))
                    .add(block.get().asItem());

            if(data.getSecond().getMaxDrop() <= 1){
                this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "ore_rates/singular")))
                        .add(block.get().asItem());
            } else {
                this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "ore_rates/dense")))
                        .add(block.get().asItem());
            }
        });
    }
}