package robomuss.rc.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.World;
import robomuss.rc.item.RCItems;

public class EntityTrain extends EntityAnimal
{

    public EntityTrain(World par1World)
    {
        super(par1World);
        this.setSize(0.9F, 0.9F);
        this.tasks.addTask(5, new EntityAIWander(this, 0.0D));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.4D));
        this.boundingBox.setBounds(0.9D, 0.9D, 0.9D, 0D, 0D, 0D);

    }

    @Override
    public boolean canBePushed()
    {
        return false;
    }

    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {}

    public EntityTrain(World par1World, double par2, double par4, double par6)
    {
        this(par1World);
        this.setPosition(par2, par4 + 1, par6);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        if(par1EntityPlayer.isSneaking())
        {
            this.setDead();
            if(!this.worldObj.isRemote)
            this.dropItem(this.getDropItem(), 1);
        }

        if (super.interact(par1EntityPlayer))
        {
            return true;
        }
        else if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer))
        {
            par1EntityPlayer.mountEntity(this);
            return true;
        }
        else
        {
            return false;
        }
    }

    protected Item getDropItem()
    {
        return RCItems.train;
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1)
    {
        super.fall(par1);

        if (par1 > 5.0F && this.riddenByEntity instanceof EntityPlayer)
        {
            ((EntityPlayer)this.riddenByEntity).triggerAchievement(AchievementList.flyPig);
        }
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        //add some thing to change the look drection, might do it in the track block
        this.getLookHelper().setLookPosition(this.posX, this.posY, this.posZ, 0F, 0F);
    }


}
