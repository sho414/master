/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraftforge.event.entity.living.LivingDamageEvent
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package com.shomod.mulchPlayMod.events;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

/**
 * ダメージイベントを受け取り、インベントリにトーテムがあれば自動で使用する機能を提供するクラス。
 */
public class Resurrection {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void init(LivingDamageEvent event) {

        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }

        Player player = (Player)entity;
        Inventory inv = player.getInventory();
        float damage = event.getAmount();
        if (damage < player.getHealth()) {
            return;
        }

        for (int i = 0; i < inv.getContainerSize(); ++i) {
            ItemStack stack = inv.getItem(i);
            if (stack.getItem() != Items.TOTEM_OF_UNDYING) {
            	continue;
            }
            stack.shrink(1);			// トーテムを1つ減らす
            event.setCanceled(true);	// ダメージイベントをキャンセル（＝死を回避）
            player.setHealth(1.0f);		// HPを1に設定
            player.removeAllEffects();	// 全ステータス効果を解除
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
            //パーティクルとサウンド
            if (player.level() instanceof ServerLevel) {
                ServerLevel serverWorld = (ServerLevel)player.level();
                serverWorld.sendParticles((ParticleOptions)ParticleTypes.TOTEM_OF_UNDYING, player.getX(), player.getY() + 1.0, player.getZ(), 30, 0.5, 0.5, 0.5, 0.0);
                serverWorld.playSound(null, player.blockPosition(), SoundEvents.TOTEM_USE, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            LOGGER.info(".............used totem.");
            break;
        }

    }
}