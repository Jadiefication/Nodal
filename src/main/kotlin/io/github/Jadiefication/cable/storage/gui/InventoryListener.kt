package io.github.Jadiefication.cable.storage.gui

import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryOpenEvent

@EventHandler
fun onInventoryOpen(event: InventoryOpenEvent) {
    val holder = event.inventory.holder as? StorageBusGui ?: return
    holder.loadFromBlock()
}

@EventHandler
fun onInventoryClose(event: InventoryCloseEvent) {
    val holder = event.inventory.holder as? StorageBusGui ?: return
    holder.saveToBlock()
}