package robomuss.rc.block;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import robomuss.rc.block.te.TileEntityFlatTrack;


public class BlockFlatTrack extends BlockTrack {

	public BlockFlatTrack() {
		super();
		setBlockBounds(0, 0, 0, 1, 0.5F, 1);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityFlatTrack();
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

    @Override
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
        double m_speed = 0.05D;
        int a = par1World.getBlockMetadata(par2, par3, par4);
        int[] ax = { 0, 1, 0, -1 };
        int[] az = { -1, 0, 1, 0 };

        if (par5Entity != null) {

            if ((ax[a] == 0) && (Math.abs(par2 + 0.5D - par5Entity.posX) < 0.5D) && (Math.abs(par2 + 0.5D - par5Entity.posX) > 0.1D)) {
                par5Entity.motionX += Math.signum(par2 + 0.5D - par5Entity.posX) * Math.min(m_speed, Math.abs(par2 + 0.5D - par5Entity.posX)) / 1.2D;
            }

            if ((az[a] == 0) && (Math.abs(par4 + 0.5D - par5Entity.posZ) < 0.5D) && (Math.abs(par4 + 0.5D - par5Entity.posZ) > 0.1D)) {
                par5Entity.motionZ += Math.signum(par4 + 0.5D - par5Entity.posZ) * Math.min(m_speed, Math.abs(par4 + 0.5D - par5Entity.posZ)) / 1.2D;
            }

            par5Entity.motionX += ax[a] * m_speed;

            par5Entity.motionZ += az[a] * m_speed;
        }
    }
}
