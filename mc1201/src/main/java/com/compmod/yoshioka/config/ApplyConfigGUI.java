// === ApplyConfigGUI.java ===
package com.compmod.yoshioka.config;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;

/**
 * Adds a custom configuration screen for editing script paths and names.
 */
public class ApplyConfigGUI {
    /**
     * Registers the GUI screen factory for Forge's config menu.
     */
    public static void initialize() {
        ModLoadingContext.get()
            .registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                    (minecraft, previousScreen) -> new ConfigScreen(previousScreen)
                )
            );
    }

    /**
     * Custom config screen to edit script execution settings.
     */
    private static class ConfigScreen extends Screen {
        private EditBox scriptDirMacField;
        private EditBox scriptDirWinField;
        private EditBox scriptNameMacField;
        private EditBox scriptNameWinField;
        private final Screen parent;

        public ConfigScreen(Screen parent) {
            super(Component.literal("Sho' compMod Settings"));
            this.parent = parent;
        }

        @Override
        protected void init() {
            int fieldWidth = this.width - 60;
            int x = 30;
            int y = 40;
            int spacing = 40;

            // Mac script directory input
            scriptDirMacField = new EditBox(this.font, x, y, fieldWidth, 20,
                Component.literal("Mac script directory"));
            scriptDirMacField.setMaxLength(256);
            scriptDirMacField.setValue(ApplyConfig.CONFIG.scriptDirMac.get());
            addRenderableWidget(scriptDirMacField);

            // Windows script directory input
            scriptDirWinField = new EditBox(this.font, x, y += spacing, fieldWidth, 20,
                Component.literal("Windows script directory"));
            scriptDirWinField.setMaxLength(256);
            scriptDirWinField.setValue(ApplyConfig.CONFIG.scriptDirWin.get());
            addRenderableWidget(scriptDirWinField);

            // Mac script filename input
            scriptNameMacField = new EditBox(this.font, x, y += spacing, fieldWidth, 20,
                Component.literal("Mac script filename"));
            scriptNameMacField.setMaxLength(256);
            scriptNameMacField.setValue(ApplyConfig.CONFIG.scriptNameMac.get());
            addRenderableWidget(scriptNameMacField);

            // Windows script filename input
            scriptNameWinField = new EditBox(this.font, x, y += spacing, fieldWidth, 20,
                Component.literal("Windows script filename"));
            scriptNameWinField.setMaxLength(256);
            scriptNameWinField.setValue(ApplyConfig.CONFIG.scriptNameWin.get());
            addRenderableWidget(scriptNameWinField);

            // Done button
            addRenderableWidget(Button.builder(Component.literal("Done"), btn -> {
                applyAndSave();
                minecraft.setScreen(parent);
            }).bounds(width / 2 - 50, y += spacing + 10, 100, 20).build());
        }

        /**
         * Applies current input values to the config and marks it dirty.
         */
        private void applyAndSave() {
            ApplyConfig.CONFIG.scriptDirMac.set(scriptDirMacField.getValue());
            ApplyConfig.CONFIG.scriptDirWin.set(scriptDirWinField.getValue());
            ApplyConfig.CONFIG.scriptNameMac.set(scriptNameMacField.getValue());
            ApplyConfig.CONFIG.scriptNameWin.set(scriptNameWinField.getValue());
        }

        @Override
        public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
            renderBackground(guiGraphics);
            guiGraphics.drawCenteredString(this.font, Component.literal("Sho' compMod Settings"),
                width / 2, 20, 0xFFFFFF);
            int x = 30;
            int y = 40;
            int spacing = 40;
            guiGraphics.drawString(this.font, Component.literal("Mac script directory"), x, y - 12, 0xFFFFFF);
            guiGraphics.drawString(this.font, Component.literal("Windows script directory"), x, y + spacing - 12, 0xFFFFFF);
            guiGraphics.drawString(this.font, Component.literal("Mac script filename"), x, y + spacing * 2 - 12, 0xFFFFFF);
            guiGraphics.drawString(this.font, Component.literal("Windows script filename"), x, y + spacing * 3 - 12, 0xFFFFFF);
            super.render(guiGraphics, mouseX, mouseY, partialTicks);
        }
    }
}