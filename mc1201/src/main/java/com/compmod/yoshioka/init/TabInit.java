/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.item.CreativeModeTab
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.RegistryObject
 */
package com.compmod.yoshioka.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TabInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "compmod");
    public static final RegistryObject<CreativeModeTab> YOSHITAB = CREATIVE_TABS.register("yoshioka_tab", () -> CreativeModeTab.builder().title(Component.literal("itemGroup.compmod")).icon(() -> new ItemStack(BlockInit.DeepslatePillar.get())).displayItems((enabledFeatures, entries) -> {
        entries.accept((ItemLike)BlockInit.DeepslatePillar.get());
        entries.accept((ItemLike)BlockInit.DeepslateHalfx2.get());
        entries.accept((ItemLike)BlockInit.DeepslateHalfx2c.get());
        entries.accept((ItemLike)BlockInit.DeepslateHalfvt.get());
        entries.accept((ItemLike)BlockInit.DeepslateBrickPillar.get());
        entries.accept((ItemLike)BlockInit.DeepslateBrickHalfx2.get());
        entries.accept((ItemLike)BlockInit.DeepslateBrickHalfx2c.get());
        entries.accept((ItemLike)BlockInit.DeepslateBrickHalfvt.get());
        entries.accept((ItemLike)BlockInit.DeepslateTilePillar.get());
        entries.accept((ItemLike)BlockInit.DeepslateTileHalfx2.get());
        entries.accept((ItemLike)BlockInit.DeepslateTileHalfx2c.get());
        entries.accept((ItemLike)BlockInit.DeepslateTileHalfvt.get());
        entries.accept((ItemLike)BlockInit.StoneBrickPillar.get());
        entries.accept((ItemLike)BlockInit.StoneBrickHalfx2.get());
        entries.accept((ItemLike)BlockInit.StoneBrickHalfx2c.get());
        entries.accept((ItemLike)BlockInit.StoneBrickHalfvt.get());
        entries.accept((ItemLike)BlockInit.BrickPillar.get());
        entries.accept((ItemLike)BlockInit.BrickHalfx2.get());
        entries.accept((ItemLike)BlockInit.BrickHalfx2c.get());
        entries.accept((ItemLike)BlockInit.BrickHalfvt.get());
        entries.accept((ItemLike)BlockInit.polished_dioritePillar.get());
        entries.accept((ItemLike)BlockInit.polished_dioriteHalfx2.get());
        entries.accept((ItemLike)BlockInit.polished_dioriteHalfx2c.get());
        entries.accept((ItemLike)BlockInit.polished_dioriteHalfx2c.get());
    }).build());
}
