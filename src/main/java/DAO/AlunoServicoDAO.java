/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Aluno;

public class AlunoServicoDAO {
    AlunoDAO alunoDAO = new AlunoDAO();
    private boolean ok = false;
    
    public Aluno validarAluno (String usuario, String senha){
        Aluno a = null;
        int RA;
        String email;
        String login; 
        String s; 
        String dataDeNascimento; 
        String nome = null;
        int cpf;
        a = alunoDAO.buscaPorUsuario(usuario);
        if(a!=null){
        //if(a.getSenha().equals(senha)){
            ok = true;
        
    }
        return null;

    }
    
    public boolean ok (){
        return ok;
    }
}
