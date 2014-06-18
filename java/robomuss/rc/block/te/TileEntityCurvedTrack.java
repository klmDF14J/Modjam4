package robomuss.rc.block.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

public class TileEntityCurvedTrack extends TileEntityTrack {
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

    @Override
    public int getDirection() {

        if(canReverse() && reverse)
        {
            if(direction == 0){
                return 1;
            }
            if(direction == 1){
                return 0;
            }
            if(direction == 2){
                return 1;
            }
            if(direction == 3){
                return 2;
            }
        }
            if(direction == 0){
                return 3;
            }
            if(direction == 1){
                return 0;
            }
            if(direction == 2){
                return 1;
            }
            if(direction == 3){
                return 2;
            }





         return direction;
    }

    @Override
    public boolean canReverse()
    {
        return true;
    }
}
