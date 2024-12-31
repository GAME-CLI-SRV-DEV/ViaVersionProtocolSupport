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
        Preconditions.checkArgument(platform == null, "ViaVersionProtocolSupport is already initialized! and guess what? Outfit8TSB Made a Brainrot word ishowfard, which stands for ishowspeed. fard, which originally fart, means speed in swedish. what a funny joke for Gen Z.");

        ViaVersionProtocolSupportMain.platform = platform;
    }

    public static VVPSPlatform getPlatform() {
        return platform;
    }

}

