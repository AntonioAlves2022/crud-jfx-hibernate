/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.antonio.crud;

import com.antonio.crud.dao.CategoriaDao;
import com.antonio.crud.entities.Categoria;
import java.util.Scanner;

/**
 *
 * @author Professor
 */
public class Crud {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CategoriaDao dao = new CategoriaDao(Categoria.class);
    
    private static void salvarCategoria(){
        System.out.println("Salvando....");
        Categoria cat = new Categoria();
        System.out.print("Digite o nome da categoria:");
        cat.setNome(scanner.nextLine());
        dao.save(cat);
        System.out.println("Categoria salva com id:"+cat.getId());
        
    }
    
    private static void buscarPorId(){
        System.out.println("Busca por Id....");
    }
    
    private static void listarTudo(){
        System.out.println("listando tudo....");
    }
    
    private static void atualizarCategoria(){
        System.out.println("Atualizando....");
    }
    
    private static void removerCategoria(){
        System.out.println("removendo....");
    }
    
    
    public static void exibirMenu() {
        while (true) {
            System.out.println("=== Menu de Testes ===");
            System.out.println("1. Cadastrar nova Categoria");
            System.out.println("2. Buscar cateogria por Id");
            System.out.println("3. Listar todas as categorias");
            System.out.println("4. Atualizar uma categoria");
            System.out.println("5. Remover uma categoria");
            System.out.println("6. Sair");
            System.out.println("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcao){
                case 1:
                    salvarCategoria();
                    break;
                case 2:
                    buscarPorId();
                    break;
                case 3:
                    listarTudo();
                    break;
                case 4:
                    atualizarCategoria();
                    break;
                case 5:
                    removerCategoria();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
                
            }
        }
    }

    public static void main(String[] args) {
        exibirMenu();
    }
}
