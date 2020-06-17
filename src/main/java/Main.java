import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.List;

public class Main extends ListenerAdapter {
    public static void main (String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String tokenBot = "NzIyNzgwNDcwNjkzMDY4ODUw.XuoD4A.0WkAS71apmu2xFZ4CGdMZNhruBM";
        builder.setToken(tokenBot);
        builder.addEventListeners(new Main());
        builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("message de " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay()
        );

        if(event.getMessage().getContentRaw().startsWith("!p4")) {

//commande défi pour affronter un joueur au puissance 4

            if (event.getMessage().getContentRaw().contains("defi")) {

// joueur numéro 1 (celui qui lance le defi)
                User j1 = event.getAuthor();

// si un joueur est tagué il devient le joeur 2 sinon l'utilisateur qui le veut peut rejoindre et devenir le joueur 2
                if (event.getMessage().getContentRaw().contains("@")) {
                    List mentions = event.getMessage().getMentionedUsers();
                    User j2 = (User) mentions.get(0);
                    System.out.println(j1);
                    System.out.println(j2);
                    event.getChannel().sendMessage( j2.getAsMention() + " le joueur " + j1.getAsMention() +
                            " Souhaite vous affronter ! Pour lancer une partie utilisez la commande : !p4 start").queue();
                } else {
                    event.getChannel().sendMessage("Pour affronter "+ j1.getAsMention() + " utilisez la commande : !j4 join").queue();
                }
            } else {
                event.getChannel().sendMessage("pong!").queue();
            }
        }
    }
}


