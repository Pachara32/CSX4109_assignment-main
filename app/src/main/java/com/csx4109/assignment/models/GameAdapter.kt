import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.R
import com.csx4109.assignment.models.Game

class GameAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_game, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.bind(game)
    }

    override fun getItemCount(): Int {
        return games.size
    }
}

class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val ivGame: ImageView = itemView.findViewById(R.id.ivGame)
    private val tvGameName: TextView = itemView.findViewById(R.id.tvGameName)
    private val tvGenre: TextView = itemView.findViewById(R.id.tvGenre)
    private val tvGameScore: TextView = itemView.findViewById(R.id.tvGameScore)
    private val tvGameDescription: TextView = itemView.findViewById(R.id.tvGameDescription)

    fun bind(game: Game) {
        // Bind data to views
        // Example: ivGame.load(game.image) using Coil for image loading
        tvGameName.text = game.name
        tvGenre.text = game.genre
        tvGameScore.text = game.rating.toString()
        tvGameDescription.text = game.description
    }
}
