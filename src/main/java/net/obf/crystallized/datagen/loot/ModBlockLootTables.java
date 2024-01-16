package net.obf.crystallized.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.obf.crystallized.block.ModBlocks;
import net.obf.crystallized.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CRYSTAL_BLOCK.get());

        this.add(ModBlocks.CRYSTAL_ORE.get(),
                block -> createCustomOreDrops(ModBlocks.CRYSTAL_ORE.get(), ModItems.CRYSTAL_SHARD.get(), 1.0F,3.0F));

        this.add(ModBlocks.DEEPSLATE_CRYSTAL_ORE.get(),
                block -> createCustomOreDrops(ModBlocks.DEEPSLATE_CRYSTAL_ORE.get(), ModItems.CRYSTAL_SHARD.get(), 1.0F,3.0F));

        this.dropSelf(ModBlocks.CRYSTAL_STAIRS.get());
        this.dropSelf(ModBlocks.CRYSTAL_BUTTON.get());
        this.dropSelf(ModBlocks.CRYSTAL_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.CRYSTAL_TRAPDOOR.get());
        this.dropSelf(ModBlocks.LOCKED_CRYSTAL_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CRYSTAL_FENCE.get());
        this.dropSelf(ModBlocks.CRYSTAL_FENCE_GATE.get());
        this.dropSelf(ModBlocks.CRYSTAL_WALL.get());

        this.dropSelf(ModBlocks.CRYSTAL_PLANKS.get());
        this.dropSelf(ModBlocks.CRYSTAL_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CRYSTAL_LOG.get());
        this.dropSelf(ModBlocks.CRYSTAL_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CRYSTAL_WOOD.get());
        this.dropSelf(ModBlocks.CRYSTAL_SAPLING.get());
        this.add(ModBlocks.POTTED_CRYSTAL_SAPLING.get(), createPotFlowerItemTable(ModBlocks.CRYSTAL_SAPLING.get()));


        this.add(ModBlocks.CRYSTAL_SLAB.get(), block ->
                createSlabItemTable(ModBlocks.CRYSTAL_SLAB.get()));
        this.add(ModBlocks.CRYSTAL_DOOR.get(), block ->
                createDoorTable(ModBlocks.CRYSTAL_DOOR.get()));
        this.add(ModBlocks.LOCKED_CRYSTAL_DOOR.get(), block ->
                createDoorTable(ModBlocks.LOCKED_CRYSTAL_DOOR.get()));
        this.add(ModBlocks.CRYSTAL_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.CRYSTAL_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    }

    protected LootTable.Builder createCustomOreDrops(Block p_251306_, Item item, float min, float max) {
        return createSilkTouchDispatchTable(p_251306_, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(p_251306_, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
