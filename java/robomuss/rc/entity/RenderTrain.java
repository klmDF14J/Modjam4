package robomuss.rc.entity;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class RenderTrain extends Render
{
    private static final ResourceLocation minecartTextures = new ResourceLocation("TEXTURE");
    /** instance of ModelTrain for rendering */
    protected ModelBase modelTrain = new ModelTrain();


    public RenderTrain()
    {
        this.shadowSize = 0.5F;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityTrain entity, double par2, double par4, double par6, float par8, float par9)
    {
        GL11.glPushMatrix();
        this.bindEntityTexture(entity);
        long i = (long)entity.getEntityId() * 493286711L;
        i = i * i * 4392167121L + i * 98761L;
        float f2 = (((float)(i >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        float f3 = (((float)(i >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        float f4 = (((float)(i >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        GL11.glTranslatef(f2, f3, f4);
        double d3 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)par9;
        double d4 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)par9;
        double d5 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)par9;
        double d6 = 0.30000001192092896D;
        Vec3 vec3 = entity.func_70489_a(d3, d4, d5);
        float f5 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9;

        if (vec3 != null)
        {
            Vec3 vec31 = entity.func_70495_a(d3, d4, d5, d6);
            Vec3 vec32 = entity.func_70495_a(d3, d4, d5, -d6);

            if (vec31 == null)
            {
                vec31 = vec3;
            }

            if (vec32 == null)
            {
                vec32 = vec3;
            }

            par2 += vec3.xCoord - d3;
            par4 += (vec31.yCoord + vec32.yCoord) / 2.0D - d4;
            par6 += vec3.zCoord - d5;
            Vec3 vec33 = vec32.addVector(-vec31.xCoord, -vec31.yCoord, -vec31.zCoord);

            if (vec33.lengthVector() != 0.0D)
            {
                vec33 = vec33.normalize();
                par8 = (float)(Math.atan2(vec33.zCoord, vec33.xCoord) * 180.0D / Math.PI);
                f5 = (float)(Math.atan(vec33.yCoord) * 73.0D);
            }
        }

        GL11.glTranslatef((float)par2, (float)par4 + 0.5F, (float)par6);
        GL11.glRotatef(180.0F - par8, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-f5, 0.0F, 0.0F, 1.0F);
        float f7 = (float)entity.getRollingAmplitude() - par9;
        float f8 = entity.getDamage() - par9;

        if (f8 < 0.0F)
        {
            f8 = 0.0F;
        }

        if (f7 > 0.0F)
        {
            GL11.glRotatef(MathHelper.sin(f7) * f7 * f8 / 10.0F * (float)entity.getRollingDirection(), 1.0F, 0.0F, 0.0F);
        }

        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.modelTrain.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityMinecart par1EntityMinecart)
    {
        return minecartTextures;
    }

    protected void func_147910_a(EntityMinecart p_147910_1_, float p_147910_2_, Block p_147910_3_, int p_147910_4_)
    {
        float f1 = p_147910_1_.getBrightness(p_147910_2_);
        GL11.glPushMatrix();
        GL11.glPopMatrix();
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEntityTexture((EntityTrain)par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRender((EntityTrain)par1Entity, par2, par4, par6, par8, par9);
    }
}