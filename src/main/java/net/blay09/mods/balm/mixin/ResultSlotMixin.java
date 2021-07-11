package net.blay09.mods.balm.mixin;

import net.blay09.mods.balm.event.BalmEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.ResultSlot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ResultSlot.class)
public class ResultSlotMixin {

    @Shadow
    @Final
    private CraftingContainer craftSlots;

    @Shadow
    @Final
    private Player player;

    @Inject(method = "onTake(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;)V", at = @At("HEAD"))
    public void onTake(Player player, ItemStack itemStack, CallbackInfo callbackInfo) {
        BalmEvents.ITEM_CRAFTED.invoker().handle(player, itemStack, craftSlots);
    }

    @Inject(method = "onQuickCraft(Lnet/minecraft/world/item/ItemStack;I)V", at = @At("HEAD"))
    public void onQuickCraft(ItemStack itemStack, int i, CallbackInfo callbackInfo) {
        BalmEvents.ITEM_CRAFTED.invoker().handle(player, itemStack, craftSlots);
    }

}
