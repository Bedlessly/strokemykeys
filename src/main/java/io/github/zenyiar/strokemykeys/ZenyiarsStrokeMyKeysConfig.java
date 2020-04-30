package io.github.zenyiar.strokemykeys;

import club.sk1er.vigilance.Vigilant;
import club.sk1er.vigilance.data.Property;
import club.sk1er.vigilance.data.PropertyType;

import java.io.File;

/**
 * Created by Zenyiar
 */
public class ZenyiarsStrokeMyKeysConfig extends Vigilant 
{
    // General
    @Property(
        type = PropertyType.SWITCH,
        name = "Show Overlay GUI",
        description = "Shows the Stroke My Keys Overlay GUI when playing. (Enabled by default)",
        category = "General",
        subcategory = "General"
    )
    public static boolean showStrokeMyKeysOverlay = true;

    // Initialize
    public ZenyiarsStrokeMyKeysConfig() {
        super(new File("./config/" + Reference.MODID + ".toml"));
        initialize();
    }
}

