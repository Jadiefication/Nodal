package io.github.Jadiefication.recipe

import io.github.Jadiefication.Nodal
import io.papermc.paper.datacomponent.DataComponentType
import io.papermc.paper.datacomponent.DataComponentTypes
import io.papermc.paper.datacomponent.item.CustomModelData
import io.papermc.paper.datacomponent.item.ItemLore
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.inventory.meta.components.CustomModelDataComponent

object NodalCableRecipe {

    private val key = NamespacedKey(Nodal, "cable")
    val chorusFlower = ItemStack.of(Material.CHORUS_PLANT).apply {
        setData(DataComponentTypes.CUSTOM_MODEL_DATA, CustomModelData.customModelData()
            .addFloat(1f)
            .addFlag(true)
            .build()
        )
        setData(DataComponentTypes.ITEM_NAME, Component.text("Cable"))
        setData(DataComponentTypes.LORE, ItemLore.lore().addLine(Component.text("A cable to connect stuff")).build());
    }
    val cableRecipe = ShapedRecipe(key, chorusFlower).apply {
        shape(
            "",
            "QDQ",
            ""
        )
        setIngredient('Q', Material.QUARTZ)
        setIngredient('D', Material.DIAMOND)
    }
}