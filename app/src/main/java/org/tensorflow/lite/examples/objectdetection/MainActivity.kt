package org.tensorflow.lite.examples.objectdetection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.coupleblog.MainActivityBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
        }

        val list: ArrayList<DataPage> = ArrayList<DataPage>()
        list.add(DataPage(android.R.color.white, "And 1 Page", R.drawable.image1))
        list.add(DataPage(android.R.color.holo_red_light, "And 2 Page", R.drawable.image2))
        list.add(DataPage(android.R.color.holo_green_dark, "And 3 Page"))

        binding.pager.adapter = ViewPagerAdapter(list)

//        binding.button.setOnClickListener {
//            val animator: ObjectAnimator = ObjectAnimator.ofFloat(binding.imageView, "rotationY", 0f, -360f)
//            animator.duration = 2000
//            animator.interpolator = AccelerateDecelerateInterpolator() // default
//            animator.start()
//        }
    }
}
