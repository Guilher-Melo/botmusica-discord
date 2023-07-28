package botjava.Commands;

import java.awt.Color;
import java.util.List;

import botjava.ICommands;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class Embed implements ICommands {

  @Override
  public String getName() {
    return "embed";
  }

  @Override
  public String getDescription() {
    return "Will send a embed";
  }

  @Override
  public List<OptionData> getOptions() {
    return null;
  }

  @Override
  public void execute(SlashCommandInteractionEvent event) {
    EmbedBuilder builder = new EmbedBuilder();
    builder.setTitle("Example embed");
    builder.setDescription("An example embed");
    builder.addField("Field 1", "Value", false);
    builder.addField("Field 2", "Value", false);
    builder.addField("Field 3", "Value", false);
    builder.setFooter("Example footer");
    builder.setColor(Color.BLUE);
    event.replyEmbeds(builder.build()).queue();
  }
  
}
