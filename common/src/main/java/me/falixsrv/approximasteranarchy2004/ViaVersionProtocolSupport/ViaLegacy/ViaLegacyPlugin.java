package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaLegacy;
  
import net.raphimc.vialegacy.platform.ViaLegacyPlatform;
import com.viaversion.viaversion.api.Via;
import java.io.File;
import java.util.logging.Logger;

public class ViaLegacyPlugin implements ViaLegacyPlatform {

    public ViaLegacyPlugin() {
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
