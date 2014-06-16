package robomuss.rc.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import robomuss.rc.block.te.TileEntityTrack;
import robomuss.rc.item.RCItems;

public class BlockTrack extends BlockContainer {

	public BlockTrack() {
		super(Material.iron);
		setHardness(1F);
		setResistance(3F);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			if(player.getHeldItem() != null) {
				if(player.getHeldItem().getItem() == RCItems.hammer) {
					TileEntityTrack tet = (TileEntityTrack) world.getTileEntity(x, y, z);
					if(tet.direction == 3) {
						tet.direction = 0;
					}
					else {
						tet.direction++;
					}
					world.markBlockForUpdate(x, y, z);
					return true;
				}
				else if(player.getHeldItem().getItem() == RCItems.brush) {
					TileEntityTrack tet = (TileEntityTrack) world.getTileEntity(x, y, z);
					tet.colour = player.getHeldItem().getItemDamage();
					world.markBlockForUpdate(x, y, z);
					return true;
				}
				else {
					return false;
				}
				
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

    public static final boolean isTrack(World world, int x, int y, int z)
    {
        return isTrack(world.getBlock(x, y, z));
    }

    public static final boolean isTrack(Block block)
    {
        return block instanceof BlockTrack;
    }


    public double getRailMaxSpeed()
    {
        return 0.2D;
    }

}
