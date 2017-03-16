package com.pontes.projetoprimeiroestagio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ponte on 16/03/2017.
 */

public class MeusContatos {

    public String[] listaNames = {
            "Nome 01",
            "Nome 02",
            "Nome 03",
            "Nome 04",
            "Nome 05"
    };

    public String listaTelefones[] = {
            "9999999",
            "9999999",
            "9999999",
            "9999999",
            "9999999"
    };


    public List<Contato> listDados(){
        List<Contato> list = new ArrayList<>();
        for(int i = 0; i < listaNames.length && i < listaTelefones.length; i++){
            Contato contato = new Contato();
            contato.setNome(listaNames[i]);
            contato.setTelefone(listaTelefones[i]);
            list.add(contato);
        }
        return list;
    }


}
