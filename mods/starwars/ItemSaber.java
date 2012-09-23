package jango.mods.starwars;

import java.util.List;
import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;

public class ItemSaber extends Item
{
    private String[] names = new String[] {"Blue LightSaber", "Red LightSaber", "Green LightSaber", "Purple LightSaber", "Yellow LightSaber", "Black LightSaber", "White LightSaber"};
    public static final int[] saberColors = new int[] {mod_jangostarwars.ItemLightSaberBlue, mod_jangostarwars.ItemLightSaberRed, mod_jangostarwars.ItemLightSaberGreen, mod_jangostarwars.ItemLightSaberPurple, mod_jangostarwars.ItemLightSaberYellow, mod_jangostarwars.ItemLightSaberBlack, mod_jangostarwars.ItemLightSaberWhite};
    private int weaponDamage;
    private final EnumToolSaber toolMaterial;
    boolean isOn;

    public ItemSaber(int var1, EnumToolSaber var2)
    {
        super(var1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.toolMaterial = var2;
        this.maxStackSize = 1;
        this.setMaxDamage(var2.getMaxUses());
        this.setTabToDisplayOn(CreativeTabs.tabCombat);
        this.weaponDamage = 4 + var2.getDamageVsEntity();
        
        sabersound.installResource("newsound/LightSaberSound/LightSaberConstantSound.ogg", new File(sabersound.mcDataDir,"resources/LightSaber/sabconst.ogg"));
        sabersound.installResource("newsound/LightSaberSound/LightSaberSwingASound.ogg", new File(sabersound.mcDataDir,"resources/LightSaber/sabrswgA.ogg"));
        sabersound.installResource("newsound/LightSaberSound/LightSaberSwingBSound.ogg", new File(sabersound.mcDataDir,"resources/LightSaber/sabrswgB.ogg"));
        sabersound.installResource("newsound/LightSaberSound/LightSaberHitSound.ogg", new File(sabersound.mcDataDir,"resources/LightSaber/sabhit.ogg"));

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
                return this.iconIndex + mod_jangostarwars.ItemLightSaberRed;

            case 2:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberGreen;

            case 3:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberPurple;

            case 4:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberYellow;

            case 5:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberBlack;

            case 6:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberWhite;

            default:
                return this.iconIndex + mod_jangostarwars.ItemLightSaberBlue;
        }
    }

    //public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
    //{
    //		EntityPlayer Player = ModLoader.getMinecraftInstance().thePlayer;
    	//		if(Player.getCurrentEquippedItem() != null && Player.getCurrentEquippedItem().itemID == mod_jangostarwars.LightSaber.shiftedIndex)
    		//		{
              //  		this.sabersound.sndManager.playSoundFX("LightSaberSound.LightSaberConstantSound", 1.0F, 1.0F); 
    			//	}
    			//
//
  //  }

    Minecraft sabersound = ModLoader.getMinecraftInstance();
    
    
    
    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack var1, Block var2)
    {
        return var2.blockID == Block.web.blockID ? 15.0F : 1.5F;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack var1, EntityLiving var2, EntityLiving var3)
    {
    	this.sabersound.sndManager.playSoundFX("LightSaberSound.LightSaberHitSound", 1.0F, 1.0F); 
        var1.damageItem(1, var3);
        return false;
    }

    public boolean func_77660_a(ItemStack var1, World var2, int var3, int var4, int var5, int var6, EntityLiving var7)
    {
        if ((double)Block.blocksList[var3].getBlockHardness(var2, var4, var5, var6) != 0.0D)
        {
            var1.damageItem(2, var7);
        }

        return true;
    }

    /**
     * Returns the damage against a given entity.
     */
    public int getDamageVsEntity(Entity var1)
    {
        return this.weaponDamage;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack var1)
    { 
        return EnumAction.block;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack var1)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
    {
        var3.setItemInUse(var1, this.getMaxItemUseDuration(var1));
        return var1;
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block var1)
    {
        return var1.blockID == Block.web.blockID;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

    public String func_77825_f()
    {
        return this.toolMaterial.toString();
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
