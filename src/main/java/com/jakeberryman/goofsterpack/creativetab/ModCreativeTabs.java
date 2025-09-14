package com.jakeberryman.goofsterpack.creativetab;

import com.jakeberryman.goofsterpack.Goofsterpack;
import com.jakeberryman.goofsterpack.block.ModBlocks;
import com.jakeberryman.goofsterpack.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Goofsterpack.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GOOFSERPACK_TAB = CREATIVE_MODE_TAB.register("goofsterpack_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TEST_ITEM.get()))
                    .title(Component.translatable("creativetab.goofsterpack_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TEST_ITEM.get());

                        ModBlocks.ORE_BLOCKS_MAP.entrySet().stream()
                                .sorted(Map.Entry.comparingByKey())
                                .forEach(entry -> {
                                    pOutput.accept(entry.getValue().get());
                                });

                        pOutput.accept(Items.COMMAND_BLOCK);
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
