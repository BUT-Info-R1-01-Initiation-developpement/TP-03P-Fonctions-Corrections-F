package tp03.activite02

// Le programme principal est contenu dans la fonction main()

// Quel est le but du programme principal ?
// Le programme présente à l'utilisateur un menu lui permettant d'exécuter sous-programmes
// différents au choix.
// 1. Le programme affiche d'abord le menu,
// 2. Il récupère le choix de l'utilisateur,
// 3. Déclenche l'action choisie par l'utilisateur ou quitte le programme si le dernier item du menu est choisi.
// 4. Une fois l'action exécutée, le programme itère àpartir de l'affichage du menu, jusqu'à ce que l'utilisateur
// choisisse de quitter l'application.


fun main() {
    // Pourquoi utiliser un do...while dans ce cas ?
    // Le contenu de la boucle doit être exécuté au moins un fois.
    // On est donc dans le cas d'utilisation standard (nominal) d'une boucle devant
    // utiliser la forme do...while.
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
// Cette fonction prend en charge exclusivement l'affichage du menu.
fun afficheMenu() {
    println("---- Menu ---")
    println("1. Dit bonjour")
    println("2. Calcule la somme de deux nombres entiers")
    println("3. Indique si un mot est un palindrome")
    println("4. Bye :-)")
}
// Quelle est la responsabilité de la fonction getChoixUtilisateur() ?
// Cette fonction prend en charhe la récupération de la valeur saisie par l'utilisateur.
// Elle gère le cas où l'utilisateur ferait un choix invalide.
fun getChoixUtilisateur(): String {
    println("Saisi ton choix (1,2, 3 ou 4)")
    var choix: String
    do {
        choix = readln()
        // Pourquoi utiliser l'appel à une fonction pour tester la
        // validité du choix ?
        // Le teste de validité du choix est mobilisé deux fois dans le programme,
        // on limite donc la duplication de code et la fonction masque la complexité
        // de la condition de validité à ce niveau.
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
// Cette fonction déclenche la fonction correspondant au choix de l'utilisateur.
fun declencheAction(choix: String) {
    // Qu'aurait-on pu utiliser à la place de ce bloc when ?
    // On aurait pu utiliser un bloc if...else if...else
    when (choix) {
        "1" -> ditBonjour()
        "2" -> calculeSomme()
        "3" -> palindrome()
    }
}

// Pour aller plus loin.
//
// Si on regarde plus en détail, ce programme est découpé en trois périmètres de responsabilité que se partagent
// les fonctions :
// - ce qui est relatif à l'interface avec l'utilisateur (fonctions d'affichage et de récupération de la saisie
// utilisateur) : la vue ;
// - ce qui est relatif à ce que le programme sait faire d'utile pour l'utilisateur (savoir dire bonjour,
// savoir calculer la somme de deux nombres, savoir reconnaitre un palindrome) : le modèle ;
// - enfin ce qui est relatif au lien entre la vue et le modèle (déclencher la fonction utile en fonction du choix
// de l'utilisateur) : le contrôleur.
// Ce découpage est un "standard" de conception en ingénierie logiciel. Il a un nom ce standard de conception :
// MVC: pour Modèle-Vue-Contrôleur.

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




