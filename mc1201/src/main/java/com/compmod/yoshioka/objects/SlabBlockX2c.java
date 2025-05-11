// === SlabBlockX2c.java ===
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
 * Column slab: occupies middle 4 block units when double slab.
 */
public class SlabBlockX2c extends SlabBlock {
    private static final VoxelShape BOTTOM_SHAPE = Block.box(0, 4, 0, 16, 8, 16);
    private static final VoxelShape TOP_SHAPE    = Block.box(0, 8, 0, 16, 12, 16);
    private static final VoxelShape DOUBLE_SHAPE = Block.box(0, 4, 0, 16, 12, 16);

    public SlabBlockX2c(BlockBehaviour.Properties props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        SlabType type = state.getValue(BlockStateProperties.SLAB_TYPE);
        switch (type) {
            case DOUBLE: return DOUBLE_SHAPE;
            case TOP:    return TOP_SHAPE;
            default:     return BOTTOM_SHAPE;
        }
    }
}