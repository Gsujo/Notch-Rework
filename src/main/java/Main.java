import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    
    private static Main instance;

    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        registerRecipe();
        getCommand("notchreload").setExecutor(new Reload());
    }

    public static Main getInstance() {
        return instance;
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(this, "enchanted_golden_apple");
        
        if (Bukkit.getRecipe(key) != null) {
            Bukkit.removeRecipe(key);
        }

        FileConfiguration config = getConfig();
        ItemStack item = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("ABC", "DEF", "GHI");

        recipe.setIngredient('A', Material.valueOf(config.getString("Recipes.TopLeft", "NETHERITE_SCRAP")));
        recipe.setIngredient('B', Material.valueOf(config.getString("Recipes.TopMiddle", "NETHERITE_SCRAP")));
        recipe.setIngredient('C', Material.valueOf(config.getString("Recipes.TopRight", "NETHERITE_SCRAP")));
        recipe.setIngredient('D', Material.valueOf(config.getString("Recipes.MiddleLeft", "NETHERITE_SCRAP")));
        recipe.setIngredient('E', Material.valueOf(config.getString("Recipes.Middle", "GOLDEN_APPLE")));
        recipe.setIngredient('F', Material.valueOf(config.getString("Recipes.MiddleRight", "NETHERITE_SCRAP")));
        recipe.setIngredient('G', Material.valueOf(config.getString("Recipes.BottomLeft", "NETHERITE_SCRAP")));
        recipe.setIngredient('H', Material.valueOf(config.getString("Recipes.BottomMiddle", "NETHERITE_SCRAP")));
        recipe.setIngredient('I', Material.valueOf(config.getString("Recipes.BottomRight", "NETHERITE_SCRAP")));

        Bukkit.addRecipe(recipe);
    }
}