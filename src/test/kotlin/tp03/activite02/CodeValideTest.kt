package tp03.activite02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CodeValideTest {
    @Test
    fun testCodeValide() {
        // Etant donné : un code valide
        val codeValide = 1234
        // Quand : on vérifie le code
        val resultat = codeValide(codeValide)
        // Alors le resultat est true
        assertTrue(resultat)
    }
    @Test
    fun testCodeInvalide() {
        // Etant donné : un code invalide
        val codeValide = 2234
        // Quand : on vérifie le code
        val resultat = codeValide(codeValide)
        // Alors le resultat est false
        assertFalse(resultat)
    }


    @Test
    fun sommeChiffresNombre() {
        // Etant donné : un nombre compris entre 0 et 9999
        val unNombre = 1234
        // Quand : on appelle la fonction sommeChiffres
        val resultat = sommeChiffres(unNombre)
        // Alors le resultat est bien la somme des chiffres
        assertEquals(10,resultat)

        // Etant donné un autre nombre
        val unNombre2 = 2589
        val resultat2 = sommeChiffres(unNombre2)
        assertEquals(24,resultat2)

        // Etant donné un autre nombre
        assertEquals(27, sommeChiffres(999))

    }

}