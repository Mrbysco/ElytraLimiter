package com.mrbysco.elytralimiter.util;

import com.mrbysco.elytralimiter.config.ElytraConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ElytraUtil {
	public static boolean canElytraFly(LivingEntity livingEntity) {
		ResourceLocation dimensionId = livingEntity.level().dimension().location();
		if (ElytraConfig.COMMON.restrictedDimensions.get().contains(dimensionId.toString())) {
			showMessage(livingEntity);
			return false;
		}
		return true;
	}

	private static void showMessage(LivingEntity livingEntity) {
		if (ElytraConfig.COMMON.showMessage.get() && livingEntity instanceof Player player) {
			player.displayClientMessage(Component.translatable("elytralimiter.restriction_message"), true);
		}
	}
}
