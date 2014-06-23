package robomuss.rc.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import robomuss.rc.RCMod;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {

	public GuiHandler() {
		 NetworkRegistry.INSTANCE.registerGuiHandler(RCMod.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0) {
			return new GuiTrackBuilder(player, world, x, y, z);
		}
		return null;
	}
}
