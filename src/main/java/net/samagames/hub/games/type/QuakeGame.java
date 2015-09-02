package net.samagames.hub.games.type;

import net.samagames.hub.Hub;
import net.samagames.hub.games.AbstractGame;
import net.samagames.hub.games.DisplayedStat;
import net.samagames.hub.games.shop.ShopCategory;
import net.samagames.hub.games.shop.ShopDependsItem;
import net.samagames.hub.games.shop.ShopImprovableItem;
import net.samagames.tools.GlowEffect;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class QuakeGame extends AbstractGame
{
    @Override
    public String getCodeName()
    {
        return "quake";
    }

    @Override
    public String getName()
    {
        return "Quake";
    }

    @Override
    public ItemStack getIcon()
    {
        return new ItemStack(Material.DIAMOND_HOE, 1);
    }

    @Override
    public String[] getDescription()
    {
        return new String[] {
                "Prochainement..."
        };
    }

    @Override
    public int getSlotInMainMenu()
    {
        return 24;
    }

    @Override
    public ShopCategory getShopConfiguration()
    {
        ShopCategory parentCategory = new ShopCategory(this, null, null, null, -1, null);

        ShopCategory hoes = new ShopCategory(this, "hoeMenu", "Houes", new ItemStack(Material.DIAMOND_HOE, 1), 21, new String[] {
                "Améliorez votre hoe !",
                "Ne ratez plus vos adversaires par manque de temps.",
        });

        ShopDependsItem woodenHoe = new ShopDependsItem(this, "hoe", "woodhoe", "SlowGun", new ItemStack(Material.WOOD_HOE), 31, new String[]{
                ChatColor.DARK_GRAY + "Recharge en " + ChatColor.GOLD + "1.8" + ChatColor.DARK_GRAY + " secondes."
        }, 0, null);
        woodenHoe.setDefaultItem(true);
        hoes.addContent(woodenHoe);

        ShopDependsItem stoneHoe = new ShopDependsItem(this, "hoe", "stonehoe", ChatColor.DARK_AQUA + "Advanced SlowGun", new ItemStack(Material.STONE_HOE, 1), 20, new String[]{
                ChatColor.DARK_GRAY + "Recharge en " + ChatColor.GOLD + "1.7" + ChatColor.DARK_GRAY + " secondes."
        }, 500, woodenHoe);
        hoes.addContent(stoneHoe);

        ShopDependsItem ironHoe = new ShopDependsItem(this, "hoe", "ironhoe", ChatColor.DARK_AQUA + "Quick Gun", new ItemStack(Material.IRON_HOE, 1), 21, new String[]{
                ChatColor.DARK_GRAY + "Recharge en " + ChatColor.GOLD + "1.6" + ChatColor.DARK_GRAY + " secondes."
        }, 2000, stoneHoe);
        hoes.addContent(ironHoe);

        ShopDependsItem goldHoe = new ShopDependsItem(this, "hoe", "goldenhoe", ChatColor.GOLD + "Golden Gun", new ItemStack(Material.GOLD_HOE, 1), 22, new String[]{
                ChatColor.DARK_GRAY + "Recharge en " + ChatColor.GOLD + "1.5" + ChatColor.DARK_GRAY + " secondes."
        }, 5000, ironHoe);
        hoes.addContent(goldHoe);

        ShopDependsItem diamondHoe = new ShopDependsItem(this, "hoe", "dimaondhoe", ChatColor.BLUE + "PortalGun", new ItemStack(Material.DIAMOND_HOE, 1), 23, new String[]{
                ChatColor.DARK_GRAY + "Recharge en " + ChatColor.GOLD + "1.4" + ChatColor.DARK_GRAY + " secondes."
        }, 20000, goldHoe);
        hoes.addContent(diamondHoe);

        ShopDependsItem amazingHoe = new ShopDependsItem(this, "hoe", "amazinghoe", ChatColor.AQUA + "Amazing" + ChatColor.BLUE + " PortalGun", GlowEffect.addGlow(new ItemStack(Material.DIAMOND_HOE, 1)), 24, new String[]{
                ChatColor.DARK_GRAY + "Recharge en " + ChatColor.GOLD + "1.3" + ChatColor.DARK_GRAY + " secondes."
        }, 50000, diamondHoe);
        hoes.addContent(amazingHoe);

        ShopDependsItem blasterHoe = new ShopDependsItem(this, "hoe", "blaster", ChatColor.AQUA + "Blaster", GlowEffect.addGlow(new ItemStack(Material.DIAMOND_BARDING, 1)), 13, new String[]{
                ChatColor.DARK_GRAY + "Recharge en " + ChatColor.GOLD + "1.2" + ChatColor.DARK_GRAY + " secondes."
        }, 150000, amazingHoe);
        hoes.addContent(blasterHoe);

        parentCategory.addContent(hoes);


        ShopImprovableItem grenadeItem = new ShopImprovableItem(this, "grenade", "Grenades", new ItemStack(Material.CLAY_BALL, 1), 23, new String[] {
                "Lancez des grenades explosives !"
        });

        grenadeItem.addDefault("1 Grenade");
        grenadeItem.addLevel(600, "2 Grenades", "fragrenade-1");
        grenadeItem.addLevel(2000, "3 Grenades", "fragrenade-2");
        grenadeItem.addLevel(5000, "4 Grenades", "fragrenade-3");
        grenadeItem.addLevel(10000, "5 Grenades", "fragrenade-4");
        grenadeItem.addLevel(20000, "5 Grenades", "fragrenade-5");

        parentCategory.addContent(grenadeItem);

        return parentCategory;
    }

    @Override
    public ArrayList<DisplayedStat> getDisplayedStats()
    {
        ArrayList<DisplayedStat> stats = new ArrayList<>();

        stats.add(new DisplayedStat("wins", "Victoires", Material.NETHER_STAR));
        stats.add(new DisplayedStat("kill", "Joueurs tués", new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal())));
        stats.add(new DisplayedStat("death", "Morts", Material.BONE));
        stats.add(new DisplayedStat("shot", "Tirs", Material.DIAMOND_HOE));
        stats.add(new DisplayedStat("played_games", "Parties jouées", Material.SIGN));

        return stats;
    }

    @Override
    public Location getLobbySpawn()
    {
        return new Location(Hub.getInstance().getHubWorld(), 5.5D, 92.0D, 115.5D, 90.0F, 0.0F);
    }

    @Override
    public boolean isLocked()
    {
        return false;
    }
}
