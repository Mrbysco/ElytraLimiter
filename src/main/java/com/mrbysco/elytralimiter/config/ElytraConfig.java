package com.mrbysco.elytralimiter.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class ElytraConfig {
	public static class Common {
		public final ForgeConfigSpec.ConfigValue<List<? extends String>> restrictedDimensions;
		public final ForgeConfigSpec.BooleanValue showMessage;

		Common(ForgeConfigSpec.Builder builder) {
			builder.comment("General settings")
					.push("general");

			restrictedDimensions = builder
					.comment("A list of dimension identifiers in which elytra flight is restricted.")
					.defineListAllowEmpty("restrictedDimensions", () -> List.of(""), o -> (o instanceof String));

			showMessage = builder
					.comment("Whether to show a message when elytra flight is restricted.")
					.define("showMessage", true);

			builder.pop();
		}
	}

	public static final ForgeConfigSpec commonSpec;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}
}
