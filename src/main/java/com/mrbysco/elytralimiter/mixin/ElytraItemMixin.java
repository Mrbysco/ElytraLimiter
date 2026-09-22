package com.mrbysco.elytralimiter.mixin;

import com.mrbysco.elytralimiter.util.ElytraUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ElytraItem.class)
public class ElytraItemMixin {

	@Inject(method = "canElytraFly(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;)Z",
			at = @At("HEAD"), cancellable = true, remap = false)
	private void ElytraCancel$updateFallFlying(ItemStack stack, LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
		boolean canFly = ElytraUtil.canElytraFly(entity);
		if (!canFly) {
			cir.setReturnValue(false);
		}
	}

}
