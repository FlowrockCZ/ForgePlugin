package ee;

import ee.item.ItemLootBall;
import forge.IPickupHandler;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityItem;
import net.minecraft.server.ItemStack;


public class AlchemyBagPickupHandler implements IPickupHandler
{
	@Override
	public boolean onItemPickup(final EntityHuman player, final EntityItem item)
	{
		final ItemStack stack = item.itemStack;
		
		if (stack.getItem() instanceof ItemLootBall)
		{
			return true;
		}
		
		for (final ItemStack inventoryStack : player.inventory.getContents())
		{
			if (inventoryStack == null)
			{
				continue;
			}
			
			if (inventoryStack.id == EEItem.alchemyBag.id)
			{
				if (ItemAlchemyBag.getBagData(inventoryStack, player, player.world).onItemPickup(stack))
				{
					return false;
				}
			}
		}
		
		return true;
	}
}