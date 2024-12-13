package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport;
  
import net.raphimc.vialegacy.platform.ViaLegacyPlatform;
import com.viaversion.api.Via;

public class ViaLegacyBukkit implements ViaLegacyPlatform {

    public ViaLegacyBukkit() {
        this.init(this.getDataFolder());
    }

    @Override
    public Logger getLogger() {
        return Via.getPlatform().getLogger();
    }

    @Override
    public File getDataFolder() {
        return Via.getPlatform().getDataFolder();
    }

}
