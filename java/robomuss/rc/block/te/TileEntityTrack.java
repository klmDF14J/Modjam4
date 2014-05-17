package robomuss.rc.block.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTrack extends TileEntity {

	public int direction;
	public int colour;
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		
		direction = compound.getInteger("direction");
		colour = compound.getInteger("colour");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
		compound.setInteger("direction", direction);
		compound.setInteger("colour", colour);
	}
}
