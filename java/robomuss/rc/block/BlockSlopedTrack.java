package robomuss.rc.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import robomuss.rc.block.te.TileEntitySlopedTrack;

public class BlockSlopedTrack extends BlockTrack {

	public BlockSlopedTrack() {
		super();
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntitySlopedTrack();
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}


	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return 110;
	}

}
