package edu.temple.dicethrow

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider


/*
Our DieThrow application has been refactored to move the dieRoll() logic
into the ViewModel instead of the Fragment.
Study the DieViewModel, ButtonFragment, and DieFragment classes to
see the changes.

Follow the requirements below to have this app function
in both portrait and landscape configurations.
The Activity layout files for both Portrait and Landscape are already provided
*/

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (findViewById<View>(R.id.diceContainer) != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.rollContainer, ButtonFragment())
                .add(R.id.diceContainer, DieFragment())
                .commit()
        }
//        else{
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.rollContainer, ButtonFragment())
//                .commit()
//        }
    }

    override fun buttonClicked() {
        if (findViewById<View>(R.id.diceContainer) == null) { // if there is no dice container...
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.rollContainer, DieFragment())
                .addToBackStack(null)
                .commit()
        }


    }
}


