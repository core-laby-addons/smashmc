package eu.smashmc.addon.util;

import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.resources.ResourceLocation;

public class SmashTextures {

  public static class Common {

    public static final Icon ICON;

    static {
      ICON = Icon.texture(ResourceLocation.create("smashmc", "textures/icon.png"));
    }

  }

}
