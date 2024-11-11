/*
 * This file is Ported for VVPS
 * From ViaBackwards 
 */

package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.api;

// import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaVersionProtocolSupportMain;
import com.viaversion.viabackwards.api.rewriters.TranslatableRewriter;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.protocol.r1_7_2_5tor1_6_4.Protocolr1_7_2_5tor1_6_4;
import com.viaversion.viaversion.util.VersionInfo;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.ProtocolManager;
import net.raphimc.vialegacy.api.LegacyProtocolVersion;
import com.viaversion.viaversion.update.Version;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import java.io.File;
import java.util.Arrays;
import java.util.logging.Logger;

public interface VVPSPlatform {

    String MINIMUM_VV_VERSION = "5.0.4";

    /**
     * Initialize ViaVersionProtocolSupport
	 *
     */
    default void init() {
        if (isOutdated()) {
            disable();
            return;
        }

        Via.getManager().getSubPlatforms().add(VersionInfo.getImplementationVersion());

        getLogger().info("번역 로딩중입니다.");
        TranslatableRewriter.loadTranslatables();

        getLogger().info("버전 등록중입니다.");
        final ProtocolManager protocolManager = Via.getManager().getProtocolManager();
        protocolManager.registerProtocol(new Protocolr1_7_2_5tor1_6_4(), LegacyProtocolVersion.r1_6_4, ProtocolVersion.v1_7_2); // 지원하는 버전이 너무 낮을 때에는 LegacyProtocolVersion을 사용한다. 하지만 참가하는 서버 버전이 클라이언트의 1.6.4보다 높으면 ProtocolVersion을 사용한다.
		// protocolManager.registerProtocol(new Protocolr1_6_4tor1_6_1(), LegacyProtocolVersion.r1_6_1, LegacyProtocolVersion.r1_6_4); // 다중 버전 지원 플러그인을 만들때는 protocolManager에서 프로토콜을 등록해야 한다. 
    }

    /**
     * Logger provided by the platform.
     *
     * @return logger instance
     */
    Logger getLogger();

    default boolean isOutdated() {
        String vvVersion = Via.getPlatform().getPluginVersion();
        if (vvVersion != null && new Version(vvVersion).compareTo(new Version(MINIMUM_VV_VERSION + "--")) < 0) {
		    getLogger().severe("╔═════════════════════════════에러 발생/ERROR OCCURRED═════════════════════════════════════╗");
		    getLogger().severe("║                               에러 - 플랫폼이 구버전입니다.               ");
		    getLogger().severe("║                                                                   ");
			getLogger().severe("║  에에에에에에        에 에  러러러러러러     러                                                           ");
			getLogger().severe("║ 에         에       에 에          러     러                                                             ");
			getLogger().severe("║ 에         에       에 에          러     러                                                           ");
			getLogger().severe("║ 에         에에에에에에 에  러러러러러러러러러러                                                             ");
			getLogger().severe("║ 에         에       에 에  러             러                                                ");
			getLogger().severe("║ 에         에       에 에  러             러                                                ");
			getLogger().severe("║  에에에에에에        에 에  러러러러러러     러                                                           ");
			getLogger().severe("║                                                                   ");
			getLogger().severe("║                                                                  ");
		    getLogger().severe("║ ViaVersion, Backwards, Rewind의 구버전을 쓰고 있습니다.                  ");
		    getLogger().severe("║ ViaVersion + ViaBackwards " + MINIMUM_VV_VERSION + "을 사용해주세요. 우리 플러그인은 아쉽게도 1.21.1 이상만 지원합니다.");
		    getLogger().severe("║ ViaProxy를 사용하시는 경우에는:");
		    getLogger().severe("║ ViaProxy: jars 폴더에 넣어주세요.(아직 미지원)");
		    getLogger().severe("║ 비아버전프로토콜서포트가 종료되었습니다. 저건 이슈 넣지 마십쇼.");
			getLogger().severe("║");
			getLogger().severe("║ EN: ");
			getLogger().severe("║ ");
			getLogger().severe("║                         ERROR - Platform is Outdated");
			getLogger().severe("║ ");
			getLogger().severe("║ EEEEEEEE RRRRRRR   RRRRRRR  OOOOOOOO RRRRRRR");
			getLogger().severe("║ E        R      R  R      R O      O R      R");
			getLogger().severe("║ EEEEEEEE RRRRRRR   RRRRRRR  O      O RRRRRRR");
			getLogger().severe("║ E        R      R  R      R O      O R      R");
			getLogger().severe("║ EEEEEEEE R      R  R      R OOOOOOOO R      R");
			getLogger().severe("║ ");
		    getLogger().severe("║ You are using Outdated version of ViaVersion, Backwards, Rewind.                  ");
		    getLogger().severe("║ Please use ViaVersion + ViaBackwards + Rewind " + MINIMUM_VV_VERSION + " We Only support 1.21.1 and above unfortunately");
		    getLogger().severe("║ if you are using ViaProxy:");
		    getLogger().severe("║ ViaProxy: put the jar in jars folder (Not Supported)");
		    getLogger().severe("║ VVPS is now turned off. do not make issue about it.");			
		    getLogger().severe("╚═════════════════════════════에러 발생/ERROR OCCURRED═════════════════════════════════════╝");
            return true;
        }
        return false;
    }

    /**
     * Disable the plugin.
     */
    void disable();

    /**
     * Returns ViaBackwards's data folder.
     *
     * @return data folder
     */
    File getDataFolder();
}
