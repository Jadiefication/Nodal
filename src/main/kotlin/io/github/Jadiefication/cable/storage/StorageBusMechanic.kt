package io.github.Jadiefication.cable.storage

import io.github.Jadiefication.cable.storage.gui.StorageBusGui
import io.github.Jadiefication.redstoneflux.api.mechanics.EnergyTransporter
import io.github.Jadiefication.redstoneflux.api.mechanics.InteractableMechanic
import org.bukkit.event.player.PlayerInteractEvent

class StorageBusMechanic : EnergyTransporter, InteractableMechanic {

    override fun onRightClick(event: PlayerInteractEvent?) {
        val block = event!!.clickedBlock!!
        val player = event.player
        player.openInventory(StorageBusGui(block).inventory)
    }

    override fun onLeftClick(event: PlayerInteractEvent?) {
        onRightClick(event)
    }

    override fun onPhysicalInteraction(event: PlayerInteractEvent?) {
        return
    }
}