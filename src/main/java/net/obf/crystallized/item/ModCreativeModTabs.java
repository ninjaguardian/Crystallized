package net.obf.crystallized.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.obf.crystallized.Crystallized;
import net.obf.crystallized.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Crystallized.MODID);

    public static final RegistryObject<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TABS.register("test_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRYSTAL_SHARD.get()))
                    .title(Component.translatable("creativetab.crystallized"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CRYSTAL_SHARD.get());
                        pOutput.accept(ModItems.CRYSTAL_DETECTOR.get());
                        pOutput.accept(ModItems.CRYSTAL_SWORD.get());
                        pOutput.accept(ModItems.CRYSTAL_PICKAXE.get());
                        pOutput.accept(ModItems.CRYSTAL_AXE.get());
                        pOutput.accept(ModItems.CRYSTAL_SHOVEL.get());
                        pOutput.accept(ModItems.CRYSTAL_HOE.get());
                        pOutput.accept(ModItems.CRYSTAL_HELMET.get());
                        pOutput.accept(ModItems.CRYSTAL_CHESTPLATE.get());
                        pOutput.accept(ModItems.CRYSTAL_LEGGINGS.get());
                        pOutput.accept(ModItems.CRYSTAL_BOOTS.get());
                        pOutput.accept(ModBlocks.CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.CRYSTAL_BLOCK.get());
                        pOutput.accept(ModBlocks.CRYSTAL_STAIRS.get());
                        pOutput.accept(ModBlocks.CRYSTAL_SLAB.get());
                        pOutput.accept(ModBlocks.CRYSTAL_BUTTON.get());
                        pOutput.accept(ModBlocks.CRYSTAL_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.CRYSTAL_FENCE.get());
                        pOutput.accept(ModBlocks.CRYSTAL_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.CRYSTAL_WALL.get());
                        pOutput.accept(ModBlocks.CRYSTAL_DOOR.get());
                        pOutput.accept(ModBlocks.LOCKED_CRYSTAL_DOOR.get());
                        pOutput.accept(ModBlocks.CRYSTAL_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.LOCKED_CRYSTAL_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.CRYSTAL_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_CRYSTAL_LOG.get());
                        pOutput.accept(ModBlocks.CRYSTAL_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_CRYSTAL_WOOD.get());
                        pOutput.accept(ModBlocks.CRYSTAL_PLANKS.get());
                        pOutput.accept(ModBlocks.CRYSTAL_LEAVES.get());
                        pOutput.accept(ModBlocks.CRYSTAL_SAPLING.get());
                        pOutput.accept(ModBlocks.CRYSTALLIZER.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
