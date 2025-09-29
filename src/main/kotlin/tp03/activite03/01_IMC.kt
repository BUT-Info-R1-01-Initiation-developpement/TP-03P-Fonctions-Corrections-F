package tp03.activite03

fun main() {
    // Récupère le poids saisi par l'utilisateur
    println("Entre un poids en kg :")
    val poids = readln().toDouble()

    // Récupère la taille saisie de l'utilisateur
    println("Entre une taille en m : ")
    val taille = readln().toDouble()

    // Calcule de l'IMC
    val imc = poids / (taille * taille)

    // Affichage du message adapté en fonction de la valeur de l'IMC
    println("L'IMC (Indice de masse corporelle) correspondant est de : $imc.")
    if (imc < 18.5) {
        println("Cet IMC correspond à une insuffisance pondérale.")
    } else if (imc < 25.0) {
        println("Cet IMC correspond à une corpulence normale.")
    } else if (imc < 30.0) {
        println("Cet IMC correspond à du surpoids.")
    } else {
        println("Cet IMC correspond à de l'obésité.")
    }
}