package asha.binar.challangechaptertiga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class AlphabetNavAdapter () : RecyclerView.Adapter<AlphabetNavAdapter.AlphabetViewHolder>() {

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

        val mBundle = Bundle()
        mBundle.putChar("KEY_ALPHABETS", data.alphabets)
        mBundle.putStringArrayList("KEY_WORDS", data.listOfWord)

        with(holder) {
            button.text = differ.currentList[position].alphabets.toString()
            button.setOnClickListener {
                itemView.findNavController().navigate(R.id.action_homeNavFragment_to_wordNavFragment, mBundle)
            }

        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class AlphabetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.btn_click)
    }
}
