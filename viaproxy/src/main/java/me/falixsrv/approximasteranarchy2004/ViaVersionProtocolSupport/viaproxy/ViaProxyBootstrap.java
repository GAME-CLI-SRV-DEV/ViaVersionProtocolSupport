package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.viaproxy;

import net.raphimc.viaproxy.ViaProxy;
import net.lenni0451.lambdaevents.EventHandler;

import net.raphimc.viaproxy.plugins.ViaProxyPlugin;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.viaproxy.VVPSBootstrap;
import com.viaversion.viaversion.api.Via;
import net.raphimc.viaproxy.plugins.events.ProxyStartEvent;
import net.raphimc.viaproxy.plugins.events.ProxyStopEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViaProxyBootstrap extends ViaProxyPlugin {


    public ViaProxyBootstrap() {
        Via.getManager().addEnableListener(VVPSBootstrap::new);
    }

 @Override
	public void onEnable() {
System.out.println("Loading...");
}
  
    @Override
    public void onDisable() { 
        System.out.println("[ ■ STOP ] ViaVersionProtocolSupport is Shutting Down...");
    }

}
