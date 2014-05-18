package robomuss.rc.proxy;

import robomuss.rc.block.render.TileEntityRenderCurvedTrack;
import robomuss.rc.block.render.TileEntityRenderFlatTrack;
import robomuss.rc.block.render.TileEntityRenderLoop;
import robomuss.rc.block.render.TileEntityRenderRideFence;
import robomuss.rc.block.render.TileEntityRenderSlopedTrack;
import robomuss.rc.block.render.TileEntityRenderSupport;
import robomuss.rc.block.render.TileEntityRenderTransitionTrack;
import robomuss.rc.block.render.TileEntityRenderTransitionTrack2;
import robomuss.rc.block.te.TileEntityCurvedTrack;
import robomuss.rc.block.te.TileEntityFlatTrack;
import robomuss.rc.block.te.TileEntityLoop;
import robomuss.rc.block.te.TileEntityRideFence;
import robomuss.rc.block.te.TileEntitySlopedTrack;
import robomuss.rc.block.te.TileEntitySupport;
import robomuss.rc.block.te.TileEntityTransitionTrack;
import robomuss.rc.block.te.TileEntityTransitionTrack2;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void initRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlatTrack.class, new TileEntityRenderFlatTrack());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTransitionTrack.class, new TileEntityRenderTransitionTrack());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTransitionTrack2.class, new TileEntityRenderTransitionTrack2());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySlopedTrack.class, new TileEntityRenderSlopedTrack());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCurvedTrack.class, new TileEntityRenderCurvedTrack());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLoop.class, new TileEntityRenderLoop());
        
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySupport.class, new TileEntityRenderSupport());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRideFence.class, new TileEntityRenderRideFence());
	}
}
