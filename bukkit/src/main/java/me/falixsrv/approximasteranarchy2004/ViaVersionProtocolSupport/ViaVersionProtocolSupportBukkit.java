package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport;

import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.api.VVPSPlatform;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import com.viaversion.viaversion.api.Via;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class ViaVersionProtocolSupportBukkit extends JavaPlugin implements VVPSPlatform {

String filePath = "config.yml";
File file = new File(filePath);

    public void BukkitPlugin() {
        Via.getManager().addEnableListener(() -> init());
    }
	
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
	}
    @Override
	public void init()
	VVPSPlatform.super.init();

        final ProtocolVersion protocolVersion = Via.getAPI().getServerVersion().highestSupportedProtocolVersion();
        if (protocolVersion.newerThanOrEqualTo(ProtocolVersion.v1_17)) {
            new PlayerItemDropListener(this).register();
        }
        if (protocolVersion.newerThanOrEqualTo(ProtocolVersion.v1_16)) {
            new FireExtinguishListener(this).register();
        }
        if (protocolVersion.newerThanOrEqualTo(ProtocolVersion.v1_14)) {
            new LecternInteractListener(this).register();
        }
        if (protocolVersion.newerThanOrEqualTo(ProtocolVersion.v1_12)) {
            new FireDamageListener(this).register();
        }
        if (protocolVersion.newerThanOrEqualTo(ProtocolVersion.v1_11)) {
            new BlockBreakListener(this).register();
        }

        final ViaProviders providers = Via.getManager().getProviders();
        if (protocolVersion.newerThanOrEqualTo(ProtocolVersion.v1_20_2)) {
            providers.use(AdvancementCriteriaProvider.class, new BukkitAdvancementCriteriaProvider());
        }
 
    @Override
	public void disable() {
		System.out.println("By who drank spezi");
		getPluginLoader().disablePlugin(this);
	}
    @Override
    public void onDisable() {
        System.out.println("Bye!");
    }
}

