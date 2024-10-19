package me.falixsrv.approximasteranarchy2004;

import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.falixsrv.approximasteranarchy2004.VVPSPlatform;

public class ViaVersionProtocolSupport {
public static void init(VVPSPlatform platform, VVPSConfig config) {
        Preconditions.checkArgument(VVPS.platform == null, "ViaVersionProtocolSupport is already initialized!");

        ViaVersionProtocolSupport.platform = platform;
        ViaBackwards.config = config;
    }

    public static ViaBackwardsPlatform getPlatform() {
        return platform;
    }

    public static ViaBackwardsConfig getConfig() {
        return config;
    }
}
