package jango.mods.starwars;


import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;

public class ItemCrystal extends Item
{
    public String[] blockEmitterCrystalnames = new String[] {"Blue Crystal", "Red Crystal", "Green Crystal", "Purple Crystal", "Black Crystal", "White Crystal"};
    private String[] names = new String[] {"Crystal0Name", "Crystal1Name", "Crystal2Name", "Crystal3Name", "Crystal4Name", "Crystal5Name", "Crystal6Name"};
    public static final int[] crystalColors = new int[] {mod_jangostarwars.ItemCrystalTextureBlue, mod_jangostarwars.ItemCrystalTextureRed, mod_jangostarwars.ItemCrystalTextureGreen, mod_jangostarwars.ItemCrystalTexturePurple, mod_jangostarwars.ItemCrystalTextureYellow, mod_jangostarwars.ItemCrystalTextureBlack, mod_jangostarwars.ItemCrystalTextureWhite};

    protected ItemCrystal(int var1)
    {
        super(var1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setTabToDisplayOn(CreativeTabs.tabMaterials);
    }

    public String getItemNameIS(ItemStack var1)
    {
        return this.names[var1.getItemDamage()];
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    public int getIconFromDamage(int var1)
    {
        int var2 = MathHelper.clamp_int(var1, 0, 15);

        switch (var1)
        {
            case 1:
                return this.iconIndex + mod_jangostarwars.ItemCrystalTextureRed;

            case 2:
                return this.iconIndex + mod_jangostarwars.ItemCrystalTextureGreen;

            case 3:
                return this.iconIndex + mod_jangostarwars.ItemCrystalTexturePurple;

            case 4:
                return this.iconIndex + mod_jangostarwars.ItemCrystalTextureYellow;

            case 5:
                return this.iconIndex + mod_jangostarwars.ItemCrystalTextureBlack;

            case 6:
                return this.iconIndex + mod_jangostarwars.ItemCrystalTextureWhite;

            default:
                return this.iconIndex + mod_jangostarwars.ItemCrystalTextureBlue;
        }
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int var1, CreativeTabs var2, List var3)
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
