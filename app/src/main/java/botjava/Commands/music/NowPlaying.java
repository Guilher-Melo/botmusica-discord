package botjava.Commands.music;

import java.util.List;

import com.sedmelluq.discord.lavaplayer.track.AudioTrackInfo;

import botjava.ICommands;
import botjava.musicplayer.GuildMusicManager;
import botjava.musicplayer.PlayerManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class NowPlaying implements ICommands {

  @Override
  public String getName() {
    return "nowplaying";
  }

  @Override
  public String getDescription() {
    return "will display the current song";
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

    if(guildMusicManager.getTrackScheduler().getPlayer().getPlayingTrack().getInfo() == null) {
      event.reply("Eu não estou tocando nada no momento");
      return;
    }

    AudioTrackInfo info = guildMusicManager.getTrackScheduler().getPlayer().getPlayingTrack().getInfo();
    EmbedBuilder embedBuilder = new EmbedBuilder();
    embedBuilder.setTitle("Currently Playing");
    embedBuilder.setDescription("**Name:** `" + info.title + "`");
    embedBuilder.appendDescription("\n**Author:** `" + info.author + "`");
    embedBuilder.appendDescription("\n**URL:** `" + info.uri + "`");
    event.replyEmbeds(embedBuilder.build()).queue();
  }
  
}
