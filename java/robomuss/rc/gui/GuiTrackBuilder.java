package robomuss.rc.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import robomuss.rc.RCMod;
import robomuss.rc.netty.packets.PacketPlaceBlocks;

public class GuiTrackBuilder extends GuiScreen {

	private EntityPlayer player;
	private World world;
	private int x;
	private int y;
	private int z;
	private int direction;
	
	public GuiTrackBuilder(EntityPlayer player, World world, int x, int y, int z) {
		this.player = player;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		//TileEntityTrackBuilder trackbuilder = (TileEntityTrack) world.getTileEntity(x, y, z);




	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		buttonList.clear();
		
		buttonList.add(new GuiButton(0, 10, 10, 20, 20, "|"));
		buttonList.add(new GuiButton(1, 40, 10, 20, 20, "_/"));
		buttonList.add(new GuiButton(2, 70, 10, 20, 20, "/"));
		buttonList.add(new GuiButton(3, 100, 10, 20, 20, "/-"));
		buttonList.add(new GuiButton(4, 130, 10, 20, 20, new String("\\").substring(0, 1) + "_"));
		buttonList.add(new GuiButton(5, 160, 10, 20, 20, new String("\\").substring(0, 1)));
		buttonList.add(new GuiButton(6, 190, 10, 20, 20, new String("-\\").substring(0, 2)));
		buttonList.add(new GuiButton(7, 220, 10, 20, 20, "�"));
		buttonList.add(new GuiButton(8, 250, 10, 20, 20, "o"));
		
		buttonList.add(new GuiButton(9, 10, 40, 20, 20, "< >"));
		buttonList.add(new GuiButton(10, 40, 40, 50, 20, "Build"));
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3) {
		super.drawScreen(par1, par2, par3);
		
		drawString(fontRendererObj, "Direction: " + direction, 10, 70, 0xFFFFFF);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		int id = button.id;

         if(id > 0 && id <10)
         {
             RCMod.packetPipeline.sendToDimension(new PacketPlaceBlocks(this.x, this.y, this.z, id, direction), world.provider.dimensionId);
         }


	}

	private void change(int id) {
		/*player.posX = x;
		player.posY = y + 1;
		player.posZ = z;*/
	}
}
