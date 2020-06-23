public class TableauJeu {
    public static class InitTableau {
        static String[][]tableau = {
                {":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:"},
                {":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:"},
                {":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:"},
                {":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:"},
                {":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:"},
                {":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:",":black_circle:"},
                };


        public static String getTableau() {
            String tableauChat = new String();
            String ligne = new String();
            String Newligne = System.getProperty("line.separator");
            for (int i = 0 ; i < 6 ; i++) {
                for (int k = 0 ; k < 7 ; k++) {
                    ligne = ligne.concat(tableau[i][k]);
                    ligne = ligne.concat(" ");
                }
                tableauChat = tableauChat.concat(ligne);
                tableauChat = tableauChat.concat(Newligne);
                ligne = "";
            }
            return tableauChat;
        }
    }
}
