package net.obf.crystallized.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.obf.crystallized.Crystallized;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Crystallized.MODID);

    public static final RegistryObject<SoundEvent> CRYSTAL_DETECTOR_FOUND = registerSoundEvents(    "crystal_detector_found");
    public static final RegistryObject<SoundEvent> CRYSTAL_DETECTOR_NOT_FOUND = registerSoundEvents("crystal_detector_not_found");


    public static final RegistryObject<SoundEvent> TEST_BLOCK_BREAK = registerSoundEvents("test_block_break");
    public static final RegistryObject<SoundEvent> TEST_BLOCK_STEP = registerSoundEvents("test_block_step");
    public static final RegistryObject<SoundEvent> TEST_BLOCK_FALL = registerSoundEvents("test_block_fall");
    public static final RegistryObject<SoundEvent> TEST_BLOCK_PLACE = registerSoundEvents("test_block_place");
    public static final RegistryObject<SoundEvent> TEST_BLOCK_HIT = registerSoundEvents("test_block_hit");



    public static final ForgeSoundType TEST_BLOCK_SOUNDS = new ForgeSoundType(1f,1f,
            ModSounds.TEST_BLOCK_BREAK,ModSounds.TEST_BLOCK_STEP,ModSounds.TEST_BLOCK_PLACE,ModSounds.TEST_BLOCK_HIT,ModSounds.TEST_BLOCK_FALL);
    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Crystallized.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
