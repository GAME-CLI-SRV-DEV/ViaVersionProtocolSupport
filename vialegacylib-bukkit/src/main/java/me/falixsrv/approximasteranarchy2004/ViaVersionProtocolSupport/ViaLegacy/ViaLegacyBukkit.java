package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaLegacy;

import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaLegacy.ViaLegacyPlugin;
import com.viaversion.viaversion.api.Via;
import org.bukkit.plugin.java.JavaPlugin;

public class ViaLegacyBukkit extends JavaPlugin {

  @Override
  public void onLoad() {
  Via.getManager().addEnableListener(ViaLegacyPlugin::new); // ViaBackwards -> ViaLegacy -> ViaRewind -> ViaVersion 
     }
  
}
