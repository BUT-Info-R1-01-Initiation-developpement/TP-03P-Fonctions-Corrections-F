package tp03.activite03

fun main() {
    println("Entre un poids en kg :")
    val poids = readln().toDouble()
    println("Entre une taille en m : ")
    val taille = readln().toDouble()
    val imc = poids / (taille * taille)
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