package net.povstalec.sgjourney.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.povstalec.sgjourney.StargateJourney;
import net.povstalec.sgjourney.block_entities.AbstractStargateEntity;
import net.povstalec.sgjourney.init.LayerInit;
import net.povstalec.sgjourney.stargate.PointOfOrigin;
import net.povstalec.sgjourney.stargate.Symbols;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractStargateRenderer
{
	protected final ModelPart event_horizon;
	protected final ModelPart symbols_39;
	protected final ModelPart symbols_36;
	protected final ModelPart dividers_39;
	protected final ModelPart dividers_36;
	protected final ModelPart ring;
	protected final ModelPart chevrons;
	
	public AbstractStargateRenderer(BlockEntityRendererProvider.Context context)
	{
		ModelPart chevron_part = context.bakeLayer(LayerInit.CHEVRON_LAYER);
		ModelPart ring_part = context.bakeLayer(LayerInit.RING_LAYER);
		ModelPart divider_part_39 = context.bakeLayer(LayerInit.DIVIDER_LAYER_39);
		ModelPart symbol_part_39 = context.bakeLayer(LayerInit.SYMBOL_LAYER_39);
		ModelPart divider_part_36 = context.bakeLayer(LayerInit.DIVIDER_LAYER_36);
		ModelPart symbol_part_36 = context.bakeLayer(LayerInit.SYMBOL_LAYER_36);
		ModelPart event_horizon_part = context.bakeLayer(LayerInit.EVENT_HORIZON_LAYER);
		this.chevrons = chevron_part;
		this.symbols_39 = symbol_part_39.getChild("symbols");
		this.symbols_36 = symbol_part_36.getChild("symbols");
		this.dividers_39 = divider_part_39.getChild("dividers");
		this.dividers_36 = divider_part_36.getChild("dividers");
		this.ring = ring_part.getChild("ring");

		this.event_horizon = event_horizon_part.getChild("event_horizon");
	}
	
	protected ModelPart chevronFront(int i)
	{
		return this.chevrons.getChild("chevron" + i + "_front");
	}
	
	protected ModelPart chevronLight(int i)
	{
		return this.chevrons.getChild("chevron" + i + "_light");
	}
	
	protected ModelPart chevronBack(int i)
	{
		return this.chevrons.getChild("chevron" + i + "_back");
	}
	
	protected ModelPart symbols(AbstractStargateEntity stargate)
	{
		if(stargate.symbolCount == 36)
			return symbols_36;
		else
			return symbols_39;
	}
	
	protected ModelPart dividers(AbstractStargateEntity stargate)
	{
		if(stargate.symbolCount == 36)
			return dividers_36;
		else
			return dividers_39;
	}
	
	protected PointOfOrigin getPointOfOrigin(AbstractStargateEntity stargate)
	{
		String pointOfOrigin = stargate.pointOfOrigin;
		
		Minecraft minecraft = Minecraft.getInstance();
		ClientPacketListener clientPacketListener = minecraft.getConnection();
		RegistryAccess registries = clientPacketListener.registryAccess();
		Registry<PointOfOrigin> registry = registries.registryOrThrow(PointOfOrigin.REGISTRY_KEY);
		
		if(registry.containsKey(new ResourceLocation(pointOfOrigin)))
			return registry.get(new ResourceLocation(pointOfOrigin));
		return registry.get(new ResourceLocation(StargateJourney.MODID, "error"));
	}
	
	protected Symbols getSymbols(AbstractStargateEntity stargate)
	{
		String symbols = stargate.symbols;
		
		Minecraft minecraft = Minecraft.getInstance();
		ClientPacketListener clientPacketListener = minecraft.getConnection();
		RegistryAccess registries = clientPacketListener.registryAccess();
		Registry<Symbols> registry = registries.registryOrThrow(Symbols.REGISTRY_KEY);
		
		if(registry.containsKey(new ResourceLocation(symbols)))
			return registry.get(new ResourceLocation(symbols));
		return registry.get(new ResourceLocation(StargateJourney.MODID, "error"));
	}
}