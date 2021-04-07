package fmproducts.apollo.geographic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fmproducts.apollo.geographic.databinding.ActivityMainBinding
import fmproducts.apollo.geographic.ui.continents.ContinentsFragment
import fmproducts.apollo.geographic.util.initFields
import fmproducts.apollo.geographic.util.mainActivity
import fmproducts.apollo.geographic.util.navigate

class MainActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.appToolbar)
        navigate(ContinentsFragment() , false)

        initFields()

    }
}