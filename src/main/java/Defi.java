import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;



public class  Defi {
    private static Boolean JoueurActif = true;
    private static User Joueur1;
    private static User Joueur2;
    private static TableauJeu.InitTableau tableau;

    public static void initDefi(User j1, User j2, MessageReceivedEvent event) {
        event.getChannel().sendMessage("un defi va se lancer entre " + j2.getAsMention() + " et " + j1.getAsMention() + " !").queue();

        // tirage au sort entre J1 et J2 pour savoir qui commence
        double aleatoire = Math.random();
        if (aleatoire > 0.5) {
            Joueur1 = j1;
            Joueur2 = j2;
        } else {
            Joueur1 = j2;
            Joueur2 = j1;
        }
        tableau = new TableauJeu.InitTableau();
        event.getChannel().sendMessage(tableau.getTableau()).queue();
        event.getChannel().sendMessage(":one: :two: :three: :four: :five: :six: :seven: numeros de colonnes").queue();
        event.getChannel().sendMessage("Executer la commande !p4 suivi du numero de colonne choisi pour placer votre jeton.").queue();
        event.getChannel().sendMessage("Le joueur " + Joueur1.getAsMention() + " commence avec la couleur :red_circle:").queue();
    }


    public static void pion(int position, MessageReceivedEvent event) {
        int k = 0;
        if (JoueurActif && event.getAuthor() == Joueur1) {
            if (tableau.tableau[0][position - 1] == ":black_circle:") {
                JoueurActif = !JoueurActif;
                if (tableau.tableau[5][position - 1] == ":black_circle:") {
                    k = 5;
                } else if (tableau.tableau[4][position - 1] == ":black_circle:") {
                    k = 4;
                } else if (tableau.tableau[3][position - 1] == ":black_circle:") {
                    k = 3;
                } else if (tableau.tableau[2][position - 1] == ":black_circle:") {
                    k = 2;
                } else if (tableau.tableau[1][position - 1] == ":black_circle:") {
                    k = 1;
                } else if (tableau.tableau[0][position - 1] == ":black_circle:") {
                    k = 0;
                }
                tableau.tableau[k][position - 1] = ":red_circle:";
                event.getChannel().sendMessage(tableau.getTableau()).queue();
                event.getChannel().sendMessage(":one: :two: :three: :four: :five: :six: :seven: numeros de colonnes").queue();
                event.getChannel().sendMessage("Au tour du joueur " + Joueur2.getAsMention() + " :blue_circle:").queue();
            } else {
                event.getChannel().sendMessage("la colonne est complete, choisissez une autre colonne").queue();
                event.getChannel().sendMessage(tableau.getTableau()).queue();
                event.getChannel().sendMessage(":one: :two: :three: :four: :five: :six: :seven: numeros de colonnes").queue();
            }

        } else if (!JoueurActif && event.getAuthor() == Joueur2) {
                if (tableau.tableau[0][position - 1] == ":black_circle:") {
                    JoueurActif = !JoueurActif;
                    if (tableau.tableau[5][position - 1] == ":black_circle:") {
                        k = 5;
                    } else if (tableau.tableau[4][position - 1] == ":black_circle:") {
                        k = 4;
                    } else if (tableau.tableau[3][position - 1] == ":black_circle:") {
                        k = 3;
                    } else if (tableau.tableau[2][position - 1] == ":black_circle:") {
                        k = 2;
                    } else if (tableau.tableau[1][position - 1] == ":black_circle:") {
                        k = 1;
                    } else if (tableau.tableau[0][position - 1] == ":black_circle:") {
                        k = 0;
                    }
                    tableau.tableau[k][position - 1] = ":blue_circle:";
                    event.getChannel().sendMessage(tableau.getTableau()).queue();
                    event.getChannel().sendMessage(":one: :two: :three: :four: :five: :six: :seven: numeros de colonnes").queue();
                    event.getChannel().sendMessage("Au tour du joueur " + Joueur1.getAsMention() + " :red_circle:").queue();
                } else {
                    event.getChannel().sendMessage("la colonne est complete, choisissez une autre colonne").queue();
                    event.getChannel().sendMessage(tableau.getTableau()).queue();
                    event.getChannel().sendMessage(":one: :two: :three: :four: :five: :six: :seven: numeros de colonnes").queue();
                }
            }else {
                    event.getChannel().sendMessage("Ce n'est pas a votre tour de jouer !").queue();
                }
            }
        }
