package io.github.Jadiefication.recipe

import io.github.Jadiefication.Nodal
import io.github.Jadiefication.redstoneflux.api.items.ItemsFactory
import io.github.Jadiefication.redstoneflux.api.mechanics.EnergyTransporter
import io.github.Jadiefication.redstoneflux.api.persistents.EnergyTypePersistentDataType
import io.github.Jadiefication.redstoneflux.api.types.EnergyTypes
import io.papermc.paper.datacomponent.DataComponentTypes
import io.papermc.paper.datacomponent.item.CustomModelData
import io.papermc.paper.datacomponent.item.ItemLore
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.persistence.PersistentDataType

object NodalCableRecipe {

    private val key = NamespacedKey(Nodal.plugin, "cable")
    private val energyTypeKey = NamespacedKey("redstoneflux", "energy-type")
    private val mechanicClassKey = NamespacedKey("redstoneflux", "mechanic-class")
    val cable = ItemStack.of(Material.MUSHROOM_STEM).apply {
        /*setData(DataComponentTypes.CUSTOM_MODEL_DATA, CustomModelData.customModelData()
            .addFloat(1f)
            .addFlag(true)
            .build()
        )*/
        setData(DataComponentTypes.ITEM_NAME, Component.text("Cable"))
        setData(DataComponentTypes.LORE, ItemLore.lore().addLine(Component.text("A cable to connect stuff")).build())

        itemMeta.persistentDataContainer.set(energyTypeKey, EnergyTypePersistentDataType.INSTANCE, EnergyTypes.RF)
        itemMeta.persistentDataContainer.set(mechanicClassKey, PersistentDataType.STRING, "EnergyTransporter")
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