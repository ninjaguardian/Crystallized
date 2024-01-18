package net.obf.crystallized.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.obf.crystallized.Crystallized;
import net.obf.crystallized.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Crystallized.MODID);

    public static final RegistryObject<BlockEntityType<CrystallizerBlockEntity>> CRYSTALLIZER_BE =
            BLOCK_ENTITIES.register("crystallizer_be", () ->
                    BlockEntityType.Builder.of(CrystallizerBlockEntity::new,
                            ModBlocks.CRYSTALLIZER.get()).build(null));;

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
