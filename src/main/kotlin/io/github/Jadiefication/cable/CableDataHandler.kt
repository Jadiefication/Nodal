package io.github.Jadiefication.cable

import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.block.data.BlockData
import org.bukkit.block.data.MultipleFacing

object CableDataHandler {

    val cableVariants = listOf(
        createCableBlockData(),
        createCableBlockData(west = true),
        createCableBlockData(up = true, west = true),
        createCableBlockData(south = true, west = true),
        createCableBlockData(south = true, up = true),
        createCableBlockData(south = true, up = true, west = true),
        createCableBlockData(north = true),
        createCableBlockData(north = true, west = true),
        createCableBlockData(north = true, up = true),
        createCableBlockData(north = true, up = true, west = true),
        createCableBlockData(north = true, south = true),
        createCableBlockData(north = true, south = true, west = true),
        createCableBlockData(north = true, south = true, up = true),
        createCableBlockData(north = true, south = true, up = true, west = true),
        createCableBlockData(east = true),
        createCableBlockData(east = true, west = true),
        createCableBlockData(east = true, up = true),
        createCableBlockData(east = true, up = true, west = true),
        createCableBlockData(east = true, south = true),
        createCableBlockData(east = true, south = true, west = true),
        createCableBlockData(east = true, south = true, up = true),
        createCableBlockData(east = true, south = true, up = true, west = true),
        createCableBlockData(east = true, north = true),
        createCableBlockData(east = true, north = true, west = true),
        createCableBlockData(east = true, north = true, up = true),
        createCableBlockData(east = true, north = true, up = true, west = true),
        createCableBlockData(east = true, north = true, south = true),
        createCableBlockData(east = true, north = true, south = true, west = true),
        createCableBlockData(east = true, north = true, south = true, up = true),
        createCableBlockData(east = true, north = true, south = true, up = true, west = true),
        createCableBlockData(down = true),
        createCableBlockData(down = true, west = true),
        createCableBlockData(down = true, up = true),
        createCableBlockData(down = true, up = true, west = true),
        createCableBlockData(down = true, south = true),
        createCableBlockData(down = true, south = true, west = true),
        createCableBlockData(down = true, south = true, up = true),
        createCableBlockData(down = true, south = true, up = true, west = true),
        createCableBlockData(down = true, north = true),
        createCableBlockData(down = true, north = true, west = true),
        createCableBlockData(down = true, north = true, up = true),
        createCableBlockData(down = true, north = true, up = true, west = true),
        createCableBlockData(down = true, north = true, south = true),
        createCableBlockData(down = true, north = true, south = true, west = true),
        createCableBlockData(down = true, north = true, south = true, up = true),
        createCableBlockData(down = true, north = true, south = true, up = true, west = true),
        createCableBlockData(down = true, east = true),
        createCableBlockData(down = true, east = true, west = true),
        createCableBlockData(down = true, east = true, up = true),
        createCableBlockData(down = true, east = true, up = true, west = true),
        createCableBlockData(down = true, east = true, south = true),
        createCableBlockData(down = true, east = true, south = true, west = true),
        createCableBlockData(down = true, east = true, south = true, up = true),
        createCableBlockData(down = true, east = true, south = true, up = true, west = true),
        createCableBlockData(down = true, east = true, north = true),
        createCableBlockData(down = true, east = true, north = true, west = true),
        createCableBlockData(down = true, east = true, north = true, up = true),
        createCableBlockData(down = true, east = true, north = true, up = true, west = true),
        createCableBlockData(down = true, east = true, north = true, south = true),
        createCableBlockData(down = true, east = true, north = true, south = true, west = true),
        createCableBlockData(down = true, east = true, north = true, south = true, up = true),
        createCableBlockData(down = true, east = true, north = true, south = true, up = true, west = true)
    )

    fun createCableBlockData(
        down: Boolean = false,
        east: Boolean = false,
        north: Boolean = false,
        south: Boolean = false,
        up: Boolean = false,
        west: Boolean = false
    ): BlockData {
        val blockData = Material.CHORUS_PLANT.createBlockData() as MultipleFacing

        if (down) blockData.setFace(BlockFace.DOWN, true)
        if (east) blockData.setFace(BlockFace.EAST, true)
        if (north) blockData.setFace(BlockFace.NORTH, true)
        if (south) blockData.setFace(BlockFace.SOUTH, true)
        if (up) blockData.setFace(BlockFace.UP, true)
        if (west) blockData.setFace(BlockFace.WEST, true)

        return blockData
    }

    fun hasBlockData(
        blockData: BlockData
    ): Boolean {
        return cableVariants.contains(blockData)
    }

    fun getCableVariant(
        down: Boolean = false,
        east: Boolean = false,
        north: Boolean = false,
        south: Boolean = false,
        up: Boolean = false,
        west: Boolean = false
    ): BlockData? {
        val searchData = createCableBlockData(down, east, north, south, up, west)
        return cableVariants.find { it.matches(searchData) }
    }
}