import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmailclone.Email
import com.example.gmailclone.R


class EmailAdapter(
    private val context: Context,
    private val emailList: List<Email>
) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderIcon: TextView = itemView.findViewById(R.id.senderIcon)
        val senderName: TextView = itemView.findViewById(R.id.senderName)
        val emailSubject: TextView = itemView.findViewById(R.id.emailSubject)
        val emailTime: TextView = itemView.findViewById(R.id.emailTime)
        val starIcon: ImageView = itemView.findViewById(R.id.starIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emailList[position]
        holder.senderIcon.text = email.senderIcon
        holder.senderName.text = email.senderName
        holder.senderIcon.setBackgroundColor(email.color)
        holder.emailSubject.text = email.subject
        holder.emailTime.text = email.time
        holder.starIcon.setImageResource(if (email.isStarred) R.drawable.star else R.drawable.star_border)
    }

    override fun getItemCount() = emailList.size
}
