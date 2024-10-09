package br.com.fabianoluiz.buscapokemon

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fabianoluiz.buscapokemon.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter : MainAdapter
    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding .inflate( layoutInflater)
        setContentView( binding.root)
        mainAdapter = MainAdapter()
        binding.rvSprites .layoutManager = LinearLayoutManager( this,
            LinearLayoutManager .HORIZONTAL, false)
        binding.rvSprites .adapter = mainAdapter

        viewModel.pokemonResponse.observe(this){
            pokemon ->
            binding.tvPokemonDetails.text = pokemon.nome
            mainAdapter.submitList(pokemon.imagesUrl)
            Glide.with(binding.root.context).load(pokemon.principalImage).into(binding.imgPrincipal)
        }
        // Configurando o clique do botão de busca
        binding.btnSearch .setOnClickListener {
            val id = binding.etPokemonId .text.toString(). toIntOrNull()
            if (id != null) {
                viewModel .fetchPokemon( id)
            }
        }
    }
}