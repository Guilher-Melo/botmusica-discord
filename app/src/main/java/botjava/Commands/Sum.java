package botjava.Commands;

import java.util.ArrayList;
import java.util.List;


import botjava.ICommands;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class Sum implements ICommands {
  

  @Override
  public String getName() {
    return "sum";
  }

  @Override
  public String getDescription() {
    return "Gives the sum of two numbers";
  }

  @Override
  public List<OptionData> getOptions() {
    List<OptionData> data = new ArrayList<>();
    data.add(new OptionData(OptionType.INTEGER, "num1", "The first number", true).setMinValue(1).setMaxValue(200));
    data.add(new OptionData(OptionType.INTEGER, "num2", "The second number", false).setMinValue(1).setMaxValue(200));
    return data;
  }
  @Override
  public void execute(SlashCommandInteractionEvent event) {
    OptionMapping number1 = event.getOption("num1");
    int num1 = number1.getAsInt();

    OptionMapping number2 = event.getOption("num2");
    int num2 = num1;
    if(number2 != null) {
      num2 = number2.getAsInt();
    }
    
    int result = num1 + num2;
    event.reply(result + "").queue();
  }
}
