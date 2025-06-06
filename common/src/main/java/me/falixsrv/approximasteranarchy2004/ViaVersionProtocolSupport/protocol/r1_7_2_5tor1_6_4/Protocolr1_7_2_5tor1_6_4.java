package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.protocol.r1_7_2_5tor1_6_4;

import net.raphimc.vialegacy.ViaLegacy;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_8;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.base.*;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.v1_7.ClientboundBaseProtocol1_7;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.util.IdAndData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaVersionProtocolSupportMain;
import net.raphimc.vialegacy.api.protocol.StatelessTransitionProtocol;
import net.raphimc.vialegacy.api.splitter.PreNettySplitter;
import net.raphimc.vialegacy.api.util.PacketUtil;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.packet.ClientboundPackets1_6_4;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.packet.ServerboundPackets1_6_4;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.provider.EncryptionProvider;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.rewriter.ItemRewriter;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.rewriter.SoundRewriter;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.rewriter.StatisticRewriter;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.rewriter.TextRewriter;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.storage.*;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.types.EntityDataTypes1_6_4;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.types.Types1_6_4;
import net.raphimc.vialegacy.protocol.release.r1_7_2_5tor1_7_6_10.packet.ClientboundPackets1_7_2;
import net.raphimc.vialegacy.protocol.release.r1_7_2_5tor1_7_6_10.packet.ServerboundPackets1_7_2;
import net.raphimc.vialegacy.protocol.release.r1_7_6_10tor1_8.Protocolr1_7_6_10Tor1_8;
import net.raphimc.vialegacy.protocol.release.r1_7_6_10tor1_8.model.GameProfile;
import net.raphimc.vialegacy.protocol.release.r1_7_6_10tor1_8.provider.GameProfileFetcher;
import net.raphimc.vialegacy.protocol.release.r1_7_6_10tor1_8.types.EntityDataTypes1_7_6;
import net.raphimc.vialegacy.protocol.release.r1_7_6_10tor1_8.types.Types1_7_6;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.protocol.r1_7_2_5tor1_6_4.Rewriter.vvpsrew_item_1_7_2_5tor1_6_4; // from ViaLegacy, Modified for a backward compat
import com.viaversion.viarewind.api.data.RewindMappingData;

import java.util.List;
import java.util.logging.Level;

public final class Protocolr1_7_2_5tor1_6_4 extends StatelessTransitionProtocol<ClientboundPackets1_7_2, ClientboundPackets1_6_4, ServerboundPackets1_7_2, ServerboundPackets1_6_4> {

    // ViaBackwards uses its own mappings and also needs a translatablerewriter for translation mappings
    public static final RewindMappingData MAPPINGS = new RewindMappingData("1.7.2", "1.6.4");
    private final vvpsrew_item_1_7_2_5tor1_6_4 itemRewriter = new vvpsrew_item_1_7_2_5tor1_6_4(this);
	
    public Protocolr1_7_2_5tor1_6_4() {
        super(ClientboundPackets1_7_2.class, ClientboundPackets1_6_4.class, ServerboundPackets1_7_2.class, ServerboundPackets1_6_4.class);
    }

	    @Override
    protected void registerPackets() {
        super.registerPackets();
    }

    

	@Override
	public RewindMappingData getMappingData() {
		return MAPPINGS;
	}

	@Override
	public vvpsrew_item_1_7_2_5tor1_6_4 getItemRewriter() {
		return itemRewriter;
	}
}
