/*
 * Copyright (c) [2021 - 2021] isXander
 *
 * All rights reserved!
 */

package dev.isxander.particlesenhanced

import dev.isxander.particlesenhanced.command.ParticlesEnhancedCommand
import dev.isxander.particlesenhanced.config.ParticlesEnhancedConfig
import dev.isxander.particlesenhanced.modules.overrides.AlwaysCriticals
import dev.isxander.particlesenhanced.modules.overrides.AlwaysSharpness
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(
    modid = "particlesenhanced",
    name = "Particles Enhanced",
    version = "1.2.1",
    acceptedMinecraftVersions = "[1.8.9]",
    clientSideOnly = true
)
class ParticlesEnhanced {

    @Mod.EventHandler
    fun onFMLInit(event: FMLInitializationEvent) {

        ParticlesEnhancedConfig.preload()

        MinecraftForge.EVENT_BUS.register(AlwaysCriticals)
        MinecraftForge.EVENT_BUS.register(AlwaysSharpness)

        ParticlesEnhancedCommand().register()

        ParticlesEnhancedConfig.checkInvulnerable = false // it broken :)
    }

}