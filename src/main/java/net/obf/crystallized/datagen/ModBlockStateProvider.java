package net.obf.crystallized.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.obf.crystallized.Crystallized;
import net.obf.crystallized.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Crystallized.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.CRYSTAL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_CRYSTAL_ORE);

        stairsBlock(((StairBlock) ModBlocks.CRYSTAL_STAIRS.get()), blockTexture(ModBlocks.CRYSTAL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.CRYSTAL_SLAB.get()), blockTexture(ModBlocks.CRYSTAL_BLOCK.get()), blockTexture(ModBlocks.CRYSTAL_BLOCK.get()));
        buttonBlock(((ButtonBlock) ModBlocks.CRYSTAL_BUTTON.get()), blockTexture(ModBlocks.CRYSTAL_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.CRYSTAL_PRESSURE_PLATE.get()), blockTexture(ModBlocks.CRYSTAL_BLOCK.get()));
        fenceBlock(((FenceBlock) ModBlocks.CRYSTAL_FENCE.get()), blockTexture(ModBlocks.CRYSTAL_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.CRYSTAL_FENCE_GATE.get()), blockTexture(ModBlocks.CRYSTAL_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.CRYSTAL_WALL.get()), blockTexture(ModBlocks.CRYSTAL_BLOCK.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.CRYSTAL_DOOR.get()),modLoc("block/crystal_door_bottom"), modLoc("block/crystal_door_top"), "cutout");
        doorBlockWithRenderType(((DoorBlock) ModBlocks.LOCKED_CRYSTAL_DOOR.get()),modLoc("block/locked_crystal_door_bottom"), modLoc("block/locked_crystal_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.CRYSTAL_TRAPDOOR.get()),modLoc("block/crystal_trapdoor"), true, "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.LOCKED_CRYSTAL_TRAPDOOR.get()),modLoc("block/locked_crystal_trapdoor"), true, "cutout");

        logBlock(((RotatedPillarBlock) ModBlocks.CRYSTAL_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.CRYSTAL_WOOD.get()), blockTexture(ModBlocks.CRYSTAL_LOG.get()), blockTexture(ModBlocks.CRYSTAL_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_CRYSTAL_LOG.get()), blockTexture(ModBlocks.STRIPPED_CRYSTAL_LOG.get()),
                new ResourceLocation(Crystallized.MODID, "block/stripped_crystal_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_CRYSTAL_WOOD.get()), blockTexture(ModBlocks.STRIPPED_CRYSTAL_LOG.get()), blockTexture(ModBlocks.STRIPPED_CRYSTAL_LOG.get()));

        blockItem(ModBlocks.CRYSTAL_LOG);
        blockItem(ModBlocks.CRYSTAL_WOOD);
        blockItem(ModBlocks.STRIPPED_CRYSTAL_LOG);
        blockItem(ModBlocks.STRIPPED_CRYSTAL_WOOD);

        blockWithItem(ModBlocks.CRYSTAL_PLANKS);

        leavesBlock(ModBlocks.CRYSTAL_LEAVES);

        saplingBlock(ModBlocks.CRYSTAL_SAPLING);
        simpleBlockWithItem(ModBlocks.POTTED_CRYSTAL_SAPLING.get(), models().singleTexture("potted_crystal_sapling", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.CRYSTAL_SAPLING.get())).renderType("cutout"));


        simpleBlockWithItem(ModBlocks.CRYSTALLIZER.get(), new ModelFile.UncheckedModelFile(modLoc("block/crystallizer")));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }
    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(Crystallized.MODID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
