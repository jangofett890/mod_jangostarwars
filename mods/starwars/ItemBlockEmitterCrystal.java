package jango.mods.starwars;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemBlockEmitterCrystal extends ItemBlock
{
    public ItemBlockEmitterCrystal(int var1)
    {
        super(var1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int var1)
    {
        return var1;
    }

    public String getItemNameIS(ItemStack var1)
    {
        int var2 = var1.getItemDamage();

        if (var2 < 0 || var2 >= BlockEmitterCrystal.crystalType.length)
        {
            var2 = 0;
        }

        return super.getItemName() + "." + BlockEmitterCrystal.crystalType[var2];
    }
}
