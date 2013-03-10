package me.potatofarms.entitypolice;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class EntityPolice extends JavaPlugin {
   public final Logger logger = Logger.getLogger("Minecraft");
   public static EntityPolice plugin;
   private CommandHandler comHandler = null;

   @Override
   public void onEnable()
   {
      PluginDescriptionFile pdffile = this.getDescription();

      comHandler = new CommandHandler(this/*, cHandler*/);
      getCommand("ep").setExecutor(comHandler);

      this.logger.info(pdffile.getName() + " version " + pdffile.getVersion() + " has been enabled.");
   }

   @Override
   public void onDisable()
   {
      PluginDescriptionFile pdffile = this.getDescription();
      this.logger.info(pdffile.getName() + " has been disabled.");
   }

}