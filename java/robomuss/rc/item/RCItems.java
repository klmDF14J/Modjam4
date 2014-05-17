package robomuss.rc.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RCItems {

	public static Item hammer, brush;
	
	public static void init() {
		hammer = new ItemHammer().setUnlocalizedName("hammer").setTextureName("rc:hammer").setCreativeTab(CreativeTabs.tabTools);
		brush = new ItemBrush().setUnlocalizedName("brush").setCreativeTab(CreativeTabs.tabTools);
		
		GameRegistry.registerItem(hammer, "hammer");
		GameRegistry.registerItem(brush, "brush");
	}

}
