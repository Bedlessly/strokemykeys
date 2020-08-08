package io.github.zenyiar.strokemykeys;

import club.sk1er.vigilance.Vigilant;
import club.sk1er.vigilance.data.Property;
import club.sk1er.vigilance.data.PropertyType;

import java.io.File;

/**
 * Created by Bedlessly
 */
public class StrokeMyKeysConfig extends Vigilant 
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
    public StrokeMyKeysConfig() {
        super(new File("./config/" + Reference.MODID + ".toml"));
        initialize();
    }
}

