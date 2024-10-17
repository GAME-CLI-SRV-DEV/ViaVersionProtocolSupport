import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import net.raphimc.vialegacy.api.util.BlockFaceUtil;
import net.raphimc.vialegacy.protocol.release.r1_6_1tor1_6_2.packet.ClientboundPackets1_6_1;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.packet.ClientboundPackets1_6_4;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.packet.ServerboundPackets1_6_4;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.types.Types1_6_4;
import net.raphimc.vialegacy.protocol.release.r1_7_6_10tor1_8.types.Types1_7_6;
import com.viaversion.viaversion.rewriter.ComponentRewriter;

public class Protocolr1_7_2_5Tor1_6_1 extends StatelessProtocol<ClientboundPackets1_6_1, ClientboundPackets1_6_4, ServerboundPackets1_6_4, ServerboundPackets1_6_4> {

    public Protocolr1_7_2_5Tor1_6_1() {
        super(ClientboundPackets1_6_1.class, ClientboundPackets1_6_4.class, ServerboundPackets1_6_4.class, ServerboundPackets1_6_4.class);
    }

    @Override
    protected void registerPackets() {
        this.registerClientbound(ClientboundPackets1_6_1.LOGIN, wrapper -> {
            final PacketWrapper brand = PacketWrapper.create(ClientboundPackets1_6_4.CUSTOM_PAYLOAD, wrapper.user());
            brand.write(Types1_6_4.STRING, "MC|Brand");
            final byte[] brandBytes = "legacy".getBytes(StandardCharsets.UTF_8);
            brand.write(Types.SHORT, (short) brandBytes.length); // length
            brand.write(Types.REMAINING_BYTES, brandBytes); // data

            wrapper.send(Protocolr1_6_1Tor1_6_2.class);
            brand.send(Protocolr1_6_1Tor1_6_2.class);
            wrapper.cancel();
        });
        this.registerClientbound(ClientboundPackets1_6_1.UPDATE_ATTRIBUTES, new PacketHandlers() {
            @Override
            public void register() {
                map(Types.INT); // entity id
                handler(wrapper -> {
                    final int amount = wrapper.passthrough(Types.INT); // count
                    for (int i = 0; i < amount; i++) {
                        wrapper.passthrough(Types1_6_4.STRING); // id
                        wrapper.passthrough(Types.DOUBLE); // baseValue
                        wrapper.write(Types.SHORT, (short) 0); // modifier count
                    }
                });
            }
        });

        this.registerServerbound(ServerboundPackets1_6_4.USE_ITEM_ON, new PacketHandlers() {
            @Override
            public void register() {
                map(Types1_7_6.BLOCK_POSITION_UBYTE); // position
                map(Types.UNSIGNED_BYTE); // direction
                map(Types1_7_6.ITEM); // item
                map(Types.UNSIGNED_BYTE); // offset x
                map(Types.UNSIGNED_BYTE); // offset y
                map(Types.UNSIGNED_BYTE); // offset z
                handler(wrapper -> {
                    final BlockPosition pos = wrapper.get(Types1_7_6.BLOCK_POSITION_UBYTE, 0);
                    final short direction = wrapper.get(Types.UNSIGNED_BYTE, 0);
                    final Item item = wrapper.get(Types1_7_6.ITEM, 0);

                    if (item != null && item.identifier() == ItemList1_6.sign.itemId() && direction != 255 && direction != 0) { // If placed item is a sign then cancel and send a OPEN_SIGN_EDITOR packet
                        final PacketWrapper openSignEditor = PacketWrapper.create(ClientboundPackets1_6_4.OPEN_SIGN_EDITOR, wrapper.user());
                        openSignEditor.write(Types.BYTE, (byte) 0); // magic value
                        openSignEditor.write(Types1_7_6.BLOCK_POSITION_INT, pos.getRelative(BlockFaceUtil.getFace(direction)));
                        openSignEditor.send(Protocolr1_6_1Tor1_6_2.class);
                    }
                });
            }
        });
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new PreNettySplitter(Protocolr1_6_1Tor1_6_2.class, ClientboundPackets1_6_1::getPacket));
    }

}
