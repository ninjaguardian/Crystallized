package net.obf.crystallized.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.obf.crystallized.Crystallized;
import net.obf.crystallized.block.ModBlocks;
import net.obf.crystallized.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Crystallized.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CRYSTAL_HELMET.get(),
                        ModItems.CRYSTAL_CHESTPLATE.get(),
                        ModItems.CRYSTAL_LEGGINGS.get(),
                        ModItems.CRYSTAL_BOOTS.get()
                        );

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CRYSTAL_LOG.get().asItem())
                .add(ModBlocks.CRYSTAL_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_CRYSTAL_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_CRYSTAL_WOOD.get().asItem())
        ;

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.CRYSTAL_PLANKS.get().asItem())
        ;
    }
}
