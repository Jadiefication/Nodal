package io.github.Jadiefication

import io.github.Jadiefication.cable.recipe.NodalCableRecipe
import org.bukkit.plugin.java.JavaPlugin

class Nodal : JavaPlugin() {

    companion object {
        lateinit var plugin: Nodal
    }

    override fun onEnable() {
        plugin = this
        server.addRecipe(NodalCableRecipe.cableRecipe)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}