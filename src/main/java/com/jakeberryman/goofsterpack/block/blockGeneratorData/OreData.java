package com.jakeberryman.goofsterpack.block.blockGeneratorData;


import appeng.core.definitions.AEItems;
import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.register.IEItems;
import com.jakeberryman.goofsterpack.item.ModItems;
import com.simibubi.create.AllItems;
import mekanism.common.registries.MekanismItems;
import mekanism.common.resource.PrimaryResource;
import mekanism.common.resource.ResourceType;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.ModList;

import java.util.*;

public final class OreData {
    public static List<MineralType> MINERALS = new ArrayList<>();
    public static Map<String, StoneType> STONES = new HashMap<>();

    static {
        STONES.put("stone", new StoneType("stone")
                .setMapColor(MapColor.STONE));
        STONES.put("deepslate", new StoneType("deepslate")
                .setMapColor(MapColor.DEEPSLATE)
                .setStrength(4.5f, 3)
        );
        STONES.put("andesite", new StoneType("andesite")
                .setMapColor(MapColor.STONE));
        STONES.put("diorite", new StoneType("diorite")
                .setMapColor(MapColor.QUARTZ));
        STONES.put("granite", new StoneType("granite")
                .setMapColor(MapColor.DIRT));
        STONES.put("tuff", new StoneType("tuff")
                .setMapColor(MapColor.TERRACOTTA_GRAY));
        //calcite
        STONES.put("nether", new StoneType("nether")
                .setMapColor(MapColor.NETHER));
        //blackstone
        //basalt
        STONES.put("soul_soil", new StoneType("soul_soil")
                .setMapColor(MapColor.COLOR_BROWN)
                .setToolTypeTag(BlockTags.MINEABLE_WITH_SHOVEL)
        );
        STONES.put("end", new StoneType("end")
                .setMapColor(MapColor.SAND)
                .setStrength(4.5f, 3)
        );

        if(ModList.get().isLoaded("ad_astra")) {
            STONES.put("moon", new StoneType("moon")
                    .setMapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
            STONES.put("mars", new StoneType("mars")
                    .setMapColor(MapColor.TERRACOTTA_RED));
            STONES.put("venus", new StoneType("venus")
                    .setMapColor(MapColor.TERRACOTTA_ORANGE));
            STONES.put("mercury", new StoneType("mercury")
                    .setMapColor(MapColor.TERRACOTTA_PURPLE));
            STONES.put("glacio", new StoneType("glacio")
                    .setMapColor(MapColor.ICE));
        }

        if(ModList.get().isLoaded("create")) {
            //STONES.put("limestone", new StoneType("limestone").setMapColor(MapColor.));
            //limestone
            //scoria
            //scorchia
            //gravel
        }


//        MINERALS.add(new MineralType("coal")
//                .setItemDrop(Items.COAL)
//                .setExpProvider(UniformInt.of(0, 2))
//        );
//        MINERALS.add(new MineralType("iron")
//                .setItemDrop(Items.RAW_IRON)
//                .setToolTag(BlockTags.NEEDS_STONE_TOOL)
//        );
        MINERALS.add(new MineralType("gold")
                .setItemDrop(Items.RAW_GOLD)
                .setSmeltedItem(Items.GOLD_INGOT)
                .setToolTag(BlockTags.NEEDS_IRON_TOOL)
                .addStoneType(STONES.get("glacio"))
        );
        MINERALS.add(new MineralType("redstone")
                .setItemDrop(Items.REDSTONE)
                .setSmeltedItem(Items.REDSTONE)
                .setExpProvider(UniformInt.of(1, 5))
                .setToolTag(BlockTags.NEEDS_IRON_TOOL)
                .setDropCount(4,5)
                .addStoneType(STONES.get("glacio"))
        );
        MINERALS.add(new MineralType("diamond")
                .setItemDrop(Items.DIAMOND)
                .setSmeltedItem(Items.DIAMOND)
                .setExpProvider(UniformInt.of(3, 7))
                .setToolTag(BlockTags.NEEDS_IRON_TOOL)
                .addStoneType(STONES.get("glacio"))
        );
        MINERALS.add(new MineralType("emerald")
                .setItemDrop(Items.EMERALD)
                .setSmeltedItem(Items.EMERALD)
                .setExpProvider(UniformInt.of(3, 7))
                .setToolTag(BlockTags.NEEDS_IRON_TOOL)
                .addStoneType(STONES.get("glacio"))
        );
//        MINERALS.add(new MineralType("copper")
//                .setItemDrop(Items.RAW_COPPER)
//                .setToolTag(BlockTags.NEEDS_STONE_TOOL)
//                .setDropCount(2,5)
//        );
//        MINERALS.add(new MineralType("lapis")
//                .setItemDrop(Items.LAPIS_ORE)
//                .setExpProvider(UniformInt.of(2,5))
//                .setToolTag(BlockTags.NEEDS_STONE_TOOL)
//                .setDropCount(4,9)
//        );
//        MINERALS.add(new MineralType("quartz")
//                .setItemDrop(Items.QUARTZ)
//                .setExpProvider(UniformInt.of(2,5))
//                .setToolTag(BlockTags.NEEDS_IRON_TOOL)
//        );

        //modded

        if(ModList.get().isLoaded("create")) {
            MINERALS.add(new MineralType("zinc")
                    .setItemDrop(AllItems.RAW_ZINC)
                    .setToolTag(BlockTags.NEEDS_IRON_TOOL)
                    .addStoneType(STONES.get("glacio"))
                    .setSmeltedItem(AllItems.ZINC_INGOT)
            );
        }

        if(ModList.get().isLoaded("immersiveengineering")){
            MINERALS.add(new MineralType("aluminum")
                    .setItemDrop(() -> IEItems.Metals.RAW_ORES.get(EnumMetals.ALUMINUM).asItem())
                    .setSmeltedItem(() -> IEItems.Metals.INGOTS.get(EnumMetals.ALUMINUM).asItem())
                    .setToolTag(BlockTags.NEEDS_STONE_TOOL)
                    .addStoneType(STONES.get("moon"))
                    .addStoneType(STONES.get("mars"))
                    .addStoneType(STONES.get("glacio"))
            );
            MINERALS.add(new MineralType("lead")
                    .setItemDrop(() -> IEItems.Metals.RAW_ORES.get(EnumMetals.LEAD).asItem())
                    .setSmeltedItem(() -> IEItems.Metals.INGOTS.get(EnumMetals.LEAD).asItem())
                    .setToolTag(BlockTags.NEEDS_IRON_TOOL)
                    .addStoneType(STONES.get("moon"))
                    .addStoneType(STONES.get("mars"))
                    .addStoneType(STONES.get("glacio"))
            );
            MINERALS.add(new MineralType("silver")
                    .setItemDrop(() -> IEItems.Metals.RAW_ORES.get(EnumMetals.SILVER).asItem())
                    .setSmeltedItem(() -> IEItems.Metals.INGOTS.get(EnumMetals.SILVER).asItem())
                    .setToolTag(BlockTags.NEEDS_IRON_TOOL)
                    .addStoneType(STONES.get("moon"))
                    .addStoneType(STONES.get("mercury"))
                    .addStoneType(STONES.get("glacio"))
            );
            MINERALS.add(new MineralType("nickel")
                    .setItemDrop(() -> IEItems.Metals.RAW_ORES.get(EnumMetals.NICKEL).asItem())
                    .setSmeltedItem(() -> IEItems.Metals.INGOTS.get(EnumMetals.NICKEL).asItem())
                    .setToolTag(BlockTags.NEEDS_IRON_TOOL)
                    .addStoneType(STONES.get("moon"))
                    .addStoneType(STONES.get("mercury"))
                    .addStoneType(STONES.get("glacio"))
            );
        }

        if(ModList.get().isLoaded("mekanism")){
            MINERALS.add(new MineralType("osmium")
                    .setItemDrop(MekanismItems.PROCESSED_RESOURCES.get(ResourceType.RAW, PrimaryResource.OSMIUM))
                    .setSmeltedItem(MekanismItems.PROCESSED_RESOURCES.get(ResourceType.INGOT, PrimaryResource.OSMIUM))
                    .setToolTag(BlockTags.NEEDS_STONE_TOOL)
                    .addStoneType(STONES.get("mars"))
                    .addStoneType(STONES.get("venus"))
                    .addStoneType(STONES.get("glacio"))
            );
            MINERALS.add(new MineralType("tin")
                    .setItemDrop(MekanismItems.PROCESSED_RESOURCES.get(ResourceType.RAW, PrimaryResource.TIN))
                    .setSmeltedItem(MekanismItems.PROCESSED_RESOURCES.get(ResourceType.INGOT, PrimaryResource.TIN))
                    .setToolTag(BlockTags.NEEDS_STONE_TOOL)
                    .addStoneType(STONES.get("mars"))
                    .addStoneType(STONES.get("venus"))
                    .addStoneType(STONES.get("glacio"))
            );
            MINERALS.add(new MineralType("uranium")
                    .setItemDrop(MekanismItems.PROCESSED_RESOURCES.get(ResourceType.RAW, PrimaryResource.URANIUM))
                    .setSmeltedItem(MekanismItems.PROCESSED_RESOURCES.get(ResourceType.INGOT, PrimaryResource.URANIUM))
                    .setToolTag(BlockTags.NEEDS_IRON_TOOL)
                    .addStoneType(STONES.get("venus"))
                    .addStoneType(STONES.get("mercury"))
                    .addStoneType(STONES.get("glacio"))
            );
            MINERALS.add(new MineralType("fluorite")
                    .setItemDrop(MekanismItems.FLUORITE_GEM)
                    .setSmeltedItem(MekanismItems.FLUORITE_GEM)
                    .setToolTag(BlockTags.NEEDS_STONE_TOOL)
                    .setDropCount(2,4)
                    .addStoneType(STONES.get("venus"))
                    .addStoneType(STONES.get("mercury"))
                    .addStoneType(STONES.get("glacio"))
            );
        }

        if(ModList.get().isLoaded("ad_astra")){

            MINERALS.add(new MineralType("desh")
                    .setItemDrop(earth.terrarium.adastra.common.registry.ModItems.RAW_DESH)
                    .setSmeltedItem(earth.terrarium.adastra.common.registry.ModItems.DESH_INGOT)
                    .setToolTag(BlockTags.NEEDS_DIAMOND_TOOL)
                    .addStoneType(STONES.get("stone"))
                    .addStoneType(STONES.get("glacio"))
            );
            MINERALS.add(new MineralType("ostrum")
                    .setItemDrop(earth.terrarium.adastra.common.registry.ModItems.RAW_OSTRUM)
                    .setSmeltedItem(earth.terrarium.adastra.common.registry.ModItems.OSTRUM_INGOT)
                    .setToolTag(BlockTags.NEEDS_DIAMOND_TOOL)
                    .addStoneType(STONES.get("stone"))
                    .addStoneType(STONES.get("glacio"))
            );
            MINERALS.add(new MineralType("calorite")
                    .setItemDrop(earth.terrarium.adastra.common.registry.ModItems.RAW_CALORITE)
                    .setSmeltedItem(earth.terrarium.adastra.common.registry.ModItems.CALORITE_INGOT)
                    .setToolTag(BlockTags.NEEDS_DIAMOND_TOOL)
                    .addStoneType(STONES.get("stone"))
                    .addStoneType(STONES.get("glacio"))
            );
            MINERALS.add(new MineralType("etrium")
                    .setItemDrop(ModItems.RAW_ETRIUM)
                    .setSmeltedItem(earth.terrarium.adastra.common.registry.ModItems.ETRIUM_INGOT)
                    .setToolTag(BlockTags.NEEDS_DIAMOND_TOOL)
                    .addStoneType(STONES.get("stone"))
                    .addStoneType(STONES.get("glacio"))
                    .addStoneType(STONES.get("deepslate"))
            );
        }

//        if(ModList.get().isLoaded("ae2")){
//            MINERALS.add(new MineralType("certus_quartz")
//                    .setItemDrop(AEItems.CERTUS_QUARTZ_CRYSTAL.asItem())
//                    .setDropCount(1,2)
//                    .setExpProvider(UniformInt.of(2, 5))
//                    .setToolTag(BlockTags.NEEDS_STONE_TOOL)
//                    .addStoneType(STONES.get("stone"))
//                    .addStoneType(STONES.get("deepslate"))
//                    .addStoneType(STONES.get("end"))
//                    .addStoneType(STONES.get("glacio"))
//            );
//            MINERALS.add(new MineralType("charged_certus_quartz")
//                    .setItemDrop(AEItems.CERTUS_QUARTZ_CRYSTAL.asItem())
//                    .setDropCount(1,2)
//                    .setExpProvider(UniformInt.of(2, 5))
//                    .setToolTag(BlockTags.NEEDS_STONE_TOOL)
//                    .addStoneType(STONES.get("stone"))
//                    .addStoneType(STONES.get("deepslate"))
//                    .addStoneType(STONES.get("end"))
//                    .addStoneType(STONES.get("glacio"))
//            );
//        }
    }
}
