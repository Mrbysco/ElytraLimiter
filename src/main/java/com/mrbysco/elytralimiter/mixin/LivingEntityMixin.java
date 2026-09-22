package com.mrbysco.elytralimiter.mixin;

import com.mrbysco.elytralimiter.util.ElytraUtil;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@Inject(method = "canGlide()Z",
			at = @At(value = "RETURN", ordinal = 0),
			cancellable = true)
	private void ElytraLimiter$canGlide(CallbackInfoReturnable<Boolean> cir) {
		LivingEntity livingEntity = (LivingEntity) (Object) this;
		boolean canFly = ElytraUtil.canElytraFly(livingEntity);
		if (!canFly) {
			cir.setReturnValue(false);
		}
	}

}
