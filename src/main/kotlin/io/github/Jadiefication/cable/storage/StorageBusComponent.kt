package io.github.Jadiefication.cable.storage

import io.github.Jadiefication.redstoneflux.api.components.EnergyComponent
import io.github.Jadiefication.redstoneflux.api.types.EnergyTypes

class StorageBusComponent : EnergyComponent<StorageBusMechanic>(
    EnergyTypes.RF,
    StorageBusMechanic()
) {
}