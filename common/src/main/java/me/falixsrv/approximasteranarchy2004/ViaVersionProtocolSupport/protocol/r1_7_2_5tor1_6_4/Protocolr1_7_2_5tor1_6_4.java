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
import com.viaversion.viaversion.api.minecraft.ClientWorld;

// Thanks To ViaBackwards For the Template for ViaLegacy Protocol.

public final class Protocolr1_7_2_5tor1_6_4 extends BackwardsProtocol<ClientboundPackets1_7_2, ClientboundPackets1_6_4, ServerboundPackets1_7_2, ServerboundPackets1_6_4> {

    // ViaBackwards uses its own mappings and also needs a translatablerewriter for translation mappings
    public static final RewindMappingData MAPPINGS = new RewindMappingData("1.7.2", "1.6.4");
    private final TranslatableRewriter<ClientboundPackets1_7_2> translatableRewriter = new TranslatableRewriter<>(this, ReadType.NBT);
    private final TagRewriter<ClientboundPackets1_7_2> tagRewriter = new TagRewriter<>(this);
    private final vvpsrew_item_1_7_2_5tor1_6_4 itemRewriter = new vvpsrew_item_1_7_2_5tor1_6_4(this);
   public static final ValueTransformer<String, String> REMOVE_DASHES = new ValueTransformer<>(Types.STRING) {
		@Override
		public String transform(PacketWrapper wrapper, String s) {
			return s.replace("-", "");
		}
	};
	
    public Protocolr1_7_2_5tor1_6_4() {
        super(ClientboundPackets1_7_2.class, ClientboundPackets1_6_4.class, ServerboundPackets1_7_2.class, ServerboundPackets1_6_4.class);
    }

    	@Override
	protected void registerPackets() {
		this.registerClientbound(State.LOGIN, ClientboundLoginPackets.GAME_PROFILE, new PacketHandlers() {
			@Override
			public void register() {
				map(Types.STRING, REMOVE_DASHES); // Uuid
				map(Types.STRING); // Name
			}
		});

        
 		this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_COMPRESSION, new PacketHandlers() {
			@Override
			public void register() {
				handler(wrapper -> {
					final int threshold = wrapper.read(Types.VAR_INT);

					Via.getManager().getProviders().get(CompressionHandlerProvider.class).onHandleLoginCompressionPacket(wrapper.user(), threshold);
					wrapper.cancel();
				});
			}
		});
		this.registerClientbound(ClientboundPackets1_7_2.KEEP_ALIVE, new PacketHandlers() {
			@Override
			public void register() {
				map(Types.VAR_INT, Types.INT); // id
			}
		});

		this.registerServerbound(State.LOGIN, ServerboundLoginPackets.ENCRYPTION_KEY, new PacketHandlers() {
			@Override
			public void register() {
				map(Types.SHORT_BYTE_ARRAY, Types.BYTE_ARRAY_PRIMITIVE); // shared secret
				map(Types.SHORT_BYTE_ARRAY, Types.BYTE_ARRAY_PRIMITIVE); // verification token
			}
		});

		this.registerServerbound(ServerboundPackets1_6_4.KEEP_ALIVE, new PacketHandlers() {
			@Override
			public void register() {
				map(Types.INT, Types.VAR_INT); // id
			}
		});
	}

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
