package mx.com.jdgv.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.squareup.picasso.Picasso
import mx.com.jdgv.databinding.ItemPeliculaBinding

class MyAdapter(private val context: Context, private val arrayList: java.util.ArrayList<Movie>) : BaseAdapter() {

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val binding = ItemPeliculaBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        var convertView = convertView
        convertView = binding.root

        binding.titleMovie.text = arrayList[position].title
        binding.yearMovie.text = arrayList[position].year.toString()
        binding.directorMovie.text = arrayList[position].director
        binding.durationMovie.text = arrayList[position].duration
        Picasso.get().load(arrayList[position].imageUrl).into(binding.imageMovie)
        return convertView

    }
}