package br.com.ekan.cadastro_usuario;

import java.util.Scanner;

public class Principal {
    public void exibeMenu() {

        var opcao = -1;

        while (opcao!= 9) {
            var menu = """
                    *** Screen Sound Músicas ***                    
                                        
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                                    
                    9 - Sair
                    """;

            System.out.println(menu);
            Scanner leitura = new Scanner(System.in);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();

            }
        }
    }

    private void cadastrarArtistas() {
        System.out.println("Apenas para teste");
    }

}

