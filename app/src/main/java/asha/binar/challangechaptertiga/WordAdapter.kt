package asha.binar.challangechaptertiga

import android.app.SearchManager
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val list: ArrayList<String>): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val data = list[position]

        with(holder) {
            button.text = data
            button.setOnClickListener {
                val intent = Intent(Intent.ACTION_WEB_SEARCH)
                val url = "https://www.google.com/search?q=${data}"
                intent.putExtra(SearchManager.QUERY, url)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.btn_click)
    }
}
