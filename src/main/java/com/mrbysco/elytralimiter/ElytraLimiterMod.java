package com.mrbysco.elytralimiter;

import com.mojang.logging.LogUtils;
import com.mrbysco.elytralimiter.config.ElytraConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ElytraLimiterMod.MOD_ID)
public class ElytraLimiterMod {
	public static final String MOD_ID = "elytralimiter";
	public static final Logger LOGGER = LogUtils.getLogger();

	public ElytraLimiterMod() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ElytraConfig.commonSpec);
	}
}
