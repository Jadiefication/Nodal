package io.github.Jadiefication.cable

import io.github.Jadiefication.redstoneflux.api.mechanics.EnergyStorage
import io.github.Jadiefication.redstoneflux.api.mechanics.EnergyTransporter

class CableMechanic : EnergyStorage, EnergyTransporter {

    override val maximumCapacity: Double = 200.0
    override var storedEnergy: Double = 0.0

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