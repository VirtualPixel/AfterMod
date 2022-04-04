package net.id.after.util;

import net.id.after.After;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

public class AfterSoundEvents {
    public static ArrayList<SoundEvent> SCREAMS = new ArrayList<>();

    public static final SoundEvent HIGH_PITCHED_MAN_SCREAM = registerSoundEvent("high_pitched_man_scream");
    public static final SoundEvent LOW_PITCHED_MAN_SCREAM = registerSoundEvent("low_pitched_man_scream");
    public static final SoundEvent HIGH_PITCHED_WOMAN_SCREAM = registerSoundEvent("high_pitched_woman_scream");
    public static final SoundEvent LOW_PITCHED_WOMAN_SCREAM = registerSoundEvent("low_pitched_woman_scream");

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(After.MOD_ID, name);
        SoundEvent event = new SoundEvent(id);

        if(name.contains("scream")){
            SCREAMS.add(event);
        }


        return Registry.register(Registry.SOUND_EVENT, new Identifier(After.MOD_ID + name), event);
    }

    public static void init(){
        After.LOGGER.info("Registering Sound Events for " + After.MOD_ID);
    }
}
