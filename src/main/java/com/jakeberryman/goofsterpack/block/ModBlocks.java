package com.jakeberryman.goofsterpack.block;

import com.jakeberryman.goofsterpack.Goofsterpack;
import com.jakeberryman.goofsterpack.block.blockGeneratorData.MineralType;
import com.jakeberryman.goofsterpack.block.blockGeneratorData.OreData;
import com.jakeberryman.goofsterpack.block.blockGeneratorData.StoneType;
import com.jakeberryman.goofsterpack.block.customBlocks.CustomRedStoneOreBlock;
import com.jakeberryman.goofsterpack.item.ModItems;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Goofsterpack.MOD_ID);

    public static final Map<String, RegistryObject<Block>> ORE_BLOCKS_MAP = new HashMap<>();
    public static final Map<RegistryObject<Block>, Pair<StoneType, MineralType>> ORE_DATA_MAP = new HashMap<>();

    static {
        OreData.MINERALS.forEach(mineral -> {
            if(mineral.getStoneTypes().isEmpty()) return;
            mineral.getStoneTypes().forEach(stone -> {
                if(stone == null){
                    System.out.println("null stone for mineral: " + mineral.getMineralType());
                    return;
                }

                BlockBehaviour.Properties blockProperties = BlockBehaviour.Properties.of()
                        .mapColor(stone.getMapColor())
                        .instrument(stone.getInstrument())
                        .requiresCorrectToolForDrops()
                        .strength(stone.getHardness(), stone.getBlastResistance());

                String blockName;
                if(stone.getStoneType().matches("stone")) {
                    blockName = "%s_ore".formatted(mineral.getMineralType());
                } else {
                    blockName = "%s_%s_ore".formatted(stone.getStoneType(), mineral.getMineralType());
                }

                RegistryObject<Block> newBlock = registerBlock(blockName,
                        () -> {
                            if (mineral.getMineralType().contains("redstone")) {
                                return new CustomRedStoneOreBlock(blockProperties, mineral.getExpProvider());
                            } else {
                                return new DropExperienceBlock(blockProperties, mineral.getExpProvider());
                            }
                        });

                addBlockToMaps(newBlock, mineral, stone);
            });
        });
    }

    private static final Map<String, RegistryObject<Block>> GENERATED_BLOCKS = new HashMap<>();

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static void addBlockToMaps(RegistryObject<Block> block, MineralType mineral, StoneType stone){
        assert block.getId() != null;
        ORE_BLOCKS_MAP.put(block.getId().getPath(), block);
        ORE_DATA_MAP.put(block, new Pair<>(stone, mineral));
    }

    /**
     *
     * @param blockId namespace without mod id, for example "goofsterpack:test_block" would be "test_block"
     * @return gets the block from the map
     */
    public static RegistryObject<Block> get(String blockId) {
        return ORE_BLOCKS_MAP.get(blockId.toLowerCase());
    }
}