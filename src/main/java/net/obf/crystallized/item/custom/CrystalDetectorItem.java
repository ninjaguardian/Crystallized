package net.obf.crystallized.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.obf.crystallized.sound.ModSounds;
import net.obf.crystallized.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CrystalDetectorItem extends Item {

    public CrystalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if(isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;
                    pContext.getLevel().playSeededSound(null,positionClicked.getX(),positionClicked.getY(),positionClicked.getZ(),
                            ModSounds.CRYSTAL_DETECTOR_FOUND.get(), SoundSource.BLOCKS, 1f, 1f,0);//volume,pitch,seed
                    break;
                }
            }

            if(!foundBlock) {
                player.sendSystemMessage(Component.literal("No Crystal Ore found"));
                pContext.getLevel().playSeededSound(null,positionClicked.getX(),positionClicked.getY(),positionClicked.getZ(),
                        ModSounds.CRYSTAL_DETECTOR_NOT_FOUND.get(), SoundSource.BLOCKS, 3f, 1f,0);//volume,pitch,seed
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.crystallized.crystal_detector.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.CRYSTAL_DETECTOR_VALUABLES); //        return state.is(ModBlocks.CRYSTAL_ORE.get()) || state.is(ModBlocks.DEEPSLATE_CRYSTAL_ORE.get());
    }
}