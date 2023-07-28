package botjava;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Listeners extends ListenerAdapter {
   public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
    if(event.getButton().getId().equals("yes-button")) {
      event.reply("Nice").queue();
    } else if(event.getButton().getId().equals("no-button")) {
      event.reply("Weirdo!").queue();
    }
    event.getMessage().delete().queue();
   }
}
