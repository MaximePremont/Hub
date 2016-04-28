package net.samagames.hub.games.types;

import net.samagames.hub.Hub;
import net.samagames.hub.games.AbstractGame;
import net.samagames.hub.games.shops.ShopCategory;
import net.samagames.hub.games.shops.ShopImprovableItem;
import net.samagames.tools.RulesBook;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UppervoidGame extends AbstractGame
{
    public UppervoidGame(Hub hub)
    {
        super(hub);
    }

    @Override
    public String getCodeName()
    {
        return "uppervoid";
    }

    @Override
    public String getName()
    {
        return "Uppervoid";
    }

    @Override
    public String getCategory()
    {
        return "Seul contre tous";
    }

    @Override
    public ItemStack getIcon()
    {
        return new ItemStack(Material.STICK, 1);
    }

    @Override
    public String[] getDescription()
    {
        return new String[] {
                "Affrontez les autres joueurs dans",
                "une arène. Faites-les tomber dans le",
                "vide à l'aide de vos impitoyables",
                "TNT's, mais gare à ne pas tomber",
                "à votre tour !"
        };
    }

    @Override
    public String[] getDevelopers()
    {
        return new String[] {
                "IamBlueSlime",
                "Silvanosky"
        };
    }

    @Override
    public RulesBook[] getRulesBooks()
    {
        return null;
    }

    @Override
    public int getSlotInMainMenu()
    {
        return 20;
    }

    @Override
    public ShopCategory getShopConfiguration()
    {
        ShopCategory parentCategory = new ShopCategory(this.hub, this, null, null, null, -1, null);

        ShopImprovableItem tntStick = new ShopImprovableItem(this.hub, this, "shooter", "Shooter", new ItemStack(Material.STICK, 1), 13, new String[] {
                "Augmentez la qualité de votre shooter, donc",
                "son temps de rechargement en augmentant cette",
                "amélioration."
        });

        tntStick.addDefault("Basic (2s)");
        tntStick.addLevel(10000, "ChaosGrabber (1.7s)", "chaosgrabber");
        tntStick.addLevel(50000, "BladeSpinner (1.5s)", "bladespinner");

        parentCategory.addContent(tntStick);

        ShopImprovableItem grenadesItem = new ShopImprovableItem(this.hub, this, "grenade", "Grenades", new ItemStack(Material.CLAY_BALL, 1), 30, new String[] {
                "Augmentez votre nombre de grenades",
                "en jeu en augmentant cette amélioration.",
        });

        grenadesItem.addDefault("1 grenade");
        grenadesItem.addLevel(550, "2 grenades", "grenade-1");
        grenadesItem.addLevel(2100, "3 grenades", "grenade-2");
        grenadesItem.addLevel(5300, "4 grenades", "grenade-3");
        grenadesItem.addLevel(19800, "5 grenades", "grenade-4");
        grenadesItem.addLevel(50000, "6 grenades", "grenade-5");

        parentCategory.addContent(grenadesItem);

        ShopImprovableItem grapnelItem = new ShopImprovableItem(this.hub, this, "grapin", "Grapin", new ItemStack(Material.LEASH, 1), 32, new String[] {
                "Augmentez le nombre d'utilisations de votre",
                "grapin en augmentant cette amélioration.",
        });

        grapnelItem.addDefault("1 utilisation");
        grapnelItem.addLevel(550, "2 utilisations", "grapin-1");
        grapnelItem.addLevel(2100, "3 utilisations", "grapin-2");
        grapnelItem.addLevel(53000, "4 utilisations", "grapin-3");
        grapnelItem.addLevel(19800, "5 utilisations", "grapin-4");

        parentCategory.addContent(grapnelItem);

        return parentCategory;
    }

    @Override
    public Location getLobbySpawn()
    {
        return new Location(this.hub.getWorld(), -7D, 83.0D, 67D, 0.0F, 0.0F);
    }

    @Override
    public boolean isGroup()
    {
        return false;
    }

    @Override
    public boolean isLocked()
    {
        return false;
    }

    @Override
    public boolean isNew()
    {
        return false;
    }
}
