package net.obf.crystallized.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.obf.crystallized.Crystallized;
import net.obf.crystallized.block.ModBlocks;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, Crystallized.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Crystallized.MODID);

    public static final RegistryObject<PoiType> CRYSTAL_POI = POI_TYPES.register("crystal_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.CRYSTAL_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> CRYSTAL_OBSERVER =
            VILLAGER_PROFESSIONS.register("crystalobserver", () -> new VillagerProfession("crystalobserver",
                    holder -> holder.get() == CRYSTAL_POI.get(), holder -> holder.get() == CRYSTAL_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_TOOLSMITH));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
