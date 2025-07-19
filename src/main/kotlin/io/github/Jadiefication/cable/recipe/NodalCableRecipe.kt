package io.github.Jadiefication.cable.recipe

import io.github.Jadiefication.Nodal
import io.github.Jadiefication.cable.CableComponent
import io.github.Jadiefication.cable.CableMechanic
import io.github.Jadiefication.redstoneflux.api.items.ItemsFactory
import io.papermc.paper.datacomponent.DataComponentTypes
import io.papermc.paper.datacomponent.item.ItemLore
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

object NodalCableRecipe {

    private val key = NamespacedKey(Nodal.plugin, "cable")
    private val cableComponent = CableComponent()

    val cable: ItemStack = ItemsFactory.registerItem {
        item = Material.MUSHROOM_STEM
        name = Component.text("Cable")
        lore = ItemLore.lore().addLine(Component.text("A cable to connect stuff")).build()
        mechanic = cableComponent
    }

    val cableRecipe = ShapedRecipe(key, cable).apply {
        shape(
            "   ",
            "QDQ",
            "   "
        )
        setIngredient('Q', Material.QUARTZ)
        setIngredient('D', Material.DIAMOND)
    }
}