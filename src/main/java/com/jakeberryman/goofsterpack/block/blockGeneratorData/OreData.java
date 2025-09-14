package com.jakeberryman.goofsterpack.block.blockGeneratorData;

import com.simibubi.create.AllItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.List;

public final class OreData {
    public static List<MineralType> MINERALS = new ArrayList<>();
    public static List<StoneType> STONES = new ArrayList<>();

    static {
        MINERALS.add(new MineralType("coal").setItemDrop(Items.COAL).setExpProvider(UniformInt.of(0, 2)));
        MINERALS.add(new MineralType("iron").setItemDrop(Items.RAW_IRON));
        MINERALS.add(new MineralType("gold").setItemDrop(Items.RAW_GOLD).setAddNether(false));
        MINERALS.add(new MineralType("redstone").setItemDrop(Items.REDSTONE));
        MINERALS.add(new MineralType("diamond").setItemDrop(Items.DIAMOND));
        MINERALS.add(new MineralType("emerald").setItemDrop(Items.EMERALD));
        MINERALS.add(new MineralType("copper").setItemDrop(Items.RAW_COPPER));
        MINERALS.add(new MineralType("lapis").setItemDrop(Items.LAPIS_ORE));
        MINERALS.add(new MineralType("quartz").setItemDrop(Items.QUARTZ).setAddNether(false));

        STONES.add(new StoneType("stone", MapColor.STONE));
        STONES.add(new StoneType("deepslate", MapColor.DEEPSLATE).setStrength(4.5f, 3));
        STONES.add(new StoneType("andesite", MapColor.STONE));
        STONES.add(new StoneType("diorite", MapColor.QUARTZ));
        STONES.add(new StoneType("granite", MapColor.DIRT));
        STONES.add(new StoneType("tuff", MapColor.TERRACOTTA_GRAY));
        STONES.add(new StoneType("nether", MapColor.NETHER));
        //Soul Soil
        STONES.add(new StoneType("end", MapColor.SAND).setStrength(4.5f, 3));
        STONES.add(new StoneType("moon", MapColor.TERRACOTTA_LIGHT_GRAY));
        STONES.add(new StoneType("mars", MapColor.TERRACOTTA_RED));
        STONES.add(new StoneType("venus", MapColor.TERRACOTTA_ORANGE));
        STONES.add(new StoneType("mercury", MapColor.TERRACOTTA_PURPLE));
        STONES.add(new StoneType("glacio", MapColor.ICE));

        //modded
        //create
        //MINERALS.add(new MineralType("zinc").setItemDrop(AllItems.RAW_ZINC.get()));
    }
}
