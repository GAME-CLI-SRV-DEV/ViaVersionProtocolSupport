import net.raphimc.viaproxy.ViaProxy;
import net.raphimc.viaproxy.plugins.ViaProxyPlugin;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.api.VVPSPlatform;
import com.viaversion.viaversion.api.Via;

public class PluginMain extends ViaProxyPlugin implements VVPSPlatform {


    public void ViaProxyPlugin() {
        Via.getManager().addEnableListener(() -> init());
    }
    
    @Override
    public void onEnable() {
       System.out.println("[ ⬤ START ] ViaVersionProtocolSupport");
       System.out.println(" ");
       System.err.println("[ (!) WARN ] ViaVersionProtocolSupport is in beta.")
       System.err.println("[ (!) WARN ] Especially ViaProxy.")
       System.err.println("[ (!) WARN ] *** VVPS will Start In 3 Seconds ***")
       Thread.sleep(3000);
       System.err.println("If You Found this Message, Congrats!")
       System.err.println("This is the VVPS Speaking.");
       System.err.println("Actually, This Plugin is Beta and will not be released until further notice.")
       System.err.println(" ");
       System.err.println("This Plugin Was Planned When Approximaster Anarchy 2004(main)/AnarchyConnect(connect) Was There,");
       System.err.println("However, The Server was Shutted Down for, Yes You Guessed it, Ram Cuts. the Main Server Died For Running out of ram.");
       System.err.println("so The Main Company decided to get a donation.");
       System.err.println(" ");
       System.err.println("So Now, this would be a rare, but please donate your Synology NAS Hardware by creating a Draft Donation issue on GAME-CLI-SRV-DEV/ViaProxyConnect or r/approximaster.");
       System.err.println("Otherwise it will be a tragedy because this christmas would be christmas Without approximaster anarchy server.");
       System.err.println("goodbye my dear lunchly");
System.err.println("we will let AnarchyConnect ViaProxy(address_port_version.viaproxy.anarchyconnect.duckdns.org:56114), and AnarchyConnect VIAaaS(address._pPort._vVersion._uUSERNAME._oX.viac9h8o4.anarchyconnect.duckdns.org:21486) on for protesters Againist Villagers654 and Infinite Games Network & Purpur Regime! LET'S OVERTHROW VILLAGERS654 & PURPURMC With Rizz Power of VIAaaS And ViaProxy!");
System.err.println(" ");
System.err.println("       /-------------\________/");
System.err.println("      /  PURPUR SUCKS        /");
System.err.println("     /    VILLA SUCKS       /");
System.err.println("    /                      /");  
System.err.println("   /--------------\_______/");
System.err.println("  /");
System.err.println(" /");


    }

      @EventHandler
    private void onProxyStart(final ProxyStartEvent event) {
	System.out.println("[ ► PLAY ] Now Loading...")
        this.init();
    }

    @EventHandler
    private void onProxyStop(final ProxyStopEvent event) {
	System.out.println("[ || PAUSE ] pausing...")
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
        System.out.println("(PAUSE ||) Proxy Stopped.");
    }
  
    @Override
    public void onDisable() { 
        System.out.println("( ■ STOP ) ViaVersionProtocolSupport is Shutting Down...");
    }

}
