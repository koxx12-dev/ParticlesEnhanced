package dev.isxander.particlesenhanced.command

import dev.isxander.particlesenhanced.config.ParticlesEnhancedConfig
import gg.essential.api.EssentialAPI
import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler

class ParticlesEnhancedCommand : Command("particlesenhanced") {
    @DefaultHandler
    fun handle() {
        EssentialAPI.getGuiUtil().openScreen(ParticlesEnhancedConfig.gui())
    }
}
