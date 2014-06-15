package robomuss.rc.block;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

public class BlockRailings extends BlockPane {

	public BlockRailings(String par1) {
		super("rc:" + par1, "rc:" + par1, Material.iron, true);
		setHardness(1F);
		setResistance(3F);
	}
}
