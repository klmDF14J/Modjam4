package robomuss.rc.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import robomuss.rc.block.te.TileEntityTrack;
import robomuss.rc.entity.EntityTrain;
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

    /**
     * Returns the max speed of the rail at the specified position.
     * @param world The world.
     * @param cart The cart on the rail, may be null.
     * @param x The rail X coordinate.
     * @param y The rail Y coordinate.
     * @param z The rail Z coordinate.
     * @return The max speed of the current rail.
     */
    public float getRailMaxSpeed(World world, EntityTrain cart, int y, int x, int z)
    {
        return 0.4f;
    }

    /**
     * Return the rail's metadata (without the power bit if the rail uses one).
     * Can be used to make the cart think the rail something other than it is,
     * for example when making diamond junctions or switches.
     * The cart parameter will often be null unless it it called from EntityMinecart.
     *
     * Valid rail metadata is defined as follows:
     * 0x0: flat track going North-South
     * 0x1: flat track going West-East
     * 0x2: track ascending to the East
     * 0x3: track ascending to the West
     * 0x4: track ascending to the North
     * 0x5: track ascending to the South
     * 0x6: WestNorth corner (connecting East and South)
     * 0x7: EastNorth corner (connecting West and South)
     * 0x8: EastSouth corner (connecting West and North)
     * 0x9: WestSouth corner (connecting East and North)
     *
     * @param world The world.
     * @param cart The cart asking for the metadata, null if it is not called by EntityMinecart.
     * @param y The rail X coordinate.
     * @param x The rail Y coordinate.
     * @param z The rail Z coordinate.
     * @return The metadata.
     */
    public int getBasicRailMetadata(IBlockAccess world, EntityTrain cart, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        if(isPowered())
        {
            meta = meta & 7;
        }
        return meta;
    }

    /**
     * Returns true if the block is power related rail.
     */
    public boolean isPowered()
    {
        return false;
    }

}
