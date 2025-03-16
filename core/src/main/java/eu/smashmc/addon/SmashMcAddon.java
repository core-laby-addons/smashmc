package eu.smashmc.addon;

import eu.smashmc.addon.badges.SmashNameTag;
import eu.smashmc.addon.enums.SmashRank;
import eu.smashmc.addon.util.SmashPlayer;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.client.entity.player.tag.PositionType;
import net.labymod.api.models.addon.annotation.AddonMain;
import java.util.UUID;

@AddonMain
public class SmashMcAddon extends LabyAddon<SmashMcConfiguration> {

  private static SmashMcAddon instance;

  @Override
  protected void enable() {
    this.registerSettingCategory();
    instance = this;

    SmashPlayer.rankCache.put(UUID.fromString("966b5d5e-2577-4ab7-987a-89bfa59da74a"), SmashRank.ADMIN);

    labyAPI().tagRegistry().registerAfter("labymod_role", "smashmc_text", PositionType.ABOVE_NAME, new SmashNameTag(this));

    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<SmashMcConfiguration> configurationClass() {
    return SmashMcConfiguration.class;
  }

  public static SmashMcAddon instance() {
    return instance;
  }

}
