package robomuss.rc.block.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import robomuss.rc.block.model.ModelCurvedTrack;
import robomuss.rc.block.model.ModelFlatTrack;
import robomuss.rc.block.te.TileEntityCurvedTrack;
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
		/*switch(((TileEntityLoop) te).direction){
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
		}*/
		GL11.glTranslatef((float) x + 0.5F, (float) y, (float) z + 0.5F);
		for(int i = 0; i < 18; i++) {
			GL11.glRotatef(10f, 0f, 0f, 1f);
			this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glRotatef(0f, 0f, 0f, 0f);
			GL11.glTranslatef(0f, 0f, 0f);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float) x + 0.5F, (float) y, (float) z + 0.5f);
		for(int i = 0; i < 16; i++) {
			if(i >= 14) {
				GL11.glRotatef(-10f, 0f, 0f, 1f);
			}
			else {
				GL11.glRotatef(-4f, 0f, 1f, 0f);
				GL11.glRotatef(-10f, 0f, 0f, 1f);
			}
			
			this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glRotatef(0f, 0f, 0f, 0f);
			GL11.glTranslatef(0f, 0f, 0f);
		}
		
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 2F, (float) y - 0.45F, (float) z + 0.5F);
		GL11.glRotatef(180f, 0f, 0f, 1f);
		GL11.glRotatef(-35f, 0f, 0f, 1f);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 2.1F, (float) y - 0.5F, (float) z + 0.5F);
		GL11.glRotatef(180f, 0f, 0f, 1f);
		GL11.glRotatef(0f, 0f, 0f, 1f);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}
