package net.obf.crystallized.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.obf.crystallized.Crystallized;
import net.obf.crystallized.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier CRYSTAL = TierSortingRegistry.registerTier(
            new ForgeTier(5,2650,11.0F,4.0F,25,
                    ModTags.Blocks.NEEDS_CRYSTAL_TOOL, () -> Ingredient.of(ModItems.CRYSTAL_SHARD.get())),
            new ResourceLocation(Crystallized.MODID,"crystal"), List.of(Tiers.NETHERITE), List.of()
    );
}
