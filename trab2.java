package game.battle;

import java.util.Scanner;

// Classe que representa um lutador no confronto
class Lutador {
    private String apelido;
    private int pontosVida;
    private int poderAtaque;
    private int resistencia;

    public Lutador(String apelido, int pontosVida, int poderAtaque, int resistencia) {
        this.apelido = apelido;
        this.pontosVida = pontosVida;
        this.poderAtaque = poderAtaque;
        this.resistencia = resistencia;
    }

    // Aplica dano ao lutador considerando a resistência
    public void receberDano(int dano) {
        int danoFinal = Math.max(1, dano - this.resistencia);
        this.pontosVida = Math.max(0, this.pontosVida - danoFinal);
    }

    // Exibe o status atual do lutador
    public String mostrarStatus() {
        if (this.pontosVida == 0) {
            return this.apelido + ": 0 de vida (derrotado)";
        } else {
            return this.apelido + ": " + this.pontosVida + " de vida";
        }
    }

    // Métodos de acesso para obter os atributos do lutador
    public String getApelido() {
        return apelido;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public int getPoderAtaque() {
        return poderAtaque;
    }
}

// Classe principal que gerencia a luta entre dois lutadores
public class Confronto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("==== Início da Batalha ====");
        System.out.println("Insira os dados do primeiro lutador:");
        
        // Entrada dos dados do primeiro lutador
        System.out.print("Apelido: ");
        String apelido1 = entrada.nextLine();
        System.out.print("Pontos de Vida: ");
        int vidaInicial1 = entrada.nextInt();
        System.out.print("Poder de Ataque: ");
        int ataqueInicial1 = entrada.nextInt();
        System.out.print("Resistência: ");
        int resistencia1 = entrada.nextInt();
        entrada.nextLine();

        Lutador lutador1 = new Lutador(apelido1, vidaInicial1, ataqueInicial1, resistencia1);

        System.out.println("Insira os dados do segundo lutador:");
        
        // Entrada dos dados do segundo lutador
        System.out.print("Apelido: ");
        String apelido2 = entrada.nextLine();
        System.out.print("Pontos de Vida: ");
        int vidaInicial2 = entrada.nextInt();
        System.out.print("Poder de Ataque: ");
        int ataqueInicial2 = entrada.nextInt();
        System.out.print("Resistência: ");
        int resistencia2 = entrada.nextInt();

        Lutador lutador2 = new Lutador(apelido2, vidaInicial2, ataqueInicial2, resistencia2);

        System.out.print("Quantos rounds você deseja executar? ");
        int rounds = entrada.nextInt();

        // Loop para executar o combate por uma quantidade de rounds determinada
        for (int round = 1; round <= rounds; round++) {
            if (lutador1.getPontosVida() == 0 || lutador2.getPontosVida() == 0) {
                break;
            }

            lutador1.receberDano(lutador2.getPoderAtaque());
            lutador2.receberDano(lutador1.getPoderAtaque());

            System.out.println("Resultado do round " + round + ":");
            System.out.println(lutador1.mostrarStatus());
            System.out.println(lutador2.mostrarStatus());
            System.out.println();

            if (lutador1.getPontosVida() == 0 || lutador2.getPontosVida() == 0) {
                break;
            }
        }

        System.out.println("=== BATALHA ENCERRADA ===");
        entrada.close();
    }
}