package net.daan.orbirator.item;

import net.daan.orbirator.Orbirator;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Orbirator.MOD_ID);

    public static final RegistryObject<Item> ELDRITCH_UPGRADE_ORB = ITEMS.register("eldritch_upgrade_orb",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ELDRITCH_RUNE = ITEMS.register("eldritch_rune",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}