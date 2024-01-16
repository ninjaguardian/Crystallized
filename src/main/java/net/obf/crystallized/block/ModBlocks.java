package net.obf.crystallized.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.obf.crystallized.Crystallized;
import net.obf.crystallized.block.custom.ModFlammableRotatedPillarBlock;
import net.obf.crystallized.item.ModItems;
import net.obf.crystallized.worldgen.tree.CrystalTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Crystallized.MODID);


    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static final RegistryObject<Block> CRYSTAL_BLOCK = registerBlock("crystal_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .strength(5.5F, 3.5F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS)
            ));

    public static final RegistryObject<Block> CRYSTAL_ORE = registerBlock("crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(4.5F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS),
                    UniformInt.of(4,7)
            ));

    public static final RegistryObject<Block> DEEPSLATE_CRYSTAL_ORE = registerBlock("deepslate_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE)
                    .strength(5.0F, 3.5F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS),
                    UniformInt.of(4,7)
            ));


    public static final RegistryObject<Block> CRYSTAL_STAIRS = registerBlock("crystal_stairs",
            () -> new StairBlock(() -> ModBlocks.CRYSTAL_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .strength(5.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS)
            ));

    public static final RegistryObject<Block> CRYSTAL_SLAB = registerBlock("crystal_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .strength(5.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS)
            ));

    public static final RegistryObject<Block> CRYSTAL_BUTTON = registerBlock("crystal_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)
                    .sound(SoundType.AMETHYST)
                    .strength(5.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS),
                    BlockSetType.IRON,
                    10,
                    true
            ));
    public static final RegistryObject<Block> CRYSTAL_PRESSURE_PLATE = registerBlock("crystal_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .strength(5.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS),
                    BlockSetType.IRON
            ));
    public static final RegistryObject<Block> CRYSTAL_FENCE = registerBlock("crystal_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .strength(5.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS)
            ));

    public static final RegistryObject<Block> CRYSTAL_FENCE_GATE = registerBlock("crystal_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .strength(5.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS),
                    SoundEvents.AMETHYST_BLOCK_PLACE,
                    SoundEvents.AMETHYST_BLOCK_CHIME
            ));
    public static final RegistryObject<Block> CRYSTAL_WALL = registerBlock("crystal_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .strength(5.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS)
            ));
    public static final RegistryObject<Block> LOCKED_CRYSTAL_DOOR = registerBlock("locked_crystal_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .sound(SoundType.AMETHYST)
                    .strength(5.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS),
                    BlockSetType.IRON
            ));

    public static final RegistryObject<Block> LOCKED_CRYSTAL_TRAPDOOR = registerBlock("locked_crystal_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .sound(SoundType.AMETHYST)
                    .strength(5.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS),
                    BlockSetType.IRON
            ));

    public static final RegistryObject<Block> CRYSTAL_DOOR = registerBlock("crystal_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .sound(SoundType.AMETHYST)
                    .strength(5.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS),
                    BlockSetType.OAK
                    ));

    public static final RegistryObject<Block> CRYSTAL_TRAPDOOR = registerBlock("crystal_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .sound(SoundType.AMETHYST)
                    .strength(5.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.LAPIS),
                    BlockSetType.OAK
            ));

    public static final RegistryObject<Block> CRYSTAL_LOG = registerBlock("crystal_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .mapColor(MapColor.COLOR_BLUE)
                    .strength(2.5F)
            ));
    public static final RegistryObject<Block> CRYSTAL_WOOD = registerBlock("crystal_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .mapColor(MapColor.COLOR_BLUE)
                    .strength(2.5F)
            ));
    public static final RegistryObject<Block> STRIPPED_CRYSTAL_LOG = registerBlock("stripped_crystal_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .mapColor(MapColor.COLOR_LIGHT_BLUE)
                    .strength(2.5F)
            ));
    public static final RegistryObject<Block> STRIPPED_CRYSTAL_WOOD = registerBlock("stripped_crystal_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .mapColor(MapColor.COLOR_LIGHT_BLUE)
                    .strength(2.5F)
            ));
    public static final RegistryObject<Block> CRYSTAL_PLANKS = registerBlock("crystal_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .mapColor(MapColor.COLOR_BLUE)
                    .strength(2.5F,3.5F)
            ){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> CRYSTAL_LEAVES = registerBlock("crystal_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .mapColor(MapColor.COLOR_LIGHT_BLUE)
                    .strength(0.3F)
            ){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> CRYSTAL_SAPLING = registerBlock("crystal_sapling",
            () -> new SaplingBlock(new CrystalTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                    .mapColor(MapColor.COLOR_LIGHT_BLUE)
            ));

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
