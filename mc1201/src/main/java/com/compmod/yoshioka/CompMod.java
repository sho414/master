/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.server.ServerStoppingEvent
 *  net.minecraftforge.eventbus.api.IEventBus
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 *  net.minecraftforge.fml.event.config.ModConfigEvent$Loading
 *  net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
 *  net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package com.compmod.yoshioka;

import com.compmod.yoshioka.config.ApplyConfig;
import com.compmod.yoshioka.init.BlockInit;
import com.compmod.yoshioka.init.ItemInit;
import com.compmod.yoshioka.init.TabInit;
import com.compmod.yoshioka.util.ScriptExecutor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value="compmod")
@Mod.EventBusSubscriber(modid="compmod", bus=Mod.EventBusSubscriber.Bus.MOD)
public class CompMod {
    public static final String MOD_ID = "compmod";
    public static CompMod instance;
    public static final Logger LOGGER;

    public CompMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::doClientSetup);
        modEventBus.addListener(this::onConfigLoading);
        MinecraftForge.EVENT_BUS.addListener(this::onServerStopping);
        ApplyConfig.initialize();
        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        TabInit.CREATIVE_TABS.register(modEventBus);
        instance = this;
        MinecraftForge.EVENT_BUS.register((Object)this);
        LOGGER.info(".............main class end.");
    }

    private void doClientSetup(FMLClientSetupEvent event) {
        LOGGER.info(".............client setup end.");
    }

    private void onConfigLoading(ModConfigEvent.Loading event) {
        LOGGER.info(".............configLoading end.");
    }

    private void onServerStopping(ServerStoppingEvent event) {
        LOGGER.info(".............World Stopping.");
        String scriptPathMac = (String)ApplyConfig.CONFIG.scriptDirMac.get();
        String scriptPathWin = (String)ApplyConfig.CONFIG.scriptDirWin.get();
        String scriptNameMac = (String)ApplyConfig.CONFIG.scriptNameMac.get();
        String scriptNameWin = (String)ApplyConfig.CONFIG.scriptNameWin.get();
        ScriptExecutor exec = new ScriptExecutor(scriptPathMac, scriptNameMac, scriptPathWin, scriptNameWin);
        if (exec.execScript()) {
            LOGGER.info(".............ScriptExecutor Succeed!!!!!!!!!!!!");
        } else {
            LOGGER.info(".............ScriptExecutor Error!!!!!!!!!!!!");
        }
    }

    static {
        LOGGER = LogManager.getLogger();
    }
}
