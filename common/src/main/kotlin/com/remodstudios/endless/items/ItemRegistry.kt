package com.remodstudios.endless.items

import com.remodstudios.endless.Endless
import com.remodstudios.endless.Endless.id
import com.remodstudios.endless.blocks.BlockRegistry
import me.shedaniel.architectury.registry.CreativeTabs
import me.shedaniel.architectury.registry.RegistrySupplier
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.registry.Registry.ITEM_KEY
import java.util.function.Supplier

@SuppressWarnings("unused")
object ItemRegistry {
    private val REGISTRY = Endless.registry(ITEM_KEY)

    private fun register(path: String, supplier: Supplier<Item>): RegistrySupplier<Item> {
        return REGISTRY.register(path, supplier)
    }

    private val CREATIVE_TAB: ItemGroup = CreativeTabs.create(id("group")) { ItemStack(COBALT_LIGHTER.get()) }

    private fun defaultSettings(): Item.Settings {
        return Item.Settings().group(CREATIVE_TAB)
    }

    val COBALT_DUST = register("cobalt_dust")
    {
        Item(defaultSettings())
    }
    val COBALT_DYNAMITE = register("cobalt_dynamite")
    {
        CobaltDynamiteItem(defaultSettings())
    }
    val COBALT_LIGHTER = register("cobalt_lighter")
    {
        CobaltLighterItem(defaultSettings().maxDamage(65))
    }
    val THERAKIUM_SHARD = register("therakium_shard")
    {
        Item(defaultSettings())
    }

    // region Block Items
    val COBALT_REPEL = register("cobalt_repel")
    {
        BlockItem(BlockRegistry.COBALT_REPEL.get(), defaultSettings())
    }
    val COBALT_ORE = register("cobalt_ore")
    {
        BlockItem(BlockRegistry.COBALT_ORE.get(), defaultSettings())
    }
    val COBALT_BLOCK = register("cobalt_block")
    {
        BlockItem(BlockRegistry.COBALT_BLOCK.get(), defaultSettings())
    }
    val THERAKIUM_ORE = register("therakium_ore")
    {
        BlockItem(BlockRegistry.THERAKIUM_ORE.get(), defaultSettings())
    }
    val THERAKIUM_BLOCK = register("therakium_block")
    {
        BlockItem(BlockRegistry.THERAKIUM_BLOCK.get(), defaultSettings())
    }
    val RHYOLITE = register("rhyolite")
    {
        BlockItem(BlockRegistry.RHYOLITE.get(), defaultSettings())
    }
    val POLISHED_RHYOLITE = register("polished_rhyolite")
    {
        BlockItem(BlockRegistry.POLISHED_RHYOLITE.get(), defaultSettings())
    }
    val LUNARIC_END_STONE = register("lunaric_end_stone")
    {
        BlockItem(BlockRegistry.LUNARIC_END_STONE.get(), defaultSettings())
    }
    // endregion

    fun register() {
        /* clinit */
        REGISTRY.register()
    }
}