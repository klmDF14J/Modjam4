package robomuss.rc.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import robomuss.rc.block.te.TileEntityCurvedTrack;

public class BlockCurvedTrack extends BlockTrack {

	public BlockCurvedTrack() {
		super();
		setBlockBounds(0, 0, 0, 1, 0.5F, 1);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityCurvedTrack();
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
	
	@Override
	public int damageDropped(int dmg) {
		return dmg;
	}
}
