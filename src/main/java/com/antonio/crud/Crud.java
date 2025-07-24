/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.antonio.crud;

import com.antonio.crud.dao.CategoriaDao;
import com.antonio.crud.dao.UsuarioDao;
import com.antonio.crud.entities.Categoria;
import com.antonio.crud.entities.Usuario;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Professor
 */
public class Crud {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CategoriaDao dao = new CategoriaDao(Categoria.class);
    private static final UsuarioDao userDao = new UsuarioDao(Usuario.class);
    
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
        System.out.print("Digite o id da categoria:");
        long id = scanner.nextLong();
        scanner.nextLine();
        
        Categoria cat = dao.findById(id);
        
        if(cat != null){
            System.out.println("Categoria enontrada.");
            System.out.println("Id: "+ cat.getId());
            System.out.println("Categoria: "+ cat.getNome());
        }else{
            System.out.println("Nenhum registro encontrado");
        }
    }
    
    private static void listarTudo(){
        System.out.println("listando tudo....");
        List<Categoria> categorias = dao.findAll();
        
        if(categorias.isEmpty()){
            System.out.println("Sem resultados");
        }else{
            System.out.println("Categorias encontradas: "+ categorias.size());
            System.out.println("==============================");
            categorias.forEach(c ->{
                System.out.println("Id:"+ c.getId());
                System.out.println("Categoria:"+ c.getNome());
                System.out.println("==============================");
            });
        }
    }
    
    private static void atualizarCategoria(){
        System.out.println("Atualizando....");
        System.out.print("Digite o id que deseja alterar:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Categoria cat = dao.findById(id);
        
        if(cat == null){
            System.out.println("Categoria não encontrada");
            return;
        }
        
        System.out.println("Nome atual: "+ cat.getNome());
        System.out.print("Novo nome (pressione enter para mater):");
        String novoNome = scanner.nextLine();
        
        if(!novoNome.isEmpty()){
            cat.setNome(novoNome);
        }
        
        dao.update(cat);
        System.out.println("Nome atualizado");
        
    }
    
    private static void removerCategoria(){
        System.out.println("removendo....");
        System.out.print("Digite o id que deseja remover:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Categoria cat = dao.findById(id);
        
         if(cat == null){
            System.out.println("Categoria não encontrada");
            return;
        }
         
         dao.delete(cat);
         System.out.println("A categoria foi removida com sucesso!");
        
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
            System.out.print("Digite um item do menu: ");
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
