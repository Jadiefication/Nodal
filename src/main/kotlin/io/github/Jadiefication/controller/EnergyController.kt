package io.github.Jadiefication.controller

import io.github.Jadiefication.redstoneflux.api.mechanics.EnergyConsumer
import io.github.Jadiefication.redstoneflux.api.mechanics.EnergyStorage
import io.github.Jadiefication.redstoneflux.api.mechanics.EnergyTransporter

class EnergyController : EnergyConsumer, EnergyStorage, EnergyTransporter {

    override val energyDemand: Double = 20.0
    override var isEnable: Boolean = false
    override val maximumCapacity: Double = 2000.0
    override var storedEnergy: Double = 0.0

    override fun consumeEnergy() {
        if (energyDemand > storedEnergy) {
            storedEnergy = 0.0
            isEnable = false
        } else {
            storedEnergy -= energyDemand
        }
    }

    override fun consumeEnergy(energyTaken: Double): Double {
        return if (energyTaken <= storedEnergy) {
            storedEnergy -= energyTaken
            energyTaken
        } else {
            val consumed = storedEnergy
            storedEnergy = 0.0
            consumed
        }
    }

    override fun receiveEnergy(energyToGive: Double) {
        storeEnergy(energyToGive)
    }

    override fun storeEnergy(energyStored: Double): Double {
        val spaceLeft = maximumCapacity - storedEnergy
        return if (energyStored <= spaceLeft) {
            storedEnergy += energyStored
            energyStored
        } else {
            storedEnergy = maximumCapacity
            spaceLeft
        }
    }
}