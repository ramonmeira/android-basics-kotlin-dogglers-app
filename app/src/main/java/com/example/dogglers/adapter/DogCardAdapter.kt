/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource
    private val dataset = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val viewDogImage: ImageView? = view?.findViewById(R.id.dog_image)
        val viewDogName: TextView? = view?.findViewById(R.id.dog_name)
        val viewDogAge: TextView? = view?.findViewById(R.id.dog_age)
        val viewDogHobbies: TextView? = view?.findViewById(R.id.dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardAdapter.DogCardViewHolder {
        val layoutType = if(layout == Layout.GRID){
            R.layout.grid_list_item
        } else{
            R.layout.vertical_horizontal_list_item
        }

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(layoutType, parent, false)

        return DogCardAdapter.DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: DogCardAdapter.DogCardViewHolder, position: Int) {
        // TODO: Get the data at the current position
        val dog = dataset[position]
        // TODO: Set the image resource for the current dog
        holder.viewDogImage?.setImageResource(dog.imageResourceId)
        // TODO: Set the text for the current dog's name
        holder.viewDogName?.text = dog.name
        // TODO: Set the text for the current dog's age
        val resources = context?.resources
        holder.viewDogAge?.text = resources?.getString(R.string.dog_age, dog.age)
        holder.viewDogHobbies?.text = resources?.getString(R.string.dog_hobbies, dog.hobbies)
        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
