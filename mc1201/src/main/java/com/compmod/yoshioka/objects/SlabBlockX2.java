// === SlabBlockX2.java ===
package com.compmod.yoshioka.objects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


/**
 * Half-height slab occupying lower 4 or upper 4 blocks.
 */
public class SlabBlockX2 extends SlabBlock {
    private static final VoxelShape BOTTOM_SHAPE = Block.box(0, 0, 0, 16, 4, 16);
    private static final VoxelShape TOP_SHAPE    = Block.box(0, 12, 0, 16, 16, 16);

    public SlabBlockX2(BlockBehaviour.Properties props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return state.getValue(BlockStateProperties.SLAB_TYPE) == SlabType.TOP ? TOP_SHAPE : BOTTOM_SHAPE;
    }
}