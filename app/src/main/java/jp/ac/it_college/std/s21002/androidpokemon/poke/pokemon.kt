package jp.ac.it_college.std.s21002.androidpokemon.jp.ac.it_college.std.s21002.androidpokemon.poke

data class PokemonJson (
    val pokemon: List<Pokemon>
)

data class Pokemon(
    val id: Int,
    val name: String
)