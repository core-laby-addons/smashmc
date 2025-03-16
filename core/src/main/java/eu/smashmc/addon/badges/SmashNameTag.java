package eu.smashmc.addon.badges;

import eu.smashmc.addon.SmashMcAddon;
import eu.smashmc.addon.enums.SmashRank;
import eu.smashmc.addon.util.SmashPlayer;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.client.component.format.TextDecoration;
import net.labymod.api.client.entity.Entity;
import net.labymod.api.client.entity.player.Player;
import net.labymod.api.client.entity.player.tag.tags.NameTag;
import net.labymod.api.client.render.font.RenderableComponent;
import net.labymod.api.client.render.matrix.Stack;
import org.jetbrains.annotations.Nullable;

public class SmashNameTag extends NameTag {

  private SmashMcAddon addon;

  public SmashNameTag(SmashMcAddon addon) {
    this.addon = addon;
  }

  @Override
  protected @Nullable RenderableComponent getRenderableComponent() {
    SmashRank rank = visibleRank();
    if(rank == null) return null;
    Component component = Component.text("SMASHMC ", NamedTextColor.WHITE, TextDecoration.BOLD)
        .append(rank.getNameTag());
    return RenderableComponent.of(component);
  }

  @Override
  public void render(Stack stack, Entity entity) {
    super.render(stack, entity);
    if(this.getRenderableComponent() == null) return;
    SmashRank rank = visibleRank();
    if(rank == null) return;
    this.addon.labyAPI().renderPipeline().renderSeeThrough(this.entity, () -> {
      rank.getIcon().render(
          stack,
          -11,
          -1.2F,
          11,
          11
      );
    });
  }

  @Override
  public float getScale() {
    return 0.6f;
  }

  @Override
  public boolean isVisible() {
    return !this.entity.isCrouching() && visibleRank() != null && super.isVisible();
  }

  private SmashRank visibleRank() {
    if(!(this.entity instanceof Player player)) return null;
    if(player.profile().getUniqueId() == null) return null;
    if(!this.addon.configuration().enabled().get()) return null;
    if(!SmashPlayer.rankCache.containsKey(player.profile().getUniqueId())) return null;
    return SmashPlayer.rankCache.get(player.profile().getUniqueId());
  }

}
