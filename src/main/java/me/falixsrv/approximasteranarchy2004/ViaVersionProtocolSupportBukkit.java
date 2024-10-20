package me.falixsrv.approximasteranarchy2004;

import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.falixsrv.approximasteranarchy2004.VVPSPlatform;

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
	     if (Via.getManager().getInjector().lateProtocolVersionSetting()) {
            // Enable in the next tick
                       Via.getPlatform().runSync(this::enable, 1);
        } else {
            enable();
        }
    }

    private void enable() {
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
    }

    @Override
    public void disable() {
        getPluginLoader().disablePlugin(this);
    }
}

