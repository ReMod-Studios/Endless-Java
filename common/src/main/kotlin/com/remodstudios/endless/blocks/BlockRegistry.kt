package com.remodstudios.endless.blocks

import com.remodstudios.endless.Endless
import me.shedaniel.architectury.registry.RegistrySupplier
import net.minecraft.block.AbstractBlock.Settings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.Material
import net.minecraft.block.MaterialColor
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.registry.Registry.BLOCK_KEY
import java.util.function.Supplier

object BlockRegistry {
    private val REGISTRY = Endless.registry(BLOCK_KEY)

    private fun register(path: String, supplier: Supplier<Block>): RegistrySupplier<Block> {
        return REGISTRY.register(path, supplier)
    }

    @JvmField
    val COBALT_ORE = register("cobalt_ore")
    {
        Block(Settings.copy(Blocks.END_STONE))
    }
    @JvmField
    val COBALT_BLOCK = register("cobalt_block")
    {
        Block(Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.STONE))
    }
    @JvmField
    val STATIC_CHARGE = register("static_charge")
    {
        StaticChargeBlock(Settings.of(Material.PLANT, MaterialColor.YELLOW).sounds(BlockSoundGroup.WOOL).nonOpaque())
    }
    @JvmField
    val COBALT_REPEL = register("cobalt_repel")
    {
        CobaltRepelBlock(Settings.of(Material.GLASS, MaterialColor.BLUE).nonOpaque())
    }
    @JvmField
    val THERAKIUM_ORE = register("therakium_ore")
    {
        Block(Settings.copy(Blocks.END_STONE))
    }
    @JvmField
    val THERAKIUM_BLOCK = register("therakium_block")
    {
        Block(Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.STONE))
    }
    @JvmField
    val RHYOLITE = register("rhyolite")
    {
        Block(Settings.copy(Blocks.GRANITE))
    }
    @JvmField
    val POLISHED_RHYOLITE = register("polished_rhyolite")
    {
        Block(Settings.copy(Blocks.POLISHED_GRANITE))
    }
    @JvmField
    val LUNARIC_END_STONE = register("lunaric_end_stone")
    {
        Block(Settings.copy(Blocks.END_STONE))
    }

    fun register() {
        /* clinit */
        REGISTRY.register()
    }
}