package com.nopo.BatphoneKeybind.config.sections;

import com.google.gson.annotations.Expose;
import com.nopo.BatphoneKeybind.core.config.annotations.ConfigEditorBoolean;
import com.nopo.BatphoneKeybind.core.config.annotations.ConfigOption;

public class Misc {
    @Expose
    @ConfigOption(
            name = "Use Keybind to open maddox",
            desc = "Use a keybind to open the batphone menu"
    )
    @ConfigEditorBoolean
    public boolean batPhoneKeybind = false;
}
