package io.github.Jadiefication.recipe

import io.github.Jadiefication.Nodal
import io.github.Jadiefication.cable.CableMechanic
import io.github.Jadiefication.redstoneflux.api.items.ItemsFactory
import io.github.Jadiefication.redstoneflux.api.mechanics.EnergyTransporter
import io.papermc.paper.datacomponent.DataComponentTypes
import io.papermc.paper.datacomponent.item.CustomModelData
import io.papermc.paper.datacomponent.item.ItemLore
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

object NodalCableRecipe {

    private val key = NamespacedKey(Nodal.plugin, "cable")
    val cable = ItemStack.of(Material.MUSHROOM_STEM).apply {
        /*setData(DataComponentTypes.CUSTOM_MODEL_DATA, CustomModelData.customModelData()
            .addFloat(1f)
            .addFlag(true)
            .build()
        )*/
        setData(DataComponentTypes.ITEM_NAME, Component.text("Cable"))
        setData(DataComponentTypes.LORE, ItemLore.lore().addLine(Component.text("A cable to connect stuff")).build())

        ItemsFactory.registerItemHolder<EnergyTransporter> {
            item = this@apply
            mechanic = CableMechanic()
        }
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