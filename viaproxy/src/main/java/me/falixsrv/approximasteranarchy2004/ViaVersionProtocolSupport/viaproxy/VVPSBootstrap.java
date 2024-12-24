package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.viaproxy;

import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.api.VVPSPlatform;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaVersionProtocolSupportMain;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VVPSBootstrap implements VVPSPlatform {

    public VVPSBootstrap() {
        this.init();
    }

    @Override
    public static Logger getLogger() {
        return ViaVersionProtocolSupportMain.getPlatform().getLogger();
    }

    @Override
    public void off() {
        Logger.info("ViaVersionProtocolSupport is Disabling...");
    }

}
