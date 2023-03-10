package com.rare.livedata

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.rare.livedata.databinding.FragmentEndBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EndFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EndFragment : Fragment() {

    val list = arrayOf<String>()

    lateinit var binding: FragmentEndBinding
    lateinit var mainActivity : MainActivity
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
   lateinit var arrayAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivity = activity as MainActivity
        super.onCreate(savedInstanceState)

     //  passViewModel.personName.value = 3
       /* mainActivity.passViewModel.personName.observe(mainActivity){

        }
*/
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       binding= FragmentEndBinding.inflate(layoutInflater)
        arrayAdapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, list)
       // list.set(passViewModel.passdata()

        binding.lv2.adapter = arrayAdapter

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EndFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EndFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}