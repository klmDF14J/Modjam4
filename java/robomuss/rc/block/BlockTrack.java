package robomuss.rc.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import robomuss.rc.item.RCItems;

public class BlockTrack extends BlockContainer {

	public BlockTrack() {
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			if(player.getHeldItem() != null && player.getHeldItem().getItem() == RCItems.hammer) {
				if(world.getBlockMetadata(x, y, z) % 4 == 3) {
					world.setBlockMetadataWithNotify(x, y, z, 0, 0);
				}
				else {
					world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 0);
				}
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
}
