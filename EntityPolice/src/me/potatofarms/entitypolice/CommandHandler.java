package me.potatofarms.entitypolice;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class CommandHandler implements CommandExecutor
{
   private final EntityPolice plugin;
   //private final CSIconfigHandler cHandler;

   public CommandHandler(EntityPolice plugin/*, CSIconfigHandler cHandler*/)
   {
      this.plugin = plugin;
      //this.cHandler = cHandler;
   }

   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
   {
      Player player = null;
      if (sender instanceof Player) 
      {
         player = (Player) sender;
      }

      if (commandLabel.equalsIgnoreCase("entitypolice")
            || commandLabel.equalsIgnoreCase("ep"))
      {
         entityCounter ec = new entityCounter();
         entityRemover er = new entityRemover();
         String subCommand = args.length > 0 ? args[0].toLowerCase() : "";

         if (subCommand.equalsIgnoreCase("count"))
         {
            if (sender.hasPermission("entitypolice.count"))
            {

               // /entitypolice count
               String entityName = args.length >= 2 ? args[1].toLowerCase() : "";
               String worldName = args.length == 3 ? args[2].toLowerCase() : "";
               PluginDescriptionFile pdffile = plugin.getDescription();

               if (args.length >= 2)
               {
                  if(null != player)
                  {
                     String count = ec.countEntity(player, entityName, worldName, pdffile.getName(), args);
                     sender.sendMessage(count);
                  }
                  return true;
               }
               else
               {
                  return false;
               }
            }
            else
            {
               sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
               return true;
            }

         }
         else if (subCommand.equalsIgnoreCase("remove"))
         {
            if (sender.hasPermission("entitypolice.remove"))
            {

               // /entitypolice count
               String entityName = args.length >= 2 ? args[1].toLowerCase() : "";
               String worldName = args.length == 3 ? args[2].toLowerCase() : "";
               PluginDescriptionFile pdffile = plugin.getDescription();

               if (args.length >= 2)
               {
                  if(null != player)
                  {
                     String remove = er.removeEntities(player, entityName, worldName, pdffile.getName(), args);
                     sender.sendMessage(remove);
                  }
                  return true;
               } 
               else
               {
                  return false;
               }
            }
            else
            {
               sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
               return true;
            }
         }
         else if (subCommand.equalsIgnoreCase("countnear"))
         {
            if (sender.hasPermission("entitypolice.countnear"))
            {
               // TODO Abfragen sicher machen! Kommt ne Exception wenn Parameter fehlen, weil er sie benutzt, auch wenn sie garnicht gesetzt wurden!
               // Daemliche ?-syntax aendern in normale syntax und Logik!
               entityCounterNear ecn = new entityCounterNear();
               String playerName = args.length >= 1 ? args[1] : "";
               Player playerC = Bukkit.getServer().getPlayer(playerName);
               String mobName = args.length >= 2 ? args[2] : "";
               String sr = args.length >= 3 ? args[3] : "";

               double x = Double.valueOf(sr);
               double y = Double.valueOf(sr);
               double z = Double.valueOf(sr);
               PluginDescriptionFile pdffile = plugin.getDescription();

               if(null != playerC)
               {
                  String countnear = ecn.countEntitiesNear(playerC, x, y, z, mobName, pdffile.getName());
                  sender.sendMessage(countnear);
               }
               else
               {
                  sender.sendMessage(ChatColor.YELLOW + "Dieser Spieler ist nicht online.");
               }
               return true;
            }
            else
            {
               sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
               return true;
            }
         }
         else if (subCommand.equalsIgnoreCase("removenear"))
         {
            if (sender.hasPermission("entitypolice.removenear"))
            {
               // TODO Abfragen sicher machen! Kommt ne Exception wenn Parameter fehlen, weil er sie benutzt, auch wenn sie garnicht gesetzt wurden!
               // Daemliche ?-syntax aendern in normale syntax und Logik!
               entityRemoverNear ern = new entityRemoverNear();
               String playerName = args.length >= 1 ? args[1] : "";
               Player playerC = Bukkit.getServer().getPlayer(playerName);
               String mobName = args.length >= 2 ? args[2] : "";
               String sr = args.length >= 3 ? args[3] : "";
               double x = Double.valueOf(sr);
               double y = Double.valueOf(sr);
               double z = Double.valueOf(sr);
               PluginDescriptionFile pdffile = plugin.getDescription();

               if(null != playerC)
               {
                  String countnear = ern.removeEntitiesNear(playerC, x, y, z, mobName, pdffile.getName());
                  sender.sendMessage(countnear);}
               else
               {
                  sender.sendMessage(ChatColor.YELLOW + "Dieser Spieler ist nicht online.");
               }
               return true;
            }
            else
            {
               sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
               return true;
            }

         }
         else if (subCommand.equalsIgnoreCase("help"))
         {
            if (sender.hasPermission("entitypolice.help"))
            {
               sender.sendMessage(ChatColor.GOLD + "EntityPolice Help:");
               sender.sendMessage(ChatColor.GOLD + "Commands:");
               sender.sendMessage(ChatColor.BLUE + "/entitypolice"
                     + ChatColor.AQUA
                     + " count <mob> <(optional) world>"
                     + ChatColor.YELLOW
                     + " - Returns the number of <mob> in <world>");
               sender.sendMessage(ChatColor.BLUE
                     + "/entitypolice"
                     + ChatColor.AQUA
                     + " remove <mob> <(optional) world>"
                     + ChatColor.YELLOW
                     + " - Removes all the mobs of type <mob> in <world>");
               sender.sendMessage(ChatColor.BLUE
                     + "/entitypolice"
                     + ChatColor.AQUA
                     + " removenear <player> <mob> <radius>"
                     + ChatColor.YELLOW
                     + " - Removes all mobs of type <mob> around player <player> within the radius of <radius>");
               sender.sendMessage(ChatColor.BLUE
                     + "/entitypolice"
                     + ChatColor.AQUA
                     + " countnear <player> <mob> <radius>"
                     + ChatColor.YELLOW
                     + " - Counts all mobs of type <mob> around player <player> within the radius of <radius>");
               return true;
            }
            else
            {
               sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
               return true;
            }
         }

      }
      return false;
   }

}
