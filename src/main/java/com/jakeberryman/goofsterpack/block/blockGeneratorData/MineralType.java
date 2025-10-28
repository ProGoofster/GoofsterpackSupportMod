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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MineralType {
    protected String mineralType;
    private TagKey<Block> toolTag;

    private float minDrop = 1;
    private float maxDrop = 1;
    private Supplier<Item> itemSupplier;

    public Supplier<Item> getSmeltedItem() {
        return smeltedItem;
    }

    public MineralType setSmeltedItem(Supplier<Item> smeltedItem) {
        this.smeltedItem = smeltedItem;
        return this;
    }
    public MineralType setSmeltedItem(Item item) {
        this.smeltedItem = () -> item;
        return this;
    }

    private Supplier<Item> smeltedItem;
    private IntProvider expProvider = ConstantInt.of(0);

    private List<StoneType> stoneTypes;

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
        stoneTypes = new ArrayList<>();
        return this;
    }

    public float getMinDrop() {
        return minDrop;
    }

    public float getMaxDrop() {
        return maxDrop;
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

    public MineralType setDropCount(int min, int max){
        minDrop = min;
        maxDrop = max;
        return this;
    }

    public List<StoneType> getStoneTypes() {
        return stoneTypes;
    }

    public MineralType setStoneTypes(List<StoneType> stoneTypes) {
        this.stoneTypes = stoneTypes;
        return this;
    }

    public MineralType addStoneType(StoneType stoneType){
        this.stoneTypes.add(stoneType);
        return this;
    }
}