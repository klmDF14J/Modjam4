package robomuss.rc.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RCItems {

	public static Item hammer, brush;
	
	public static void init() {
		hammer = new ItemHammer().setUnlocalizedName("hammer").setTextureName("rc:hammer").setCreativeTab(CreativeTabs.tabTools);
		brush = new ItemBrush().setUnlocalizedName("brush").setCreativeTab(CreativeTabs.tabTools);
		
		GameRegistry.registerItem(hammer, "hammer");
		GameRegistry.registerItem(brush, "brush");
		
		GameRegistry.addRecipe(new ItemStack(hammer), new Object[] {
			"X", "Y", 'X', Items.iron_ingot, 'Y', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(brush, 1, 0), new Object[] {
			"X", "Y", "Z", 'X', new ItemStack(Items.dye, 1, 15), 'Y', Blocks.wool, 'Z', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(brush, 1, 1), new Object[] {
			"X", "Y", "Z", 'X', new ItemStack(Items.dye, 1, 0), 'Y', Blocks.wool, 'Z', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(brush, 1, 2), new Object[] {
			"X", "Y", "Z", 'X', new ItemStack(Items.dye, 1, 1), 'Y', Blocks.wool, 'Z', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(brush, 1, 3), new Object[] {
			"X", "Y", "Z", 'X', new ItemStack(Items.dye, 1, 4), 'Y', Blocks.wool, 'Z', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(brush, 1, 4), new Object[] {
			"X", "Y", "Z", 'X', new ItemStack(Items.dye, 1, 11), 'Y', Blocks.wool, 'Z', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(brush, 1, 5), new Object[] {
			"X", "Y", "Z", 'X', new ItemStack(Items.dye, 1, 2), 'Y', Blocks.wool, 'Z', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(brush, 1, 6), new Object[] {
			"X", "Y", "Z", 'X', new ItemStack(Items.dye, 1, 6), 'Y', Blocks.wool, 'Z', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(brush, 1, 7), new Object[] {
			"X", "Y", "Z", 'X', new ItemStack(Items.dye, 1, 13), 'Y', Blocks.wool, 'Z', Items.stick
		});
	}

}
