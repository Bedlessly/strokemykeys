package io.github.zenyiar.strokemykeys.gui;

import club.sk1er.elementa.components.UIText;
import club.sk1er.elementa.components.Window;
import club.sk1er.elementa.constraints.ConstantColorConstraint;
import club.sk1er.elementa.constraints.PixelConstraint;
import io.github.zenyiar.strokemykeys.ZenyiarsStrokeMyKeysConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.util.Properties;

public class StrokeMyKeysGui extends GuiScreen
{
    public static Window window = new Window();
    public static Properties json = new Properties();
    public static void handleKeyDown(int key)
    {
        if (Keyboard.isKeyDown(key)) {
            json.setProperty(Keyboard.getKeyName(key).toUpperCase() + ":activated", String.valueOf(true));
        } else {
            json.setProperty(Keyboard.getKeyName(key).toUpperCase() + ":activated", String.valueOf(false));
        }
    }

    public static ConstantColorConstraint getColor(String str) {
        if (json.getProperty(str + ":activated") == "true") {
            return new ConstantColorConstraint(Color.YELLOW);
        } else {
            return new ConstantColorConstraint(Color.WHITE);
        }
    }

    public static void update()
    {
        if (ZenyiarsStrokeMyKeysConfig.showStrokeMyKeysOverlay && Minecraft.getMinecraft().inGameHasFocus && !Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            UIText key_W_text = new UIText("W");
            key_W_text.setTextScale(new PixelConstraint(2.0F));
            key_W_text.setX(new PixelConstraint(18.0F));
            key_W_text.setY(new PixelConstraint(3.0F));
            key_W_text.setColor(getColor("W"));
            window.addChild(key_W_text);

            UIText key_S_text = new UIText("S");
            key_S_text.setTextScale(new PixelConstraint(2.0F));
            key_S_text.setX(new PixelConstraint(18.0F));
            key_S_text.setY(new PixelConstraint(23.0F));
            key_S_text.setColor(getColor("S"));
            window.addChild(key_S_text);

            UIText key_A_text = new UIText("A");
            key_A_text.setTextScale(new PixelConstraint(2.0F));
            key_A_text.setX(new PixelConstraint(3.0F));
            key_A_text.setY(new PixelConstraint(23.0F));
            key_A_text.setColor(getColor("A"));
            window.addChild(key_A_text);

            UIText key_D_text = new UIText("D");
            key_D_text.setTextScale(new PixelConstraint(2.0F));
            key_D_text.setX(new PixelConstraint(33.0F));
            key_D_text.setY(new PixelConstraint(23.0F));
            key_D_text.setColor(getColor("D"));
            window.addChild(key_D_text);

            window.draw();
        }
    }
}
