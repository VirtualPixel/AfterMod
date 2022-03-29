package net.after.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Random;

public class SoulGlass extends Block {
    public SoulGlass(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int rolls = 1;
        int baseRandom = 3; //Lower the number == faster
        Direction direction;

        if (random.nextInt(baseRandom) != 0) {
            return;
        }

        for(int i = 0; i < rolls; i++) {
            direction = Direction.random(random);
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);

            if (isBlockTouchingAnotherBlock(state, blockState, world, blockPos, direction)){
                return;
            }

            double d = direction.getOffsetX() == 0 ? random.nextDouble() : 0.5 + (double) direction.getOffsetX() * 0.6;
            double e = direction.getOffsetY() == 0 ? random.nextDouble() : 0.5 + (double) direction.getOffsetY() * 0.6;
            double f = direction.getOffsetZ() == 0 ? random.nextDouble() : 0.5 + (double) direction.getOffsetZ() * 0.6;
            world.addParticle(ParticleTypes.SOUL, (double) pos.getX() + d, (double) pos.getY() + e, (double) pos.getZ() + f, 0.0, 0.0, 0.0);
        }
    }

    private boolean isBlockTouchingAnotherBlock(BlockState state, BlockState blockState, World world, BlockPos blockPos, Direction direction){
        if(state.isOpaque() && blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite())){
            return true;
        } else{
            return false;
        }
    }
}
