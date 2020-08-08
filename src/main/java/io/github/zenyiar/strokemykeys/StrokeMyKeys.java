package io.github.zenyiar.strokemykeys;

import io.github.zenyiar.strokemykeys.gui.StrokeMyKeysGUI;
import io.github.zenyiar.strokemykeys.modcore.ModCoreInstaller;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

/**
 * Created by Zenyiar
 */
@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class StrokeMyKeys
{
    public static StrokeMyKeysConfig strokeMyKeysConfig;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModCoreInstaller.initializeModCore(Minecraft.getMinecraft().mcDataDir);

        strokeMyKeysConfig = new StrokeMyKeysConfig();
        strokeMyKeysConfig.preload();

        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new CommandStrokeMyKeys());
    }

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (strokeMyKeysConfig.showStrokeMyKeysOverlay && Minecraft.getMinecraft().inGameHasFocus && !Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            StrokeMyKeysGui.window.draw();
        }
    }

    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event) {
        if (strokeMyKeysConfig.showStrokeMyKeysOverlay && Minecraft.getMinecraft().inGameHasFocus && !Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            StrokeMyKeysGui.window.draw();
        }
    }

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
        if (strokeMyKeysConfig.showStrokeMyKeysOverlay && Minecraft.getMinecraft().inGameHasFocus && !Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            StrokeMyKeysGui.handleKeyDown(Keyboard.getEventKey());
            StrokeMyKeysGui.update();
        }
    }
}
