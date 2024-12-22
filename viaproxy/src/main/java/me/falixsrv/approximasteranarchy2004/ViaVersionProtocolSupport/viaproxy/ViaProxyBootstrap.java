package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.viaproxy;

import net.raphimc.viaproxy.ViaProxy;
import net.lenni0451.lambdaevents.EventHandler;

import net.raphimc.viaproxy.plugins.ViaProxyPlugin;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.;
import com.viaversion.viaversion.api.Via;
import net.raphimc.viaproxy.plugins.events.ProxyStartEvent;
import net.raphimc.viaproxy.plugins.events.ProxyStopEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViaProxyBootstrap extends ViaProxyPlugin {


    public ViaProxyVVPSPlugin() {
        Via.getManager().addEnableListener(VVPSBootstrap::new);
    }


      @EventHandler
    private void onProxyStart(final ProxyStartEvent event) {
       logger.info("[ ⬤ START ] ViaVersionProtocolSupport");
       logger.info("[ ⬤ START ] Copyright (C) 2015-2024, Approximaster Studios 2004, All Rights Reversed.");
       logger.severe("[ (!) WARN ] ViaVersionProtocolSupport is in beta.");
       logger.severe("[ (!) WARN ] Especially ViaProxy.");
       logger.info("[ ► PLAY ] Now Loading...");
    }

    @EventHandler
    private void onProxyStop(final ProxyStopEvent event) {
	logger.info("[ || PAUSE ] pausing...");
        this.disable();
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
	
    @Override
	public void init() {
	VVPSPlatform.super.init();
    }
 
    @Override
    public void disable() { 
        logger.info("[ PAUSE || ] Proxy Stopped.");
    }
  
    @Override
    public void onDisable() { 
        logger.info("[ ■ STOP ] ViaVersionProtocolSupport is Shutting Down...");
    }

}
