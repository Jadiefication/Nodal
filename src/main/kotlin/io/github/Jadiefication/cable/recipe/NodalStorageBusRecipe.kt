package io.github.Jadiefication.cable.recipe

import io.github.Jadiefication.Nodal
import io.github.Jadiefication.cable.storage.StorageBusComponent
import io.github.Jadiefication.redstoneflux.api.items.ItemsFactory
import io.papermc.paper.datacomponent.item.ItemLore
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

object NodalStorageBusRecipe {

    private val key = NamespacedKey(Nodal.plugin, "storageBus")
    private val storageBusComponent = StorageBusComponent()

    val storageBus: ItemStack = ItemsFactory.registerItem {
        item = Material.PURPUR_BLOCK
        name = Component.text("Storage Bus")
        lore = ItemLore.lore()
            .addLine(
            Component.text("A component to connect to storages"))
            .addLine(
                Component.text("And add their contents to the network")
            ).build()
        mechanic = storageBusComponent
    }

    val storageBusRecipe = ShapedRecipe(key, storageBus).apply {
        shape(
            "CCC",
            "CNC",
            "CCC"
        )
        setIngredient('C', Material.CALCITE)
        setIngredient('N', NodalCableRecipe.cable)
    }
}