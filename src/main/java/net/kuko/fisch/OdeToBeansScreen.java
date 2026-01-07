package net.kuko.fisch;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class OdeToBeansScreen extends Screen {
    public OdeToBeansScreen() {
        super(Component.literal("Ode To Beans"));
    }

    protected void init() {
        super.init();
    }


    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        int baseSize = 150; // Base width and height
        int x = (this.width - baseSize) / 2;
        int y = (this.height - baseSize) / 2;


        int glowThickness = 4; // How thick the neon glow is

// Base rectangle
        int neonColor = 0xF04f62bd;
        int baseColor = 0xF0798ffc;
        guiGraphics.fill(x, y, x + baseSize, y + baseSize, baseColor);

        guiGraphics.fill(x - glowThickness, y - glowThickness, x + baseSize + glowThickness, y, neonColor); // Top
        guiGraphics.fill(x - glowThickness, y + baseSize, x + baseSize + glowThickness, y + baseSize + glowThickness, neonColor); // Bottom
        guiGraphics.fill(x - glowThickness, y, x, y + baseSize, neonColor); // Left
        guiGraphics.fill(x + baseSize, y,
                x + baseSize + glowThickness, y + baseSize, neonColor); // Right

        super.render(guiGraphics, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }

    @Override
    public void onClose() {
        assert this.getMinecraft().level != null;
        if (this.getMinecraft().level.isClientSide) {
            this.minecraft.setScreen(null);
        }
    }

}