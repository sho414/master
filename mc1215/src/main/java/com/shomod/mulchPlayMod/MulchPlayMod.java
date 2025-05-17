/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.LivingDamageEvent
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package com.shomod.mulchPlayMod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.shomod.mulchPlayMod.events.Resurrection;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("mulchplaymod")
@Mod.EventBusSubscriber(modid = MulchPlayMod.MOD_ID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class MulchPlayMod {
    /** Mod identifier */
    public static final String MOD_ID = "mulchplaymod";
    /** Singleton instance */
    public static MulchPlayMod instance;
    /** Logger */
    public static final Logger LOGGER;

    static {
        LOGGER = LogManager.getLogger();
    }

    /**
     * コンストラクタ――ダメージイベントを登録
     */
    public MulchPlayMod() {
        MinecraftForge.EVENT_BUS.addListener(this::onPlayerDamage);
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info(".............main class end.");
    }

    /**
     * プレイヤーがダメージを受けたときに呼ばれる。
     * インベントリ内のトーテムを探して自動発動を試みる。
     */
    public void onPlayerDamage(LivingDamageEvent event) {
        Resurrection.init(event);
        LOGGER.info(".............onPlayerDamage end.");
    }
}
