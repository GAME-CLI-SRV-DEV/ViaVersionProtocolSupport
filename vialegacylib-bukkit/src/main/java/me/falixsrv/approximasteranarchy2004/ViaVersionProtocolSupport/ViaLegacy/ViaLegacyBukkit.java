package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport;

import com.viaversion.viaversion.api.Via;

public class ViaLegacyBukkit extends JavaPlugin {

  @Override
  public void onLoad() {
  Via.getManager().addEnableListener(ViaLegacyPlatformImpl::new);
     }
  
}
