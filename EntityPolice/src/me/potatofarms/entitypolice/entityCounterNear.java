package me.potatofarms.entitypolice;

import org.bukkit.ChatColor;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Golem;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Monster;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Squid;

public class entityCounterNear
{
   public String countEntitiesNear(Player playerC, double sr, String entityName, String pluginName)
   {
      Integer all = 0;

      double x = sr;
      double y = sr;
      double z = sr;
      
      Boolean validEntityName = false;
      for (EntityNames en : EntityNames.values())
      {
         String theName = en.getName();
         if (theName.equalsIgnoreCase(entityName))
         {
            validEntityName = true;
         }
         else
         {
            continue;
         }
         continue;
      }
      
      // TODO Befehl machen der das alles für ALLE Spieler durchzaehlt und nach Spieler sortiert ausgibt o.ae.
      
      if (validEntityName == true
            && !entityName.equalsIgnoreCase("monster")
            && !entityName.equalsIgnoreCase("animal")
            && !entityName.equalsIgnoreCase("mob")
            && !entityName.equalsIgnoreCase("squid")
            && !entityName.equalsIgnoreCase("PigZombie")
            && !entityName.equalsIgnoreCase("MagmaCube")
            && !entityName.equalsIgnoreCase("MushroomCow")
            && !entityName.equalsIgnoreCase("IronGolem")
            && !entityName.equalsIgnoreCase("Golem")
            && !entityName.equalsIgnoreCase("Enderman"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f.getType().toString().equalsIgnoreCase(entityName))
            {
               all++;
               continue;
            }
         }
      }
      else if (validEntityName == true
            && entityName.equalsIgnoreCase("monster"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f instanceof Monster)
            {
               all++;
            }
         }
      }
      else if (validEntityName == true
            && entityName.equalsIgnoreCase("animal"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f instanceof Animals)
            {
               all++;
            }
         }
      }
      else if (validEntityName == true
            && entityName.equalsIgnoreCase("mob"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f instanceof Animals)
            {
               all++;
               continue;
            }
            else if (f instanceof Monster)
            {
               all++;
               continue;

            }
            else if (f instanceof Squid)
            {
               all++;
               continue;

            }
         }
      }
      else if (validEntityName == true
            && entityName.equalsIgnoreCase("squid"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f instanceof Squid)
            {
               all++;
            }
         }
      }
      else if (validEntityName == true
            && entityName.equalsIgnoreCase("PigZombie"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f instanceof PigZombie)
            {
               all++;
            }
         }
      }
      else if (validEntityName == true
            && entityName.equalsIgnoreCase("MushroomCow"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f instanceof MushroomCow)
            {
               all++;
            }
         }
      }
      else if (validEntityName == true
            && entityName.equalsIgnoreCase("PigZombie"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f instanceof Monster)
            {
               all++;
            }
         }
      }
      else if (validEntityName == true
            && entityName.equalsIgnoreCase("PigZombie"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f instanceof Monster) {
               all++;
            }
         }
      }
      else if (validEntityName == true
            && entityName.equalsIgnoreCase("MagmaCube"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f instanceof MagmaCube)
            {
               all++;
            }
         }
      }
      else if (validEntityName == true
            && entityName.equalsIgnoreCase("IronGolem"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f instanceof IronGolem)
            {
               all++;
            }
         }
      }
      else if (validEntityName == true
            && entityName.equalsIgnoreCase("Golem"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f instanceof Golem) {
               all++;
            }
         }
      }
      else if (validEntityName == true
            && entityName.equalsIgnoreCase("Enderman"))
      {
         for (Entity f : playerC.getNearbyEntities(x, y, z))
         {
            if (f instanceof Enderman)
            {
               all++;
            }
         }
      }
      else
      {
         return ChatColor.RED + "Invalid Entity.";
      }

      return ChatColor.GOLD + "[" + pluginName + "]" + ChatColor.GREEN
            + " " + ChatColor.WHITE + all.toString() + ChatColor.GREEN + " " + entityName + "s in " + ChatColor.WHITE + x + ChatColor.GREEN + " Metern um " + playerC.getName();
   }
}
