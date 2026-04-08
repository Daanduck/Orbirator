package net.daan.orbirator.item;

import net.daan.orbirator.Orbirator;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Orbirator.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ORBIRATOR = CREATIVE_MODE_TABS.register("learning_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ELDRITCH_UPGRADE_ORB.get()))
                    .title(Component.translatable("creativetab.orbirator"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ELDRITCH_UPGRADE_ORB.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}