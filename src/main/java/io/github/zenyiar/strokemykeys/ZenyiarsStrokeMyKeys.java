package io.github.zenyiar.strokemykeys;

import io.github.zenyiar.strokemykeys.gui.StrokeMyKeysGui;
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
public class ZenyiarsStrokeMyKeys
{
    public static ZenyiarsStrokeMyKeysConfig zenyiarsStrokeMyKeysConfig;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModCoreInstaller.initializeModCore(Minecraft.getMinecraft().mcDataDir);

        zenyiarsStrokeMyKeysConfig = new ZenyiarsStrokeMyKeysConfig();
        zenyiarsStrokeMyKeysConfig.preload();

        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new CommandStrokeMyKeys());
    }

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (ZenyiarsStrokeMyKeysConfig.showStrokeMyKeysOverlay && Minecraft.getMinecraft().inGameHasFocus && !Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            StrokeMyKeysGui.window.draw();
        }
    }

    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event) {
        if (ZenyiarsStrokeMyKeysConfig.showStrokeMyKeysOverlay && Minecraft.getMinecraft().inGameHasFocus && !Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            StrokeMyKeysGui.window.draw();
        }
    }

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
        StrokeMyKeysGui.handleKeyDown(Keyboard.getEventKey());
        StrokeMyKeysGui.update();
    }
}
