package net.cobrasrock.skinchange.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.cobrasrock.skinchange.gui.SkinScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(MultiplayerScreen.class)
public class MixinMultiplayerMenu extends Screen
{

	public MixinMultiplayerMenu(Text title)
	{
		super(title);
	}

	@Inject(at = @At("RETURN"), method = "init")
	private void init(CallbackInfo info)
	{
		this.addButton(new ButtonWidget(this.width - 125, this.height / 36, 100, 20, new LiteralText("Change Skin"), button ->{
			MinecraftClient.getInstance().openScreen(new SkinScreen(this));
		}));
	}
}