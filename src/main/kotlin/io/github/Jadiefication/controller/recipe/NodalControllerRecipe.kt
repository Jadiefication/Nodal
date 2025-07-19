package io.github.Jadiefication.controller.recipe

import io.github.Jadiefication.Nodal
import io.github.Jadiefication.controller.ControllerComponent
import io.github.Jadiefication.controller.EnergyController
import io.github.Jadiefication.redstoneflux.api.items.ItemsFactory
import io.papermc.paper.datacomponent.DataComponentTypes
import io.papermc.paper.datacomponent.item.ItemLore
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

object NodalControllerRecipe {

    private val key = NamespacedKey(Nodal.plugin, "controller")
    val controller = ItemsFactory.registerItemHolder {
            item = ItemStack.of(Material.OBSIDIAN)
            name = Component.text("Controller")
            lore = ItemLore.lore().addLine(Component.text("The base for starting your digital storage")).build()
            mechanic = ControllerComponent()
    }
    val controllerRecipe = ShapedRecipe(key, controller).apply {
        shape(
            "NNN",
            "NSN",
            "NNN"
        )
        setIngredient('N', Material.NETHERITE_INGOT)
        setIngredient('S', Material.NETHER_STAR)
    }
}