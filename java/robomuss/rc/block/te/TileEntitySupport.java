package robomuss.rc.block.te;

import net.minecraft.tileentity.TileEntity;

public class TileEntitySupport extends TileEntity {
    boolean up, down;
    @Override
    public void updateEntity()
    {
       if(this.worldObj.getTileEntity(this.xCoord , this.yCoord + 1, this.zCoord) instanceof  TileEntitySupport)
       {
        up = true;
       }
        else
       {
           up = false;
       }

        if(this.worldObj.getTileEntity(this.xCoord , this.yCoord - 1, this.zCoord) instanceof  TileEntitySupport)
        {
            down = true;
        }
        else
        {
            down = false;
        }
    }
}
