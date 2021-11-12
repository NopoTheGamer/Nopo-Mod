package com.nopo.BatphoneKeybind;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = "batphoneKeybind", name = "Maddox Batphone Mod", version = "1.0", clientSideOnly = true)
public class BatphoneKeybind {
    public static KeyBinding[] keyBindings = new KeyBinding[1];

    @Mod.EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new Keybind());
        keyBindings[0] = new KeyBinding("Open Maddox Menu", Keyboard.KEY_M, "Maddox mod");
        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }
    }
}
