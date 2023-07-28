package botjava.Commands.music;

import java.util.List;

import botjava.ICommands;
import botjava.musicplayer.GuildMusicManager;
import botjava.musicplayer.PlayerManager;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class Skip implements ICommands {

  @Override
  public String getName() {
    return "skip";
  }

  @Override
  public String getDescription() {
    return "will skip the current song";
  }

  @Override
  public List<OptionData> getOptions() {
    return null;
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
      event.reply("Eu não estou em um canal de voz!").queue();
      return;
    }

    if(selfVoiceState.getChannel() != memberVoiceState.getChannel()) {
      event.reply("Você não está no mesmo server que eu!").queue();
      return;
    }

    GuildMusicManager guildMusicManager = PlayerManager.get().getGuildMusicManager(event.getGuild());
    guildMusicManager.getTrackScheduler().getPlayer().stopTrack();
    event.reply("Skipped...").queue();
  }
  
}
