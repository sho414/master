package com.compmod.yoshioka.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "compmod");
    public static final RegistryObject<Item> DeepslatePillar         = ITEMS.register("pillars/deepslate_pillar",         () -> new BlockItem(BlockInit.DeepslatePillar.get(), new Item.Properties()));
    public static final RegistryObject<Item> DeepslateBrickPillar    = ITEMS.register("pillars/deepslate_brick_pillar",   () -> new BlockItem(BlockInit.DeepslateBrickPillar.get(), new Item.Properties()));
    public static final RegistryObject<Item> StoneBrickPillar        = ITEMS.register("pillars/stone_brick_pillar",      () -> new BlockItem(BlockInit.StoneBrickPillar.get(), new Item.Properties()));
    public static final RegistryObject<Item> DeepslateTilePillar     = ITEMS.register("pillars/deepslate_tile_pillar",   () -> new BlockItem(BlockInit.DeepslateTilePillar.get(), new Item.Properties()));
    public static final RegistryObject<Item> polished_dioritePillar   = ITEMS.register("pillars/polished_diorite_pillar", () -> new BlockItem(BlockInit.polished_dioritePillar.get(), new Item.Properties()));
    public static final RegistryObject<Item> BrickPillar            = ITEMS.register("pillars/brick_pillar",            () -> new BlockItem(BlockInit.BrickPillar.get(), new Item.Properties()));

    public static final RegistryObject<Item> DeepslateHalfx2        = ITEMS.register("halfx2s/deepslate_halfx2",        () -> new BlockItem(BlockInit.DeepslateHalfx2.get(), new Item.Properties()));
    public static final RegistryObject<Item> DeepslateBrickHalfx2   = ITEMS.register("halfx2s/deepslate_brick_halfx2",   () -> new BlockItem(BlockInit.DeepslateBrickHalfx2.get(), new Item.Properties()));
    public static final RegistryObject<Item> StoneBrickHalfx2       = ITEMS.register("halfx2s/stone_brick_halfx2",     () -> new BlockItem(BlockInit.StoneBrickHalfx2.get(), new Item.Properties()));
    public static final RegistryObject<Item> DeepslateTileHalfx2    = ITEMS.register("halfx2s/deepslate_tile_halfx2",   () -> new BlockItem(BlockInit.DeepslateTileHalfx2.get(), new Item.Properties()));
    public static final RegistryObject<Item> polished_dioriteHalfx2  = ITEMS.register("halfx2s/polished_diorite_halfx2",() -> new BlockItem(BlockInit.polished_dioriteHalfx2.get(), new Item.Properties()));
    public static final RegistryObject<Item> BrickHalfx2           = ITEMS.register("halfx2s/brick_halfx2",           () -> new BlockItem(BlockInit.BrickHalfx2.get(), new Item.Properties()));

    public static final RegistryObject<Item> DeepslateHalfx2c       = ITEMS.register("halfx2s/deepslate_halfx2c",       () -> new BlockItem(BlockInit.DeepslateHalfx2c.get(), new Item.Properties()));
    public static final RegistryObject<Item> DeepslateBrickHalfx2c  = ITEMS.register("halfx2s/deepslate_brick_halfx2c",  () -> new BlockItem(BlockInit.DeepslateBrickHalfx2c.get(), new Item.Properties()));
    public static final RegistryObject<Item> StoneBrickHalfx2c      = ITEMS.register("halfx2s/stone_brick_halfx2c",     () -> new BlockItem(BlockInit.StoneBrickHalfx2c.get(), new Item.Properties()));
    public static final RegistryObject<Item> DeepslateTileHalfx2c   = ITEMS.register("halfx2s/deepslate_tile_halfx2c",  () -> new BlockItem(BlockInit.DeepslateTileHalfx2c.get(), new Item.Properties()));
    public static final RegistryObject<Item> polished_dioriteHalfx2c = ITEMS.register("halfx2s/polished_diorite_halfx2c",() -> new BlockItem(BlockInit.polished_dioriteHalfx2c.get(), new Item.Properties()));
    public static final RegistryObject<Item> BrickHalfx2c          = ITEMS.register("halfx2s/brick_halfx2c",          () -> new BlockItem(BlockInit.BrickHalfx2c.get(), new Item.Properties()));

    public static final RegistryObject<Item> DeepslateHalfvt       = ITEMS.register("halfvts/deepslate_halfvt",       () -> new BlockItem(BlockInit.DeepslateHalfvt.get(), new Item.Properties()));
    public static final RegistryObject<Item> DeepslateBrickHalfvt  = ITEMS.register("halfvts/deepslate_brick_halfvt", () -> new BlockItem(BlockInit.DeepslateBrickHalfvt.get(), new Item.Properties()));
    public static final RegistryObject<Item> StoneBrickHalfvt      = ITEMS.register("halfvts/stone_brick_halfvt",     () -> new BlockItem(BlockInit.StoneBrickHalfvt.get(), new Item.Properties()));
    public static final RegistryObject<Item> DeepslateTileHalfvt   = ITEMS.register("halfvts/deepslate_tile_halfvt",  () -> new BlockItem(BlockInit.DeepslateTileHalfvt.get(), new Item.Properties()));
    public static final RegistryObject<Item> polished_dioriteHalfvt = ITEMS.register("halfvts/polished_diorite_halfvt",() -> new BlockItem(BlockInit.polished_dioriteHalfvt.get(), new Item.Properties()));
    public static final RegistryObject<Item> BrickHalfvt          = ITEMS.register("halfvts/brick_halfvt",          () -> new BlockItem(BlockInit.BrickHalfvt.get(), new Item.Properties()));
}