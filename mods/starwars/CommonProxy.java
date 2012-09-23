package jango.mods.starwars;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;

public class CommonProxy
{

	
	
	
	public void sound()
	{
	       sabersound.installResource("newsound/LightSaberSound/LightSaberOffSound.ogg", new File(sabersound.mcDataDir,"resources/LightSaber/ltsaberoff.ogg"));
	        sabersound.installResource("newsound/LightSaberSound/LightSaberOnSound.ogg", new File(sabersound.mcDataDir,"resources/LightSaber/ltsaberon.ogg"));
	 
	}
	
    Minecraft sabersound = ModLoader.getMinecraftInstance();

    
	
}