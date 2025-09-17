package tp03.activite02

// Le programme principal se trouve dans le corps de la fonction ..........

// Quel est le but du programme principal ?
// ...
// À quelle condition le code est valide ?
// ...
fun main() {
    println("Saisie ton code compris entre 0 et 9999 : ")
    val code = readln().toInt()
    if (code < 0 || code > 9999) {
        println("$code est invalide.")
    } else {
        val u = code % 10
        val d = (code / 10) % 10
        val c = (code / 100) % 10
        val m = (code / 1000) % 10
        if (u + d + c + m == 10) {
           println("$code est valide.")
        } else {
            println("$code est invalide.")
        }
    }
}



