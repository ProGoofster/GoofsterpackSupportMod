package com.jakeberryman.goofsterpack.datagen;


import com.jakeberryman.goofsterpack.Goofsterpack;
import com.jakeberryman.goofsterpack.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Goofsterpack.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

//        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
//                .add(ModBlocks.TEST_BLOCK.get());
//
//        this.tag(BlockTags.NEEDS_IRON_TOOL)
//                .add(ModBlocks.TEST_BLOCK.get());

        ModBlocks.ORE_DATA_MAP.forEach((block, data) -> {
            if (data.getFirst().getToolTypeTag() != null) {
                this.tag(data.getFirst().getToolTypeTag()).add(block.get());
            }
            if (data.getSecond().getToolTag() != null) {
                this.tag(data.getSecond().getToolTag()).add(block.get());
            }
        });
    }
}