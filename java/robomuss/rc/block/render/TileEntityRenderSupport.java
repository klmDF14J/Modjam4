package robomuss.rc.block.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import robomuss.rc.block.model.ModelTrackSupport;

public class TileEntityRenderSupport extends TileEntitySpecialRenderer {
    
    public ModelTrackSupport model;
    
    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float var8) {
        GL11.glPushMatrix();

        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

        ResourceLocation textures = (new ResourceLocation("rc:textures/models/support.png"));

        Minecraft.getMinecraft().renderEngine.bindTexture(textures);

        GL11.glPushMatrix();



        this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
