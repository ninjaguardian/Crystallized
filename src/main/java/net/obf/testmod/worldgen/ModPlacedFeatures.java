package net.obf.testmod.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.obf.testmod.TestMod;
import net.obf.testmod.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> CRYSTAL_ORE_PLACED_KEY = registerKey("crystal_ore_placed");

    public static final ResourceKey<PlacedFeature> CRYSTAL_TREE_PLACED_KEY = registerKey("crystal_tree_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_CRYSTAL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5, //veins per chunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32)))); //spawn range (uniform: same all the way, triangle: more likely in between)

        register(context, CRYSTAL_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTAL_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3,0.1f,1), //placement amount, chance of getting {3rd arg} extra, extra count
                        ModBlocks.CRYSTAL_SAPLING.get()));                                                                             //2nd arg must follow: 1 / {2nd arg} = integer
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(TestMod.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
