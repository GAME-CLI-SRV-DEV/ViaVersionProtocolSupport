package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.protocol.r1_7_2_5tor1_6_4;

import net.raphimc.vialegacy.api.LegacyProtocolVersion;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.SoundRewriter;
import com.viaversion.viabackwards.api.rewriters.TranslatableRewriter;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.packet.ClientboundPackets1_6_4;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ClientboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ServerboundPackets1_7_2_5;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.packet.ServerboundPackets1_6_4;
import com.viaversion.viaversion.rewriter.ComponentRewriter.ReadType;
import com.viaversion.viaversion.rewriter.StatisticsRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viarewind.api.data.RewindMappingData;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.*;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.task.WorldBorderUpdateTask;
import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viaversion.api.Via;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.protocol.r1_7_2_5tor1_6_4.Rewriter.vvpsrew_item_1_7_2_5tor1_6_4; // from ViaLegacy, Modified for a backward compat
import java.util.concurrent.TimeUnit;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.CompressionHandlerProvider;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.compression.TrackingCompressionHandlerProvider;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import net.raphimc.vialegacy.protocol.release.r1_7_6_10tor1_8.types.Types1_7_6;
import me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaVersionProtocolSupportMain;

// Thanks To ViaBackwards For the Template for ViaLegacy Protocol.

public final class Protocolr1_7_2_5tor1_6_4 extends StatelessTransitionProtocol<ClientboundPackets1_7_2_5, ClientboundPackets1_6_4, ServerboundPackets1_7_2_5, ServerboundPackets1_6_4> {

    // ViaBackwards uses its own mappings and also needs a translatablerewriter for translation mappings
    public static final RewindMappingData MAPPINGS = new RewindMappingData("1.7.2", "1.6.4");
    private final TagRewriter<ClientboundPackets1_7_2_5> tagRewriter = new TagRewriter<>(this);
    private final vvpsrew_item_1_7_2_5tor1_6_4 itemRewriter = new vvpsrew_item_1_7_2_5tor1_6_4(this);
	
    public Protocolr1_7_2_5tor1_6_4() {
        super(ClientboundPackets1_7_2_5.class, ClientboundPackets1_6_4.class, ServerboundPackets1_7_2_5.class, ServerboundPackets1_6_4.class);
    }

@Override
protected void registerPackets() {
        super.registerPackets();
	    
this.registerClientboundTransition(ClientboundPackets1_7_2_5.LOGIN,
                ClientboundPackets1_6_4.LOGIN, new PacketHandlers() {
                    @Override
                    public void register() {
                        map(Types.INT); // entity id
                        handler(wrapper -> {
                            wrapper.user().get(PlayerInfoStorage.class).entityId = wrapper.get(Types.INT, 0);
                            final String terrainType = wrapper.read(Types.STRING); // level type
                            final short gameType = wrapper.read(Types.BYTE); // game mode
                            final byte dimension = wrapper.read(Types.BYTE); // dimension id
                            final short difficulty = wrapper.read(Types.BYTE); // difficulty
                            wrapper.read(Types.BYTE); // world height
                            final short maxPlayers = wrapper.read(Types.BYTE); // max players

                            wrapper.write(Types.UNSIGNED_BYTE, gameType);
                            wrapper.write(Types.BYTE, dimension);
                            wrapper.write(Types.UNSIGNED_BYTE, difficulty);
                            wrapper.write(Types.UNSIGNED_BYTE, maxPlayers);
                            wrapper.write(Types.STRING, terrainType);
                        });
                        handler(wrapper -> {
                            final byte dimensionId = wrapper.get(Types.BYTE, 0);
                            wrapper.user().getClientWorld(Protocolr1_7_2_5Tor1_6_4.class).setEnvironment(dimensionId);

                            wrapper.user().put(new ChunkTracker(wrapper.user()));
                        });
                    }
                }, State.LOGIN, (PacketHandler) wrapper -> {
                    ViaVersionProtocolSupportMain.getPlatform().getLogger().warning("VVPS: 서버가 로그인 단계를 건너뛰었습니다!");
                    wrapper.user().get(ProtocolMetadataStorage.class).skipEncryption = true;
                    wrapper.user().get(ProtocolMetadataStorage.class).skipEncryption = false;
                    wrapper.setPacketType(ClientboundPackets1_7_2_5.LOGIN);
                    wrapper.send(Protocolr1_7_2_5tor1_6_4.class, false);
                    wrapper.cancel();
                }
        );

   this.registerClientbound(ClientboundPackets1_7_2_5.CHAT, new PacketHandlers() {
            @Override
            public void register() {
                map(Types.STRING, Types1_6_4.STRING, TextRewriter::toClient); // message
            }
        });
	
   this.registerClientbound(ClientboundPackets1_7_2_5.SET_EQUIPPED_ITEM, new PacketHandlers() { 
            @Override
            public void register() {
                map(Types.INT); // entity id
                map(Types.SHORT); // slot
                map(Types1_7_6.ITEM); // item
                handler(wrapper -> itemRewriter.handleItemToClient(wrapper.user(), wrapper.get(Types1_6_4.ITEM, 0)));
            }
        });

	@Override
	public void init(UserConnection connection) {
		connection.addEntityTracker(this.getClass(), new EntityTracker1_8(connection));
		connection.addClientWorld(this.getClass(), new ClientWorld());

		connection.put(new InventoryTracker(connection));
		connection.put(new PlayerSessionStorage(connection));
		connection.put(new GameProfileStorage(connection));
		connection.put(new ScoreboardTracker(connection));
		connection.put(new CompressionStatusTracker(connection));
		connection.put(new WorldBorderEmulator(connection));
	}

	@Override
	public void register(ViaProviders providers) {
		providers.register(CompressionHandlerProvider.class, new TrackingCompressionHandlerProvider());

		if (ViaRewind.getConfig().isEmulateWorldBorder()) {
			Via.getManager().getScheduler().scheduleRepeating(new WorldBorderUpdateTask(), 0L, 50L, TimeUnit.MILLISECONDS);
		}
	}

	@Override
	public RewindMappingData getMappingData() {
		return MAPPINGS;
	}

	@Override
	public vvpsrew_item_1_7_2_5tor1_6_4 getItemRewriter() {
		return itemRewriter;
	}

	@Override
	public boolean hasMappingDataToLoad() {
		return true;
	}
  }
