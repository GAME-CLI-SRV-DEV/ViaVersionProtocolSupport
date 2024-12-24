package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.viaproxy;

import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.api.VVPSPlatform;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupportMain;

public class VVPSBootstrap implements VVPSPlatform {

    public VVPSBootstrap() {
        this.init();
    }

    @Override
    public Logger getLogger() {
        return ViaVersionProtocolSupportMain.getPlatform().getLogger();
    }

    @Override
    public void off() {
        Logger.INFO("Now Who is Bozo, Shevchik?")
    }

}
