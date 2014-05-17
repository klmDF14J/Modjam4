package robomuss.rc.proxy;

import robomuss.rc.block.render.TileEntityRenderCurvedTrack;
import robomuss.rc.block.render.TileEntityRenderFlatTrack;
import robomuss.rc.block.render.TileEntityRenderSlopedTrack;
import robomuss.rc.block.render.TileEntityRenderSupport;
import robomuss.rc.block.render.TileEntityRenderTransitionTrack;
import robomuss.rc.block.te.TileEntityCurvedTrack;
import robomuss.rc.block.te.TileEntityFlatTrack;
import robomuss.rc.block.te.TileEntitySlopedTrack;
import robomuss.rc.block.te.TileEntitySupport;
import robomuss.rc.block.te.TileEntityTransitionTrack;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void initRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlatTrack.class, new TileEntityRenderFlatTrack());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTransitionTrack.class, new TileEntityRenderTransitionTrack());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySlopedTrack.class, new TileEntityRenderSlopedTrack());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCurvedTrack.class, new TileEntityRenderCurvedTrack());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySupport.class, new TileEntityRenderSupport());
	}
}
