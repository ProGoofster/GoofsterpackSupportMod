package com.jakeberryman.goofsterpack.block.blockGeneratorData;

import com.jakeberryman.goofsterpack.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class OreBlock {
    public MineralType mineralType;
    public StoneType stoneType;
    public Supplier<Block> block;

    public OreBlock(MineralType mineralType, StoneType stoneType){
        this.mineralType = mineralType;
        this.stoneType = stoneType;
        this.block = block;
    }
}
