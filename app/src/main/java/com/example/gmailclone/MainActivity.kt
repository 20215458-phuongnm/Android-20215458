package com.example.gmailclone

import EmailAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emailAdapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val emailList = listOf(
            Email("E", "John Doe", "Meeting reminder for upcoming project discussion about timelines and deliverables", "10:30 AM", false),
            Email("A", "Alice Smith", "Project update: Detailed Phase 2 requirements and timeline adjustments based on feedback", "Yesterday", true),
            Email("B", "Bob Lee", "Dinner plans with the team at the new restaurant downtown to celebrate project completion", "12:45 PM", false),
            Email("J", "Jessica Wong", "Budget review for Q3 financial planning meeting, including expense projections", "9:00 AM", true),
            Email("M", "Michael Tan", "Follow-up on last week's brainstorming session on upcoming project ideas", "11:15 AM", false),
            Email("R", "Rachel Green", "Invoice details for recent purchases and expenses, including itemized breakdown", "Monday", true),
            Email("S", "Simon Lee", "Invitation to the annual tech conference next month for networking and presentations", "Tuesday", false),
            Email("D", "David Kim", "Final approval needed for the client proposal document with all recent edits", "2:30 PM", false),
            Email("L", "Laura Adams", "Reminder: Team building event this Friday afternoon with planned activities", "Wednesday", true),
            Email("C", "Chris Brown", "Code review and feedback on the latest project update from the development team", "Yesterday", false)
        )

        emailAdapter = EmailAdapter(this, emailList)
        recyclerView.adapter = emailAdapter
    }
}

