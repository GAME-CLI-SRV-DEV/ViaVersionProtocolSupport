/*
 * This file is Ported for ViaLegacy
 * From ViaBackwards 
 */

package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.api;

import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaVersionProtocolSupportMain;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.VVPSConfig;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.api.rewriters.TranslatableRewriter;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.protocol.r1_7_2tor1_6_4.Protocolr1_7_2_5tor1_6_4;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.utils.VersionInfo;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.ProtocolManager;
import net.raphimc.vialegacy.api.LegacyProtocolVersion;
import com.viaversion.viaversion.update.Version;
import java.io.File;
import java.util.Arrays;
import java.util.logging.Logger;

public interface VVPSPlatform {

    String MINIMUM_VV_VERSION = "5.0.4";

    /**
     * Initialize ViaVersionProtocolSupport
	 *
     */
    default void init(final File configFile) {
        VVPSConfig config = new VVPSConfig(configFile, getLogger());
        config.reload();
        Via.getManager().getConfigurationProvider().register(config);

        ViaBackwards.init(this, config);

        if (isOutdated()) {
            disable();
            return;
        }

        Via.getManager().getSubPlatforms().add(VersionInfo.getImplementationVersion());

        getLogger().info("Loading translations...");
        TranslatableRewriter.loadTranslatables();

        getLogger().info("Registering protocols...");
        final ProtocolManager protocolManager = Via.getManager().getProtocolManager();
        protocolManager.registerProtocol(new Protocolr1_7_2_5To1_6_4(), LegacyProtocolVersion.v1_6_4, LegacyProtocolVersion.v1_7_2_5);
    }

    /**
     * Logger provided by the platform.
     *
     * @return logger instance
     */
    Logger getLogger();

    default boolean isOutdated() {
        String vvVersion = Via.getPlatform().getPluginVersion();
        if (vvVersion != null && new Version(vvVersion).compareTo(new Version(MINIMUM_VV_VERSION + "--")) < 0) {
		    getLogger().severe("╔══════════════════════════════════════════════════════════════════╗");
		    getLogger().severe("║               FATAL ERROR - Platform Outdated               ");
		    getLogger().severe("║                                                                   ");
		    getLogger().severe("║ Your ViaVersion, Backwards, Rewind is Outdated                    ");
		    getLogger().severe("║ Please Use ViaVersion + ViaBackwards " + MINIMUM_VV_VERSION + "or higher");
			getLogger().severe("║ If You Are Using ViaVersion On ViaLoader Follow these steps:");
			getLogger().severe("║ ViaProxy: Override it using JAR(Not Yet Supported)");
			getLogger().severe("║ ViaVersionProtocolSupport Will Now Shutdown...");
		    getLogger().severe("╚══════════════════════════════════════════════════════════════════╝");
            return true;
        }
        return false;
    }

    /**
     * Disable the plugin.
     */
    void disable();

    /**
     * Returns ViaBackwards's data folder.
     *
     * @return data folder
     */
    File getDataFolder();
}
