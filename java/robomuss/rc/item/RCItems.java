package robomuss.rc.item;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import robomuss.rc.RCMod;
import cpw.mods.fml.common.registry.GameRegistry;

public class RCItems {

	public static Item hammer, paint, empty_brush, brush;
	
	public static void init() {
		hammer = new ItemHammer().setUnlocalizedName("hammer").setTextureName("rc:hammer").setCreativeTab(RCMod.tools);
		paint = new ItemPaint().setUnlocalizedName("paint").setCreativeTab(RCMod.tools);
		empty_brush = new Item().setUnlocalizedName("empty_brush").setTextureName("rc:brush").setCreativeTab(RCMod.tools);
		brush = new ItemBrush().setUnlocalizedName("brush").setCreativeTab(RCMod.tools);
		
		GameRegistry.registerItem(hammer, "hammer");
		GameRegistry.registerItem(paint, "paint");
		GameRegistry.registerItem(empty_brush, "empty_brush");
		GameRegistry.registerItem(brush, "brush");
		
		GameRegistry.addRecipe(new ItemStack(hammer), new Object[] {
			"X", "Y", 'X', Items.iron_ingot, 'Y', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(empty_brush), new Object[] {
			"X", "Y", 'X', new ItemStack(Blocks.wool, 1, 0), 'Y', Items.stick
		});
		
		for(int i = 0; i < 16; i++) {
			GameRegistry.addRecipe(new ItemStack(paint, 1, i), new Object[] {
				"X X", "XYX", "XXX", 'X', Items.iron_ingot, 'Y', new ItemStack(Items.dye, 1, 15 - i)
			});
			
			GameRegistry.addShapelessRecipe(new ItemStack(brush, 1, i), new Object[] {
				new ItemStack(paint, 1, i), empty_brush
			});
		}
	}

}
