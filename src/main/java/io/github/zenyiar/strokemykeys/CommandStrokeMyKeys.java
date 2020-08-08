package io.github.zenyiar.strokemykeys;

import club.sk1er.mods.core.ModCore;
import club.sk1er.mods.core.command.ModCoreCommand;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Bedlessly
 */
public class CommandStrokeMyKeys extends ModCoreCommand {
    @Override
    public String getCommandName() {
        return "notifpixelconfig";
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("strokemykeysmod", "smk", "smkm");
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        ModCore.getInstance().getGuiHandler().open(ZenyiarsStrokeMyKeys.zenyiarsStrokeMyKeysConfig.gui());
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}
