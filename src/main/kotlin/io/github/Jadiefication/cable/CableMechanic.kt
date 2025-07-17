package io.github.Jadiefication.cable

import io.github.Jadiefication.redstoneflux.api.mechanics.EnergyStorage
import io.github.Jadiefication.redstoneflux.api.mechanics.EnergyTransporter

class CableMechanic : EnergyStorage, EnergyTransporter {

    override val maximumCapacity: Double = 200.0
    override var storedEnergy: Double = 0.0

    override fun consumeEnergy(energyTaken: Double): Double {
        TODO("Not yet implemented")
    }

    override fun storeEnergy(energyStored: Double): Double {
        val spaceLeft = maximumCapacity - this.storedEnergy
        return if (energyStored <= spaceLeft) {
            this.storedEnergy += energyStored
            energyStored
        } else {
            this.storedEnergy = maximumCapacity
            spaceLeft
        }
    }
}