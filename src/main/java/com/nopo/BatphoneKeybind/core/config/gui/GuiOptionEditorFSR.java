package com.nopo.BatphoneKeybind.core.config.gui;

import com.nopo.BatphoneKeybind.core.config.Config;
import com.nopo.BatphoneKeybind.core.config.struct.ConfigProcessor;
import com.nopo.BatphoneKeybind.core.util.render.RenderUtils;
import com.nopo.BatphoneKeybind.core.util.render.TextRenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Mouse;

import static com.nopo.BatphoneKeybind.util.GuiTextures.button_fsr;

public class GuiOptionEditorFSR extends GuiOptionEditor {

    private final int runnableId;
    private String buttonText;
    private final Config config;

    public GuiOptionEditorFSR(ConfigProcessor.ProcessedOption option, int runnableId, String buttonText, Config config) {
        super(option);
        this.runnableId = runnableId;
        this.config = config;

        this.buttonText = buttonText;
        if (this.buttonText != null && this.buttonText.isEmpty()) this.buttonText = null;
    }

    @Override
    public void render(int x, int y, int width) {
        super.render(x, y, width);

        int height = getHeight();

        GlStateManager.color(1, 1, 1, 1);
        Minecraft.getMinecraft().getTextureManager().bindTexture(button_fsr);
        RenderUtils.drawTexturedRect(x + width / 6 - 24, y + height - 7 - 14, 48, 16);

        if (buttonText != null) {
            TextRenderUtils.drawStringCenteredScaledMaxWidth(buttonText, Minecraft.getMinecraft().fontRendererObj,
                    x + width / 6, y + height - 7 - 6,
                    false, 44, 0xFF303030);
        }
    }

    @Override
    public boolean mouseInput(int x, int y, int width, int mouseX, int mouseY) {
        if (Mouse.getEventButtonState()) {
            int height = getHeight();
            if (mouseX > x + width / 6 - 24 && mouseX < x + width / 6 + 24 &&
                    mouseY > y + height - 7 - 14 && mouseY < y + height - 7 + 2) {
                config.executeRunnable(runnableId);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean keyboardInput() {
        return false;
    }
}
