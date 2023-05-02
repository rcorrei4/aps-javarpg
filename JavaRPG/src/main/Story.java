package main;

import gui.Window;

public class Story {
    public static void intro() {
        Window.setDisplayText(
            "NeoTókio 2087"+
            "\n\nO ano é 2087 e NeoTokyo é uma cidade à beira do colapso."+
            "O sistema meteorológico não funciona bem, a cidade está poluída e as pessoas lutam para sobreviver."+
            "Em meio a esse caos, uma nova droga chamada 'Bliss' surgiu, oferecendo aos usuários uma fuga temporária"+
            " de sua dura realidade."

        );
    }

    public static void actI() {
        Window.setDisplayText(
            "Como membro de uma organização de desenvolvimento sustentável, você tem a tarefa de investigar"+
            " a causa dos problemas da cidade e encontrar uma solução que beneficie tanto o meio ambiente" + 
            " quanto as pessoas. Sua investigação o leva a descobrir que a fonte da poluição  da cidade são" +
            " as corporações,\nque despejam lixo tóxico no abastecimento de água da cidade."
        );
    }

    public static void actI_1 () {
        Window.setDisplayText(
            "Uma noite, enquanto Akira voltava de um protesto para casa, ele foi atacado por um grupo de "+
            "mercenários corporativos contratados para silenciá-lo."
        );
    }
}
