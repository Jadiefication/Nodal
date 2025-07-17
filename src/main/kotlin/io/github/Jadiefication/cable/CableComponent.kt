package io.github.Jadiefication.cable

import io.github.Jadiefication.redstoneflux.api.components.EnergyComponent
import io.github.Jadiefication.redstoneflux.api.types.EnergyTypes

class CableComponent : EnergyComponent<CableMechanic>(
    EnergyTypes.RF,
    CableMechanic()
) {
}