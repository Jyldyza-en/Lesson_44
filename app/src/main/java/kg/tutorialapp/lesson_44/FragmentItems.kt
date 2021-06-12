package kg.tutorialapp.lesson_44

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kg.tutorialapp.lesson_44.databinding.FragmentItemsBinding

class FragmentItems: Fragment(R.layout.fragment_items), MyAdapter.OnClickListener {

    private var _binding: FragmentItemsBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private lateinit var myAdapter: MyAdapter

    private lateinit var listener: FragmentItemsListener

    private lateinit var list: List<Any>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentItemsListener) listener = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        list = Data.getLongListOfItems()
        myAdapter = MyAdapter(this)

        recyclerView.adapter = myAdapter
        myAdapter.setNewItems(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
        val item = list [position] as Item

        listener.openFragmentItemDetails(item.id)
    }

    override fun onAdClick(position: Int) {
        val url = list [position] as String
        listener.openBrowser(url)
    }

    override fun onButtonClick(position: Int) {
        val item = list [position] as Item

        Toast.makeText(context, item.name, Toast.LENGTH_LONG).show()
    }
}