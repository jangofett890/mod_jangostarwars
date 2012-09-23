package jango.mods.starwars;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemProjecter extends Item
{
    protected ItemProjecter(int var1)
    {
        super(var1);
        this.setMaxDamage(0);
        this.setHasSubtypes(false);
        this.setTabToDisplayOn(CreativeTabs.tabMaterials);
    }
}
