package jango.mods.starwars;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.UP;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraftforge.common.ForgeDirection;

public class Blockhlight extends Block
{
	  public Blockhlight(int var1)
	    {
	        super(var1, 2, Material.glass);
	        this.setCreativeTab(CreativeTabs.tabDeco);
	    }
	  
	    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	    {
	        return this.blockIndexInTexture;
	    }
	    
	    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	    {
	        return null;
	    }


	    public int idDropped(int var1, Random var2, int var3)
	    {
	        return mod_jangostarwars.Hlight.blockID;
	    }
	    
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }
	    
	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }

	    public int getRenderType()
	    {
	        return 5;
	    }
	    
	    public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5)
	    {
	        ForgeDirection dir = ForgeDirection.getOrientation(par5);
	        return (dir == DOWN  && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN )) ||
	               (dir == UP    && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP   )) ||
	               (dir == NORTH && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH)) ||
	               (dir == SOUTH && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH)) ||
	               (dir == WEST  && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST )) ||
	               (dir == EAST  && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ));
	    }
	    
	    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	    {
	        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ) ||
	               par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST ) ||
	               par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) ||
	               par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH) ||
	               par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP   ) ||
	               par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN );
	    }
	    
	    public void updateBlockMetadata(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8)
	    {
	        int var9 = par1World.getBlockMetadata(par2, par3, par4);
	        int var10 = var9 & 8;
	        var9 &= 7;
	        var9 = -1;

	        if (par5 == 0 && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN))
	        {
	            var9 = par1World.rand.nextBoolean() ? 0 : 7;
	        }

	        if (par5 == 1 && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP))
	        {
	            var9 = 5 + par1World.rand.nextInt(2);
	        }

	        if (par5 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH))
	        {
	            var9 = 4;
	        }

	        if (par5 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH))
	        {
	            var9 = 3;
	        }

	        if (par5 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST))
	        {
	            var9 = 2;
	        }

	        if (par5 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST))
	        {
	            var9 = 1;
	        }

	        if (var9 == -1)
	        {
	            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
	            par1World.setBlockWithNotify(par2, par3, par4, 0);
	        }
	        else
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, var9 + var10);
	        }
	    }
	    
	    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	    {
	        if (this.checkIfAttachedToBlock(par1World, par2, par3, par4))
	        {
	            int var6 = par1World.getBlockMetadata(par2, par3, par4) & 7;
	            boolean var7 = false;

	            if (!par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST) && var6 == 1)
	            {
	                var7 = true;
	            }

	            if (!par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST) && var6 == 2)
	            {
	                var7 = true;
	            }

	            if (!par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) && var6 == 3)
	            {
	                var7 = true;
	            }

	            if (!par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH) && var6 == 4)
	            {
	                var7 = true;
	            }

	            if (!par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP) && var6 == 5)
	            {
	                var7 = true;
	            }

	            if (!par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP) && var6 == 6)
	            {
	                var7 = true;
	            }

	            if (!par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN) && var6 == 0)
	            {
	                var7 = true;
	            }

	            if (!par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN) && var6 == 7)
	            {
	                var7 = true;
	            }

	            if (var7)
	            {
	                this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
	                par1World.setBlockWithNotify(par2, par3, par4, 0);
	            }
	        }
	    }
	    
	    private boolean checkIfAttachedToBlock(World par1World, int par2, int par3, int par4)
	    {
	        if (!this.canPlaceBlockAt(par1World, par2, par3, par4))
	        {
	            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
	            par1World.setBlockWithNotify(par2, par3, par4, 0);
	            return false;
	        }
	        else
	        {
	            return true;
	        }
	    }

	    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	    {
	        int var5 = par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 7;
	        float var6 = 0.1875F;

	        if (var5 == 1)
	        {
	            this.setBlockBounds(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
	        }
	        else if (var5 == 2)
	        {
	            this.setBlockBounds(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
	        }
	        else if (var5 == 3)
	        {
	            this.setBlockBounds(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
	        }
	        else if (var5 == 4)
	        {
	            this.setBlockBounds(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
	        }
	        else if (var5 != 5 && var5 != 6)
	        {
	            if (var5 == 0 || var5 == 7)
	            {
	                var6 = 0.25F;
	                this.setBlockBounds(0.5F - var6, 0.4F, 0.5F - var6, 0.5F + var6, 1.0F, 0.5F + var6);
	            }
	        }
	        else
	        {
	            var6 = 0.25F;
	            this.setBlockBounds(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
	        }
	    }
	    
}
