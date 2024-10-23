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
import com.viaversion.viaversion.api.Via;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class ViaVersionProtocolSupportBukkit extends JavaPlugin {

String filePath = "config.yml";
File file = new File(filePath);

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
	Component message = Component.text()
    .append(Component.text("ViaVersion", NamedTextColor.AQUA))
    .append(Component.text("ProtocolSupport", NamedTextColor.GRAY))
    .build();
Bukkit.getServer().sendMessage(message);
        this.start();
	}

	public void start() {

        if (!file.exists()) {
            VVPSConfig.GenerateConfig();
        } else {
            System.out.println("File exists.");
	    com.viaversion.viaversion.api.Via.getManager().addEnableListener(() -> this.init(new File(getDataFolder(), "vvpsconfig.yml")));
           }
	}
    @Override
    public void disable() {
        System.out.println("Bye!");
    }
}

