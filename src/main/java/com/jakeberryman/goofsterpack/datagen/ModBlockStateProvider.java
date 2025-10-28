package com.jakeberryman.goofsterpack.datagen;

import com.jakeberryman.goofsterpack.Goofsterpack;
import com.jakeberryman.goofsterpack.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Goofsterpack.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModBlocks.ORE_BLOCKS_MAP.forEach((blockId, block) -> {
            blockWithItem(block);
        });
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(
                        blockRegistryObject.getId().getPath(),
                        oreBlockTexture(blockRegistryObject.get())
                        ));
    }

    public ResourceLocation oreBlockTexture(Block block) {
        ResourceLocation name = ForgeRegistries.BLOCKS.getKey(block);
        String oreName = name.getPath().split("_")[1];
        if (oreName.matches("ore")){
            oreName = name.getPath().split("_")[0];
        }
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/ores/" + oreName + "/" + name.getPath());
    }
}