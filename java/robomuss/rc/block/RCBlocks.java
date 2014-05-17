package robomuss.rc.block;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import robomuss.rc.block.te.TileEntityCurvedTrack;
import robomuss.rc.block.te.TileEntityFlatTrack;
import robomuss.rc.block.te.TileEntitySlopedTrack;
import robomuss.rc.block.te.TileEntitySupport;
import robomuss.rc.block.te.TileEntityTransitionTrack;
import robomuss.rc.item.ItemBlockPath;
import cpw.mods.fml.common.registry.GameRegistry;

public class RCBlocks {

	public static Block flat_track, transition_track, sloped_track, curved_track, support, path;
	
	public static void init() {
		flat_track = new BlockFlatTrack().setBlockName("flat_track").setBlockTextureName("rc:flat_track").setCreativeTab(CreativeTabs.tabTransport);
		transition_track = new BlockTransitionTrack().setBlockName("transition_track").setBlockTextureName("rc:transition_track").setCreativeTab(CreativeTabs.tabTransport);
		sloped_track = new BlockSlopedTrack().setBlockName("sloped_track").setBlockTextureName("rc:sloped_track").setCreativeTab(CreativeTabs.tabTransport);
		curved_track = new BlockCurvedTrack().setBlockName("curved_track").setBlockTextureName("rc:curved_track").setCreativeTab(CreativeTabs.tabTransport);
        
		support = new BlockSupport().setBlockName("support").setBlockTextureName("rc:support").setCreativeTab(CreativeTabs.tabTransport);

        path = new BlockPath().setBlockName("path").setCreativeTab(CreativeTabs.tabBlock);
		
		GameRegistry.registerBlock(flat_track, "flat_track");
		GameRegistry.registerBlock(transition_track, "transition_track");
		GameRegistry.registerBlock(sloped_track, "sloped_track");
		GameRegistry.registerBlock(curved_track, "curved_track");
		
        GameRegistry.registerBlock(support, "support");
        
        GameRegistry.registerBlock(path, ItemBlockPath.class, "path");
		
		GameRegistry.registerTileEntity(TileEntityFlatTrack.class, "te_flat_track");
		GameRegistry.registerTileEntity(TileEntityTransitionTrack.class, "te_transition_track");
		GameRegistry.registerTileEntity(TileEntitySlopedTrack.class, "te_sloped_track");
		GameRegistry.registerTileEntity(TileEntityCurvedTrack.class, "te_curved_track");
        GameRegistry.registerTileEntity(TileEntitySupport.class, "te_support");
	}

}
