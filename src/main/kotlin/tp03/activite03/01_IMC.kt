package tp03.activite03

fun main() {
    val poids = recuperePoidsEnKg()
    val taille = recupereTailleEnM()
    val imc = calculeIMC(poids, taille)
    affichageMessagePourImc(imc)
}

fun affichageMessagePourImc(imc: Double) {
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

fun calculeIMC(poids: Double, taille: Double): Double {
    return poids / (taille * taille)
}

fun recuperePoidsEnKg(): Double {
    println("Entre un poids en kg :")
    return readln().toDouble()
}

fun recupereTailleEnM(): Double {
    println("Entre une taille en m : ")
    return readln().toDouble()
}