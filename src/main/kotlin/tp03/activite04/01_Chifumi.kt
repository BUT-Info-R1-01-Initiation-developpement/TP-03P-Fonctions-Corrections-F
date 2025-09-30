package tp03.activite04

import kotlin.random.Random

fun main() {
    afficheMessageBienvenue()
    do {
        val figureJoueur = recupereFigureJoueur()
        val figureOrdinateur = recupereFigureOrdinateur()
        afficheInformationsSurLeVainqueur(figureJoueur, figureOrdinateur)
        val partieContinue = recupereSouhaitJoueurSurPoursuite()
    } while (partieContinue)
}

fun afficheMessageBienvenue() {
    println(
        """
        Bienvenue sur le jeu Chifumi !
        ------------------------------
      
    """.trimIndent()
    )
}

fun recupereFigureJoueur(): String {
    println(
        """
        Saisie ta figure :
        1. Pierre
        2. Feuille
        3. Ciseaux
    """.trimIndent()
    )
    var choix: String
    do {
        choix = readln()
        if (choixInvalide(choix)) {
            println("Choix invalide")
        }
    } while (choixInvalide(choix))
    return figurePourChoix(choix)
}

fun choixInvalide(choix: String): Boolean {
    return choix != "1" && choix != "2" && choix != "3"
}

fun figurePourChoix(choix: String): String {
    return when (choix) {
        "1" -> "Pierre"
        "2" -> "Feuille"
        else -> "Ciseaux"
    }
}

fun recupereFigureOrdinateur(): String {
    val choix = Random.nextInt(1, 4).toString()
    return figurePourChoix(choix)
}

fun afficheInformationsSurLeVainqueur(figureJoueur: String, figureOrdinateur: String) {
    println(
        """
        Joueur : $figureJoueur vs Ordinateur : $figureOrdinateur
        ${
            when (joueurGagne(figureJoueur, figureOrdinateur)) {
                1 -> "Joueur gagne !"
                -1 -> "Ordinateur gagne !"
                else -> "Egalité !"
            }
        }
    """.trimIndent()
    )
}

fun joueurGagne(figureJoueur: String, figureOrdinateur: String): Int {
    return when {
        figureJoueur == "Pierre" && figureOrdinateur == "Ciseaux" -> 1
        figureJoueur == "Feuille" && figureOrdinateur == "Pierre" -> 1
        figureJoueur == "Ciseaux" && figureOrdinateur == "Feuille" -> 1
        figureJoueur == figureOrdinateur -> 0
        else -> -1
    }

}

fun recupereSouhaitJoueurSurPoursuite(): Boolean {
    println("Voulez-vous rejouer ? (o pour continuer)")
    return readln() == "o"
}