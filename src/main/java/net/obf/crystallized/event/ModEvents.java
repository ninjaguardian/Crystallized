package net.obf.crystallized.event;

import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.obf.crystallized.Crystallized;


@Mod.EventBusSubscriber(modid = Crystallized.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
//        if(event.getType() == )

    }

}
