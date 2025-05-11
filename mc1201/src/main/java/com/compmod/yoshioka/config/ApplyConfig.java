// === ApplyConfig.java ===
package com.compmod.yoshioka.config;

import org.apache.commons.lang3.tuple.Pair;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

/**
 * Handles registration and initialization of mod configuration.
 */
public class ApplyConfig {
    /** Common config specification for Forge. */
    public static ForgeConfigSpec COMMON_SPEC;
    /** Configuration values holder. */
    public static CommonConfig CONFIG;
    /** Registered ModConfig instance for COMMON settings. */
    public static ModConfig COMMON_MOD_CONFIG;

    /**
     * Builds the config specifications and registers them with Forge,
     * then sets up the config GUI extension point.
     */
    public static void initialize() {
        Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder()
            .configure(CommonConfig::new);
        CONFIG = specPair.getLeft();
        COMMON_SPEC = specPair.getRight();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_SPEC);
        ApplyConfigGUI.initialize();
    }

    /**
     * Defines configurable values for script execution paths and filenames.
     */
    public static class CommonConfig {
        /** Directory where scripts are located on Mac. */
        public final ForgeConfigSpec.ConfigValue<String> scriptDirMac;
        /** Directory where scripts are located on Windows. */
        public final ForgeConfigSpec.ConfigValue<String> scriptDirWin;
        /** Script filename to execute on Mac. */
        public final ForgeConfigSpec.ConfigValue<String> scriptNameMac;
        /** Script filename to execute on Windows. */
        public final ForgeConfigSpec.ConfigValue<String> scriptNameWin;

        public CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("==== ScriptExecutor Settings ====");
            scriptDirMac = builder.comment("Directory where scripts are located (Mac)")
                .define("scriptDirMac", "scripts");
            scriptDirWin = builder.comment("Directory where scripts are located (Windows)")
                .define("scriptDirWin", "scripts");
            scriptNameMac = builder.comment("Script filename to run (Mac)")
                .define("scriptNameMac", "run_mac.sh");
            scriptNameWin = builder.comment("Script filename to run (Windows)")
                .define("scriptNameWin", "run_win.bat");
        }
    }
}