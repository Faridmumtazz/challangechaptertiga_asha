package asha.binar.challangechaptertiga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import asha.binar.challangechaptertiga.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    var state = false

    private var _binding: ActivityMain2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView2, HomeFragment())
            commit()
        }

    }
    fun setWordFragment(alphabet: Char ,fragment: Fragment){
        supportActionBar?.title = "Words That Start With $alphabet"
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView2, fragment)
            commit()
            addToBackStack(null)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.withoutNav -> {
                Toast.makeText(this, "You're Already Here", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.withNav -> {
                MainActivity().finish()
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    override fun onPause() {
        state = true
        super.onPause()
    }

    public override fun onDestroy() {
        if (state) super.onDestroy() else true
    }



}