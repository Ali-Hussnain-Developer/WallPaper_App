package com.example.wallpaperapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperapp.R
import com.example.wallpaperapp.adapter.GenericSimpleRecyclerBindingInterface
import com.example.wallpaperapp.adapter.SimpleGenericRecyclerAdapter
import com.example.wallpaperapp.constants.Constants
import com.example.wallpaperapp.databinding.FragmentRandomBinding
import com.example.wallpaperapp.model.ModelClass
import com.example.wallpaperapp.ui.activities.SelectedWallpaper
import com.example.wallpaperapp.viewModels.ViewModel

class RandomFragment : Fragment(), SimpleGenericRecyclerAdapter.onItemClickListener {
    private lateinit var randomWallpaperViewModel: ViewModel
    lateinit var binding: FragmentRandomBinding
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var bindingInterface: GenericSimpleRecyclerBindingInterface<ModelClass>
    lateinit var randomWallpaperDataList: ArrayList<ModelClass>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRandomBinding.inflate(inflater, container, false)
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModelInitializer()
        bindDataWithGenericAdapter()
        setDataInAdapter()
        backPressedButton()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun viewModelInitializer() {
        randomWallpaperViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        randomWallpaperDataList = ArrayList()

    }


    private fun setDataInAdapter() {
        randomWallpaperDataList = randomWallpaperViewModel.randomWallpaperList
        manager = GridLayoutManager(requireContext(), 2)
        binding.rvRandom.apply {
            layoutManager = manager
        }
        val adapter = SimpleGenericRecyclerAdapter(randomWallpaperDataList,
            R.layout.single_view_rv,
            bindingInterface,
            this@RandomFragment)
        binding.rvRandom.adapter = adapter


    }


    private fun bindDataWithGenericAdapter() {
        bindingInterface =
            object : GenericSimpleRecyclerBindingInterface<ModelClass> {
                override fun bindData(item: ModelClass, view: View) {
                    val wallpaper: ImageView =
                        view.findViewById(R.id.wallpaperImage)
                    wallpaper.setImageResource(item.wallpaperImage)
                }
            }
    }

    override fun onClick(position: Int, ModelClass: Any) {
        val picture: Int = randomWallpaperDataList.get(position).wallpaperImage
        val intent = Intent(requireActivity().baseContext,
            SelectedWallpaper::class.java)
        intent.putExtra(Constants.SELECTED_WALLPAPER, picture)
        requireActivity().startActivity(intent)
    }

    override fun onLongClick(position: Int, ModelClass: Any) {
    }


    private fun backPressedButton() {
        activity?.onBackPressedDispatcher?.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().moveTaskToBack(true)
                requireActivity().finish()

            }
        })


    }


}