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

import java.util.Comparator;
import java.util.Map;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Goofsterpack.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GOOFSERPACK_TAB = CREATIVE_MODE_TAB.register("goofsterpack_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.get("glacio_etrium_ore").get()))
                    .title(Component.translatable("creativetab.goofsterpack_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        ModItems.ITEMS.getEntries().stream()
                                .sorted(Comparator.comparing(entry -> entry.getId().getPath()))
                                .forEach(entry -> pOutput.accept(entry.get()));

                        pOutput.accept(Items.COMMAND_BLOCK);
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
