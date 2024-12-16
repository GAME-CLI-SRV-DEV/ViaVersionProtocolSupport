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
    Component Prefix = Component.text()
    .append(Component.text("ViaVersion", NamedTextColor.AQUA))
    .append(Component.text("ProtocolSupport", NamedTextColor.GRAY))
    .build();
    Bukkit.getServer().sendMessage(message);
    Component copyleft = Component.text()
    .append(Component.text("Copyright (C) 2015~2024 ", NamedTextColor.WHITE))
    .append(Component.text("A", NamedTextColor.RED))
    .append(Component.text("p", NamedTextColor.GOLD))
    .append(Component.text("p", NamedTextColor.YELLOW))
    .append(Component.text("r", NamedTextColor.GREEN))
    .append(Component.text("o", NamedTextColor.AQUA))
    .append(Component.text("x", NamedTextColor.BLUE))
    .append(Component.text("i", NamedTextColor.PURPLE))
    .append(Component.text("m", NamedTextColor.DARK_PURPLE))
    .append(Component.text("a", NamedTextColor.DARK_RED))
    .append(Component.text("s", NamedTextColor.GOLD))
    .append(Component.text("t", NamedTextColor.DARK_GREEN))
    .append(Component.text("e", NamedTextColor.DARK_AQUA))
    .append(Component.text("r", NamedTextColor.DARK_PURPLE))
    .append(Component.text(" Studios 2004, All Rights Reversed.", NamedTextColor.WHITE))
    .build();
		logger.severe("╔═══════════════════════════════════════════════════════════════════════════╗");
		logger.severe("║                               LOADING...                             ");
		logger.severe("║                                                                   ");
		logger.severe("║                                                                   ");
		logger.severe("║ ViaVersionProtocolSupport is in beta. use with caution!           ");
		logger.severe("║                                                                   ");
		logger.severe("║                                                                   ");
		logger.severe("║ https://github.com/GAME-CLI-SRV-DEV/ViaVersionProtocolSupport     ");
		logger.severe("║                                                                   ");
		logger.severe("║                                                                   ");
		logger.severe("║ Copyright (C) 2015-2024, Approximaster Studios 2004, All Rights Reversed.");
		logger.severe("╚═══════════════════════════════════════════════════════════════════════════╝");
            }
	
    @Override
	public void onEnable() {
	Component message = Component.text()
    .append(Component.text("ViaVersion", NamedTextColor.AQUA))
    .append(Component.text("ProtocolSupport", NamedTextColor.GRAY))
    .build();
    Bukkit.getServer().sendMessage(message);
	 if (Via.getManager().getInjector().lateProtocolVersionSetting()) {
            // Enable in the next tick
            Via.getPlatform().runSync(this::init, 1);
        } else {
            init();
        }
}
	
    @Override
	public void init() {
	VVPSPlatform.super.init();
    Component Prefix = Component.text()
    .append(Component.text("ViaVersion", NamedTextColor.AQUA))
    .append(Component.text("ProtocolSupport", NamedTextColor.GRAY))
    .build();
    Component loaf = Component.text()
    .append(Prefix)
    .append(Component.text("VVPS Is Loafed...", NamedTextColor.GREEN))
    .build();
	Bukkit.getServer().sendMessage(loaf);
    }
 
    @Override
	public void disable() {
		getPluginLoader().disablePlugin(this);
	}
    @Override
    public void onDisable() {
	System.out.println("By CensingSmile123 and Approximaster");
        System.out.println("이 플러그인의 저작권은 아프록시마스터 스튜디오 2004에서 만들어져 2024년 첫 버전이 제공되었으며, GNU 일반 공중 사용 허가서 v3.0에 따라 라이선스가 부여됩니다. 자세한 내용은 <https://www.gnu.org/licenses/>를 참조하십시오.");
    }
}

