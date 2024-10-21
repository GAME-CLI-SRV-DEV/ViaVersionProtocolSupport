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
import com.viaversion.viabackwards.api.BackwardsProtocol;

import static com.viaversion.viaversion.util.ProtocolUtil.packetTypeMap;

// Thanks To ViaBackwards For the Template for ViaLegacy Protocol.

public final class Protocolr1_7_2_5tor1_6_4 extends BackwardsProtocol<ClientboundPackets1_7_2_5, ClientboundPackets1_6_4, ServerboundPackets1_7_2_5, ServerboundPackets1_6_4> {

    // ViaBackwards uses its own mappings and also needs a translatablerewriter for translation mappings
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.7.2", "1.6.4", Protocol1_6_4To1_7_2_5.class);
    private final TranslatableRewriter<ClientboundPackets1_7_2_5> translatableRewriter = new TranslatableRewriter<>(this, ReadType.NBT);
    private final TagRewriter<ClientboundPackets1_7_2_5> tagRewriter = new TagRewriter<>(this);

    public Protocolr1_7_2_5tor1_6_4() {
        super(ClientboundPackets1_7_2_5.class, ClientboundPackets1_6_4.class, ServerboundPackets1_7_2_5.class, ServerboundPackets1_6_4.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();

        //tagRewriter.registerGeneric(ClientboundPackets1_7_2_5.UPDATE_TAGS);
        //tagRewriter.registerGeneric(ClientboundConfigurationPackets1_21.UPDATE_TAGS);
        new StatisticsRewriter<>(this).register(ClientboundPackets1_7_2_5.AWARD_STATS);
        //new AttributeRewriter<>(this).register1_6_4(ClientboundPackets1_7_2_5.ENTITY_PROPERTIES);

        // Registers translatable mappings (missing a whole bunch still)
        //translatableRewriter.registerOpenWindow(ClientboundPackets1_7_2_5.OPEN_WINDOW); // Handled by registerOpenWindow in item rewriters
        //translatableRewriter.registerComponentPacket(ClientboundPackets1_7_2_5.SET_ACTION_BAR_TEXT);
        //translatableRewriter.registerComponentPacket(ClientboundPackets1_7_2_5.SET_TITLE_TEXT);
        //translatableRewriter.registerComponentPacket(ClientboundPackets1_7_2_5.SET_SUBTITLE_TEXT);
        //translatableRewriter.registerBossEvent(ClientboundPackets1_7_2_5.BOSS_EVENT);
        translatableRewriter.registerComponentPacket(ClientboundPackets1_7_2_5.DISCONNECT);
        // translatableRewriter.registerTabList(ClientboundPackets1_7_2_5.TAB_LIST);
        // translatableRewriter.registerPlayerCombatKill1_20(ClientboundPackets1_7_2_5.PLAYER_COMBAT_KILL);
        //translatableRewriter.registerComponentPacket(ClientboundPackets1_7_2_5.SYSTEM_CHAT);
        //translatableRewriter.registerComponentPacket(ClientboundPackets1_7_2_5.DISGUISED_CHAT);
        translatableRewriter.registerPing();
    }
/*
    @Override
    public void init(final UserConnection user) {
        //addEntityTracker(user, new EntityTrackerBase(user, EntityTypes1_7_2_5.PLAYER));
    }
*/
    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    // @Override
    // public EntityPacketRewriter1_7_2_5 getEntityRewriter() {
    //    return entityRewriter;
    // }

    // @Override
    // public BlockItemPacketRewriter1_7_2_5 getItemRewriter() {
    //   return itemRewriter;
    // }
/*
    @Override
    public TranslatableRewriter<ClientboundPackets1_7_2_5> getComponentRewriter() {
        return translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_7_2_5> getTagRewriter() {
        return tagRewriter;
    }

    @Override
    protected PacketTypesProvider<ClientboundPackets1_7_2_5, ClientboundPackets1_6_4, ServerboundPacket1_7_2_5, ServerboundPacket1_6_4> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<>(
            packetTypeMap(unmappedClientboundPacketType, ClientboundPackets1_7_2_5.class, ClientboundPackets1_6_4.class),
            packetTypeMap(mappedClientboundPacketType, ClientboundPackets1_7_2_5.class, ClientboundPackets1_6_4.class),
            packetTypeMap(mappedServerboundPacketType, ServerboundPackets1_7_2_5.class, ServerboundPackets1_6_4.class),
            packetTypeMap(unmappedServerboundPacketType, ServerboundPackets1_7_2_5.class, ServerboundPackets1_6_4.class)
        );
    }
}
*/
}
