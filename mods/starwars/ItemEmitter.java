package jango.mods.starwars;


import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;

public class ItemEmitter extends Item
{
    public String[] blockEmitterCrystalnames = new String[] {"Blue SaberEmitter", "Red SaberEmitter"};
    private String[] names = new String[] {"EmitterName", "Emitter1Name", "Emitter2Name", "Emitter3Name", "Emitter4Name", "Emitter5Name", "Emitter6Name"};
    public static final int[] emitterColors = new int[] {mod_jangostarwars.ItemLightSaberEmitterBlue, mod_jangostarwars.ItemLightSaberEmitterRed, mod_jangostarwars.ItemLightSaberEmitterGreen, mod_jangostarwars.ItemLightSaberEmitterPurple, mod_jangostarwars.ItemLightSaberEmitterYellow, mod_jangostarwars.ItemLightSaberEmitterBlack, mod_jangostarwars.ItemLightSaberEmitterWhite};

    protected ItemEmitter(int var1)
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
                return this.iconIndex + mod_jangostarwars.ItemLightSaberEmitterRed;

            case 2:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberEmitterGreen;

            case 3:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberEmitterPurple;

            case 4:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberEmitterYellow;

            case 5:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberEmitterBlack;

            case 6:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberEmitterWhite;

            default:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberEmitterBlue;
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
