package net.obf.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.obf.testmod.TestMod;
import net.obf.testmod.block.ModBlocks;
import net.obf.testmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //Custom tags
        this.tag(ModTags.Blocks.CRYSTAL_DETECTOR_VALUABLES)
                .add(ModBlocks.CRYSTAL_ORE.get())
                .add(ModBlocks.DEEPSLATE_CRYSTAL_ORE.get())
        ;

        //Tool type tags
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CRYSTAL_BLOCK.get())
                .add(ModBlocks.CRYSTAL_ORE.get())
                .add(ModBlocks.DEEPSLATE_CRYSTAL_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
        ;

        this.tag(BlockTags.MINEABLE_WITH_HOE)
        ;

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
        ;

        //Tool ingredient tags
        this.tag(ModTags.Blocks.NEEDS_CRYSTAL_TOOL)
        ;

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
        ;

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CRYSTAL_BLOCK.get())
                .add(ModBlocks.CRYSTAL_ORE.get())
                .add(ModBlocks.DEEPSLATE_CRYSTAL_ORE.get())
        ;

        this.tag(BlockTags.NEEDS_IRON_TOOL)
        ;

        this.tag(BlockTags.NEEDS_STONE_TOOL)
        ;

        //Groups
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.CRYSTAL_FENCE.get())
        ;
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.CRYSTAL_FENCE_GATE.get())
        ;
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.CRYSTAL_WALL.get())
        ;

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CRYSTAL_LOG.get())
                .add(ModBlocks.CRYSTAL_WOOD.get())
                .add(ModBlocks.STRIPPED_CRYSTAL_LOG.get())
                .add(ModBlocks.STRIPPED_CRYSTAL_WOOD.get())
        ;

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.CRYSTAL_PLANKS.get())
        ;
    }
}
