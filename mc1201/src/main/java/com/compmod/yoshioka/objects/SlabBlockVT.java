// === SlabBlockVT.java ===
package com.compmod.yoshioka.objects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Vertical-tail slab: adjusts shape based on facing direction.
 */
public class SlabBlockVT extends SlabBlock {
    public static final EnumProperty<SlabType> TYPE = BlockStateProperties.SLAB_TYPE;
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;

    private static final VoxelShape NORTH_SHAPE = Block.box(0, 0, 8, 16, 16, 16);
    private static final VoxelShape SOUTH_SHAPE = Block.box(0, 0, 0, 16, 16, 8);
    private static final VoxelShape EAST_SHAPE  = Block.box(0, 0, 0, 8, 16, 16);
    private static final VoxelShape WEST_SHAPE  = Block.box(8, 0, 0, 16, 16, 16);

    public SlabBlockVT(BlockBehaviour.Properties props) {
        super(props);
        // Set default state: bottom slab, not waterlogged, facing north
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(TYPE, SlabType.BOTTOM)
            .setValue(WATERLOGGED, false)
            .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED, FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case SOUTH: return SOUTH_SHAPE;
            case EAST:  return EAST_SHAPE;
            case WEST:  return WEST_SHAPE;
            default:    return NORTH_SHAPE;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        SlabType slabType = (context.getClickedFace() == Direction.DOWN ||
            (context.getClickedFace() != Direction.UP && context.getClickLocation().y - context.getClickedPos().getY() > 0.5))
            ? SlabType.TOP : SlabType.BOTTOM;

        return defaultBlockState()
            .setValue(TYPE, slabType)
            .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
            .setValue(FACING, context.getHorizontalDirection());
    }
}