package com.remodstudios.endless.items

import com.remodstudios.endless.Endless
import com.remodstudios.endless.Endless.id
import com.remodstudios.endless.blocks.BlockRegistry
import me.shedaniel.architectury.registry.CreativeTabs
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.registry.Registry
import java.util.function.Supplier

object ItemRegistry {
    private val REGISTRY = Endless.REGISTRIES.get(Registry.ITEM_KEY);

    private fun register(path: String, supplier: Supplier<Item>): Supplier<Item> {
        return REGISTRY.register(id(path), supplier);
    }

    private val CREATIVE_TAB: ItemGroup = CreativeTabs.create(id("group")) { ItemStack(COBALT_LIGHTER.get()) }

    private fun defaultSettings(): Item.Settings {
        return Item.Settings().group(CREATIVE_TAB)
    }

    val TEST_BLOCK = register("test_block") { BlockItem(BlockRegistry.TEST_BLOCK.get(), defaultSettings()) }
    val COBALT_LIGHTER = register("cobalt_lighter") { CobaltLighterItem(defaultSettings()) }

    fun register() {
        /* clinit */
    }
}