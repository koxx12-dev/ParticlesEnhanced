package dev.isxander.particlesenhanced.utils

import net.minecraft.network.Packet
import net.minecraftforge.fml.common.eventhandler.Event

open class PacketEvent constructor(val packet: Packet<*>, val type: Type) : Event() {

    companion object {

    }

    enum class Type {
        INCOMING
    }

    class Incoming(packet: Packet<*>) : PacketEvent(packet, Type.INCOMING)
}