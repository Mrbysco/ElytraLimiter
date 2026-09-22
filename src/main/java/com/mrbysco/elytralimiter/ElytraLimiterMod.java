package com.mrbysco.elytralimiter;

import com.mojang.logging.LogUtils;
import com.mrbysco.elytralimiter.config.ElytraConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.slf4j.Logger;

@Mod(ElytraLimiterMod.MOD_ID)
public class ElytraLimiterMod {
	public static final String MOD_ID = "elytralimiter";
	public static final Logger LOGGER = LogUtils.getLogger();

	public ElytraLimiterMod(ModContainer container, Dist dist) {
		container.registerConfig(ModConfig.Type.COMMON, ElytraConfig.commonSpec);
		
		if (dist.isClient()) {
			container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
		}
	}
}
