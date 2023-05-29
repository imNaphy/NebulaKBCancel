package me.naphy;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import com.sk89q.worldguard.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;

import javax.security.auth.kerberos.KerberosTicket;

public class Events implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage (EntityDamageByEntityEvent event) {
        /*
        com.sk89q.worldguard.LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer((Player) event.getEntity());
        com.sk89q.worldedit.util.Location wgLocation = BukkitAdapter.adapt(event.getEntity().getLocation());
        com.sk89q.worldedit.world.World wgWorld = BukkitAdapter.adapt(event.getEntity().getWorld());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = container.createQuery();
        ApplicableRegionSet set = query.getApplicableRegions(wgLocation);
        for (ProtectedRegion region : set) {
            System.out.println(region.getId());
            System.out.println(region.getFlag(Flags.PVP));
            if (region.getFlag(Flags.PVP).equals("DENY")) System.out.println("TESTSUCCES!!!");
        }
        */
        if (event.isCancelled()) {
            Location loc = event.getEntity().getLocation();
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(NebulaKBCancel.plugin, () -> {
                event.getEntity().teleport(loc);
            }, 1);
        }
    }
}
