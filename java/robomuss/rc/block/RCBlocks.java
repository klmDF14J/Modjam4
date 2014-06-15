package robomuss.rc.block;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import robomuss.rc.RCMod;
import robomuss.rc.block.te.TileEntityCurvedTrack;
import robomuss.rc.block.te.TileEntityFlatTrack;
import robomuss.rc.block.te.TileEntityLoop;
import robomuss.rc.block.te.TileEntityRideFence;
import robomuss.rc.block.te.TileEntitySlopedTrack;
import robomuss.rc.block.te.TileEntitySupport;
import robomuss.rc.block.te.TileEntityTrackDesigner;
import robomuss.rc.block.te.TileEntityTransitionTrack;
import robomuss.rc.block.te.TileEntityTransitionTrack2;
import robomuss.rc.item.ItemBlockPath;
import cpw.mods.fml.common.registry.GameRegistry;

public class RCBlocks {

	public static Block flat_track, transition_track, transition_track_2, sloped_track, curved_track, loop, support, path, railings, picket, ride_fence, track_designer;
	
	public static void init() {
		flat_track = new BlockFlatTrack().setBlockName("flat_track").setBlockTextureName("rc:flat_track").setCreativeTab(RCMod.track);
		transition_track = new BlockTransitionTrack().setBlockName("transition_track").setBlockTextureName("rc:transition_track").setCreativeTab(RCMod.track);
		transition_track_2 = new BlockTransitionTrack2().setBlockName("transition_track_2").setBlockTextureName("rc:transition_track_2").setCreativeTab(RCMod.track);
		sloped_track = new BlockSlopedTrack().setBlockName("sloped_track").setBlockTextureName("rc:sloped_track").setCreativeTab(RCMod.track);
		curved_track = new BlockCurvedTrack().setBlockName("curved_track").setBlockTextureName("rc:curved_track").setCreativeTab(RCMod.track);
        loop = new BlockLoop().setBlockName("loop").setBlockTextureName("rc:loop").setCreativeTab(RCMod.track);
        
		support = new BlockSupport().setBlockName("support").setBlockTextureName("rc:support").setCreativeTab(RCMod.track);
		track_designer = new BlockTrackDesigner().setBlockTextureName("rc:track_designer").setCreativeTab(RCMod.track);
		
        path = new BlockPath().setBlockName("path").setCreativeTab(RCMod.decor);
		railings = new BlockRailings("railings").setBlockName("railings").setCreativeTab(RCMod.decor);
		picket = new BlockRailings("picket").setBlockName("picket").setCreativeTab(RCMod.decor);
		ride_fence = new BlockRideFence().setBlockName("ride_fence").setBlockTextureName("rc:ride_fence").setCreativeTab(RCMod.decor);
		
		GameRegistry.registerBlock(flat_track, "flat_track");
		GameRegistry.registerBlock(transition_track, "transition_track");
		GameRegistry.registerBlock(transition_track_2, "transition_track_2");
		GameRegistry.registerBlock(sloped_track, "sloped_track");
		GameRegistry.registerBlock(curved_track, "curved_track");
		GameRegistry.registerBlock(loop, "loop");
		
        GameRegistry.registerBlock(support, "support");
        //GameRegistry.registerBlock(track_designer, "track_designer");
        
        GameRegistry.registerBlock(path, ItemBlockPath.class, "path");
		GameRegistry.registerBlock(railings, "railings");
		GameRegistry.registerBlock(picket, "picket");
		GameRegistry.registerBlock(ride_fence, "ride_fence");
        
		GameRegistry.registerTileEntity(TileEntityFlatTrack.class, "te_flat_track");
		GameRegistry.registerTileEntity(TileEntityTransitionTrack.class, "te_transition_track");
		GameRegistry.registerTileEntity(TileEntityTransitionTrack2.class, "te_transition_track_2");
		GameRegistry.registerTileEntity(TileEntitySlopedTrack.class, "te_sloped_track");
		GameRegistry.registerTileEntity(TileEntityCurvedTrack.class, "te_curved_track");
		GameRegistry.registerTileEntity(TileEntityLoop.class, "te_loop");
		
        GameRegistry.registerTileEntity(TileEntitySupport.class, "te_support");
        GameRegistry.registerTileEntity(TileEntityTrackDesigner.class, "te_track_designer");
        
		GameRegistry.registerTileEntity(TileEntityRideFence.class, "te_ride_fence");
		
		GameRegistry.addRecipe(new ItemStack(ride_fence, 4), new Object[] {
			"XXX", "X X", 'X', Items.iron_ingot
		});
		
		GameRegistry.addRecipe(new ItemStack(support, 4), new Object[] {
			" X ", " X ", " X ", 'X', Items.iron_ingot
		});
	}

}
