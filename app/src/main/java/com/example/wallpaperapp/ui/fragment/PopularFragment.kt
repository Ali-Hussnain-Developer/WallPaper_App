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
import com.example.wallpaperapp.databinding.FragmentPopularBinding
import com.example.wallpaperapp.model.ModelClass
import com.example.wallpaperapp.ui.activities.SelectedWallpaper
import com.example.wallpaperapp.viewModels.ViewModel

class PopularFragment : Fragment(), SimpleGenericRecyclerAdapter.onItemClickListener {
    private lateinit var popularWallpaperViewModel: ViewModel
    lateinit var binding: FragmentPopularBinding
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var bindingInterface: GenericSimpleRecyclerBindingInterface<ModelClass>
    lateinit var popularWallpaperDataList: ArrayList<ModelClass>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPopularBinding.inflate(inflater, container, false)
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
        popularWallpaperViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        popularWallpaperDataList = ArrayList()

    }


    private fun setDataInAdapter() {
        popularWallpaperDataList = popularWallpaperViewModel.popularWallpaperList
        manager = GridLayoutManager(requireContext(), 2)
        binding.rvPopular.apply {
            layoutManager = manager
        }
        val adapter = SimpleGenericRecyclerAdapter(popularWallpaperDataList,
            R.layout.single_view_rv,
            bindingInterface,
            this@PopularFragment)
        binding.rvPopular.adapter = adapter


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
        val picture: Int = popularWallpaperDataList.get(position).wallpaperImage
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