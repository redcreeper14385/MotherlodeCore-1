package motherlode.core.item;

import motherlode.core.Motherlode;
import motherlode.core.registry.MotherlodeItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.registry.Registry;

public class MaterialToolsAndArmor {

    public final Item axe;
    public final Item hoe;
    public final Item pickaxe;
    public final Item shovel;
    public final Item sword;

    public final Item helmet;
    public final Item chestplate;
    public final Item leggings;
    public final Item boots;

    public MaterialToolsAndArmor(DefaultToolMaterial toolMaterial, ArmorMaterial armorMaterial) {
        this.axe = register(true, toolMaterial.getName() + "_axe", new MaterialAxe(toolMaterial));
        this.hoe = register(true, toolMaterial.getName() + "_hoe", new MaterialHoe(toolMaterial));
        this.pickaxe = register(true, toolMaterial.getName() + "_pickaxe", new MaterialPickaxe(toolMaterial));
        this.shovel = register(true, toolMaterial.getName() + "_shovel", new ShovelItem(toolMaterial, 1.5F, 3.0F, new Item.Settings().maxCount(1).group(Motherlode.ARMOUR_AND_TOOLS)));
        this.sword = register(true, toolMaterial.getName() + "_sword", new SwordItem(toolMaterial, 3, -2.4F, new Item.Settings().maxCount(1).group(Motherlode.ARMOUR_AND_TOOLS)));

        this.helmet = register(false, toolMaterial.getName() + "_helmet", new ArmorItem(armorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(Motherlode.ARMOUR_AND_TOOLS)));
        this.chestplate = register(false, toolMaterial.getName() + "_chestplate", new ArmorItem(armorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(Motherlode.ARMOUR_AND_TOOLS)));
        this.leggings = register(false, toolMaterial.getName() + "_leggings", new ArmorItem(armorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(Motherlode.ARMOUR_AND_TOOLS)));
        this.boots = register(false, toolMaterial.getName() + "_boots", new ArmorItem(armorMaterial, EquipmentSlot.FEET, new Item.Settings().group(Motherlode.ARMOUR_AND_TOOLS)));

    }

    private Item register(boolean tool, String id, Item item) {
        Registry.register(Registry.ITEM, Motherlode.id(id), item);
        if(tool) MotherlodeItems.handheldItemModelList.add(item);
        else MotherlodeItems.defaultItemModelList.add(item);
        return item;
    }

}

class MaterialPickaxe extends PickaxeItem {
    public MaterialPickaxe(DefaultToolMaterial material) {
        super(material, 1, -2.8F, new Item.Settings().maxCount(1).group(Motherlode.ARMOUR_AND_TOOLS));
    }
}

class MaterialAxe extends AxeItem {
    public MaterialAxe(DefaultToolMaterial material) {
        super(material, 6, -3.1F, new Item.Settings().maxCount(1).group(Motherlode.ARMOUR_AND_TOOLS));
    }
}

class MaterialHoe extends HoeItem {
    public MaterialHoe(DefaultToolMaterial material) {
        super(material, -2, -1F, new Item.Settings().maxCount(1).group(Motherlode.ARMOUR_AND_TOOLS));
    }
}
