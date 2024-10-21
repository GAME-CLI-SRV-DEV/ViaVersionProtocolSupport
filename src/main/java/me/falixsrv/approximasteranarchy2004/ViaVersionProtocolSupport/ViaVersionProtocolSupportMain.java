package me.falixsrv.approximasteranarchy2004;

import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.falixsrv.approximasteranarchy2004.VVPSPlatform;

public class ViaVersionProtocolSupportMain {
public static void init(VVPSPlatform platform, VVPSConfig config) {
        Preconditions.checkArgument(ViaVersionProtocolSupport.platform == null, "ViaVersionProtocolSupport is already initialized!");

        ViaVersionProtocolSupport.platform = platform;
        ViaVersionProtocolSupport.config = config;
    }

    public static VVPSPlatform getPlatform() {
        return platform;
    }

    public static VVPSConfig getConfig() {
        return config;
    }
}
