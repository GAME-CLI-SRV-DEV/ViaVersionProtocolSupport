package me.falixsrv.approximasteranarchy2004.viaversionprotocolsupport.JavaEdition2BedrockEdition;
      
import net.raphimc.vialoader.ViaLoader;
import net.raphimc.vialoader.impl.platform.ViaBackwardsPlatformImpl;
import net.raphimc.vialoader.impl.platform.ViaRewindPlatformImpl;
import net.raphimc.vialoader.impl.platform.ViaLegacyPlatformImpl;
import net.raphimc.vialoader.impl.platform.ViaAprilFoolsPlatformImpl;
import net.raphimc.vialoader.impl.platform.ViaBedrockPlatformImpl;
import org.geysermc.geyser.api.extension.Extension;
import com.viaversion.viaversion.api.connection.UserConnection;
import io.netty.channel.Channel;
import net.raphimc.netminecraft.constants.MCPipeline;
import net.raphimc.viabedrock.api.io.compression.ProtocolCompression;
import net.raphimc.viabedrock.netty.AesEncryptionCodec;
import net.raphimc.viabedrock.netty.CompressionCodec;
import net.raphimc.viabedrock.protocol.provider.NettyPipelineProvider;
import net.raphimc.vialoader.netty.VLPipeline;


public class JE2BE implements Extension {
      @Subscribe
    public void onPreInitialize(GeyserPreInitializeEvent event) {
            this.logger().info("ViaVersionProtocolSupport를 실행하기 위해 필요한 라이브러리를 로딩합니다.");
            this.logger().severe("경고:");
            this.logger().severe("이 확장 플러그인은 Java 플레이어가 Geyser 인스턴스에 들어오는 확장 플러그인입니다.");
            this.logger().severe("이에 사용되는 ViaBedrock은 실험적 기능입니다.");
            this.logger().severe("");
        if (this.geyserApi().platformType() = PlatformType.VIAPROXY) {
            this.logger().severe("경고: ViaProxy판 GeyserMC에서 ViaVersionProtocolSupportJE2BE를 사용하려고 했습니다.");
            this.logger().severe("ViaProxy는 ViaVersionProtocolSupportJE2BE에 사용되는 ViaBedrock이 있기 때문에 그럴 필요가 없습니다.");
            this.logger().severe("해당 확장은 곧 꺼집니다.");
            this.disable();
    }
                  
            ViaLoader.init(null, new VVPSJE2BEVLLoaderImpl(), null, null, ViaBackwardsPlatformImpl::new, ViaRewindPlatforImpl::new, ViaAprilFoolsPlatformImpl::new, ViaBedrockPlatformImpl::new);

        this.logger().info("ViaVersion 라이브러리 로딩을 완료했습니다.");
        }
    }
  


class VVPSJE2BEVLLoaderImpl extends VLLoader {
        @Override
    public void load() {
        super.load();

        // ViaVersion
        Via.getManager().getProviders().use(CompressionProvider.class, new ViaProxyCompressionProvider());
        Via.getManager().getProviders().use(VersionProvider.class, new ViaProxyVersionProvider());

        // ViaBackwards
        Via.getManager().getProviders().use(TransferProvider.class, new ViaProxyTransferProvider());

        // ViaBedrock
        Via.getManager().getProviders().use(NettyPipelineProvider.class, new VVPSJE2BENettyPipelineProvider());
    }
}

class VVPSJE2BEVLPipeline extends VLPipeline {


    @Override
    protected String compressionCodecName() {
        return MCPipeline.COMPRESSION_HANDLER_NAME;
    }

    @Override
    protected String packetCodecName() {
        return MCPipeline.PACKET_CODEC_HANDLER_NAME;
    }

    @Override
    protected String lengthCodecName() {
        return MCPipeline.SIZER_HANDLER_NAME;
    }
}

class VVPSJE2BENettyPipelineProvider extends NettyPipelineProvider {

    @Override
    public void enableCompression(UserConnection user, ProtocolCompression protocolCompression) {
        final ProxyConnection proxyConnection = ProxyConnection.fromUserConnection(user);
        final Channel channel = proxyConnection.getChannel();

        if (channel.pipeline().names().contains(MCPipeline.COMPRESSION_HANDLER_NAME)) {
            throw new IllegalStateException("Compression already enabled");
        }

        try {
            channel.pipeline().addBefore(MCPipeline.SIZER_HANDLER_NAME, MCPipeline.COMPRESSION_HANDLER_NAME, new CompressionCodec(protocolCompression));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enableEncryption(UserConnection user, SecretKey key) {
        final ProxyConnection proxyConnection = ProxyConnection.fromUserConnection(user);
        final Channel channel = proxyConnection.getChannel();

        if (channel.pipeline().names().contains(MCPipeline.ENCRYPTION_HANDLER_NAME)) {
            throw new IllegalStateException("Encryption already enabled");
        }

        try {
            channel.pipeline().addAfter(VLPipeline.VIABEDROCK_FRAME_ENCAPSULATION_HANDLER_NAME, MCPipeline.ENCRYPTION_HANDLER_NAME, new AesEncryptionCodec(key));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
