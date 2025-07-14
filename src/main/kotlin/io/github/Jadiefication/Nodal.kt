package io.github.Jadiefication

import io.github.Jadiefication.recipe.NodalCableRecipe
import org.bukkit.plugin.java.JavaPlugin

object Nodal : JavaPlugin() {

    override fun onEnable() {
        server.addRecipe(NodalCableRecipe.cableRecipe)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}