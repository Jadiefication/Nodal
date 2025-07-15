package io.github.Jadiefication.event

import io.github.Jadiefication.cable.CableDataHandler
import io.github.Jadiefication.recipe.NodalCableRecipe
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import org.bukkit.block.data.MultipleFacing
import org.bukkit.event.EventHandler
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.util.Vector

private val positions = buildList {
    for (x in -1..1) {
        for (y in -1..1) {
            for (z in -1..1) {
                if (x != 0 || y != 0 || z != 0) {
                    add(Vector(x, y, z))
                }
            }
        }
    }
}

private val directionToFace: Map<Vector, BlockFace> = mapOf(
    Vector(0, 1, 0) to BlockFace.UP,
    Vector(0, -1, 0) to BlockFace.DOWN,
    Vector(1, 0, 0) to BlockFace.EAST,
    Vector(-1, 0, 0) to BlockFace.WEST,
    Vector(0, 0, 1) to BlockFace.SOUTH,
    Vector(0, 0, -1) to BlockFace.NORTH
)


@EventHandler
fun onCablePlace(
    event: BlockPlaceEvent
) {
    if (event.itemInHand == NodalCableRecipe.cable) {
        val loc = event.blockPlaced.location
        val neighbours = getNeighbours(loc)
        val mainBlock = event.blockPlaced
        if (neighbours.isEmpty()) {
            mainBlock.blockData = CableDataHandler.getCableVariant()!!
        } else {
            val data = mainBlock.blockData as MultipleFacing
            neighbours.forEach { (block, pos) ->
                val defPos = pos.toVector().subtract(loc.toVector())
                directionToFace[defPos]?.let { data.setFace(it, true) }

                val otherData = block.blockData as MultipleFacing
                val otherBlockPos = loc.toVector().subtract(pos.toVector())
                directionToFace[otherBlockPos]?.let { otherData.setFace(it, true) }
                block.blockData = otherData
            }
            mainBlock.blockData = data
        }
    }
}

private fun getNeighbours(
    pos: Location
): Map<Block, Location> {
    val world = pos.world
    return positions
        .map { offset -> pos.clone().add(offset) }
        .mapNotNull { loc ->
            val block = world.getBlockAt(loc)
            if (block.type == Material.MUSHROOM_STEM && CableDataHandler.hasBlockData(block.blockData)) {
                block to loc
            } else null
        }
        .toMap()
}