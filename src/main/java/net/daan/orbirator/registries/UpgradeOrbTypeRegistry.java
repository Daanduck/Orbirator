package net.daan.orbirator.registries;

import com.mojang.serialization.Codec;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.UpgradeOrbType;
import net.daan.orbirator.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.RegistryFixedCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.DataPackRegistryEvent;

public class UpgradeOrbTypeRegistry {
    public static final ResourceKey<Registry<UpgradeOrbType>> UPGRADE_ORB_REGISTRY_KEY = ResourceKey.createRegistryKey(IronsSpellbooks.id("upgrade_orb_type"));
    public static final Codec<Holder<UpgradeOrbType>> UPGRADE_ORB_REGISTRY_CODEC = RegistryFixedCodec.create(UPGRADE_ORB_REGISTRY_KEY);

    public static Registry<UpgradeOrbType> upgradeTypeRegistry(RegistryAccess registryAccess) {
        return registryAccess.registryOrThrow(UPGRADE_ORB_REGISTRY_KEY);
    }

    public static void registerDatapackRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(UPGRADE_ORB_REGISTRY_KEY, UpgradeOrbType.CODEC, UpgradeOrbType.CODEC);
    }
    public static ResourceKey<UpgradeOrbType> ELDRITCH_SPELL_POWER = ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("eldritch_power"));
    public static void bootstrap(BootstapContext<UpgradeOrbType> bootstrap) {
        bootstrap.register(ELDRITCH_SPELL_POWER,
                new UpgradeOrbType(AttributeRegistry.FIRE_SPELL_POWER, 0.05, AttributeModifier.Operation.MULTIPLY_BASE, ModItems.ELDRITCH_UPGRADE_ORB));
    }
}
