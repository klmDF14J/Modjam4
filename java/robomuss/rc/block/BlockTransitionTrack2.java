package robomuss.rc.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import robomuss.rc.block.te.TileEntityTransitionTrack2;

public class BlockTransitionTrack2 extends BlockTrack {
	
	public BlockTransitionTrack2() {
		super();
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityTransitionTrack2();
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
