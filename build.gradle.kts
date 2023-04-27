import xyz.deftu.gradle.tools.minecraft.VersionType
import xyz.deftu.gradle.utils.GameSide

plugins {
    java
    val dgtVersion = "1.10.4"
    id("org.jetbrains.kotlin.jvm") version("1.6.10")
    id("xyz.deftu.gradle.tools") version(dgtVersion)
    id("xyz.deftu.gradle.tools.shadow") version(dgtVersion)
    id("xyz.deftu.gradle.tools.blossom") version(dgtVersion)
    id("xyz.deftu.gradle.tools.minecraft.loom") version(dgtVersion)
    id("xyz.deftu.gradle.tools.minecraft.releases") version(dgtVersion)
}

deftu.useDevAuth()

repositories {
    maven("https://repo.essential.gg/repository/maven-public/")
}

loomHelper {
    useForgeMixin(modData.id)
    useMixinRefMap(modData.id)
    useProperty("mixin.debug.export", "true", GameSide.CLIENT)
    useTweaker("gg.essential.loader.stage0.EssentialSetupTweaker")
    disableRunConfigs(GameSide.SERVER)
}

dependencies {
    modCompileOnly("gg.essential:essential-${mcData.versionStr}-${mcData.loader.name}:4479+ge389e52d8")
    implementation(shade("gg.essential:loader-launchwrapper:1.1.3")!!)

    compileOnly("org.spongepowered:mixin:0.8.5-SNAPSHOT")
}

// dependencies {
//     minecraft("com.mojang:minecraft:1.8.9")
//     mappings("de.oceanlabs.mcp:mcp_stable:22-1.8.9")
//     forge("net.minecraftforge:forge:1.8.9-11.15.1.2318-1.8.9")
// 
//     compileOnly("gg.essential:essential-1.8.9-forge:4479+ge389e52d8")
//     embed("")
// 
//     shadowImpl(kotlin("stdlib-jdk8"))
// 
//     // If you don't want mixins, remove these lines
//     shadowImpl("org.spongepowered:mixin:0.7.11-SNAPSHOT") {
//         isTransitive = false
//     }
//     annotationProcessor("org.spongepowered:mixin:0.8.4-SNAPSHOT")
// 
// }
// 
// 
// 
// tasks.withType(Jar::class) {
//     archiveBaseName.set("particlesenhanced")
//     manifest.attributes.run {
//         this["FMLCorePluginContainsFMLMod"] = "true"
//         this["ForceLoadAsMod"] = "true"
// 
//         // If you don't want mixins, remove these lines
//         this["TweakClass"] = "gg.essential.loader.stage0.EssentialSetupTweaker"
//         this["MixinConfigs"] = "mixins.particlesenhanced.json"
//     }
// }

