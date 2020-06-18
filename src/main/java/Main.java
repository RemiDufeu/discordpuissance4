import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.List;

public class Main extends ListenerAdapter {
    public static void main (String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String tokenBot = "NzIyNzgwNDcwNjkzMDY4ODUw.XusgzA.wcTMqQrvLPBnicS8zhaUV1s-VOk";
        builder.setToken(tokenBot);
        builder.addEventListeners(new Main());
        builder.build();
    }
    boolean defiG = false;
    User j1;
    User j2;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("message de " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay()
        );

        if(event.getMessage().getContentRaw().startsWith("!p4")) {

//commande défi pour affronter un joueur au puissance 4
            if (event.getMessage().getContentRaw().contains("defi")) {

// si un joueur est tagué il devient le joeur 2 sinon l'utilisateur qui le veut peut rejoindre et devenir le joueur 2
                if (event.getMessage().getContentRaw().contains("@")) {
                    j1 = event.getAuthor();
                    List mentions = event.getMessage().getMentionedUsers();
                    if ((User) mentions.get(0) != j1) {
                        j2 = (User) mentions.get(0);
                        System.out.println(j1);
                        System.out.println(j2);
                        event.getChannel().sendMessage(j2.getAsMention() + " le joueur " + j1.getAsMention() +
                                " Souhaite vous affronter ! Pour lancer une partie utilisez la commande : !p4 start").queue();
                    } else {
                        event.getChannel().sendMessage(j1.getAsMention() + " Vous ne pouvez pas vous affronter vous-meme, un defi generale est lance !").queue();
                        event.getChannel().sendMessage("Pour affronter "+ j1.getAsMention() + " utilisez la commande : !p4 join").queue();
                        defiG = true;
                    }

                } else if (defiG == true) {
                    if ( event.getAuthor() != j1) {
                        j2 = event.getAuthor();
                        defiG = false;
                        event.getChannel().sendMessage("un defi va se lancer entre "+ j2.getAsMention() + " et "+ j1.getAsMention() + " !").queue();
                    } else {
                        event.getChannel().sendMessage("Vous ne pouvez pas vous affronter vous meme !").queue();
                    }
                } else {
                    j1 = event.getAuthor();
                    event.getChannel().sendMessage("Pour affronter "+ j1.getAsMention() + " utilisez la commande : !p4 join").queue();
                    defiG = true;
                }


            } else if (event.getMessage().getContentRaw().contains("join")){
                if (event.getAuthor() != j1) {
                    j2 = event.getAuthor();
                    defiG = false;
                    event.getChannel().sendMessage("un defi va se lancer entre "+ j2.getAsMention() + " et "+ j1.getAsMention() + " !").queue();
                } else {
                    event.getChannel().sendMessage("Vous ne pouvez pas vous affronter vous meme !").queue();
                }


            } else if (event.getMessage().getContentRaw().contains("start")) {
                if (event.getAuthor() == j2) {
                    event.getChannel().sendMessage("un defi va se lancer entre "+ j2.getAsMention() + " et "+ j1.getAsMention() + " !").queue();
                } else {
                    event.getChannel().sendMessage("Vous n'êtes pas le joueur défié !").queue();
                }
            }
            else {
                event.getChannel().sendMessage("Commande inconnue !").queue();
                event.getChannel().sendMessage("Pour voir la liste des commandes, Executez la commande suivante : !p4 help").queue();
            }
        }
    }
}


