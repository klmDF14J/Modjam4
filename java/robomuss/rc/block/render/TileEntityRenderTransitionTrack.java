package robomuss.rc.block.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import robomuss.rc.block.model.ModelTransitionTrack;
import robomuss.rc.block.te.TileEntityTransitionTrack;
import robomuss.rc.util.ColourUtil;


public class TileEntityRenderTransitionTrack extends TileEntitySpecialRenderer {

	private ModelTransitionTrack model;

	public TileEntityRenderTransitionTrack() {
		this.model = new ModelTransitionTrack();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		GL11.glPushMatrix();
		int colour = ((TileEntityTransitionTrack) te).colour;
		//GL11.glColor4f(ColourUtil.getRed(colour), ColourUtil.getGreen(colour), ColourUtil.getBlue(colour), ColourUtil.getAlpha(colour));
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		ResourceLocation textures = (new ResourceLocation("rc:textures/models/colour_" + colour + ".png"));

		Minecraft.getMinecraft().renderEngine.bindTexture(textures);

		GL11.glPushMatrix();
		switch(((TileEntityTransitionTrack) te).direction){
        case 1:
        		GL11.glRotatef(180f, -180f, 0f, 0f);
                break;
        case 2:
                GL11.glRotatef(180f, 180f, 0f, 180f);
                break;
        case 3:
                GL11.glRotatef(180f, 0f, 0f, 180f);
                break;
        default:
        		GL11.glRotatef(180f, -180f, 0f, 180f);
        		break;
		}

		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
