package robomuss.rc.block;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import robomuss.rc.block.te.TileEntityFlatTrack;
import robomuss.rc.block.te.TileEntitySlopedTrack;
import robomuss.rc.block.te.TileEntityTransitionTrack;
import robomuss.rc.item.ItemBlockTrack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RCBlocks {

	public static Block flat_track, transition_track, sloped_track;
	
	public static void init() {
		flat_track = new BlockFlatTrack().setBlockName("flat_track").setBlockTextureName("rc:flat_track").setCreativeTab(CreativeTabs.tabTransport);
		transition_track = new BlockTransitionTrack().setBlockName("transition_track").setBlockTextureName("rc:transition_track").setCreativeTab(CreativeTabs.tabTransport);
		sloped_track = new BlockSlopedTrack().setBlockName("sloped_track").setBlockTextureName("rc:sloped_track").setCreativeTab(CreativeTabs.tabTransport);
		
		GameRegistry.registerBlock(flat_track, ItemBlockTrack.class, "flat_track");
		GameRegistry.registerBlock(transition_track, ItemBlockTrack.class, "transition_track");
		GameRegistry.registerBlock(sloped_track, ItemBlockTrack.class, "sloped_track");
		
		GameRegistry.registerTileEntity(TileEntityFlatTrack.class, "te_flat_track");
		GameRegistry.registerTileEntity(TileEntityTransitionTrack.class, "te_transition_track");
		GameRegistry.registerTileEntity(TileEntitySlopedTrack.class, "te_sloped_track");
	}

}
