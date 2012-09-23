package jango.mods.starwars;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockDuraSteel extends Block
{
	  public BlockDuraSteel(int var1)
	    {
	        super(var1, 2, Material.iron);
	        this.setCreativeTab(CreativeTabs.tabDeco);
	    }

	    public int idDropped(int var1, Random var2, int var3)
	    {
	        return mod_jangostarwars.DuraSteel.blockID;
	    }
}
