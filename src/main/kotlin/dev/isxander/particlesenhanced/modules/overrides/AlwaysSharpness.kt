package dev.isxander.particlesenhanced.modules.overrides

import cc.polyfrost.oneconfig.events.event.ReceivePacketEvent
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe
import dev.isxander.particlesenhanced.config.ParticlesEnhancedConfig
import net.minecraft.client.Minecraft
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.EnumCreatureAttribute
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.network.play.server.S19PacketEntityStatus
import net.minecraft.util.EnumParticleTypes
import net.minecraftforge.event.entity.player.AttackEntityEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

object AlwaysSharpness {

    private var attacker: EntityPlayer? = null
    private var targetId = -1

    @Subscribe
    fun onPacketReceive(event: ReceivePacketEvent) {
        if (!ParticlesEnhancedConfig.checkInvulnerable) return

        if (event.packet is S19PacketEntityStatus) {
            val packet = event.packet as S19PacketEntityStatus
            if (packet.opCode.toInt() != 2) return

            val target = packet.getEntity(Minecraft.getMinecraft().theWorld) ?: return
            if (attacker != null && targetId == target.entityId) {
                doSharpness(attacker!!, target)
                attacker = null
                targetId = -1
            }
        }
    }

    @SubscribeEvent
    fun onAttack(event: AttackEntityEvent) {
        if (ParticlesEnhancedConfig.checkInvulnerable) {
            if (event.entityPlayer.entityId == Minecraft.getMinecraft().thePlayer.entityId) {
                attacker = event.entityPlayer
                targetId = event.target.entityId
            }
        } else {
            doSharpness(event.entityPlayer, event.target)
        }
    }

    private fun doSharpness(attacker: EntityPlayer, target: Entity) {
        if (!ParticlesEnhancedConfig.alwaysSharp)
            return

        val modifier = if (target is EntityLivingBase) {
            EnchantmentHelper.getModifierForCreature(attacker.heldItem, target.creatureAttribute)
        } else {
            EnchantmentHelper.getModifierForCreature(attacker.heldItem, EnumCreatureAttribute.UNDEFINED)
        }

        if (modifier <= 0f) {
            Minecraft.getMinecraft().effectRenderer.emitParticleAtEntity(target, EnumParticleTypes.CRIT_MAGIC)
        }
    }

}