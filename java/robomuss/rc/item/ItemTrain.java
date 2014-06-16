package robomuss.rc.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import robomuss.rc.entity.EntityTrain;

public class ItemTrain extends Item {


    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10){
     //   if (!BlockTrack.isTrack(par3World.getBlock(par4, par5, par6)))
        // return false;
            if (!par3World.isRemote)
            {
                EntityTrain entity = new EntityTrain(par3World, (double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F));

                par3World.spawnEntityInWorld(entity);
            }
            --par1ItemStack.stackSize;
            return true;
    }
}
