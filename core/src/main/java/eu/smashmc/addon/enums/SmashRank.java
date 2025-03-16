package eu.smashmc.addon.enums;

import eu.smashmc.addon.util.SmashTextures.Common;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.client.gui.icon.Icon;

public enum SmashRank {

  ADMIN(1, "admin", true, Component.text("ADMIN", NamedTextColor.DARK_RED), Common.ICON),
  STAFF(2, "staff", true, Component.text("STAFF", NamedTextColor.RED), Common.ICON);

  private final int id;
  private final String name;
  private final boolean staff;
  private final Component nameTag;
  private final Icon icon;

  SmashRank(int id, String name, boolean staff, Component nameTag, Icon icon) {
    this.id = id;
    this.name = name;
    this.staff = staff;
    this.nameTag = nameTag;
    this.icon = icon;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public boolean isStaff() {
    return staff;
  }

  public Component getNameTag() {
    return nameTag;
  }

  public Icon getIcon() {
    return icon;
  }

}
