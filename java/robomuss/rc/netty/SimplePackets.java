package robomuss.rc.netty;

import robomuss.rc.RCMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class SimplePackets {

    public static  SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(RCMod.MODID);

    public static void init()
    {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(RCMod.MODID);
        INSTANCE.registerMessage(messageTrackBuilder.class, messageTrackBuilder.class, 0, Side.SERVER);
    }
}
