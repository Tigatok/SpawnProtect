package com.acrotm.spawnprotect;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Tyler Marshall
 * --- 08/03/16 ---
 * -SpawnProtect)-
 */
public class SpawnProtect extends JavaPlugin implements Listener {

  private YamlConfiguration config;
  @Override
  public void onEnable(){
    Bukkit.getPluginManager().registerEvents(this, this);
  }

  @EventHandler
  public void onBlockBreakEvent(BlockBreakEvent event){
    Location spawnLocation = Bukkit.getWorld("world").getSpawnLocation();
    Player player = event.getPlayer();
    if( (player.getLocation().getX() >= spawnLocation.getX()- 10  && player.getLocation().getX() <= spawnLocation.getX() + 10 )  && (player.getLocation().getZ() >= spawnLocation.getZ() - 10 && player.getLocation().getZ() <= spawnLocation.getZ() + 10)) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onBlockPlaceEvent(BlockPlaceEvent event){
    Location spawnLocation = Bukkit.getWorld("world").getSpawnLocation();
    Player player = event.getPlayer();
    if( (player.getLocation().getX() >= spawnLocation.getX()- 10  && player.getLocation().getX() <= spawnLocation.getX() + 10 )  && (player.getLocation().getZ() >= spawnLocation.getZ() - 10 && player.getLocation().getZ() <= spawnLocation.getZ() + 10)) {
      event.setCancelled(true);
    }
  }
}
