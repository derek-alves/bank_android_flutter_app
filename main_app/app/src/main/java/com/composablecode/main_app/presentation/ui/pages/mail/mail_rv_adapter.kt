package com.bank.app_android.ui.pages.mail


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MailRvAdapter(private val mailList: List<Mail>): RecyclerView.Adapter<MailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailViewHolder {
        return MailViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MailViewHolder, position: Int) {
        holder.bind(mailList[position])
    }

    override fun getItemCount(): Int {
      return  mailList.size
    }


}

//    inner class MailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        val title : TextView = itemView.findViewById(R.id.cardTitle)
//        val description : TextView = itemView.findViewById(R.id.cardDescription)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.mail_card,parent, false)
//        return MailViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: MailViewHolder, position: Int) {
//        Log.d("INDEXzzzzzzzzzzzz", position.toString())
//        holder.title.text = mailList[position].title
//        holder.description.text = mailList[position].description
//
//    }
//
//    override fun getItemCount(): Int {
//        return mailList.size
//    }
//}