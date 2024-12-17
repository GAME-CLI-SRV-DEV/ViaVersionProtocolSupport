package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaLegacy;

import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaLegacy.ViaLegacyPlugin;
import com.viaversion.viaversion.api.Via;
import org.bukkit.plugin.java.JavaPlugin;
import com.viaversion.viaversion.protocol.ProtocolManagerImpl;

public class ViaLegacyBukkit extends JavaPlugin {

  public ViaLegacyBukkit() {
     Via.getManager().addEnableListener(ViaLegacyPlugin::new); 
  }

  @Override
  public void onEnable() { // Since ViaVersion Initializes ViaManager We can Refresh Version.
    Via.getManager().getProtocolManager().setMaxProtocolPathSize(Integer.MAX_VALUE); // Allow Integer.MAX_VALUE protocols in the pipeline
    Via.getManager().getProtocolManager().setMaxPathDeltaIncrease(-1); // Allow unlimited protocol path size increase
    ((ProtocolManagerImpl) Via.getManager().getProtocolManager()).refreshVersions(); // Refresh the version paths
  }
  
}
