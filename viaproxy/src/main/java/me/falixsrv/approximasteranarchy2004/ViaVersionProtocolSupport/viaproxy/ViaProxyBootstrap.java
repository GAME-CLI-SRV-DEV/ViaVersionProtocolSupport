package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.viaproxy;

import net.raphimc.viaproxy.ViaProxy;
import net.lenni0451.lambdaevents.EventHandler;

import net.raphimc.viaproxy.plugins.ViaProxyPlugin;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.api.VVPSPlatform;
import com.viaversion.viaversion.api.Via;
import net.raphimc.viaproxy.plugins.events.ProxyStartEvent;
import net.raphimc.viaproxy.plugins.events.ProxyStopEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViaProxyBootstrap extends ViaProxyPlugin implements VVPSPlatform {


    public void ViaProxyVVPSPlugin() {
        Via.getManager().addEnableListener(() -> init());
    }
    
    @Override
    public void onEnable() {
       Logger logger = getLogger();
       logger.info("[ ⬤ START ] ViaVersionProtocolSupport");
       logger.info(" ");
       logger.severe("[ (!) WARN ] ViaVersionProtocolSupport is in beta.");
       logger.severe("[ (!) WARN ] Especially ViaProxy.");
       logger.severe("[ (!) WARN ] *** VVPS will Start In 3 Seconds ***");
       Thread.sleep(3000);
       logger.severe("If You Found this Message, Congrats!");
       logger.severe("This is Outfit8TSB Speaking. i got some bad news");
       logger.severe("Actually, This Plugin is Beta and will not be released until further notice.");
       logger.severe(" ");
       logger.severe("This Plugin Was Planned When Approximaster Anarchy 2004(main)/AnarchyConnect(connect) Was There,");
       logger.severe("However, The Server was Shutted Down for, Yes You Guessed it, Ram Cuts. the Main Server Died For Running out of ram.");
       logger.severe("so The Main Company decided to get a donation.");
       logger.severe(" ");
       logger.severe("So Now, this would be a rare, but please donate your Synology NAS Hardware by creating a Draft Donation issue on GAME-CLI-SRV-DEV/ViaProxyConnect or r/approximaster.");
       logger.severe("Otherwise it will be a tragedy because this christmas would be christmas Without approximaster anarchy server.");
       logger.severe("goodbye my dear lunchly");
logger.severe("we will let AnarchyConnect ViaProxy(address_port_version.viaproxy.anarchyconnect.duckdns.org:56114), and AnarchyConnect VIAaaS(address._pPort._vVersion._uUSERNAME._oX.viac9h8o4.anarchyconnect.duckdns.org:21486) on for protesters Againist Villagers654 and Infinite Games Network & Purpur Regime! LET'S OVERTHROW VILLAGERS654 & PURPURMC With Rizz Power of VIAaaS And ViaProxy!");


    }

      @EventHandler
    private void onProxyStart(final ProxyStartEvent event) {
	logger.info("[ ► PLAY ] Now Loading...");
        this.init();
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
        logger.info("(PAUSE ||) Proxy Stopped.");
    }
  
    @Override
    public void onDisable() { 
        logger.info("( ■ STOP ) ViaVersionProtocolSupport is Shutting Down...");
    }

}
