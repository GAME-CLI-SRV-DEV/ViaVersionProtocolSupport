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
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.GLOBAL.VVPSBootstrap;

public class ViaVersionProtocolSupportBukkit extends JavaPlugin {

String filePath = "config.yml";
File file = new File(filePath);

    public void onLoad() {
	System.out.println("Please Ignore the warning from Bukkit");
	System.out.println("We Use STDOUT. STDOUT FOREVER.");
	System.out.println("Loading the Platform");
        Via.getManager().addEnableListener(VVPSBootstrap::new);
    }

	
    @Override
	public void onEnable() {
    Component message = Component.text()
    .append(Component.text("ViaVersion", NamedTextColor.AQUA))
    .append(Component.text("ProtocolSupport", NamedTextColor.GRAY))
    .build();
    Logger logger = getLogger();
    Bukkit.getServer().sendMessage(message);
    Component copyleft = Component.text()
    .append(Component.text("Copyright (C) 2015~2024 ", NamedTextColor.WHITE))
    .append(Component.text("A", NamedTextColor.RED))
    .append(Component.text("p", NamedTextColor.GOLD))
    .append(Component.text("p", NamedTextColor.YELLOW))
    .append(Component.text("r", NamedTextColor.GREEN))
    .append(Component.text("o", NamedTextColor.AQUA))
    .append(Component.text("x", NamedTextColor.BLUE))
    .append(Component.text("i", NamedTextColor.LIGHT_PURPLE))
    .append(Component.text("m", NamedTextColor.DARK_PURPLE))
    .append(Component.text("a", NamedTextColor.DARK_RED))
    .append(Component.text("s", NamedTextColor.GOLD))
    .append(Component.text("t", NamedTextColor.DARK_GREEN))
    .append(Component.text("e", NamedTextColor.DARK_AQUA))
    .append(Component.text("r", NamedTextColor.DARK_PURPLE))
    .append(Component.text(" Studios 2004, All Rights Reversed.", NamedTextColor.WHITE))
    .build();
    Bukkit.getServer().sendMessage(copyleft);
		logger.severe("╔═══════════════════════════════════════════════════════════════════════════╗");
		logger.severe("║                               LOADING...                             ");
		logger.severe("║                                                                   ");
		logger.severe("║                                                                   ");
		logger.severe("║ ViaVersionProtocolSupport is in beta. use with caution!           ");
		logger.severe("║ ViaVersionProtocolSupport는 베타 버전입니다. 테스트 후 사용하세요.   ");
		logger.severe("║                                                                   ");
		logger.severe("║ https://github.com/GAME-CLI-SRV-DEV/ViaVersionProtocolSupport     ");
		logger.severe("║                                                                   ");
		logger.severe("║                                                                   ");
		logger.severe("║ Copyright (C) 2015-2024, Approximaster Studios 2004, All Rights Reversed.");
		logger.severe("╚═══════════════════════════════════════════════════════════════════════════╝");
    Bukkit.getServer().sendMessage(message);
}
}

