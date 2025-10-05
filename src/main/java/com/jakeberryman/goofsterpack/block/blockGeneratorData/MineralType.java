package com.jakeberryman.goofsterpack.block.blockGeneratorData;

import com.jakeberryman.goofsterpack.block.customBlocks.CustomRedStoneOreBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class MineralType {
    public String mineralType;
    public TagKey<Block> toolTag;

    public float minDrop = 1;
    public float maxDrop = 1;
    private Supplier<Item> itemSupplier;
    public IntProvider expProvider = ConstantInt.of(0);

    public boolean addStone = false;
    public boolean addNether = true;

    // Main constructor with toolTag parameter
    public MineralType(String mineralType){
        this.mineralType = mineralType;
    }

    public String getMineralType() {
        return mineralType;
    }

    public TagKey<Block> getToolTag() {
        return toolTag;
    }

    public MineralType setToolTag(TagKey<Block> toolTag) {
        this.toolTag = toolTag;
        return this;
    }

    public float getMinDrop() {
        return minDrop;
    }

    public MineralType setMinDrop(float minDrop) {
        this.minDrop = minDrop;
        return this;
    }

    public float getMaxDrop() {
        return maxDrop;
    }

    public MineralType setMaxDrop(float maxDrop) {
        this.maxDrop = maxDrop;
        return this;
    }

    public MineralType setItemDrop(Supplier<Item> supplier) {
        this.itemSupplier = supplier;
        return this;
    }

    public MineralType setItemDrop(Item item) {
        this.itemSupplier = () -> item;
        return this;
    }

    public Item getItem() {
        return itemSupplier != null ? itemSupplier.get() : Items.AIR;
    }

    public IntProvider getExpProvider() {
        return expProvider;
    }

    public MineralType setExpProvider(IntProvider expProvider) {
        this.expProvider = expProvider;
        return this;
    }

    public boolean isAddStone() {
        return addStone;
    }

    public MineralType setAddStone(boolean addStone) {
        this.addStone = addStone;
        return this;
    }

    public boolean isAddNether() {
        return addNether;
    }

    public MineralType setAddNether(boolean addNether) {
        this.addNether = addNether;
        return this;
    }

    public MineralType setDropCount(int min, int max){
        minDrop = min;
        maxDrop = max;
        return this;
    }
}