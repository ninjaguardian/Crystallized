package net.obf.testmod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.obf.testmod.TestMod;
import net.obf.testmod.item.custom.CrystalDetectorItem;
import net.obf.testmod.item.custom.ModArmorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    public static final RegistryObject<Item> CRYSTAL_SHARD = ITEMS.register("crystal_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_DETECTOR = ITEMS.register("crystal_detector",
            () -> new CrystalDetectorItem(new Item.Properties().durability(50)));

    public static final RegistryObject<Item> CRYSTAL_SWORD = ITEMS.register("crystal_sword",
            () -> new SwordItem(ModToolTiers.CRYSTAL,4,-2.3F, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_PICKAXE = ITEMS.register("crystal_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CRYSTAL,2,-2.7F, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_AXE = ITEMS.register("crystal_axe",
            () -> new AxeItem(ModToolTiers.CRYSTAL,6,-2.5F, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_HOE = ITEMS.register("crystal_hoe",
            () -> new HoeItem(ModToolTiers.CRYSTAL,-4,0.5F, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_SHOVEL = ITEMS.register("crystal_shovel",
            () -> new ShovelItem(ModToolTiers.CRYSTAL,2,-3.0F, new Item.Properties()));


    public static final RegistryObject<Item> CRYSTAL_HELMET = ITEMS.register("crystal_helmet",
            () -> new ModArmorItem(ModArmorMaterials.CRYSTAL,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_CHESTPLATE = ITEMS.register("crystal_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_LEGGINGS = ITEMS.register("crystal_leggings",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_BOOTS = ITEMS.register("crystal_boots",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL,ArmorItem.Type.BOOTS,new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}


