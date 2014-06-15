package robomuss.rc.block.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import robomuss.rc.block.model.ModelFlatTrack;
import robomuss.rc.block.te.TileEntityLoop;


public class TileEntityRenderLoop extends TileEntitySpecialRenderer {

	private ModelFlatTrack model;

	public TileEntityRenderLoop() {
		this.model = new ModelFlatTrack();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		GL11.glPushMatrix();
		int colour = ((TileEntityLoop) te).colour;
		//GL11.glColor4f(ColourUtil.getRed(colour), ColourUtil.getGreen(colour), ColourUtil.getBlue(colour), ColourUtil.getAlpha(colour));
		

		ResourceLocation textures = (new ResourceLocation("rc:textures/models/colour_" + colour + ".png"));

		Minecraft.getMinecraft().renderEngine.bindTexture(textures);

		GL11.glPushMatrix();

		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(-20f, 0f, 0f, -1f);
		for(int i = 0; i < 16; i++) {
			GL11.glRotatef(10f, 0f, 0f, 1f);
			this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glRotatef(0f, 0f, 0f, 0f);
			GL11.glTranslatef(0f, 0f, 0f);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 1.5f);
		GL11.glRotatef(-20f, 0f, 0f, 1f);
		for(int i = 0; i < 16; i++) {
			GL11.glRotatef(-10f, 0f, 0f, 1f);
			this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glRotatef(0f, 0f, 0f, 0f);
			GL11.glTranslatef(0f, 0f, 0f);
		}
		GL11.glPopMatrix();
		
		
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 1.4f);
		GL11.glRotatef(-5f, 0f, 0f, 1f);
		GL11.glRotatef(-30f, 0f, 1f, 0f);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.2F, (float) y + 1.5F, (float) z + 1f);
		GL11.glRotatef(-5f, 0f, 0f, 1f);
		GL11.glRotatef(-60f, 0f, 1f, 0f);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y + 1.5F, (float) z + 0.6f);
		GL11.glRotatef(-5f, 0f, 0f, 1f);
		GL11.glRotatef(-30f, 0f, 1f, 0f);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}
