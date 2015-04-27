package net.samagames.hub.commands.admin;

import com.xxmicloxx.NoteBlockAPI.NBSDecoder;
import net.samagames.hub.Hub;
import net.samagames.hub.commands.AbstractCommand;
import net.samagames.hub.cosmetics.jukebox.JukeboxDiskCosmetic;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class CommandNBS extends AbstractCommand
{
    @Override
    public boolean doAction(Player player, Command command, String s, String[] args)
    {
        if(args.length == 1)
        {
            if (new File(Hub.getInstance().getDataFolder(), "nbs" + File.separator + args[0] + ".nbs").exists())
            {
                JukeboxDiskCosmetic disk = new JukeboxDiskCosmetic("", new ItemStack(Material.RECORD_12, 1), NBSDecoder.parse(args[0]));
                Hub.getInstance().getCosmeticManager().getJukeboxManager().play(disk, player);
            }
            else
            {
                player.sendMessage(ChatColor.RED + "Cette musique n'éxiste !");
            }
        }
        else
        {
            player.sendMessage(ChatColor.RED + "Veuiller indiquer une musique !");
        }

        return true;
    }
}