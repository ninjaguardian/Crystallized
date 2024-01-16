package net.obf.crystallized;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.obf.crystallized.block.ModBlocks;
import net.obf.crystallized.item.ModCreativeModTabs;
import net.obf.crystallized.item.ModItems;
import net.obf.crystallized.loot.ModLootModifiers;
import net.obf.crystallized.worldgen.tree.ModFoliagePlacers;
import net.obf.crystallized.worldgen.tree.ModTrunkPlacerTypes;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Crystallized.MODID)
public class Crystallized {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "crystallized";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Crystallized() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModTrunkPlacerTypes.register(modEventBus);
        ModFoliagePlacers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.CRYSTAL_SWORD);
            event.accept(ModItems.CRYSTAL_AXE);
            event.accept(ModItems.CRYSTAL_HELMET);
            event.accept(ModItems.CRYSTAL_CHESTPLATE);
            event.accept(ModItems.CRYSTAL_LEGGINGS);
            event.accept(ModItems.CRYSTAL_BOOTS);
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.CRYSTAL_PICKAXE);
            event.accept(ModItems.CRYSTAL_SHOVEL);
            event.accept(ModItems.CRYSTAL_HOE);
            event.accept(ModItems.CRYSTAL_AXE);
            event.accept(ModItems.CRYSTAL_DETECTOR);
        }
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.CRYSTAL_SHARD);
        }
        if(event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(ModBlocks.CRYSTAL_BUTTON);
            event.accept(ModBlocks.CRYSTAL_PRESSURE_PLATE);
            event.accept(ModBlocks.CRYSTAL_DOOR);
            event.accept(ModBlocks.LOCKED_CRYSTAL_DOOR);
            event.accept(ModBlocks.CRYSTAL_TRAPDOOR);
            event.accept(ModBlocks.LOCKED_CRYSTAL_TRAPDOOR);
        }
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.CRYSTAL_ORE);
            event.accept(ModBlocks.DEEPSLATE_CRYSTAL_ORE);
            event.accept(ModBlocks.CRYSTAL_LOG);
            event.accept(ModBlocks.CRYSTAL_LEAVES);
            event.accept(ModBlocks.CRYSTAL_SAPLING);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.CRYSTAL_BLOCK);
            event.accept(ModBlocks.CRYSTAL_STAIRS);
            event.accept(ModBlocks.CRYSTAL_SLAB);
            event.accept(ModBlocks.CRYSTAL_BUTTON);
            event.accept(ModBlocks.CRYSTAL_PRESSURE_PLATE);
            event.accept(ModBlocks.CRYSTAL_FENCE);
            event.accept(ModBlocks.CRYSTAL_FENCE_GATE);
            event.accept(ModBlocks.CRYSTAL_WALL);
            event.accept(ModBlocks.CRYSTAL_DOOR);
            event.accept(ModBlocks.LOCKED_CRYSTAL_DOOR);
            event.accept(ModBlocks.CRYSTAL_TRAPDOOR);
            event.accept(ModBlocks.LOCKED_CRYSTAL_TRAPDOOR);
            event.accept(ModBlocks.CRYSTAL_LOG);
            event.accept(ModBlocks.STRIPPED_CRYSTAL_LOG);
            event.accept(ModBlocks.CRYSTAL_WOOD);
            event.accept(ModBlocks.STRIPPED_CRYSTAL_WOOD);
            event.accept(ModBlocks.CRYSTAL_PLANKS);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
