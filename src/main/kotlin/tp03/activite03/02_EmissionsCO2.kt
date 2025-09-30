package tp03.activite03

import com.sun.jdi.connect.Transport

fun main() {
    val distance = recupereDistanceEnKm()
    val nombreVoyageurs = recupereNombreVoyageurs()
    val nomTransport = recupereModeTransport()


    val emissionsCO2TotaleParVoyageurEnKg = calculeEmissionsCO2TotaleParVoyageurEnKg(
        nomTransport,
        nombreVoyageurs,
        distance
    )

    afficheInformationsEmissionsPourVoyage(
        distance,
        nomTransport,
        emissionsCO2TotaleParVoyageurEnKg,
        nombreVoyageurs)

}

fun afficheInformationsEmissionsPourVoyage(
    distance: Double,
    nomTransport: String,
    emissionsCO2TotaleParVoyageurEnKg: Double,
    nombreVoyageurs: Int
) {
    println("""
        Dans le cas de ce voyage de $distance km en $nomTransport, la quantité de CO2 émise 
        - par chaque voyageur est de $emissionsCO2TotaleParVoyageurEnKg kg.
        - pour tous les voyageurs est de ${emissionsCO2TotaleParVoyageurEnKg * nombreVoyageurs} kg
        """.trimIndent())
}

fun calculeEmissionsCO2TotaleParVoyageurEnKg(
    nomTransport: String,
    nombreVoyageurs: Int,
    distance: Double
): Double {
    val emissionCO2enGParKmParVoyageur = if (nomTransport == "Voiture") {
        120 / nombreVoyageurs
    } else if (nomTransport == "Train") {
        14
    } else {
        285
    }
    return emissionCO2enGParKmParVoyageur * distance / 1000
}

fun recupereDistanceEnKm(): Double {
    println("Entrez la distance parcourue en km:")
    return readln().toDouble()
}

fun recupereNombreVoyageurs(): Int {
    println("Entrez le nombre de voyageurs:")
    return readln().toInt()
}

fun recupereModeTransport(): String {
    println(
        """
            Entrez le mode de transports :
            1. Voiture
            2. Train
            3. Avion
        """.trimIndent()
    )
    var choixTransport: String
    var nomTransport = "Non renseigné"
    do {
        choixTransport = readln()
        if (choixTransport != "1" && choixTransport != "2" && choixTransport != "3") {
            println("Choix invalide.")
        } else {
            if (choixTransport == "1") {
                nomTransport = "Voiture"
            } else if (choixTransport == "2") {
                nomTransport = "Train"
            } else {
                nomTransport = "Avion"
            }
        }
    } while (choixTransport != "1" && choixTransport != "2" && choixTransport != "3")
    return nomTransport
}


