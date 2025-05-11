package com.compmod.yoshioka.init;

import com.compmod.yoshioka.objects.SlabBlockVT;
import com.compmod.yoshioka.objects.SlabBlockX2;
import com.compmod.yoshioka.objects.SlabBlockX2c;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "compmod");
    public static final RegistryObject<Block> DeepslatePillar         = BLOCKS.register("pillars/deepslate_pillar",         () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f, 2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> DeepslateBrickPillar    = BLOCKS.register("pillars/deepslate_brick_pillar",   () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f, 2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> StoneBrickPillar        = BLOCKS.register("pillars/stone_brick_pillar",      () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f, 2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> DeepslateTilePillar     = BLOCKS.register("pillars/deepslate_tile_pillar",   () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f, 2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> polished_dioritePillar   = BLOCKS.register("pillars/polished_diorite_pillar", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f, 2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> BrickPillar            = BLOCKS.register("pillars/brick_pillar",            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f, 2.0f).sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> DeepslateHalfx2        = BLOCKS.register("halfx2s/deepslate_halfx2",        () -> new SlabBlockX2(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f, 2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> DeepslateBrickHalfx2   = BLOCKS.register("halfx2s/deepslate_brick_halfx2",   () -> new SlabBlockX2(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f, 2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> StoneBrickHalfx2       = BLOCKS.register("halfx2s/stone_brick_halfx2",     () -> new SlabBlockX2(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f, 2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> DeepslateTileHalfx2    = BLOCKS.register("halfx2s/deepslate_tile_halfx2",   () -> new SlabBlockX2(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f, 2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> polished_dioriteHalfx2  = BLOCKS.register("halfx2s/polished_diorite_halfx2",() -> new SlabBlockX2(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> BrickHalfx2           = BLOCKS.register("halfx2s/brick_halfx2",           () -> new SlabBlockX2(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> DeepslateHalfx2c       = BLOCKS.register("halfx2s/deepslate_halfx2c",       () -> new SlabBlockX2c(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> DeepslateBrickHalfx2c  = BLOCKS.register("halfx2s/deepslate_brick_halfx2c",  () -> new SlabBlockX2c(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> StoneBrickHalfx2c      = BLOCKS.register("halfx2s/stone_brick_halfx2c",     () -> new SlabBlockX2c(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> DeepslateTileHalfx2c   = BLOCKS.register("halfx2s/deepslate_tile_halfx2c",  () -> new SlabBlockX2c(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> polished_dioriteHalfx2c = BLOCKS.register("halfx2s/polished_diorite_halfx2c",() -> new SlabBlockX2c(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> BrickHalfx2c          = BLOCKS.register("halfx2s/brick_halfx2c",          () -> new SlabBlockX2c(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> DeepslateHalfvt       = BLOCKS.register("halfvts/deepslate_halfvt",       () -> new SlabBlockVT(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> DeepslateBrickHalfvt  = BLOCKS.register("halfvts/deepslate_brick_halfvt", () -> new SlabBlockVT(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> StoneBrickHalfvt      = BLOCKS.register("halfvts/stone_brick_halfvt",     () -> new SlabBlockVT(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> DeepslateTileHalfvt   = BLOCKS.register("halfvts/deepslate_tile_halfvt",  () -> new SlabBlockVT(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> polished_dioriteHalfvt = BLOCKS.register("halfvts/polished_diorite_halfvt",() -> new SlabBlockVT(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> BrickHalfvt          = BLOCKS.register("halfvts/brick_halfvt",          () -> new SlabBlockVT(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(1.4f,2.0f).sound(SoundType.DEEPSLATE)));
}