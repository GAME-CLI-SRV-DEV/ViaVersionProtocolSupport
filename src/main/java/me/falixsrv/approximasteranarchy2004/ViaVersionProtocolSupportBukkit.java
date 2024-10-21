package me.falixsrv.approximasteranarchy2004;

import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.falixsrv.approximasteranarchy2004.api.VVPSPlatform;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ViaVersionProtocolSupportBukkit extends JavaPlugin {


	@Override
	public void onLoad() {
    Logger logger = getLogger();
		logger.severe("╔══════════════════════════════════════════════════════════════════╗");
		logger.severe("║                               WARNING                             ");
		logger.severe("║                                                                   ");
		logger.severe("║                                                                   ");
		logger.severe("║ ViaVersionProtocolSupport is in beta. use with caution!           ");
		logger.severe("║                                                                   ");
		logger.severe("║                                                                   ");
		logger.severe("║ https://github.com/GAME-CLI-SRV-DEV/ViaVersionProtocolSupport     ");
		logger.severe("╚══════════════════════════════════════════════════════════════════╝");
            }
	@Override
	public void onEnable() {
	Via.getManager().addEnableListener(() -> this.init(new File(getDataFolder(), "config.yml")));
	Component message = Component.text()
    .append(Component.text("ViaVersion", NamedTextColor.AQUA))
    .append(Component.text("ProtocolSupport", NamedTextColor.GRAY))
    .build();
Bukkit.getServer().sendMessage(message);
	}


    @Override
    public void disable() {
        
    }
}

