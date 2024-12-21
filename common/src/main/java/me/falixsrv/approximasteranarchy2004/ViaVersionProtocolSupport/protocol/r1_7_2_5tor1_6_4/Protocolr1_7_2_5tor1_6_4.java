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
import net.raphimc.vialegacy.protocol.release.r1_7_2_5tor1_7_6_10.packet.ClientboundPackets1_7_2;
import net.raphimc.vialegacy.protocol.release.r1_7_2_5tor1_7_6_10.packet.ServerboundPackets1_7_2;
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
import net.raphimc.vialegacy.protocol.release.r1_7_6_10tor1_8.types.Types1_7_6;
import com.viaversion.viaversion.api.minecraft.ClientWorld;

// Thanks To ViaBackwards For the Template for ViaLegacy Protocol.

public final class Protocolr1_7_2_5tor1_6_4 extends StatelessTransitionProtocol<ClientboundPackets1_7_2, ClientboundPackets1_6_4, ServerboundPackets1_7_2, ServerboundPackets1_6_4> {

    private final vvpsrew_item_1_7_2_5tor1_6_4 itemRewriter = new vvpsrew_item_1_7_2_5tor1_6_4(this);

	
    public Protocolr1_7_2_5tor1_6_4() {
        super(ClientboundPackets1_7_2.class, ClientboundPackets1_6_4.class, ServerboundPackets1_7_2.class, ServerboundPackets1_6_4.class);
    }

    	@Override
	protected void registerPackets() {
		super.registerPackets();
	        this.registerClientboundTransition(ClientboundPackets1_7_2.LOGIN,
                ClientboundPackets1_6_4.LOGIN, new PacketHandlers() {
                    @Override
                    public void register() {
                        map(Types.INT); // entity id
                        handler(wrapper -> {
                            wrapper.user().get(PlayerInfoStorage.class).entityId = wrapper.get(Types.INT, 0);
                            final String terrainType = wrapper.read(Types1_7_6.STRING); // level type
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

	}
}, State.LOGIN, (PacketHandler) wrapper -> {
                    ViaLegacy.getPlatform().getLogger().warning("Server skipped LOGIN state");
                    final PacketWrapper sharedKey = PacketWrapper.create(ClientboundPackets1_6_4.SHARED_KEY, wrapper.user());
                    sharedKey.write(Types.SHORT_BYTE_ARRAY, new byte[0]);
                    sharedKey.write(Types.SHORT_BYTE_ARRAY, new byte[0]);
                    wrapper.user().get(ProtocolMetadataStorage.class).skipEncryption = true;
                    sharedKey.send(Protocolr1_6_4Tor1_7_2_5.class, false); // switch to play state
                    wrapper.user().get(ProtocolMetadataStorage.class).skipEncryption = false;

                    wrapper.setPacketType(ClientboundPackets1_6_4.LOGIN);
                    wrapper.send(Protocolr1_6_4Tor1_7_2_5.class, false);
                    wrapper.cancel();
                }
        );
	@Override
	public void transform(Direction direction, State state, PacketWrapper packetWrapper) throws CancelException {
		Via.getManager().getProviders().get(CompressionHandlerProvider.class).onTransformPacket(packetWrapper.user());

		super.transform(direction, state, packetWrapper);
	}

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
