package net.obf.crystallized.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.obf.crystallized.Crystallized;
import net.obf.crystallized.worldgen.tree.custom.CrystalFoliagePlacer;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, Crystallized.MODID);

    public static final RegistryObject<FoliagePlacerType<CrystalFoliagePlacer>> CRYSTAL_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("crystal_foliage_placer", () -> new FoliagePlacerType<>(CrystalFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
