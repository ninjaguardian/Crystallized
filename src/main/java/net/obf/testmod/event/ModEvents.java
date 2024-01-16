package net.obf.testmod.event;

import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.obf.testmod.TestMod;


@Mod.EventBusSubscriber(modid = TestMod.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
//        if(event.getType() == )

    }

}
