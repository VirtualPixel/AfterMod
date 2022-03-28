package net.after.blocks;

import net.after.AfterMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class PhantoniumOre extends OreBlock {
    public PhantoniumOre(Settings settings) {super(settings);}
    public ArrayList<SoundEvent> sounds = new ArrayList<>();
    public int lastSoundPlayed;
    public int soundBeforeLastPlayed;
    public int rand;

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        if (!world.isClient) {
            world.playSound(
                    null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                    pos, // The position of where the sound will come from
                    playRandomSound(), // The sound that will play
                    SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
                    0.2f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                    1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
            );
        }

    }

    public SoundEvent playRandomSound(){
        if(sounds.isEmpty()){
            addSoundsToList();
        }
        int max = sounds.size() - 1;
        int min = 0;
        int range = max - min + 1;

        while(lastSoundPlayed == rand || soundBeforeLastPlayed == rand) {
            rand = (int) (Math.random() * range) + min;
        }

        soundBeforeLastPlayed = lastSoundPlayed;
        lastSoundPlayed = rand;

        return sounds.get(rand);

    }

    public void addSoundsToList(){
        sounds.add(AfterMod.HIGH_PITCHED_MAN_SCREAM_EVENT);
        sounds.add(AfterMod.HIGH_PITCHED_WOMAN_SCREAM_EVENT);
        sounds.add(AfterMod.LOW_PITCHED_WOMAN_SCREAM_EVENT);
        sounds.add(AfterMod.LOW_PITCHED_MAN_SCREAM_EVENT);
    }
}
