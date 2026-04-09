package net.daan.orbirator.mixin;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.UpgradeOrbType;
import io.redspace.ironsspellbooks.registries.UpgradeOrbTypeRegistry;
import net.daan.orbirator.item.ModItems;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import static io.redspace.ironsspellbooks.registries.UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY;

@Mixin(UpgradeOrbTypeRegistry.class)
public class UpgradeOrbTypeRegistryMixin {
    @Inject(method = "bootstrap", at = @At("TAIL"))
    private static void addCustomOrbs(BootstapContext<UpgradeOrbType> bootstrap) {
        bootstrap.register(
                ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, new ResourceLocation("orbirator", "eldritch_power")),
                new UpgradeOrbType(AttributeRegistry.FIRE_SPELL_POWER, 0.05, AttributeModifier.Operation.MULTIPLY_BASE, ModItems.ELDRITCH_UPGRADE_ORB)
        );
    }
}

