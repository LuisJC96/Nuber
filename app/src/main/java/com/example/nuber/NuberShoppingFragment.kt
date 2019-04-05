package com.example.nuber


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_nuber_shopping.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class NuberShoppingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nuber_shopping, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        send_salad_button.setOnClickListener {
            val  _db = FirebaseDatabase.getInstance().getReference("salads")
            val k = _db.push().key
            val s = Salad(salad_name_edittext.text.toString(),
                salad_description_edittext.text.toString(),54.50, k.toString())

            _db.child(k!!).setValue(s).addOnCompleteListener {
                Toast.makeText(activity, "Your purchase has been placed", Toast.LENGTH_LONG).show()
            }
        }
    }
}
