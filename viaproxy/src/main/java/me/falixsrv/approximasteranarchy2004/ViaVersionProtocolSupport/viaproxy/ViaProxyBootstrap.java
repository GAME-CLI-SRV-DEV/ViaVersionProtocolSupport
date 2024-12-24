package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.viaproxy;

import net.raphimc.viaproxy.ViaProxy;
import net.lenni0451.lambdaevents.EventHandler;

import net.raphimc.viaproxy.plugins.ViaProxyPlugin;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.VVPSBootstrap;
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
	 if (Via.getManager().getInjector().lateProtocolVersionSetting()) {
            // Enable in the next tick
            Via.getPlatform().runSync(this::init, 1);
        } else {
            init();
        }
}
	

    @EventHandler
    private void onProxyStop(final ProxyStopEvent event) {
	System.out.println("[ || PAUSE ] pausing...");
        this.disable();
    }
    
	
    @Override
	public void init() {
	VVPSPlatform.super.init();
    }
 
    @Override
    public void off() { 
        System.out.println("[ PAUSE || ] Proxy Stopped.");
    }
  
    @Override
    public void onDisable() { 
        System.out.println("[ ■ STOP ] ViaVersionProtocolSupport is Shutting Down...");
    }

}
