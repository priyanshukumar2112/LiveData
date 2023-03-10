package com.rare.livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.rare.livedata.databinding.FragmentStartBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding
    lateinit var mainActivity: MainActivity
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var passViewModel: PassViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivity = activity as MainActivity
        super.onCreate(savedInstanceState)


        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        passViewModel = ViewModelProvider(mainActivity)[PassViewModel::class.java]
        
        
        passViewModel.personName.observe(mainActivity){
            Toast.makeText(mainActivity, "in pass $it", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStartBinding.inflate(layoutInflater)



        val arrayAdapter : ArrayAdapter<String>
        val list = arrayOf("Blue Badgers", "Cheetah Colonels", "Phantom Bulls"," Crashing Amigos",
                "Bengal Bisons","Dashing Devils","Dazzling Balls","Flying Squirrels",
            "Crew X","Rule Breakers","The Squad")

        arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1, list)
        binding.lv1.adapter = arrayAdapter



        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}