package com.example.mymethodistdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymethodistdialog.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var myRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.bottomSheetBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_bottomSheetFragment)
        }

        //BIND TO LAYOUT
        myRecyclerView = binding.recycView

        //CREATE ARRAY
        val listStuff = arrayListOf(
            ListObject(title = "one", ContextCompat.getDrawable(requireContext(), R.drawable.texas_map)!!),
            ListObject(title = "two", ContextCompat.getDrawable(requireContext(), R.drawable.texas_map)!!),
            ListObject(title = "three", ContextCompat.getDrawable(requireContext(), R.drawable.texas_map)!!),
            ListObject(title = "four", ContextCompat.getDrawable(requireContext(), R.drawable.texas_map)!!),

            ListObject(title = "one", ContextCompat.getDrawable(requireContext(), R.drawable.texas_map)!!),
            ListObject(title = "two", ContextCompat.getDrawable(requireContext(), R.drawable.texas_map)!!),
            ListObject(title = "three", ContextCompat.getDrawable(requireContext(), R.drawable.texas_map)!!),
            ListObject(title = "four", ContextCompat.getDrawable(requireContext(), R.drawable.texas_map)!!),

            ListObject(title = "one", ContextCompat.getDrawable(requireContext(), R.drawable.texas_map)!!),
            ListObject(title = "two", ContextCompat.getDrawable(requireContext(), R.drawable.texas_map)!!),
            ListObject(title = "three", ContextCompat.getDrawable(requireContext(), R.drawable.texas_map)!!),
            ListObject(title = "four", ContextCompat.getDrawable(requireContext(), R.drawable.texas_map)!!)
        )

        //BIND TO ADAPTER
        val adapter = MyAdapter(listStuff)

        myRecyclerView.adapter = adapter

        //CHANGE TO HORIZTONTAL
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        myRecyclerView.layoutManager = layoutManager

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


//ADAPTER FOR RECYCLERVIEW
class MyAdapter(private val data: ArrayList<ListObject>): RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var titleTV: TextView = itemView.findViewById(R.id.textView1)
        val imageIV: ImageView = itemView.findViewById(R.id.imageView1)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.imageIV.setImageDrawable(item.image)
        holder.titleTV.text = item.title
    }

    override fun getItemCount(): Int {
        return data.size
    }


}