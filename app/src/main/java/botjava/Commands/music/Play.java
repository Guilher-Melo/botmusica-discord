package botjava.Commands.music;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


import botjava.ICommands;
import botjava.musicplayer.PlayerManager;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class Play implements ICommands {

  @Override
  public String getName() {
   return "play";
  }

  @Override
  public String getDescription() {
    return "will play a song";
  }

  @Override
  public List<OptionData> getOptions() {
    List<OptionData> options = new ArrayList<>();
    options.add(new OptionData(OptionType.STRING, "name", "Name of the song to play", true));
    return options;
  }

  @Override
  public void execute(SlashCommandInteractionEvent event) {
    Member member = event.getMember();
    GuildVoiceState memberVoiceState = member.getVoiceState();

    if(!memberVoiceState.inAudioChannel()) {
      event.reply("Você precisa estar em um canal de voz!").queue();
      return;
    }

    Member self = event.getGuild().getSelfMember();
    GuildVoiceState selfVoiceState = self.getVoiceState();

    if(!selfVoiceState.inAudioChannel()) {
      event.getGuild().getAudioManager().openAudioConnection(memberVoiceState.getChannel());
    } else {
      if(selfVoiceState.getChannel() != memberVoiceState.getChannel()) {
        event.reply("Você precisa estar no mesmo canal de voz que eu!").queue();
        return;
      }
    }

    String name = event.getOption("name").getAsString();

    try {
      new URI(name);
    } catch (URISyntaxException e) {
      name = "ytsearch:" + name;
    }

    PlayerManager playerManager = PlayerManager.get();
    event.reply("Playing...").queue();
    playerManager.play(event.getGuild(), name);
  }
  
}
