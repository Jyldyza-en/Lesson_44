package kg.tutorialapp.lesson_44

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.tutorialapp.lesson_44.databinding.FragmentItemDetailsBinding

class FragmentItemDetails: Fragment(R.layout.fragment_item_details) {

    private var _binding: FragmentItemDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }

    private fun setup() {
        val idFromArgs = arguments?.getLong(Long::class.java.canonicalName)

        idFromArgs?.let { id ->

            val details = Data.itemDetails.find { it.id == id }

            details?.let {
                binding.ivDetailIcon.setImageResource(details.icon)
                binding.tvDetailName.text = details.name
                binding.tvDetailCreator.text = details.creator
                binding.tvDetailDescription.text = details.description
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        fun newInstance(id: Long): FragmentItemDetails{
            val bundle = Bundle().apply {
                putLong(Long::class.java.canonicalName, id)
            }

            return FragmentItemDetails().apply { arguments = bundle }
        }
    }
}