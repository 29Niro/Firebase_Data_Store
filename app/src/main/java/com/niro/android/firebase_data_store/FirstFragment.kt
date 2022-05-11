package com.niro.android.firebase_data_store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.niro.android.firebase_data_store.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var db = FirebaseFirestore.getInstance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textName.setOnClickListener {
            binding.textName.text = null
        }

        binding.textEmail.setOnClickListener {
            binding.textEmail.text = null
        }

        binding.textPhone.setOnClickListener {
            binding.textPhone.text = null
        }

        binding.saveButton.setOnClickListener {
            saveData()
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

        }
    }

    private fun saveData() {
        val userName = binding.textName.text.toString()
        val email = binding.textEmail.text.toString()
        val phone = binding.textPhone.text.toString()

        var user = mapOf("userName" to userName, "email" to email, "phone" to phone)

        db.collection("user").document("user1").set(user)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}