package tp03.activite02

// Le programme principal se trouve dans le corps de la fonction main()

// Quel est le but du programme principal ?
// Indiquer si le code saisi est valide ou non

fun main() {
    println("Saisie ton code compris entre 0 et 9999 : ")
    val codeSaisi = readln().toInt()
    if (codeValide(codeSaisi)) {
        println("$codeSaisi est valide.")
    } else {
        println("$codeSaisi est invalide.")
    }
}

// À quelle condition le code est il valide ?
// Il faut que le code soit un nombre entier entre 0 et 9999 et
// que la somme de ses chiffres soit égale à 10
fun codeValide(code: Int): Boolean {
    if (code < 0 || code > 9999) {
        return false
    }
    return sommeChiffres(code) == 10
}

// Quel est le but de cette fonction ?
// Calcule la somme des chiffres de l'objet référencé par code et
// retourne la somme au programme appelant
fun sommeChiffres(code: Int): Int {
    val unites = code % 10
    val dizaines = (code / 10) % 10
    val centaines = (code / 100) % 10
    val milliers = (code / 1000) % 10
    return unites + dizaines + centaines + milliers
}

// Entre 01_CodePinV1 et 02_CodePinV2, quelle version du programme préférez-vous ?
// Justifiez votre réponse.
// Le code est plus facile à comprendre, il est structuré en petites fonctions elles même faciles
// à comprendre
