package net.id.after.blocks.decorative;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Wearable;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class MarrowBlock extends HorizontalFacingBlock implements Wearable {

    public MarrowBlock(Settings settings){
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager){
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);

        return switch (dir) {
            case NORTH, SOUTH -> VoxelShapes.cuboid(0, 0, 0.0625, 1, 1, 0.9375);
            case EAST, WEST -> VoxelShapes.cuboid(0.0625, 0, 0, 0.9375, 1, 1);
            default -> VoxelShapes.fullCube();
        };

    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx){
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }


}
