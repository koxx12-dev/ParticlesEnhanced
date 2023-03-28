package dev.isxander.particlesenhanced.utils

import net.minecraft.network.Packet
import net.minecraftforge.fml.common.eventhandler.Event

open class PacketEvent(val packet: Packet<*>) : Event() {

    class Incoming(packet: Packet<*>) : PacketEvent(packet)
}