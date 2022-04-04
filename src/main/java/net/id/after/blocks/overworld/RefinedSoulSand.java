package net.id.after.blocks.overworld;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class RefinedSoulSand extends SoulSandBlock {

    protected static final VoxelShape COLLISION_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0);

    public RefinedSoulSand(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int rolls = 2;
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

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    public VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.fullCube();
    }

    @Override
    public VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.fullCube();
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    private boolean isBlockTouchingAnotherBlock(BlockState state, BlockState blockState, World world, BlockPos blockPos, Direction direction){
        return state.isOpaque() && blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite());
    } //If block is touching another block and not rendering that face
}
