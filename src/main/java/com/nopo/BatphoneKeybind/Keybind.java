package com.nopo.BatphoneKeybind;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import java.util.List;

public class Keybind {

    static String lastMaddoxCommand = "/cb placeholder";
    static double lastMaddoxTime = 0;

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String message = StringUtils.stripControlCodes(event.message.getUnformattedText());

        //if (message.contains(":")) return;

        System.out.println(message);

        if (message.contains("[OPEN MENU]")) {
            List<IChatComponent> listOfSiblings = event.message.getSiblings();
            for (IChatComponent sibling : listOfSiblings) {
                if (sibling.getUnformattedText().contains("[OPEN MENU]")) {
                    lastMaddoxCommand = sibling.getChatStyle().getChatClickEvent().getValue();
                    lastMaddoxTime = System.currentTimeMillis() / 1000;
                }
            }
        }
    }


    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event) {
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        if (BatphoneKeybind.keyBindings[0].isPressed()) {
            player.sendChatMessage(lastMaddoxCommand);
        }
    }

}