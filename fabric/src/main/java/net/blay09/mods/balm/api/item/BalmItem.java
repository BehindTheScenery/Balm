package net.blay09.mods.balm.api.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BalmItem extends Item implements BalmItemContract {
    public BalmItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean balmShowDurabilityBar(ItemStack stack) {
        return stack.isDamaged();
    }

    @Override
    public double balmGetDurabilityForDisplay(ItemStack stack) {
        return (double) stack.getDamageValue() / (double) stack.getMaxDamage();
    }
}