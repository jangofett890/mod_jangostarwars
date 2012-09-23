package jango.mods.starwars;


import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.ModLoader;
import net.minecraft.src.BaseMod;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.CreativeTabs;

 
import net.minecraft.src.EntityPlayer;	
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;	
import net.minecraft.src.TileEntity;	
import net.minecraft.src.TileEntityChest;	
import net.minecraft.src.World;


@Mod( modid = "starwars/jangosversion", name="Star Wars/Simple But Advanced", version="0.3.5 Rebuild With Forge") 
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class mod_jangostarwars extends BaseMod
{

	public static int rarity = 50;
	
    public static final Block EmitterCrystal = (new BlockEmitterCrystal(200)).setLightValue(0.5F).setHardness(0.5F).setStepSound(Block.soundGlassFootstep).setBlockName("EmmiterCrystal");
    public static final Block Hlight = (new Blockhlight(203)).setLightValue(0.9F).setHardness(0.1F).setStepSound(Block.soundGlassFootstep).setBlockName("H Light");
    public static final Block DuraSteel = (new BlockDuraSteel(201)).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("DuraSteel");
    public static final Block PermaCrete = (new BlockPermaCrete(202)).setHardness(0.9F).setStepSound(Block.soundStoneFootstep).setBlockName("PermaCrete");
    public static final Item Crystal = (new ItemCrystal(5000)).setItemName("Crystal");
    public static final Item LightSaberOFF = (new ItemSaberOFF(5001)).setItemName("LightSaberOFF");
    public static final Item LightSaber = (new ItemSaber(5002, EnumToolSaber.SABER)).setItemName("LightSaber");
    public static final Item LightSaberEmitter = (new ItemEmitter(5003)).setItemName("LightSaberEmiter");
    public static final Item LightSaberProjecter = (new ItemProjecter(5004)).setItemName("LightSaber Projecter");
    public static int texCrystalBlue = ModLoader.addOverride("/terrain.png", "/JangosTextures/StarWars/CrystalBlue.png");
    public static int texCrystalRed = ModLoader.addOverride("/terrain.png", "/JangosTextures/StarWars/CrystalRed.png");
    public static int texCrystalGreen = ModLoader.addOverride("/terrain.png", "/JangosTextures/StarWars/CrystalGreen.png");
    public static int texCrystalPurple = ModLoader.addOverride("/terrain.png", "/JangosTextures/StarWars/CrystalPurple.png");
    public static int texCrystalYellow = ModLoader.addOverride("/terrain.png", "/JangosTextures/StarWars/CrystalYellow.png");
    public static int texCrystalBlack = ModLoader.addOverride("/terrain.png", "/JangosTextures/StarWars/CrystalBlack.png");
    public static int texCrystalWhite = ModLoader.addOverride("/terrain.png", "/JangosTextures/StarWars/CrystalWhite.png");
    public static int ItemCrystalTextureBlue = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/BlueGem.png");
    public static int ItemCrystalTextureRed = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/RedGem.png");
    public static int ItemCrystalTextureGreen = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/GreenGem.png");
    public static int ItemCrystalTexturePurple = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/PurpleGem.png");
    public static int ItemCrystalTextureYellow = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/YellowGem.png");
    public static int ItemCrystalTextureBlack = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/BlackGem.png");
    public static int ItemCrystalTextureWhite = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/WhiteGem.png");
    public static int ItemLightSaberOff = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSabberOFF.png");
    public static int ItemLightSaberBlue = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSabberB.png");
    public static int ItemLightSaberRed = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSabberR.png");
    public static int ItemLightSaberGreen = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSabberG.png");
    public static int ItemLightSaberPurple = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSabberP.png");
    public static int ItemLightSaberYellow = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSabberY.png");
    public static int ItemLightSaberBlack = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSabberBL.png");
    public static int ItemLightSaberWhite = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSabberW.png");
    public static int ItemLightSaberEmitterBlue = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSaberEmitterB.png");
    public static int ItemLightSaberEmitterRed = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSaberEmitterR.png");
    public static int ItemLightSaberEmitterGreen = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSaberEmitterG.png");
    public static int ItemLightSaberEmitterPurple = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSaberEmitterP.png");
    public static int ItemLightSaberEmitterYellow = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSaberEmitterY.png");
    public static int ItemLightSaberEmitterBlack = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSaberEmitterB2.png");
    public static int ItemLightSaberEmitterWhite = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSaberEmitterW.png");
    
    


    @SidedProxy(clientSide = "jango.mods.starwars.ClientProxy", serverSide = "jango.mods.starwars.CommonProxy")
    public static CommonProxy proxy;
    @Instance
    public static mod_jangostarwars instance;
    
    @Init
    public void load(FMLInitializationEvent evt)
      {
      proxy.sound();
      }
    
    
    
    public mod_jangostarwars()
    {
    	

    	GameRegistry.registerBlock(EmitterCrystal, ItemBlockEmitterCrystal.class);
        LightSaberProjecter.iconIndex = ModLoader.addOverride("/gui/items.png", "/JangosTextures/StarWars/LightSaberProjecter.png");
    	GameRegistry.registerBlock(DuraSteel);
    	GameRegistry.registerBlock(PermaCrete);
    	GameRegistry.registerBlock(Hlight);
    	DuraSteel.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/JangosTextures/StarWars/Dura Steel.png");
    	PermaCrete.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/JangosTextures/StarWars/Permacrete.png");
    	Hlight.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/JangosTextures/StarWars/Hlight1.png");
    	LanguageRegistry.addName(new ItemStack(DuraSteel), "Dura Steel");
        LanguageRegistry.addName(new ItemStack(PermaCrete), "Permacrete");
    	LanguageRegistry.addName(new ItemStack(Hlight), "H Light");
        LanguageRegistry.addName(new ItemStack(EmitterCrystal, 1), "Blue Crystal");
        LanguageRegistry.addName(new ItemStack(EmitterCrystal, 1, 1), "Red Crystal");
        LanguageRegistry.addName(new ItemStack(EmitterCrystal, 1, 2), "Green Crystal");
        LanguageRegistry.addName(new ItemStack(EmitterCrystal, 1, 3), "Purple Crystal");
        LanguageRegistry.addName(new ItemStack(EmitterCrystal, 1, 4), "Yellow Crystal");
        LanguageRegistry.addName(new ItemStack(EmitterCrystal, 1, 5), "Black Crystal");
        LanguageRegistry.addName(new ItemStack(EmitterCrystal, 1, 6), "White Crystal");
        LanguageRegistry.addName(new ItemStack(LightSaberOFF, 1), "Blue LightSaber Off");
        LanguageRegistry.addName(new ItemStack(LightSaberOFF, 1, 1), "Red LightSaber Off");
        LanguageRegistry.addName(new ItemStack(LightSaberOFF, 1, 2), "Green LightSaber Off");
        LanguageRegistry.addName(new ItemStack(LightSaberOFF, 1, 3), "Purple LightSaber Off");
        LanguageRegistry.addName(new ItemStack(LightSaberOFF, 1, 4), "Yellow LightSaber Off");
        LanguageRegistry.addName(new ItemStack(LightSaberOFF, 1, 5), "Black LightSaber Off");
        LanguageRegistry.addName(new ItemStack(LightSaberOFF, 1, 6), "White LightSaber Off");
        LanguageRegistry.addName(new ItemStack(Crystal, 1), "Blue Crystal");
        LanguageRegistry.addName(new ItemStack(Crystal, 1, 1), "Red Crystal");
        LanguageRegistry.addName(new ItemStack(Crystal, 1, 2), "Green Crystal");
        LanguageRegistry.addName(new ItemStack(Crystal, 1, 3), "Purple Crystal");
        LanguageRegistry.addName(new ItemStack(Crystal, 1, 4), "Yellow Crystal");
        LanguageRegistry.addName(new ItemStack(Crystal, 1, 5), "Black Crystal");
        LanguageRegistry.addName(new ItemStack(Crystal, 1, 6), "White Crystal");
        LanguageRegistry.addName(new ItemStack(LightSaber, 1), "Blue LightSaber");
        LanguageRegistry.addName(new ItemStack(LightSaber, 1, 1), "Red LightSaber");
        LanguageRegistry.addName(new ItemStack(LightSaber, 1, 2), "Green LightSaber");
        LanguageRegistry.addName(new ItemStack(LightSaber, 1, 3), "Purple LightSaber");
        LanguageRegistry.addName(new ItemStack(LightSaber, 1, 4), "Yellow LightSaber");
        LanguageRegistry.addName(new ItemStack(LightSaber, 1, 5), "Black LightSaber");
        LanguageRegistry.addName(new ItemStack(LightSaber, 1, 6), "White LightSaber");
        LanguageRegistry.addName(new ItemStack(LightSaberEmitter, 1), "Blue LightSaber Emitter");
        LanguageRegistry.addName(new ItemStack(LightSaberEmitter, 1, 1), "Red LightSaber Emitter");
        LanguageRegistry.addName(new ItemStack(LightSaberEmitter, 1, 2), "Green LightSaber Emitter");
        LanguageRegistry.addName(new ItemStack(LightSaberEmitter, 1, 3), "Purple LightSaber Emitter");
        LanguageRegistry.addName(new ItemStack(LightSaberEmitter, 1, 4), "Yellow LightSaber Emitter");
        LanguageRegistry.addName(new ItemStack(LightSaberEmitter, 1, 5), "Black LightSaber Emitter");
        LanguageRegistry.addName(new ItemStack(LightSaberEmitter, 1, 6), "White LightSaber Emitter");
        LanguageRegistry.addName(new ItemStack(LightSaberProjecter), "LightSaber Projecter");
        
        ModLoader.registerKey(this, new KeyBinding("sword toggle", 19), true);
        ModLoader.addLocalization("KEY_R", "KEY_R");
        ModLoader.setInGameHook(this, true, false);
        
      
        
        ModLoader.addRecipe(new ItemStack(LightSaberOFF, 1, 0), new Object[] {" P ", " EB", " I ", 'E', new ItemStack(LightSaberEmitter, 1, 0), 'I', Item.ingotIron, 'P', mod_jangostarwars.LightSaberProjecter, 'B', Block.button});
        ModLoader.addRecipe(new ItemStack(LightSaberOFF, 1, 1), new Object[] {" P ", " EB", " I ", 'E', new ItemStack(LightSaberEmitter, 1, 1), 'I', Item.ingotIron, 'P', mod_jangostarwars.LightSaberProjecter, 'B', Block.button});
        ModLoader.addRecipe(new ItemStack(LightSaberOFF, 1, 2), new Object[] {" P ", " EB", " I ", 'E', new ItemStack(LightSaberEmitter, 1, 2), 'I', Item.ingotIron, 'P', mod_jangostarwars.LightSaberProjecter, 'B', Block.button});
        ModLoader.addRecipe(new ItemStack(LightSaberOFF, 1, 3), new Object[] {" P ", " EB", " I ", 'E', new ItemStack(LightSaberEmitter, 1, 3), 'I', Item.ingotIron, 'P', mod_jangostarwars.LightSaberProjecter, 'B', Block.button});
        ModLoader.addRecipe(new ItemStack(LightSaberOFF, 1, 4), new Object[] {" P ", " EB", " I ", 'E', new ItemStack(LightSaberEmitter, 1, 4), 'I', Item.ingotIron, 'P', mod_jangostarwars.LightSaberProjecter, 'B', Block.button});
        ModLoader.addRecipe(new ItemStack(LightSaberOFF, 1, 5), new Object[] {" P ", " EB", " I ", 'E', new ItemStack(LightSaberEmitter, 1, 5), 'I', Item.ingotIron, 'P', mod_jangostarwars.LightSaberProjecter, 'B', Block.button});
        ModLoader.addRecipe(new ItemStack(LightSaberOFF, 1, 6), new Object[] {" P ", " EB", " I ", 'E', new ItemStack(LightSaberEmitter, 1, 6), 'I', Item.ingotIron, 'P', mod_jangostarwars.LightSaberProjecter, 'B', Block.button});
        ModLoader.addRecipe(new ItemStack(LightSaberProjecter, 1), new Object[] {"IDI", "IGI", "IDI", 'D', Item.diamond, 'I', Item.ingotIron, 'G',Block.glass});
        ModLoader.addRecipe(new ItemStack(LightSaberEmitter, 1, 0), new Object[] {"IDI", "ICI", "IRI", 'D', Item.diamond, 'I', Item.ingotIron, 'C', new ItemStack(Crystal, 1, 0), 'R', Item.redstone});
        ModLoader.addRecipe(new ItemStack(LightSaberEmitter, 1, 1), new Object[] {"IDI", "ICI", "IRI", 'D', Item.diamond, 'I', Item.ingotIron, 'C', new ItemStack(Crystal, 1, 1), 'R', Item.redstone});
        ModLoader.addRecipe(new ItemStack(LightSaberEmitter, 1, 2), new Object[] {"IDI", "ICI", "IRI", 'D', Item.diamond, 'I', Item.ingotIron, 'C', new ItemStack(Crystal, 1, 2), 'R', Item.redstone});
        ModLoader.addRecipe(new ItemStack(LightSaberEmitter, 1, 3), new Object[] {"IDI", "ICI", "IRI", 'D', Item.diamond, 'I', Item.ingotIron, 'C', new ItemStack(Crystal, 1, 3), 'R', Item.redstone});
        ModLoader.addRecipe(new ItemStack(LightSaberEmitter, 1, 4), new Object[] {"IDI", "ICI", "IRI", 'D', Item.diamond, 'I', Item.ingotIron, 'C', new ItemStack(Crystal, 1, 4), 'R', Item.redstone});
        ModLoader.addRecipe(new ItemStack(LightSaberEmitter, 1, 5), new Object[] {"IDI", "ICI", "IRI", 'D', Item.diamond, 'I', Item.ingotIron, 'C', new ItemStack(Crystal, 1, 5), 'R', Item.redstone});
        ModLoader.addRecipe(new ItemStack(LightSaberEmitter, 1, 6), new Object[] {"IDI", "ICI", "IRI", 'D', Item.diamond, 'I', Item.ingotIron, 'C', new ItemStack(Crystal, 1, 6), 'R', Item.redstone});

        sabersound.installResource("newsound/LightSaberSound/LightSaberOffSound.ogg", new File(sabersound.mcDataDir,"resources/LightSaber/ltsaberoff.ogg"));
        sabersound.installResource("newsound/LightSaberSound/LightSaberOnSound.ogg", new File(sabersound.mcDataDir,"resources/LightSaber/ltsaberon.ogg"));
        sabersound.installResource("newsound/LightSaberSound/LightSaberConstantSound.ogg", new File(sabersound.mcDataDir,"resources/LightSaber/sabconst.ogg"));
        sabersound.installResource("newsound/LightSaberSound/LightSaberSwingASound.ogg", new File(sabersound.mcDataDir,"resources/LightSaber/sabrswgA.ogg"));
        sabersound.installResource("newsound/LightSaberSound/LightSaberSwingBSound.ogg", new File(sabersound.mcDataDir,"resources/LightSaber/sabrswgB.ogg"));
        sabersound.installResource("newsound/LightSaberSound/LightSaberHitSound.ogg", new File(sabersound.mcDataDir,"resources/LightSaber/sabhit.ogg"));
    
        
        
    
    }
        

    
    Minecraft sabersound = ModLoader.getMinecraftInstance();

    
    public void keyboardEvent(KeyBinding var1)
    {
            if (var1.isPressed() && var1.keyCode == 19)
            {
                    int var2 = ModLoader.getMinecraftInstance().thePlayer.inventory.currentItem;
                    ItemStack var3 = ModLoader.getMinecraftInstance().thePlayer.inventory.getStackInSlot(var2);
                    
                    
                    if (var3 == null)
                    {
                     return;
                    }
                    
                    if (var3.itemID == mod_jangostarwars.LightSaberOFF.shiftedIndex)
                     {
                    
                     sabersound.sndManager.playSoundFX("LightSaberSound.LightSaberOnSound", 1.0F, 1.0F);
                     
                     		if(var3.itemID == mod_jangostarwars.LightSaberOFF.shiftedIndex && var3.getItemDamage() == 0)  
                      		  {
                                     ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaber,1,0));   
                              }
                       
                            if(var3.itemID == mod_jangostarwars.LightSaberOFF.shiftedIndex && var3.getItemDamage() == 1)  
                            {
                            	ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaber,1,1));   
                            }
                       
                            if(var3.itemID == mod_jangostarwars.LightSaberOFF.shiftedIndex && var3.getItemDamage() == 2)  
                            {
                            	ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaber,1,2));   
                            }
                       
                      
                            if(var3.itemID == mod_jangostarwars.LightSaberOFF.shiftedIndex && var3.getItemDamage() == 3)  
              {
               ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaber,1,3));   
              }
                      
                            if(var3.itemID == mod_jangostarwars.LightSaberOFF.shiftedIndex && var3.getItemDamage() == 4)  
              {
               ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaber,1,4));   
              }
                       
                            if(var3.itemID == mod_jangostarwars.LightSaberOFF.shiftedIndex && var3.getItemDamage() == 5)  
              {
               ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaber,1,5));   
              }
                      
                            if(var3.itemID == mod_jangostarwars.LightSaberOFF.shiftedIndex && var3.getItemDamage() == 6)  
              {
               ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaber,1,6));   
              }
                            
                            
                     }
               
                    if (var3.itemID == mod_jangostarwars.LightSaber.shiftedIndex)
             {
                     sabersound.sndManager.playSoundFX("LightSaberSound.LightSaberOffSound", 1.0F, 1.0F);
                    
                     if(var3.itemID == mod_jangostarwars.LightSaber.shiftedIndex && var3.getItemDamage() == 0)  
               {
                    ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaberOFF,1,0));   
               }
                    
                     if(var3.itemID == mod_jangostarwars.LightSaber.shiftedIndex && var3.getItemDamage() == 1)  
               {
                    ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaberOFF,1,1));   
               }
                    
                     if(var3.itemID == mod_jangostarwars.LightSaber.shiftedIndex && var3.getItemDamage() == 2)  
               {
                    ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaberOFF,1,2));   
               }
                    
                     if(var3.itemID == mod_jangostarwars.LightSaber.shiftedIndex && var3.getItemDamage() == 3)  
               {
                    ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaberOFF,1,3));   
               }
                    
                     if(var3.itemID == mod_jangostarwars.LightSaber.shiftedIndex && var3.getItemDamage() == 4)  
               {
                    ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaberOFF,1,4));   
               }
                    
                     if(var3.itemID == mod_jangostarwars.LightSaber.shiftedIndex && var3.getItemDamage() == 5)  
               {
                    ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaberOFF,1,5));   
               }
                    
                     if(var3.itemID == mod_jangostarwars.LightSaber.shiftedIndex && var3.getItemDamage() == 6)  
               {
                    ModLoader.getMinecraftInstance().thePlayer.inventory.setInventorySlotContents(var2, new ItemStack(mod_jangostarwars.LightSaberOFF,1,6));   
               }
             }

            }
                    
         }
                
            
    

    
    

    
	

    public void generateSurface(World var1, Random var2, int var3, int var4, int y, int z)
    {
        int var5;
        int var6;
        int var7;
        int var8;

        for (var5 = 0; var5 < 6; ++var5)
        {
            var6 = var3 + var2.nextInt(16);
            var7 = var2.nextInt(48);
            var8 = var4 + var2.nextInt(16);
            (new WorldGenMinable(EmitterCrystal.blockID, 0, 17)).generate(var1, var2, var6, var7, var8);
        }

        for (var5 = 0; var5 < 6; ++var5)
        {
            var6 = var3 + var2.nextInt(16);
            var7 = var2.nextInt(48);
            var8 = var4 + var2.nextInt(16);
            (new WorldGenMinable(EmitterCrystal.blockID, 1, 17)).generate(var1, var2, var6, var7, var8);
        }
        
	      for(int a = 0; a < 90; a++)
	      {
	         int RandPosX = y + var2.nextInt(16);
	         int RandPosY = var2.nextInt(150);
	         int RandPosZ = z + var2.nextInt(16);
	         (new WorldGenImperialBase()).generate(var1, var2, RandPosX, RandPosY, RandPosZ);
	      }
	   		
    
    }





	@Override
	public String getVersion() 
	{
		return null;
	}





	@Override
	public void load() 
	{

		
	}





}
