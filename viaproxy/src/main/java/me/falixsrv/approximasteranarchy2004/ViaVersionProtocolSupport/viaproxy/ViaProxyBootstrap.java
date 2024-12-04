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
       System.out.println("If You Found this Message, Congrats!")
       System.out.println("This is the VVPS Speaking.");
       System.out.println("Actually, This Plugin is Beta and will not be released.")
       System.out.println(" ");
       System.out.println("This Plugin Was Planned When Approximaster Anarchy 2004(main)/AnarchyConnect(connect) Was There,");
       System.out.println("However, The Server was Shutted Down for, Yes You Guessed it, Ram Cuts. the Main Server Died For Running out of ram.");
       System.out.println("so The Main Company decided to get a donation.");
       System.out.println(" ");
       System.out.println("So Now, this would be a rare, but please donate your Synology NAS Hardware by creating a Draft Donation issue on GAME-CLI-SRV-DEV/ViaProxyConnect or r/approximaster.");
       System.out.println("Otherwise it will be a tragedy because this christmas would be christmas Without approximaster anarchy server.");
       System.out.println(" ");



    }

      @EventHandler
    private void onProxyStart(final ProxyStartEvent event) {
        this.init();
    }

    @EventHandler
    private void onProxyStop(final ProxyStopEvent event) {
        this.disable();
    }
    
      @Override
	public void onEnable() {
	Component message = Component.text()
    .append(Component.text("ViaVersion", NamedTextColor.AQUA))
    .append(Component.text("ProtocolSupport", NamedTextColor.GRAY))
    .build();
    Bukkit.getServer().sendMessage(message);
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
        System.out.println("Proxy Stopped.");
        ViaProxyPlugin.disable()
    }
  
    @Override
    public void onDisable() { 
        System.out.println("ViaVersionProtocolSupport is Shutting Down...");
    }

}
