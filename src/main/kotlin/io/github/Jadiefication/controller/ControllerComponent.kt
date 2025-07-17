package io.github.Jadiefication.controller

import io.github.Jadiefication.redstoneflux.api.components.EnergyComponent
import io.github.Jadiefication.redstoneflux.api.types.EnergyTypes

class ControllerComponent : EnergyComponent<EnergyController>(
    EnergyTypes.RF,
    EnergyController()
) {

}