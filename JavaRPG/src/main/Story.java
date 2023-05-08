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

    public static void act1() {
        Window.setDisplayText(
            "Como membro de uma organização de desenvolvimento sustentável, você tem a tarefa de investigar"+
            " a causa dos problemas da cidade e encontrar uma solução que beneficie tanto o meio ambiente" + 
            " quanto as pessoas. Sua investigação o leva a descobrir que a fonte da poluição  da cidade são" +
            " as corporações,\nque despejam lixo tóxico no abastecimento de água da cidade."
        );
    }

    public static void act1_1 () {
        Window.setDisplayText(
            "Uma noite, enquanto Akira voltava de um protesto para casa, ele foi atacado por um grupo de "+
            "mercenários corporativos contratados para silenciá-lo."
        );
    }

    public static void act1_2 () {
        Window.setDisplayText(
            "Embora ela tenha conseguido lutar contra eles, ele ficou gravemente ferido e traumatizado pela experiência." +
            "Determinado a continuar seu trabalho, mas com medo de sua segurança, Akira Kankyo decidiu adotar uma nova" +
            "abordagem para seu ativismo"
        );
    }

    public static void act2_1 () {
        Window.setDisplayText(
            "Usando seu conhecimento de desenvolvimento sustentável e sua formação em tecnologia, Akira Kankyo começou a " +
            "criar uma série de redes clandestinas e identidades ocultas, permitindo-lhe operar secretamente sem chamar a atenção para si mesma."
        );
    }

    public static void act2_2 () {
        "À medida que o trabalho de Akira Kankyo continuou, ela se tornou conhecida como a 'Advogada das Sombras', uma figura" +
        "misteriosa que se tornou um farol de esperança para o povo de NeoTóquio. Suas invenções e redes começaram a se espalhar" +
        "pela cidade, ajudando as pessoas a sobreviver em um mundo cada vez mais difícil de viver. No entanto, à medida que seu trabalho" +
        "se tornava mais visível, Akira Kankyo mais uma vez se viu na mira das corporações, que estavam determinadas a acabar com seus esforços."
    }
}
