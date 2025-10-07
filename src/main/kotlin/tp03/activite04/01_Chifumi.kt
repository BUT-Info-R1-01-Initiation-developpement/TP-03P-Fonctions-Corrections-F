package tp03.activite04

import kotlin.random.Random

// Le mot clé const indique au compilateur qu'il peut remplacer la chaine de caractère dès la
// compilation quand il tombe sur une expression mobilisant la constante !

// Une val déclarée const est une val dont la valeur est connue dès la compilation.
// L'indiquer explicitement au compilateur permet d'optimiser l'exécution du programme :
// il n'y a plus d'opération de substitution à l'exécution car elles ont déjà été faites
// à la compilation.

// Les constantes peuvent être déclarées à l'extérieur de toute fonction pour les rendre globales,
// c'est-à-dire accessible depuis n'importe quelle fonction.

const val PIERRE = "Pierre"
const val FEUILLE = "Feuille"
const val CISEAUX = "Ciseaux"

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
        1. ${PIERRE}
        2. ${FEUILLE}
        3. ${CISEAUX}
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
        "1" -> PIERRE
        "2" -> FEUILLE
        else -> CISEAUX
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
        figureJoueur == PIERRE && figureOrdinateur == CISEAUX -> 1
        figureJoueur == FEUILLE && figureOrdinateur == PIERRE -> 1
        figureJoueur == CISEAUX && figureOrdinateur == FEUILLE -> 1
        figureJoueur == figureOrdinateur -> 0
        else -> -1
    }

}

fun recupereSouhaitJoueurSurPoursuite(): Boolean {
    println("Voulez-vous rejouer ? (o pour continuer)")
    return readln() == "o"
}