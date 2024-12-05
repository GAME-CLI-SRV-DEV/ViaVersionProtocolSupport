/*
 * From ViaLegacy 
 */
package me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.protocol.r1_7_2_5tor1_6_4.Rewriter;

import net.raphimc.vialegacy.api.remapper.LegacyItemRewriter;
import me.falixsrv.ViaVersionProtocolSupport.protocol.r1_7_2_5tor1_6_4.Protocolr1_7_2_5Tor1_6_4;
import net.raphimc.vialegacy.protocol.release.r1_6_4tor1_7_2_5.packet.ClientboundPackets1_6_4;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ClientBoundPackets1_7_2_5;
import net.raphimc.vialegacy.protocol.release.r1_7_6_10tor1_8.types.Types1_7_6;

public class vvpsrew_item_1_7_2_5tor1_6_4 extends LegacyItemRewriter<ClientboundPackets1_6_4, ServerboundPackets1_7_2_5, Protocolr1_7_2_5Tor1_6_4> {

    public vvpsrew_item_1_7_2_5tor1_6_4(final Protocolr1_7_2_5tor1_6_4 protocol) {
        super(protocol, "1.6.4", Types1_7_6.ITEM, Types1_7_6.ITEM_ARRAY);

      this.addRemappedItem(355, 26, "Bed Block");
      this.addRemappedItem(33, 34, "Piston Head");
      this.addRemappedItem(33, 36, "Piston Moving");
      this.addRemappedItem(331, 55, "Redstone Wire");
      this.addRemappedItem(295, 59, "Wheat Crops");
      this.addRemappedItem(323, 63, "Standing Sign");
      this.addRemappedItem(324, 64, "Oak Door Block");
      this.addRemappedItem(323, 68, "Wall Sign");
      this.addRemappedItem(330, 71, "Iron Door Block");
      this.addRemappedItem(73, 74, "Lit Redstone Ore");
      this.addRemappedItem(76, 75, "Unlit Redstone Torch");
      this.addRemappedItem(338, 83, "Sugar Cane Block");
      this.addRemappedItem(354, 92, "Cake Block");
      this.addRemappedItem(356, 93, "Unlit Redstone Repeater");
      this.addRemappedItem(356, 94, "Lit Redstone Repeater");
      this.addRemappedItem(146, 95, "Locked Chest");
      this.addRemappedItem(361, 104, "Pumpkin Stem");
      this.addRemappedItem(362, 105, "Melon Stem");
      this.addRemappedItem(372, 115, "Nether Wart Block");
      this.addRemappedItem(379, 117, "Brewing Stand Block");
      this.addRemappedItem(380, 118, "Cauldron Block");
      this.addRemappedItem(123, 124, "Lit Redstone Lamp");
      this.addRemappedItem(287, 132, "Tripwire");
      this.addRemappedItem(390, 140, "Flower Pot");
      this.addRemappedItem(397, 144, "Undefined Mob Head");
      this.addRemappedItem(404, 149, "Unlit Redstone Comparator");
      this.addRemappedItem(404, 150, "Lit Redstone Comparator");

        this.addNonExistentItem(3, 2);
        this.addNonExistentItem(5, 4, 5);
        this.addNonExistentItem(6, 4, 5);
        this.addNonExistentItem(12, 1);
        this.addNonExistentItem(38, 1, 8);
        this.addNonExistentItems(95);
        this.addNonExistentItem(97, 3, 5);
        this.addNonExistentItem(126, 4, 5);
        this.addNonExistentItemRange(160, 164);
        this.addNonExistentItemRange(174, 175);
        this.addNonExistentItem(349, 1, 3);
        this.addNonExistentItemRange(350, 1);
    }

    @Override
    protected void registerPackets() {
        this.registerCreativeInventoryAction(ServerboundPackets1_7_2.SET_CREATIVE_MODE_SLOT);
    }

}

