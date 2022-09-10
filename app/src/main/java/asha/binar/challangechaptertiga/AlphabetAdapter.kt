package asha.binar.challangechaptertiga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class AlphabetAdapter : RecyclerView.Adapter<AlphabetAdapter.AlphabetViewHolder>(){

    private var diffCallback = object: DiffUtil.ItemCallback<Word>(){
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.alphabets == newItem.alphabets
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private var differ = AsyncListDiffer(this, diffCallback)
    fun submitData(value: ArrayList<Word>) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return AlphabetViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlphabetViewHolder, position: Int) {
        val data = differ.currentList[position]
        with(holder) {
            button.text = data.alphabets.toString()

            button.setOnClickListener {
                val activity = (itemView.context as MainActivity2)
                activity.setWordFragment(data.alphabets ,WordFragment(data.listOfWord))
            }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class AlphabetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.btn_click)
    }

}
