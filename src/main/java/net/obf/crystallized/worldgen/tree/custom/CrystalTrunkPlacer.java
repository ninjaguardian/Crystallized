package net.obf.crystallized.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.obf.crystallized.worldgen.tree.ModTrunkPlacerTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class CrystalTrunkPlacer extends TrunkPlacer {
    public static final Codec<CrystalTrunkPlacer> CODEC = RecordCodecBuilder.create(crystalTrunkPlacerInstance ->
            trunkPlacerParts(crystalTrunkPlacerInstance).apply(crystalTrunkPlacerInstance, CrystalTrunkPlacer::new));

//    private final int minHeightForLeaves;
//    private final IntProvider bendLength;

    public CrystalTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
//        this.minHeightForLeaves = 1; //int
//        this.bendLength = UniformInt.of(3,5); //int provider
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.CRYSTAL_TRUNK_PLACER.get();
    }

//    @Override
//    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, int i, BlockPos blockPos, TreeConfiguration treeConfiguration) {
//        //TRUNKPLACER
//        //(LevelSimulatedReader p_226079_, BiConsumer<BlockPos, BlockState> p_226080_, RandomSource p_226081_, int p_226082_, BlockPos p_226083_, TreeConfiguration p_226084_)
//        Direction $$6 = Direction.Plane.HORIZONTAL.getRandomDirection(randomSource);
//        Direction $$12 = $$6.getOpposite();
//        int $$7 = i - 1;
//        BlockPos.MutableBlockPos $$8 = blockPos.mutable();
//        BlockPos.MutableBlockPos $$14 = $$8;
//        BlockPos $$9 = $$8.below();
//        setDirtAt(levelSimulatedReader, biConsumer, randomSource, $$9, treeConfiguration);
//        List<FoliagePlacer.FoliageAttachment> $$10 = Lists.newArrayList();
//        int $$11;
//        for($$11 = 0; $$11 <= $$7; ++$$11) {
//            if ($$11 + 1 >= $$7 + randomSource.nextInt(2)) {
//                $$8.move($$6);
//            }
//
//            if (TreeFeature.validTreePos(levelSimulatedReader, $$8)) {
//                this.placeLog(levelSimulatedReader, biConsumer, randomSource, $$8, treeConfiguration);
//            }
//
//            if ($$11 >= this.minHeightForLeaves) {
//                $$10.add(new FoliagePlacer.FoliageAttachment($$8.immutable(), 0, false));
//            }
//
//            $$8.move(Direction.UP);
//        }
//        for($$11 = 0; $$11 <= $$7; ++$$11) {
//            if ($$11 + 1 >= $$7 + randomSource.nextInt(2)) {
//                $$14.move($$12);
//            }
//
//            if (TreeFeature.validTreePos(levelSimulatedReader, $$14)) {
//                this.placeLog(levelSimulatedReader, biConsumer, randomSource, $$14, treeConfiguration);
//            }
//
//            if ($$11 >= this.minHeightForLeaves) {
//                $$10.add(new FoliagePlacer.FoliageAttachment($$14.immutable(), 0, false));
//            }
//
//            $$14.move(Direction.UP);
//        }
//
//        $$11 = this.bendLength.sample(randomSource);
//
//        for(int $$13 = 0; $$13 <= $$11; ++$$13) {
//            if (TreeFeature.validTreePos(levelSimulatedReader, $$8)) {
//                this.placeLog(levelSimulatedReader, biConsumer, randomSource, $$8, treeConfiguration);
//            }
//
//            $$10.add(new FoliagePlacer.FoliageAttachment($$8.immutable(), 0, false));
//            $$8.move($$6);
//        }
//
//        return $$10;
//        //TRUNKPLACER

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter,
                                                            RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        // THIS WHERE BLOCK PLACING LOGIC GOES
        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);
        int height = pFreeTreeHeight + pRandom.nextInt(heightRandA, heightRandA + 3) + pRandom.nextInt(heightRandB - 1, heightRandB + 1);
        short NORTH_COOLDOWN = 0;
        short SOUTH_COOLDOWN = 0;
        short WEST_COOLDOWN = 0;
        short EAST_COOLDOWN = 0;

        boolean shifted_tree = false;
        int shifted_treeY = 0;
        ArrayList<Direction> PossibleDirections = new ArrayList<Direction>();
        for(int i = 0; i < height; i++) {
            if (!shifted_tree && i > 3 && i < height - 5) {
                shifted_tree = true;
                shifted_treeY = i;
                placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
                switch (ThreadLocalRandom.current().nextInt(1, 5)) {
                    case 1: pPos = pPos.north(); break;
                    case 2: pPos = pPos.south(); break;
                    case 3: pPos = pPos.west(); break;
                    case 4: pPos = pPos.east(); break;
                }
            }

            placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);

            //make it happen 2 times?

            PossibleDirections.clear();
            if (NORTH_COOLDOWN == 0) {
                PossibleDirections.add(Direction.NORTH);
            }
            else {
                NORTH_COOLDOWN--;
            }
            if (SOUTH_COOLDOWN == 0) {
                PossibleDirections.add(Direction.SOUTH);
            }
            else {
                SOUTH_COOLDOWN--;
            }
            if (EAST_COOLDOWN == 0) {
                PossibleDirections.add(Direction.EAST);
            }
            else {
                EAST_COOLDOWN--;
            }
            if (WEST_COOLDOWN == 0) {
                PossibleDirections.add(Direction.WEST);
            }
            else {
                WEST_COOLDOWN--;
            }


            if(pRandom.nextFloat() > 0.30f && i < height-5 && i > 1) {
                if(!PossibleDirections.isEmpty() && !(shifted_treeY == i)) {
                    Direction place_direction = getRandomFromDirectionArrayList(PossibleDirections);
                    Direction.Axis place_axis = getAxis(place_direction);
                    BlockPos bPos = pPos;

                    if (place_direction == Direction.NORTH) {
                        NORTH_COOLDOWN = 4;
                    }
                    if (place_direction == Direction.SOUTH) {
                        SOUTH_COOLDOWN = 4;
                    }
                    if (place_direction == Direction.EAST) {
                        EAST_COOLDOWN = 4;
                    }
                    if (place_direction == Direction.WEST) {
                        WEST_COOLDOWN = 4;
                    }

                    int branch_len = ThreadLocalRandom.current().nextInt(3, 6); //2-5
                    boolean went_up_but_no_stack = false;
                    for (int x = 1; x < branch_len; x++) {
                        pBlockSetter.accept(bPos.above(i).relative(place_direction, x), ((BlockState)
                                Function.identity().apply(pConfig.trunkProvider.getState(pRandom, bPos).setValue(RotatedPillarBlock.AXIS, place_axis))));
                        if (pRandom.nextFloat() > 0.25f && x > 1 && !(x == branch_len - 1)) {
                            bPos = bPos.above();
                            if (pRandom.nextFloat() > 0.5f && !went_up_but_no_stack) {
                                pBlockSetter.accept(bPos.above(i).relative(place_direction, x), ((BlockState)
                                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, bPos).setValue(RotatedPillarBlock.AXIS, place_axis))));
                            }
                            else {went_up_but_no_stack = true;}
                        }
                        else {went_up_but_no_stack = false;}
                    }
                }
            }
        }
        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(height), 0, false));
    }


    private static Direction getRandomFromDirectionArrayList(ArrayList<Direction> arrayList) {
        int rnd = new Random().nextInt(arrayList.size());
        return arrayList.get(rnd);
    }

    private static Direction.Axis getAxis(Direction place_direction) {
        Direction.Axis place_axis = null; //null so no error
        if (place_direction == Direction.NORTH) {
            place_axis = Direction.Axis.Z;
        }
        if (place_direction == Direction.SOUTH) {
            place_axis = Direction.Axis.Z;
        }
        if (place_direction == Direction.EAST) {
            place_axis = Direction.Axis.X;
        }
        if (place_direction == Direction.WEST) {
            place_axis = Direction.Axis.X;
        }
        return place_axis;
    }
}