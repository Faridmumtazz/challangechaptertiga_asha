package asha.binar.challangechaptertiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    val aWord = arrayListOf(
        Word('A', arrayListOf("Ayam", "Akar", "Abadi")),
        Word('B', arrayListOf("Bakar", "Buku", "Biawak")),
        Word('C', arrayListOf("Cukur", "Cicak", "Cantik")),
        Word('D', arrayListOf("Dodol", "Dadu", "Dukun")),
        Word('E', arrayListOf("Ekor", "Empang", "Endok")),
        Word('G', arrayListOf("Goreng", "Gagak", "Gulung")),
        Word('H', arrayListOf("Horden", "Hamba", "Harus")),
        Word('J', arrayListOf("Jera", "Jarum", "Jantung")),
        Word('L', arrayListOf("London", "Labil", "Loker")),
        Word('N', arrayListOf("Nakal", "Nirwana", "Nabi"))
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}