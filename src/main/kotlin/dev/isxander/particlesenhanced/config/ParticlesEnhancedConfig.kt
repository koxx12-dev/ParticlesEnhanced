/*
 * Copyright (c) [2021 - 2021] isXander
 *
 * All rights reserved!
 */

package dev.isxander.particlesenhanced.config

import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.Dropdown
import cc.polyfrost.oneconfig.config.annotations.Slider
import cc.polyfrost.oneconfig.config.annotations.Switch
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType

object ParticlesEnhancedConfig : Config(Mod("ParticlesEnhanced", ModType.UTIL_QOL), "particlesenhanced/config.toml") {
    @Dropdown(
        name = "Critical Particle Type",
        description = "Change what type of particle appears when you get a critical hit.",
        category = "Aesthetics",
        subcategory = "Overrides",
        options = ["Normal Explosion", "Large Explosion", "Huge Explosion", "Firework Spark", "Water Bubble", "Water Splash", "Water Wake", "Suspended", "Suspended Depth", "Critical", "Sharpness", "Normal Smoke", "Large Smoke", "Spell", "Instant Spell", "Mob Spell", "Ambient Mob Spell", "Witch Spell", "Water Drip", "Lava Drip", "Angry Villager", "Happy Villager", "Town Aura", "Note", "Portal", "Enchantment Table", "Flame", "Lava", "Footstep", "Cloud", "Redstone", "Snowball", "Shovel Snow", "Slime", "Heart", "Barrier", "Item Break", "Block Break", "Block Dust", "Water Drop", "Take Item", "Mop Appearance", "Blood"]
    )
    var critParticleType = 9

    @Dropdown(
        name = "Sharpness Particle Type",
        description = "Change what type of particle appears when you get a sharpness hit.",
        category = "Aesthetics",
        subcategory = "Overrides",
        options = ["Normal Explosion", "Large Explosion", "Huge Explosion", "Firework Spark", "Water Bubble", "Water Splash", "Water Wake", "Suspended", "Suspended Depth", "Critical", "Sharpness", "Normal Smoke", "Large Smoke", "Spell", "Instant Spell", "Mob Spell", "Ambient Mob Spell", "Witch Spell", "Water Drip", "Lava Drip", "Angry Villager", "Happy Villager", "Town Aura", "Note", "Portal", "Enchantment Table", "Flame", "Lava", "Footstep", "Cloud", "Redstone", "Snowball", "Shovel Snow", "Slime", "Heart", "Barrier", "Item Break", "Block Break", "Block Dust", "Water Drop", "Take Item", "Mop Appearance", "Blood"]
    )
    var sharpParticleType = 10

    @Switch(
        name = "Check Invulnerability",
        description = "Before showing the critical or sharpness particles, check if the player can be hit (e.g. isn't in creative mode)",
        category = "Aesthetics",
        subcategory = "Overrides"
    )
    var checkInvulnerable = true

    @Switch(
        name = "Always Show Criticals",
        description = "Every time you hit an entity, critical particles are spawned.",
        category = "Aesthetics",
        subcategory = "Overrides"
    )
    var alwaysCrit = false

    @Switch(
        name = "Always Show Sharpness",
        description = "Every time you hit an entity, sharpness particles are spawned.",
        category = "Aesthetics",
        subcategory = "Overrides"
    )
    var alwaysSharp = false

    @Switch(
        name = "Override Critical Bow Arrows",
        description = "When you fire a full charge hit with a bow, critical particles are spawned. Override with your desired particle?",
        category = "Aesthetics",
        subcategory = "Overrides"
    )
    var overrideCriticalBow = true


    @Switch(
        name = "Fade",
        description = "Make particles fade rather than just disappearing.",
        category = "Aesthetics",
        subcategory = "Fade"
    )
    var fade = true

    @Slider(
        name = "Fade Out Start",
        description = "How far into the lifespan of the particle before it starts to fade.",
        category = "Aesthetics",
        subcategory = "Fade",
        max = 1F,
        min = 0F
    )
    var fadeOutStart = 0.5f

    @Slider(
        name = "Minimum Transparency",
        description = "Rather than fading to nothing fade to this value.",
        category = "Aesthetics",
        subcategory = "Fade",
        max = 100F,
        min = 0F
    )
    var minFadeTransparency = 0

    @Slider(
        name = "Critical Multiplier",
        description = "How many critical particles you want to see.",
        category = "Aesthetics",
        subcategory = "Multipliers",
        max = 20F,
        min = 0F
    )
    var critMultiplier = 1

    @Slider(
        name = "Sharpness Multiplier",
        description = "How many sharpness particles you want to see.",
        category = "Aesthetics",
        subcategory = "Multipliers",
        max = 20F,
        min = 0F
    )
    var sharpMultiplier = 1

    init { initialize() }
}