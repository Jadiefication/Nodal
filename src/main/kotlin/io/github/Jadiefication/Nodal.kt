package io.github.Jadiefication

import io.github.Jadiefication.cable.recipe.NodalCableRecipe
import io.github.Jadiefication.cable.recipe.NodalStorageBusRecipe
import io.github.Jadiefication.cable.storage.gui.InventoryListener
import io.github.Jadiefication.controller.recipe.NodalControllerRecipe
import org.bukkit.plugin.java.JavaPlugin

class Nodal : JavaPlugin() {

    companion object {
        lateinit var plugin: Nodal
    }

    override fun onEnable() {
        plugin = this
        server.addRecipe(NodalCableRecipe.cableRecipe)
        server.addRecipe(NodalControllerRecipe.controllerRecipe)
        server.addRecipe(NodalStorageBusRecipe.storageBusRecipe)

        server.pluginManager.registerEvents(InventoryListener(), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}