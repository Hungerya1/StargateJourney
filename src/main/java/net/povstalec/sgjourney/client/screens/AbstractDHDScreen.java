package net.povstalec.sgjourney.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.povstalec.sgjourney.StargateJourney;
import net.povstalec.sgjourney.client.widgets.DHDSymbolButton;
import net.povstalec.sgjourney.common.menu.AbstractDHDMenu;

public abstract class AbstractDHDScreen extends AbstractContainerScreen<AbstractDHDMenu>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(StargateJourney.MODID, "textures/gui/dhd/milky_way_dhd_background.png");
	
	public AbstractDHDScreen(AbstractDHDMenu pMenu, Inventory pPlayerInventory, Component pTitle)
	{
        super(pMenu, pPlayerInventory, pTitle);
        this.imageWidth = 192;
        this.imageHeight = 192;
    }
    
    @Override
    public void init()
    {
    	int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
		super.init();
		
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 8, y + 68, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_1));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 14, y + 43, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_2));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 27, y + 23, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_3));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 50, y + 11, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_4));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 75, y + 8, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_5));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 103, y + 9, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_6));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 122, y + 16, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_7));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 140, y + 32, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_8));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 152, y + 56, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_9));
		
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 158, y + 82, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_10));
		
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 152, y + 108, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_11));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 140, y + 127, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_12));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 122, y + 143, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_13));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 103, y + 154, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_14));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 75, y + 158, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_15));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 50, y + 150, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_16));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 27, y + 135, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_17));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 14, y + 118, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_18));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 8, y + 97, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_19));
		
		
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 35, y + 77, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_20));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 39, y + 59, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_21));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 49, y + 46, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_22));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 64, y + 38, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_23));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 82, y + 35, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_24));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 99, y + 35, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_25));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 110, y + 41, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_26));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 119, y + 52, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_27));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 126, y + 68, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_28));
		
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 129, y + 87, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_29));
		
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 126, y + 102, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_30));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 119, y + 113, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_31));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 110, y + 121, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_32));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 99, y + 127, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_33));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 82, y + 128, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_34));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 64, y + 124, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_35));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 49, y + 117, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_36));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 39, y + 108, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_37));
		this.addRenderableWidget(new DHDSymbolButton.MilkyWay(x + 35, y + 97, menu, DHDSymbolButton.MilkyWay.MilkyWayButton.BUTTON_38));
	}

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY)
    {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
		int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight + 1);
    }

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float delta)
    {
        renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, delta);
        renderTooltip(matrixStack, mouseX, mouseY);
	    
	    /*tooltip(matrixStack, 44, 6, mouseX, mouseY, "1");
	    tooltip(matrixStack, 64, 6, mouseX, mouseY, "2");
	    tooltip(matrixStack, 84, 6, mouseX, mouseY, "3");
	    tooltip(matrixStack, 104, 6, mouseX, mouseY, "4");
	    tooltip(matrixStack, 124, 6, mouseX, mouseY, "5");

	    tooltip(matrixStack, 10, 26, mouseX, mouseY, "6");
	    tooltip(matrixStack, 30, 26, mouseX, mouseY, "7");
	    tooltip(matrixStack, 50, 26, mouseX, mouseY, "8");
	    tooltip(matrixStack, 70, 26, mouseX, mouseY, "9");
	    tooltip(matrixStack, 90, 26, mouseX, mouseY, "10");
	    tooltip(matrixStack, 110, 26, mouseX, mouseY, "11");
	    tooltip(matrixStack, 130, 26, mouseX, mouseY, "12");
	    tooltip(matrixStack, 150, 26, mouseX, mouseY, "13");

	    tooltip(matrixStack, 10, 46, mouseX, mouseY, "14");
	    tooltip(matrixStack, 30, 46, mouseX, mouseY, "15");
	    tooltip(matrixStack, 50, 46, mouseX, mouseY, "16");

	    tooltip(matrixStack, 110, 46, mouseX, mouseY, "17");
	    tooltip(matrixStack, 130, 46, mouseX, mouseY, "18");
	    tooltip(matrixStack, 150, 46, mouseX, mouseY, "19");

	    tooltip(matrixStack, 10, 66, mouseX, mouseY, "20");
	    tooltip(matrixStack, 30, 66, mouseX, mouseY, "21");
	    tooltip(matrixStack, 50, 66, mouseX, mouseY, "22");

	    tooltip(matrixStack, 110, 66, mouseX, mouseY, "23");
	    tooltip(matrixStack, 130, 66, mouseX, mouseY, "24");
	    tooltip(matrixStack, 150, 66, mouseX, mouseY, "25");

	    tooltip(matrixStack, 10, 86, mouseX, mouseY, "26");
	    tooltip(matrixStack, 30, 86, mouseX, mouseY, "27");
	    tooltip(matrixStack, 50, 86, mouseX, mouseY, "28");
	    tooltip(matrixStack, 70, 86, mouseX, mouseY, "29");
	    tooltip(matrixStack, 90, 86, mouseX, mouseY, "30");
	    tooltip(matrixStack, 110, 86, mouseX, mouseY, "31");
	    tooltip(matrixStack, 130, 86, mouseX, mouseY, "32");
	    tooltip(matrixStack, 150, 86, mouseX, mouseY, "33");

	    tooltip(matrixStack, 44, 106, mouseX, mouseY, "34");
	    tooltip(matrixStack, 64, 106, mouseX, mouseY, "35");
	    tooltip(matrixStack, 84, 106, mouseX, mouseY, "36");
	    tooltip(matrixStack, 104, 106, mouseX, mouseY, "37");
	    tooltip(matrixStack, 124, 106, mouseX, mouseY, "38");*/
    }
    
    private void tooltip(PoseStack matrixStack, int x, int y, int mouseX, int mouseY, String number)
    {
    	if(this.isHovering(x, y, 16, 16, (double) mouseX, (double) mouseY))
	    	renderTooltip(matrixStack, Component.literal(number), mouseX, mouseY);
    }
    
    @Override
    protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) 
	{
    	
    }
    
    
}
