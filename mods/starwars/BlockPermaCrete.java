package jango.mods.starwars;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockPermaCrete extends Block
{
	  public BlockPermaCrete(int var1)
	    {
	        super(var1, 2, Material.rock);
	        this.setCreativeTab(CreativeTabs.tabDeco);
	    }

	    public int idDropped(int var1, Random var2, int var3)
	    {
	        return mod_jangostarwars.PermaCrete.blockID;
	    }
}
