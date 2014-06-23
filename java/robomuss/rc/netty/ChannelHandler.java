package robomuss.rc.netty;

import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

import java.io.IOException;
import java.util.EnumMap;
import java.util.logging.Logger;

public class ChannelHandler extends FMLIndexedMessageToMessageCodec<SimplePacket> {
	private static EnumMap<Side, FMLEmbeddedChannel>	channels;

	public ChannelHandler() {

	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, SimplePacket msg, ByteBuf target) throws Exception {
		msg.writePacketData(target);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, SimplePacket msg) {
		try {
			msg.readPacketData(source);
			msg.execute();
		}
		catch (IOException e) {
			Logger.getLogger("RCMod").warning("Something caused a Protocol Exception!");
		}
	}

	public static void setChannels(EnumMap<Side, FMLEmbeddedChannel> _channels) {
		channels = _channels;
	}

	public static EnumMap<Side, FMLEmbeddedChannel> getChannels() {
		return channels;
	}

	public static void sendPacketToServer(SimplePacket packet) {
		ChannelHandler.getChannels().get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
		ChannelHandler.getChannels().get(Side.CLIENT).writeOutbound(packet);
	}

	public static void sendPacketToPlayer(SimplePacket packet, EntityPlayer player) {
		ChannelHandler.getChannels().get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
		ChannelHandler.getChannels().get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
		ChannelHandler.getChannels().get(Side.SERVER).writeOutbound(packet);
	}

	public static void sendPacketToAllPlayers(SimplePacket packet) {
		ChannelHandler.getChannels().get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
		ChannelHandler.getChannels().get(Side.SERVER).writeOutbound(packet);
	}

	public static void sendPacketToAllPlayers(Packet packet, World world) {
		for (Object player : world.playerEntities) {
			if (player instanceof EntityPlayerMP)
				if (player != null)
					((EntityPlayerMP) player).playerNetServerHandler.sendPacket(packet);
		}
	}
}
