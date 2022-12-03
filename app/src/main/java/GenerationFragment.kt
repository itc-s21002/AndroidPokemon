package jp.ac.it_college.std.s21002.androidpokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import jp.ac.it_college.std.s21002.androidpokemon.databinding.FragmentGenerationBinding


class GenerationFragment : Fragment() {
    private var _binding: FragmentGenerationBinding? = null
    private val binding get() = _binding!!
    private val args: GenerationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGenerationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokedex.forEach { g ->
            val button = Button(activity).apply { text = g.name }
            button.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    GenerationFragmentDirections.selectToQuiz(
                        g.entries.map { e -> e.pokemon_id }.toIntArray(),
                        arrayOfNulls(10),
                        args.isHard
                    )
                )
            }
            binding.generations.addView(button)
        }
    }
}