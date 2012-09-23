package jango.mods.starwars;

public enum EnumToolSaber
{
    SABER(9, 0, 26.0F, 10, 50);
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;
    private final int enchantability;

    private EnumToolSaber(int var3, int var4, float var5, int var6, int var7)
    {
        this.harvestLevel = var3;
        this.maxUses = var4;
        this.efficiencyOnProperMaterial = var5;
        this.damageVsEntity = var6;
        this.enchantability = var7;
    }

    public int getMaxUses()
    {
        return this.maxUses;
    }

    public float getEfficiencyOnProperMaterial()
    {
        return this.efficiencyOnProperMaterial;
    }

    public int getDamageVsEntity()
    {
        return this.damageVsEntity;
    }

    public int getHarvestLevel()
    {
        return this.harvestLevel;
    }

    public int getEnchantability()
    {
        return this.enchantability;
    }
}
