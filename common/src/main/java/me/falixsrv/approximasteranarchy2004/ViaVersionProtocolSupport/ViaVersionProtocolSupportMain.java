package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.api.VVPSPlatform;

public final class ViaVersionProtocolSupportMain {
	
	    private static VVPSPlatform platform;
	
public static void init(VVPSPlatform platform) {
        Preconditions.checkArgument(platform == null, "ViaVersionProtocolSupport is already initialized!");

        ViaVersionProtocolSupportMain.platform = platform;
    }

    public static VVPSPlatform getPlatform() {
        return platform;
    }

}

