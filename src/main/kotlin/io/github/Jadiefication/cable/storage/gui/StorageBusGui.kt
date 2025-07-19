package io.github.Jadiefication.cable.storage.gui

import io.github.Jadiefication.Nodal
import io.github.Jadiefication.redstoneflux.api.items.ItemsFactory
import org.bukkit.NamespacedKey
import org.bukkit.block.Block
import org.bukkit.block.TileState
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class StorageBusGui(
    val block: Block
) : InventoryHolder {

    private val inventory = Nodal.plugin.server.createInventory(this, 9)
    private val key = NamespacedKey(Nodal.plugin, "storageBusGUI")

    override fun getInventory(): Inventory {
        return inventory
    }

    fun loadFromBlock() {
        val state = block.state as? TileState ?: return
        val pdc = state.persistentDataContainer
        inventory.storageContents = ItemsFactory.gson.fromJson(pdc.get(key, PersistentDataType.STRING), Array<ItemStack>::class.java)
    }

    fun saveToBlock() {
        val state = block.state as? TileState ?: return
        val pdc = state.persistentDataContainer
        pdc.set(key, PersistentDataType.STRING, ItemsFactory.gson.toJson(inventory.storageContents))
        state.update(true)
    }
}