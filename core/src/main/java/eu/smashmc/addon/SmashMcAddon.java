package eu.smashmc.addon;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class SmashMcAddon extends LabyAddon<SmashMcConfiguration> {

  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<SmashMcConfiguration> configurationClass() {
    return SmashMcConfiguration.class;
  }
}
