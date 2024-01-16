package net.obf.crystallized.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.obf.crystallized.Crystallized;
import net.obf.crystallized.worldgen.tree.custom.CrystalTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Crystallized.MODID);

    public static final RegistryObject<TrunkPlacerType<CrystalTrunkPlacer>> CRYSTAL_TRUNK_PLACER =
            TRUNK_PLACER.register("crystal_trunk_placer", () -> new TrunkPlacerType<>(CrystalTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
