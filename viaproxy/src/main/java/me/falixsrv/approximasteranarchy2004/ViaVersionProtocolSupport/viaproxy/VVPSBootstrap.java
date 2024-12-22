package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.viaproxy;

import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.api.VVPSPlatform;

public class VVPSBootstrap implements VVPSPlatform {

    public VVPSBootstrap() {
        this.init();
    }

    @Override
    public Logger getLogger() {
        return ViaVersionProtocolSupportMain.getPlatform().getLogger();
    }

}
