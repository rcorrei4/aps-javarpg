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
            "Determinado a continuar seu trabalho, mas com medo de sua segurança, Akira Kankyo decidiu adotar uma nova " +
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
    	Window.setDisplayText(
	        "À medida que o trabalho de Akira Kankyo continuou, ela se tornou conhecida como a 'Advogada das Sombras', uma figura" +
	        "misteriosa que se tornou um farol de esperança para o povo de NeoTóquio. Suas invenções e redes começaram a se espalhar" +
	        "pela cidade, ajudando as pessoas a sobreviver em um mundo cada vez mais difícil de viver. No entanto, à medida que seu trabalho" +
	        "se tornava mais visível, Akira Kankyo mais uma vez se viu na mira das corporações, que estavam determinadas a acabar com seus esforços."
        );
    }
    
    public static void act2_3 () {
    	Window.setDisplayText("[Você encontra mercenários ao tentar um caminho alternativo para sua casa.]");
    }
    
    public static void act2_4 () {
    	Window.setDisplayText(
			"Mercenário: Ei, o que você está fazendo aqui? Este é o território da Corporação Arashi, saia imediatamente ou " + 
			"você vai se arrepender!"
    	);
    }
    
    public static void act2_5 () {
    	Window.setDisplayText(
    		"Eu estou aqui para proteger as pessoas desta cidade. E vocês estão aqui para causar mais danos e sofrimento."
    	);
    }
    
    public static void act2_6 () {
    	Window.setDisplayText(
    		"Hah! Quem é você para nos dizer o que fazer? Nós estamos sendo pagos para fazer um trabalho e vamos fazê-lo, mesmo " +
    		"que isso signifique pisar em algumas pessoas."
    	);
    }
    
    public static void act2_7 () {
    	Window.setDisplayText(
    		"Eu não vou deixar vocês causarem mais danos nesta cidade. É hora de acabar com isso."
    	);
    }

    public static void act3_1 () {
        Window.setDisplayText(
            "Hefesto: Você está atrapalhando o progresso, e isso é algo que não posso permitir, está perdendo seu tempo, sabia? Você não pode mudar nada, por mais que tente."
        );
    }

    public static void act3_2 () {
        Window.setDisplayText(
            "Talvez não hoje, talvez não amanhã. Mas, eventualmente, faremos a diferença. Temos que fazer."
        );
    }

    public static void act3_3 () {
        Window.setDisplayText(
            "Hefesto: E como você tem tanta certeza disso?"
        );
    }

    public static void act3_4 () {
        Window.setDisplayText(
            "Porque acreditamos no que estamos lutando. E quando você acredita em algo, você pode conseguir qualquer coisa."
        );
    }
}
