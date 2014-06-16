package robomuss.rc.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import robomuss.rc.block.render.*;
import robomuss.rc.block.te.*;
import robomuss.rc.entity.EntityTrain;
import robomuss.rc.entity.RenderTrain;

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

        RenderingRegistry.registerEntityRenderingHandler(EntityTrain.class, new RenderTrain());
	}
}
