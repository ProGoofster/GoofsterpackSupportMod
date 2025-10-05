package com.jakeberryman.goofsterpack.block.blockGeneratorData;


import appeng.core.definitions.AEItems;
import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.register.IEItems;
import com.jakeberryman.goofsterpack.Config;
import com.simibubi.create.AllItems;
import mekanism.common.registries.MekanismItems;
import mekanism.common.resource.PrimaryResource;
import mekanism.common.resource.ResourceType;
import mekanism.common.tags.MekanismTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class OreData {
    public static List<MineralType> MINERALS = new ArrayList<>();
    public static List<StoneType> STONES = new ArrayList<>();

    static {
        STONES.add(new StoneType("stone", MapColor.STONE));
        STONES.add(new StoneType("deepslate", MapColor.DEEPSLATE)
                .setStrength(4.5f, 3)
        );
        STONES.add(new StoneType("andesite", MapColor.STONE));
        STONES.add(new StoneType("diorite", MapColor.QUARTZ));
        STONES.add(new StoneType("granite", MapColor.DIRT));
        STONES.add(new StoneType("tuff", MapColor.TERRACOTTA_GRAY));
        //calcite
        STONES.add(new StoneType("nether", MapColor.NETHER));
        //blackstone
        //basalt
        STONES.add(new StoneType("soul_soil", MapColor.COLOR_BROWN)
                .setToolTypeTag(BlockTags.MINEABLE_WITH_SHOVEL)
        );
        STONES.add(new StoneType("end", MapColor.SAND)
                .setStrength(4.5f, 3));

        if(ModList.get().isLoaded("ad_astra")) {
            STONES.add(new StoneType("moon", MapColor.TERRACOTTA_LIGHT_GRAY));
            STONES.add(new StoneType("mars", MapColor.TERRACOTTA_RED));
            STONES.add(new StoneType("venus", MapColor.TERRACOTTA_ORANGE));
            STONES.add(new StoneType("mercury", MapColor.TERRACOTTA_PURPLE));
            STONES.add(new StoneType("glacio", MapColor.ICE));
        }

        if(ModList.get().isLoaded("create")) {
            //STONES.add(new StoneType("limestone", MapColor.));
            //limestone
            //scoria
            //scorchia
            //gravel
        }


        MINERALS.add(new MineralType("coal")
                .setItemDrop(Items.COAL)
                .setExpProvider(UniformInt.of(0, 2))
        );
        MINERALS.add(new MineralType("iron")
                .setItemDrop(Items.RAW_IRON)
                .setToolTag(BlockTags.NEEDS_STONE_TOOL)
        );
        MINERALS.add(new MineralType("gold")
                .setItemDrop(Items.RAW_GOLD).setAddNether(false)
                .setToolTag(BlockTags.NEEDS_IRON_TOOL)
        );
        MINERALS.add(new MineralType("redstone")
                .setItemDrop(Items.REDSTONE)
                .setExpProvider(UniformInt.of(1, 5))
                .setToolTag(BlockTags.NEEDS_IRON_TOOL)
                .setDropCount(4,5)
        );
        MINERALS.add(new MineralType("diamond")
                .setItemDrop(Items.DIAMOND)
                .setExpProvider(UniformInt.of(3, 7))
                .setToolTag(BlockTags.NEEDS_IRON_TOOL)
        );
        MINERALS.add(new MineralType("emerald")
                .setItemDrop(Items.EMERALD)
                .setExpProvider(UniformInt.of(3, 7))
                .setToolTag(BlockTags.NEEDS_IRON_TOOL)
        );
        MINERALS.add(new MineralType("copper")
                .setItemDrop(Items.RAW_COPPER)
                .setToolTag(BlockTags.NEEDS_STONE_TOOL)
                .setDropCount(2,5)
        );
        MINERALS.add(new MineralType("lapis")
                .setItemDrop(Items.LAPIS_ORE)
                .setExpProvider(UniformInt.of(2,5))
                .setToolTag(BlockTags.NEEDS_STONE_TOOL)
                .setDropCount(4,9)
        );
        MINERALS.add(new MineralType("quartz")
                .setItemDrop(Items.QUARTZ)
                .setAddNether(false)
                .setExpProvider(UniformInt.of(2,5))
                .setToolTag(BlockTags.NEEDS_IRON_TOOL)
        );

        //modded

        if(ModList.get().isLoaded("create")) {
            MINERALS.add(new MineralType("zinc")
                    .setItemDrop(AllItems.RAW_ZINC)
                    .setToolTag(BlockTags.NEEDS_IRON_TOOL)
            );
        }

        if(ModList.get().isLoaded("mekanism")){
            MINERALS.add(new MineralType("osmium")
                    .setItemDrop(MekanismItems.PROCESSED_RESOURCES.get(ResourceType.RAW, PrimaryResource.OSMIUM))
                    .setToolTag(BlockTags.NEEDS_STONE_TOOL)
            );
            MINERALS.add(new MineralType("tin")
                    .setItemDrop(MekanismItems.PROCESSED_RESOURCES.get(ResourceType.RAW, PrimaryResource.TIN))
                    .setToolTag(BlockTags.NEEDS_STONE_TOOL)
            );
            MINERALS.add(new MineralType("uranium")
                    .setItemDrop(MekanismItems.PROCESSED_RESOURCES.get(ResourceType.RAW, PrimaryResource.URANIUM))
                    .setToolTag(BlockTags.NEEDS_IRON_TOOL)
            );
            MINERALS.add(new MineralType("fluorite")
                    .setItemDrop(MekanismItems.FLUORITE_GEM)
                    .setToolTag(BlockTags.NEEDS_STONE_TOOL)
                    .setDropCount(2,4)
            );
        }

        if(ModList.get().isLoaded("immersiveengineering")){
            MINERALS.add(new MineralType("aluminum")
                    .setItemDrop(() -> IEItems.Metals.RAW_ORES.get(EnumMetals.ALUMINUM).asItem())
                    .setToolTag(BlockTags.NEEDS_STONE_TOOL)
            );
            MINERALS.add(new MineralType("lead")
                    .setItemDrop(() -> IEItems.Metals.RAW_ORES.get(EnumMetals.LEAD).asItem())
                    .setToolTag(BlockTags.NEEDS_IRON_TOOL)
            );
            MINERALS.add(new MineralType("silver")
                    .setItemDrop(() -> IEItems.Metals.RAW_ORES.get(EnumMetals.SILVER).asItem())
                    .setToolTag(BlockTags.NEEDS_IRON_TOOL)
            );
            MINERALS.add(new MineralType("nickel")
                    .setItemDrop(() -> IEItems.Metals.RAW_ORES.get(EnumMetals.NICKEL).asItem())
                    .setToolTag(BlockTags.NEEDS_IRON_TOOL)
            );
        }

        if(ModList.get().isLoaded("ae2") && Config.generateCertusOre){
            MINERALS.add(new MineralType("certus_quartz")
                    .setItemDrop(AEItems.CERTUS_QUARTZ_CRYSTAL.asItem())
                    .setDropCount(1,2)
                    .setAddStone(true)
                    .setExpProvider(UniformInt.of(2, 5))
                    .setToolTag(BlockTags.NEEDS_STONE_TOOL)
            );
            MINERALS.add(new MineralType("charged_certus_quartz")
                    .setItemDrop(AEItems.CERTUS_QUARTZ_CRYSTAL.asItem())
                    .setDropCount(1,2)
                    .setAddStone(true)
                    .setExpProvider(UniformInt.of(2, 5))
                    .setToolTag(BlockTags.NEEDS_STONE_TOOL)
            );
        }
    }
}
