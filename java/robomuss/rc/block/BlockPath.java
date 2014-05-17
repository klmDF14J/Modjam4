package robomuss.rc.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockPath extends Block {

	public int paths = 4;
	
	public BlockPath() {
		super(Material.rock);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for(int i = 0; i < paths; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	private IIcon[] icons;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		icons = new IIcon[paths];
		
		for(int i = 0; i < paths; i++) {
			icons[i] = register.registerIcon("rc:path_" + i);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return icons[meta];
	}
}
