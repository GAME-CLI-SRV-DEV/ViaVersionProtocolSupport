package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaLegacy;

import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaLegacy.ViaLegacyPlugin
import com.viaversion.viaversion.api.Via;

public class ViaLegacyBukkit extends JavaPlugin {

  @Override
  public void onLoad() {
  Via.getManager().addEnableListener(ViaLegacyPlugin::new);
     }
  
}
