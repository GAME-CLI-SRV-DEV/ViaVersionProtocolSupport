
import com.viaversion.viaversion.ViaLoader;
import com.viaversion.viaversion.api.platform.ViaPlatform;
import com.viaversion.viaversion.api.injector.ViaInjector;
import com.viaversion.viaversion.api.command.ViaCommandHandler;
import us.myles.ViaBackwardsPlatformImpl;
import us.myles.ViaRewindPlatformImpl;
import us.myles.ViaLegacyPlatformImpl;
import us.myles.ViaAprilFoolsPlatformImpl;
import us.myles.ViaBedrockPlatformImpl;

public class Main implements Extension{
      @Subscribe
    public void onPreInitialize(GeyserPreInitializeEvent event) {
            this.logger().info("ViaVersionProtocolSupport를 실행하기 위해 필요한 라이브러리를 로딩합니다.");
            this.logger().severe("경고:");
            this.logger().severe("이 확장 플러그인은 Java 플레이어가 Geyser 인스턴스에 들어오는 확장 플러그인입니다.");
            this.logger().severe("이에 사용되는 ViaBedrock은 실험적 기능으로 명령어로 베드락 기능이 구현되었습니다.");
            this.logger().severe("해당 확장 플러그인의 명령어를 사용하여 서버가 테러당하였을 경우, 그로 인해 밴을 당한 경우에는 책임지지 않습니다.");
            this.logger().severe("");
        if (this.geyserApi().platformType() = PlatformType.VIAPROXY) {
            this.logger().severe("경고: ViaProxy판 GeyserMC에서 ViaVersionProtocolSupportJE2BE를 사용하려고 했습니다.");
            this.logger().severe("ViaProxy는 ViaVersionProtocolSupportJE2BE에 사용되는 ViaBedrock이 있기 때문에 그럴 필요가 없습니다.");
            this.logger().severe("해당 확장은 곧 꺼집니다.");
            this.disable();
    }
                  // ViaBedrock 로드
            ViaLoader.init(
            null /*ViaPlatform*/,
            new CustomVLLoaderImpl(),
            null /*ViaInjector*/,
            null /*ViaCommandHandler*/,
            ViaBedrockPlatformImpl::new
            );

        this.logger().info("ViaVersion 라이브러리 로딩을 완료했습니다.");
            this.disable();
        }
    }
  


class CustomVLLoaderImpl extends VLLoader {
    // 구현 내용
}
