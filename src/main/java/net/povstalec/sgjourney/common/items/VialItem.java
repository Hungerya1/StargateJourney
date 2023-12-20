package net.povstalec.sgjourney.common.items;

import java.util.List;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;
import net.povstalec.sgjourney.common.init.FluidInit;
import net.povstalec.sgjourney.common.init.ItemInit;

public class VialItem extends Item
{
	public static final int MAX_CAPACITY = 150;
	
	public VialItem(Properties properties)
	{
		super(properties);
	}
	
	@Override
    public final ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag tag)
	{
		return new FluidHandlerItemStack(stack, MAX_CAPACITY)
				{
		    		@Override
		    		public boolean isFluidValid(int tank, @NotNull FluidStack stack)
		    		{
		    			return stack.getFluid() == FluidInit.LIQUID_NAQUADAH_SOURCE.get();
		    		}
				};
	}
	
	public static ItemStack liquidNaquadahSetup()
	{
		ItemStack stack = new ItemStack(ItemInit.VIAL.get());
        
        stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(fluidHandler ->
        {
        	fluidHandler.fill(new FluidStack(FluidInit.LIQUID_NAQUADAH_SOURCE.get().getSource(), MAX_CAPACITY), FluidAction.EXECUTE);
        });
		
		return stack;
	}
	
	public static ItemStack heavyLiquidNaquadahSetup()
	{
		ItemStack stack = new ItemStack(ItemInit.VIAL.get());
        
        stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(fluidHandler ->
        {
        	fluidHandler.fill(new FluidStack(FluidInit.HEAVY_LIQUID_NAQUADAH_SOURCE.get().getSource(), MAX_CAPACITY), FluidAction.EXECUTE);
        });
		
		return stack;
	}
	
	public static int getFluidAmount(ItemStack stack)
	{
		FluidStack fluidStack = getFluidStack(stack);
		
		return fluidStack.getAmount();
	}
	
	public static int getLiquidNaquadahAmount(ItemStack stack)
	{
		FluidStack fluidStack = getFluidStack(stack);
		
		if(fluidStack.getFluid() != FluidInit.LIQUID_NAQUADAH_SOURCE.get())
			return 0;
		
		return fluidStack.getAmount();
	}
	
	public static FluidStack getFluidStack(ItemStack stack)
	{
		Optional<FluidStack> fluid = stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).map(fluidHandler -> fluidHandler.getFluidInTank(0));
		
		return fluid.isPresent() ? fluid.get() : FluidStack.EMPTY;
	}
	
	public static void drainLiquidNaquadah(ItemStack stack)
	{
		stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(fluidHandler -> 
		{
			fluidHandler.drain(1, FluidAction.EXECUTE);
		});
	}
	
	public static int getMaxCapacity()
	{
		return MAX_CAPACITY;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced)
	{
		int fluidAmount = getFluidAmount(stack);
		
		MutableComponent liquidNaquadah = Component.translatable(getFluidStack(stack).getTranslationKey()).withStyle(ChatFormatting.GREEN);
		liquidNaquadah.append(Component.literal(" " + fluidAmount + "mB").withStyle(ChatFormatting.GREEN));
    	tooltipComponents.add(liquidNaquadah);
    	
    	super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
	}
}
