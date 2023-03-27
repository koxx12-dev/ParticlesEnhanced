/*
 * Copyright (c) [2021 - 2021] isXander
 *
 * All rights reserved!
 */

package dev.isxander.particlesenhanced

import dev.isxander.particlesenhanced.config.ParticlesEnhancedConfig
import dev.isxander.particlesenhanced.modules.overrides.AlwaysCriticals
import dev.isxander.particlesenhanced.modules.overrides.AlwaysSharpness
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(
    modid = "@ID@",
    name = "@NAME@",
    version = "@VER@",
    acceptedMinecraftVersions = "[1.8.9]",
    clientSideOnly = true,
)
class ParticlesEnhanced {
    var config: ParticlesEnhancedConfig? = null

    @Mod.EventHandler
    fun onFMLInit(event: FMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(AlwaysCriticals)
        MinecraftForge.EVENT_BUS.register(AlwaysSharpness)

        config = ParticlesEnhancedConfig
    }
}