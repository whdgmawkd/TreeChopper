package treechopper.common.config;

import com.google.common.collect.ImmutableList;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import treechopper.core.TreeChopper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationHandler {
    public static Configuration config;

    public static boolean decayLeaves;
    public static boolean reverseShift;
    public static boolean disableShift;
    public static boolean plantSapling;
    public static boolean damageAxe;

    public static List<String> axeTypes = new ArrayList<>();
    public static List<String> blockWhiteList = new ArrayList<>();
    public static List<String> leafWhiteList = new ArrayList<>();

    public static void init(File configFile) {
        if (config == null) {
            config = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {
        try {
            decayLeaves = config.getBoolean("Decay leaves", "Settings", true, "Cut down whole tree - wooden blocks and leaves");
            reverseShift = config.getBoolean("Reverse shift", "Settings", false, "Reverse shift function - Mod works with shift pressing");
            disableShift = config.getBoolean("Disable shift", "Settings", false, "Disable shift function - Always chop trees regardless of shift pressing");
            plantSapling = config.getBoolean("Plant sapling", "Settings", false, "Automatic sapling plant on tree chop");
            damageAxe = config.getBoolean("Damage Axe","Settings",true, "Decrease axe durability when cut down tres");

            axeTypes = ImmutableList.copyOf(config.getStringList("Whitelisted items", "Data", new String[]{
                    "item.hatchetWood",
                    "item.hatchetStone",
                    "item.hatchetIron",
                    "item.hatchetGold",
                    "item.hatchetDiamond",
                    "item.mud_axe",
                    "item.psi:psimetalAxe",
                    "item.tconstruct.lumberaxe",
                    "item.tconstruct.mattock",
                    "item.tconstruct.hatchet",
                    "item.brain_stone_axe",
                    "item.stable_pulsating_brain_stone_axe",
                    "item.adobe_axe",
                    "item.ObsidianAxe",
                    "item.LazuliAxe",
                    "item.OsmiumAxe",
                    "item.BronzeAxe",
                    "item.GlowstoneAxe",
                    "item.SteelAxe",
                    "item.LapisLazuliAxe",
                    "item.peridotAxe",
                    "item.rubyAxe",
                    "item.sapphireAxe",
                    "item.bronzeAxe",
                    "item.mud_axe",
                    "ic2.chainsaw",
                    "item.itemcrystalaxe",
                    "item.itemchargedcrystalaxe",
                    "item.axe_copper",
                    "item.axe_silver",
                    "item.axe_lead",
                    "item.axe_dawnstone",
                    "item.axe_aluminum",
                    "item.axe_bronze",
                    "item.axe_electrum",
                    "item.axe_nickel",
                    "item.axe_tin",
                    "item.WoodPaxel",
                    "item.StonePaxel",
                    "item.IronPaxel",
                    "item.DiamondPaxel",
                    "item.GoldPaxel",
                    "item.ObsidianPaxel",
                    "item.LapisLazuliPaxel",
                    "item.OsmiumPaxel",
                    "item.BronzePaxel",
                    "item.GlowstonePaxel",
                    "item.SteelPaxel",
                    "item.ma.inferium_axe",
                    "item.ma.prudentium_axe",
                    "item.ma.intermedium_axe",
                    "item.ma.superium_axe",
                    "item.ma.supremium_axe",
                    "item.psimetal_axe",
                    "item.netheraxt",
                    "item.stahlaxt",
                    "item.teufelseisenaxt",
                    "item.flintAxt",
                    "item.flint_axe",
                    "item.bone_axe",
                    "item.emerald_axe",
                    "item.obsidian_axe",
                    "item.diamond_multi",
                    "item.emerald_multi",
                    "item.golden_multi",
                    "item.iron_multi",
                    "item.obsidian_multi",
                    "item.stone_multi",
                    "item.wooden_multi",
                    "item.natura.ghostwood_axe",
                    "item.natura.bloodwood_axe",
                    "item.natura.darkwood_axe",
                    "item.natura.fusewood_axe",
                    "item.natura.netherquartz_axe",
                    "item.terraAxe",
                    "item.elementiumAxe",
                    "item.manasteelAxe",
                    "item.actuallyadditions.item_axe_quartz",
                    "item.actuallyadditions.item_axe_emerald",
                    "item.actuallyadditions.item_axe_obsidian",
                    "item.actuallyadditions.item_axe_crystal_red",
                    "item.actuallyadditions.item_axe_crystal_blue",
                    "item.actuallyadditions.item_axe_crystal_light_blue",
                    "item.actuallyadditions.item_axe_crystal_black",
                    "item.actuallyadditions.item_axe_crystal_green",
                    "item.actuallyadditions.item_axe_crystal_white",
                    "item.daxe",
                    "item.aaxe",
                    "item.coraxe",
                    "item.dreadiumaxe",
                    "item.ethaxiumaxe",
                    "item.crystal_axe",
                    "item.crystal_axe_bone",
                    "item.dungeontactics:gilded_axe",
                    "item.dungeontactics:jewelled_axe",
                    "item.flint_axe",
                    "item.quartz_axe",
                    "item.obsidian_axe",
                    "item.opal_axe",
                    "item.diamond_axe",
                    "item.thermalfoundation.tool.copperAxe",
                    "item.thermalfoundation.tool.tinAxe",
                    "item.thermalfoundation.tool.silverAxe",
                    "item.thermalfoundation.tool.leadAxe",
                    "item.thermalfoundation.tool.aluminumAxe",
                    "item.thermalfoundation.tool.nickelAxe",
                    "item.thermalfoundation.tool.platinumAxe",
                    "item.thermalfoundation.tool.steelAxe",
                    "item.thermalfoundation.tool.electrumAxe",
                    "item.thermalfoundation.tool.invarAxe",
                    "item.thermalfoundation.tool.bronzeAxe",
                    "item.thermalfoundation.tool.constantanAxe",
                    "item.next:toolAxeBone",
                    "item.ironwoodAxe",
                    "item.steeleafAxe",
                    "item.minotaurAxe",
                    "item.knightlyAxe",
            }, "Put here allowed items(axes), "));

            blockWhiteList = ImmutableList.copyOf(config.getStringList("Whitelisted blocks", "Data", new String[]{
                    "tile.log",
                    "tile.log_0",
                    "tile.log_1",
                    "tile.log_2",
                    "tile.log_3",
                    "tile.log_4",
                    "tile.pamCinnamon",
                    "tile.pamPaperbark",
                    "tile.pamMaple",
                    "tile.for.pile_wood",
                    "tile.for.logs.vanilla.fireproof.1",
                    "tile.for.logs.vanilla.fireproof.0",
                    "tile.for.logs.fireproof.7",
                    "tile.for.logs.fireproof.6",
                    "tile.for.logs.fireproof.5",
                    "tile.for.logs.fireproof.4",
                    "tile.for.logs.fireproof.3",
                    "tile.for.logs.fireproof.2",
                    "tile.for.logs.fireproof.1",
                    "tile.for.logs.fireproof.0",
                    "tile.for.logs.7",
                    "tile.for.logs.6",
                    "tile.for.logs.5",
                    "tile.for.logs.4",
                    "tile.for.logs.3",
                    "tile.for.logs.2",
                    "tile.for.logs.1",
                    "tile.for.logs.0",
                    "ic2.rubber_wood",
                    "tile.terraqueous.trunk",
                    "tile.techreborn.rubberlog",
                    "tile.dendrology:log",
                    "tile.livingwood",
                    "tile.totemic:cedar_log",
                    "tile.rustic.log",
                    "tile.natura.nether_logs",
                    "tile.natura.nether_logs2",
                    "tile.natura.overworld_logs",
                    "tile.natura.overworld_logs2",
            }, "Put here allowed blocks(wood), "));

            leafWhiteList = ImmutableList.copyOf(config.getStringList("Whitelisted leaves", "Data", new String[]{
                    "tile.pamdate",
                    "tile.pampistachio",
                    "tile.pampapaya",
                    "tile.pamwalnut",
                    "tile.pamcherry",
                    "tile.pamfig",
                    "tile.pamdragonfruit",
                    "tile.pamapple",
                    "tile.pamlemon",
                    "tile.pampear",
                    "tile.pamolive",
                    "tile.pamgrapefruit",
                    "tile.pampomegranate",
                    "tile.pamcashew",
                    "tile.pamvanilla",
                    "tile.pamstarfruit",
                    "tile.pambanana",
                    "tile.pamplum",
                    "tile.pamavocadu",
                    "tile.pampecan",
                    "tile.pampistachio",
                    "tile.pamlime",
                    "tile.pampeppercorn",
                    "tile.pamalmond",
                    "tile.pamgooseberry",
                    "tile.pampeach",
                    "tile.pamchestnut",
                    "tile.pamcoconut",
                    "tile.pammango",
                    "tile.pamapricot",
                    "tile.pamorange",
                    "tile.pampersimmon",
                    "tile.pamnutmeg",
                    "tile.pamdurian",
                    "tile.pamcinnamon",
                    "tile.pammaple",
                    "tile.pampaperbark"
            }, "Put here allowed special blocks - e.g. fruit, "));

        } catch (Exception e) {
            System.out.printf("Cannot load Tree Chopper config.");
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

    public static void setPlantSap(boolean plantSap) {
        ConfigurationHandler.plantSapling = plantSap;
        config.get("Settings", "Plant sapling", false, "Automatic sapling plant on tree chop").set(plantSap);

        config.save();
    }

    public static void setReverseShi(boolean reverseShi) {
        ConfigurationHandler.reverseShift = reverseShi;
        config.get("Settings", "Reverse shift", false, "Reverse shift function - Mod works with shift pressing").set(reverseShi);

        config.save();
    }

    public static void setDisableShi(boolean disableShi) {
        ConfigurationHandler.disableShift = disableShi;
        config.get("Setting", "Disable shift", false, "Disable shift function - Always chop trees regardless of shift pressing").set(disableShi);

        config.save();
    }

    public static void setDecayLea(boolean decayLea) {
        ConfigurationHandler.decayLeaves = decayLea;
        config.get("Settings", "Decay leaves", true, "Cut down whole tree - wooden blocks and leaves").set(decayLea);

        config.save();
    }

    public static void setDamageAxe(boolean dmgAxe){
        ConfigurationHandler.damageAxe = dmgAxe;
        config.get("Settings","Damage Axe",true,"Decrease axe durability when cut down tres");

        config.save();
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equalsIgnoreCase(TreeChopper.MOD_ID)) {
            loadConfiguration();
        }
    }
}
