package com.extremelf;

import com.extremelf.BLL.AguaBLL;
import com.extremelf.DAL.AguaEntity;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Eu vou fazer o BLL até Funcionário, incluido. Podes fazer os seguintes. Quanto às named querrys podes seguir o exemplo das que já fiz

        AguaEntity doce = new AguaEntity();
        doce.setDescricao("Doce");

        AguaBLL.create(doce);


        List<AguaEntity> lista = AguaBLL.readAll();
        for (AguaEntity list : lista) {
            System.out.println("Id:" + list.getIdagua() + "Descrição: " + list.getDescricao());
        }

    }
}
