package net.samagames.hub.games.shop;

import net.samagames.hub.Hub;
import net.samagames.hub.games.AbstractGame;
import net.samagames.hub.gui.shop.GuiShopCategory;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ShopCategory extends ShopIcon
{
    private final AbstractGame game;
    private final String[] description;
    private final ArrayList<ShopIcon> contents;

    public ShopCategory(AbstractGame game, String actionName, String displayName, ItemStack icon, String[] description)
    {
        super(actionName, displayName, icon);

        this.game = game;
        this.description = description;
        this.contents = new ArrayList<>();
    }

    public void addContent(ShopIcon icon)
    {
        this.contents.add(icon);
    }

    @Override
    public void execute(Player player, ClickType clickType)
    {
        Hub.getInstance().getGuiManager().openGui(player, new GuiShopCategory(this.game, this, Hub.getInstance().getGuiManager().getPlayerGui(player)));
    }

    @Override
    public ItemStack getFormattedIcon(Player player)
    {
        ItemStack icon = this.getIcon();
        ItemMeta meta =  icon.getItemMeta();
        ArrayList<String> lores = new ArrayList<>();

        for(String str : this.description)
            lores.add(ChatColor.GRAY + str);

        meta.setLore(lores);
        icon.setItemMeta(meta);

        return icon;
    }

    public ShopIcon getIconByAction(String action)
    {
        for(ShopIcon icon : this.contents)
            if(icon.getActionName().equals(action))
                return icon;

        return null;
    }

    public ArrayList<ShopIcon> getContents()
    {
        return this.contents;
    }
}