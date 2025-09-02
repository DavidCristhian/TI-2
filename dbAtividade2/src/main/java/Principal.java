import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlunoDAO dao = new AlunoDAO();
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Listar");
            System.out.println("2 - Inserir");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    List<Aluno> alunos = dao.listar();
                    for (Aluno a : alunos) {
                        System.out.println(a);
                    }
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Curso: ");
                    String curso = sc.nextLine();
                    dao.inserir(new Aluno(nome, idade, curso));
                    System.out.println("Aluno inserido com sucesso!");
                    break;
                case 3:
                    System.out.print("ID do aluno: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Nova idade: ");
                    int novaIdade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo curso: ");
                    String novoCurso = sc.nextLine();
                    dao.atualizar(new Aluno(idAtualizar, novoNome, novaIdade, novoCurso));
                    System.out.println("Aluno atualizado!");
                    break;
                case 4:
                    System.out.print("ID do aluno a excluir: ");
                    int idExcluir = sc.nextInt();
                    dao.excluir(idExcluir);
                    System.out.println("Aluno excluído!");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        sc.close();
    }
}
