package tp03.activite02

// Le programme principal est contenu dans la fonction .........

// Quel est le but du programme principal ?
// ...


fun main() {
    // Pourquoi utiliser un do...while dans ce cas ?
    // ...
    do {
        afficheMenu()
        val choix = getChoixUtilisateur()
        if (choix == "4") {
            println("Bye !")
        } else {
            declencheAction(choix)
        }
    } while (choix != "4")
}

// Quelle est la responsabilité de la fonction afficheMenu() ?
// ...
fun afficheMenu() {
    println("---- Menu ---")
    println("1. Dit bonjour")
    println("2. Calcule la somme de deux nombres entiers")
    println("3. Indique si un mot est un palindrome")
    println("4. Bye :-)")
}
// Quelle est la responsabilité de la fonction getChoixUtilisateur() ?
// ...
fun getChoixUtilisateur(): String {
    println("Saisi ton choix (1,2, 3 ou 4)")
    var choix: String
    do {
        choix = readln()
        // Pourquoi utiliser l'appel à une fonction pour tester la
        // validité du choix ?
        // ...
        if (!choixValide(choix)) {
            println("Choix non valide")
        }
    } while (!choixValide(choix))
    return choix
}

fun choixValide(choix: String): Boolean {
    return choix == "1" || choix == "2" || choix == "3" || choix == "4"
}

// Quelle est la responsabilité de la fonction declencheAction() ?
// ...
fun declencheAction(choix: String) {
    // Qu'aurait-on pu utiliser à la place de ce bloc when ?
    // ...
    when (choix) {
        "1" -> ditBonjour()
        "2" -> calculeSomme()
        "3" -> palindrome()
    }
}

fun ditBonjour() {
    println("Quel est ton nom ?")
    val nom = readln()
    println("Bonjour $nom")
}

fun calculeSomme() {
    println("Nombre 1  ?")
    val nombre1 = readln().toInt()
    println("Nombre 1  ?")
    val nombre2 = readln().toInt()
    println("La somme vaut : ${nombre1 + nombre2}")
}

fun palindrome() {
    println("Le mot à tester ?")
    val mot = readln()
    if (mot.reversed() == mot) {
        println("C'est un palindrome !")
    } else {
        println("Ce n'est pas un palindrome !")
    }
}




