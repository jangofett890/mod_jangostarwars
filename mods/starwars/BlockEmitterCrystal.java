package jango.mods.starwars;

import java.util.List;
import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockEmitterCrystal extends Block
{
    public static final String[] crystalType = new String[] {"Blue", "Red", "Green", "Purple", "Yellow", "Black", "White"};

    public BlockEmitterCrystal(int var1)
    {
        super(var1, 2, Material.glass);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        switch (var2)
        {
            case 0:
                return mod_jangostarwars.texCrystalBlue;

            case 1:
                return mod_jangostarwars.texCrystalRed;

            case 2:
                return mod_jangostarwars.texCrystalGreen;

            case 3:
                return mod_jangostarwars.texCrystalPurple;

            case 4:
                return mod_jangostarwars.texCrystalYellow;

            case 5:
                return mod_jangostarwars.texCrystalBlack;

            case 6:
                return mod_jangostarwars.texCrystalWhite;

            default:
                return var2;
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    protected int damageDropped(int var1)
    {
        return var1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return mod_jangostarwars.Crystal.shiftedIndex;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int var1, CreativeTabs var2, List var3)
    {
        var3.add(new ItemStack(var1, 1, 0));
        var3.add(new ItemStack(var1, 1, 1));
        var3.add(new ItemStack(var1, 1, 2));
        var3.add(new ItemStack(var1, 1, 3));
        var3.add(new ItemStack(var1, 1, 4));
        var3.add(new ItemStack(var1, 1, 5));
        var3.add(new ItemStack(var1, 1, 6));
    }
}
