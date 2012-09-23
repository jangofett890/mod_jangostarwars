package jango.mods.starwars;

import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class ItemSaberOFF extends Item
{
    public String[] blockEmitterCrystalnames = new String[] {"Blue Crystal", "Red Crystal"};
    public String[] names = new String[] {"Blue Light Saber Off State", "Red LightSaber Off State", "Green LightSaber Off State", "Purple LightSaber Off State", "Yellow LightSaber Off State", "Black LightSaber Off State", "White LightSaber Off State"};
    public static final int[] crystalColors = new int[] {mod_jangostarwars.ItemLightSaberOff};
    
    protected ItemSaberOFF(int var1)
    {
        super(var1);
        boolean var2 = true;
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setHasSubtypes(true);
        this.setTabToDisplayOn(CreativeTabs.tabCombat);
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
                return this.iconIndex + mod_jangostarwars.ItemLightSaberOff;

            case 2:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberOff;

            case 3:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberOff;

            case 4:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberOff;

            case 5:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberOff;

            case 6:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberOff;

            default:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberOff;
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
