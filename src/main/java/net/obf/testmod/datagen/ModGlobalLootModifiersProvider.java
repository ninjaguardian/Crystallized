package net.obf.testmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.obf.testmod.TestMod;
import net.obf.testmod.item.ModItems;
import net.obf.testmod.loot.AddItemModifier;
import net.obf.testmod.loot.AddSusItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, TestMod.MODID);
    }

    @Override
    protected void start() {
        add("crystal_shard_from_stone", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STONE).build(),
                LootItemRandomChanceCondition.randomChance(0.01F).build()} , ModItems.CRYSTAL_SHARD.get()));

        add("crystal_shard_from_deepslate", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE).build(),
                LootItemRandomChanceCondition.randomChance(0.02F).build()} , ModItems.CRYSTAL_SHARD.get()));

        add("crystal_shard_from_ruins_sus", new AddSusItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/trail_ruins_rare")).build(),
                LootItemRandomChanceCondition.randomChance(0.02F).build()} , ModItems.CRYSTAL_SHARD.get()));

        add("crystal_shard_from_zombie", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(0.01F).build()} , ModItems.CRYSTAL_SHARD.get()));

        add("crystal_shard_from_end_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.06F).build()} , ModItems.CRYSTAL_SHARD.get()));

        add("crystal_shard_from_stronghold_corridor", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/stronghold_corridor")).build(),
                LootItemRandomChanceCondition.randomChance(0.06F).build()} , ModItems.CRYSTAL_SHARD.get()));

        add("crystal_shard_from_stronghold_crossing", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/stronghold_crossing")).build(),
                LootItemRandomChanceCondition.randomChance(0.04F).build()} , ModItems.CRYSTAL_SHARD.get()));

        add("crystal_detector_from_end_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.05F).build()} , ModItems.CRYSTAL_DETECTOR.get()));
    }
}
