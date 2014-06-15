package robomuss.rc.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPath extends Block {

	public int paths = 10;
	
	public BlockPath() {
		super(Material.carpet);
		setBlockBounds(0, 0, 0, 1, 0.05F, 1);
		setHardness(1F);
		setResistance(3F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isBlockNormalCube() {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
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
	
	@Override
	public int damageDropped(int dmg) {
		return dmg;
	}
}
