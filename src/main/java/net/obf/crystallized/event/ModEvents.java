package net.obf.crystallized.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.obf.crystallized.Crystallized;
import net.obf.crystallized.block.ModBlocks;
import net.obf.crystallized.item.ModItems;

import java.util.List;


@Mod.EventBusSubscriber(modid = Crystallized.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer( //the '1' is the villager level between 1-5
                    new ItemStack(Items.EMERALD, 25), //price (item, count)
                    new ItemStack(Items.OAK_SAPLING, 2), //price (item, count) OPTIONAL
                    new ItemStack(ModBlocks.CRYSTAL_SAPLING.get(), 2), //reward (item, count)
                    7, 10, 0.02f//max uses, xp, price multiplier
            ));
        }

    }
    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer( //the '1' is the villager level between 1-5
                new ItemStack(Items.EMERALD, 25), //price (item, count)
                new ItemStack(Items.OAK_SAPLING, 2), //price (item, count) OPTIONAL
                new ItemStack(ModBlocks.CRYSTAL_SAPLING.get(), 2), //reward (item, count)
                7, 10, 0.02f//max uses, xp, price multiplier
        ));
    }
}
