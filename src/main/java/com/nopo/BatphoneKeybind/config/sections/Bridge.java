package com.nopo.BatphoneKeybind.config.sections;

import com.google.gson.annotations.Expose;
import com.nopo.BatphoneKeybind.core.config.annotations.ConfigEditorBoolean;
import com.nopo.BatphoneKeybind.core.config.annotations.ConfigEditorDropdown;
import com.nopo.BatphoneKeybind.core.config.annotations.ConfigOption;

public class Bridge {
    @Expose
    @ConfigOption(
            name = "Enable Bridge Bot",
            desc = "Turns on custom bridge bot"
    )
    @ConfigEditorBoolean
    public boolean bridgeBot = true;

    @Expose
    @ConfigOption(
            name = "Bridge Name Color",
            desc = "Change the color of the name of the user"
    )
    @ConfigEditorDropdown(
            values = {"Black", "Dark Blue", "Dark Green", "Dark Aqua", "Dark Red", "Dark Purple", "Gold",
                    "Gray", "Dark Gray", "Blue", "Green", "Aqua", "Red", "Light Purple", "Yellow", "White"}
    )
    public int bridgePrefixColor = 11;

    @Expose
    @ConfigOption(
            name = "Bridge Name Color",
            desc = "Change the color of the name of the user"
    )
    @ConfigEditorDropdown(
            values = {"Black", "Dark Blue", "Dark Green", "Dark Aqua", "Dark Red", "Dark Purple", "Gold",
                    "Gray", "Dark Gray", "Blue", "Green", "Aqua", "Red", "Light Purple", "Yellow", "White"}
    )
    public int bridgeNameColor = 11;
}
