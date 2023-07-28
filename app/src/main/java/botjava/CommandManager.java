package botjava;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandManager extends ListenerAdapter {
  private List<ICommands> commands = new ArrayList<>();

   public void onReady(@NotNull ReadyEvent event) {
    for(Guild guild: event.getJDA().getGuilds()) {
      for (ICommands command: commands) {
        if(command.getOptions() == null) {
          guild.upsertCommand(command.getName(), command.getDescription()).queue();
        } else {
          guild.upsertCommand(command.getName(), command.getDescription()).addOptions(command.getOptions()).queue();
        }
      }
    }
   }

   public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
    for(ICommands command: commands) {
      if(command.getName().equals(event.getName())) {
        command.execute(event);
        return;
      }
    }
   }

   public void add(ICommands command) {
      commands.add(command);
   }
}
