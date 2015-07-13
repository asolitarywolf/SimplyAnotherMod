package asolitarywolf.sam.init;


import asolitarywolf.sam.item.ItemMapleLeaf;
import asolitarywolf.sam.item.ItemSAM;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

    public static final ItemSAM mapleLeaf = new ItemMapleLeaf();

    public static void init(){

        GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
    }
}
