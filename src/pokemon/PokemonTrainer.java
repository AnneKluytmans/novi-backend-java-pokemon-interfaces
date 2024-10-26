package pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonTrainer {
    private final String name;
    private List<Pokemon> pokemons = new ArrayList<Pokemon>();

    public PokemonTrainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
