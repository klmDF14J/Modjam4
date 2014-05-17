package robomuss.rc.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockTrack extends ItemBlock {

	public ItemBlockTrack(Block p_i45328_1_) {
		super(p_i45328_1_);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return stack.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
}
