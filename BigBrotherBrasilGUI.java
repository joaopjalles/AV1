import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BigBrotherBrasil {
    public static void main(String[] args) {
        ArrayList<Jogador> jogadores = new ArrayList<>();

        cadastrarJogadores(jogadores);
        votacao(jogadores);
        apuracaoFinal(jogadores);
    }

    public static void cadastrarJogadores(ArrayList<Jogador> jogadores) {
        String[] nomes = {"Alane Dias", "Beatriz Reis", "Davi Brito", "Deniziane Ferreira", "Fernanda Bande",
                "Giovanna Lima", "Giovanna Pitel", "Isabelle Nogueira", "Juninho", "Leidy Elin", "Lucas Henrique",
                "Lucas Luigi", "Lucas Pizane", "Marcus Vinicius", "Matteus Amaral", "Maycon Cosmer", "MC Bin Laden",
                "Michel Nogueira", "Nizam", "Raquele Cardozo", "Rodriguinho", "Thalyta Alves", "Vanessa Lopes",
                "Vinicius Rodrigues", "Wanessa Camargo", "Yasmin Brunet"};

        for (String nome : nomes) {
            Jogador jogador = new Jogador(nome);
            jogadores.add(jogador);
        }
    }

    public static void votacao(ArrayList<Jogador> jogadores) {
        JOptionPane.showMessageDialog(null, "Digite 'sair' para encerrar a votação.");
        while (true) {
            String votoEm = JOptionPane.showInputDialog(null, "Em quem você vota para sair da casa?");
            if (votoEm == null || votoEm.equalsIgnoreCase("sair")) {
                break;
            }

            boolean encontrado = false;
            for (Jogador jogador : jogadores) {
                if (jogador.getNome().equalsIgnoreCase(votoEm)) {
                    jogador.incrementaUmVoto();
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Jogador não encontrado. Por favor, digite novamente.");
            }
        }
    }

    public static void apuracaoFinal(ArrayList<Jogador> jogadores) {
        Jogador jogadorEliminado = jogadores.get(0);
        for (Jogador jogador : jogadores) {
            if (jogador.getVotos() > jogadorEliminado.getVotos()) {
                jogadorEliminado = jogador;
            }
        }

        JOptionPane.showMessageDialog(null, "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir " +
                "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir " +
                "dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te " +
                "eliminar com alegria. Com " + jogadorEliminado.getVotos() + " votos, é você quem sai " +
                jogadorEliminado.getNome());
    }
}

