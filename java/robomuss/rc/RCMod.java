package robomuss.rc;

import robomuss.rc.block.RCBlocks;
import robomuss.rc.item.RCItems;
import robomuss.rc.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RCMod.MODID, name = RCMod.NAME, version = RCMod.VERSION)
public class RCMod {
	
	public static final String MODID = "rc";
	public static final String NAME = "Rollercoaster Mod";
	public static final String VERSION = "1.0";

	@SidedProxy(clientSide="robomuss.rc.proxy.ClientProxy", serverSide="robomuss.rc.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.initRenderers();
		RCBlocks.init();
		RCItems.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
