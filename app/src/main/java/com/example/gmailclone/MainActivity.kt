package com.example.gmailclone

import EmailAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Color


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emailAdapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val colors = listOf(
            Color.parseColor("#F44336"),
            Color.parseColor("#E91E63"),
            Color.parseColor("#9C27B0"),
            Color.parseColor("#3F51B5"),
            Color.parseColor("#2196F3"),
            Color.parseColor("#4CAF50"),
            Color.parseColor("#FF9800"),
            Color.parseColor("#795548"),
            Color.parseColor("#607D8B")
        )

        val emailList = listOf(
            Email("A", "Nguyễn An", "Lịch họp về dự án mới và cập nhật các công việc cần hoàn thành", "10:30 AM", false, colors.random()),
            Email("B", "Bích Hằng", "Báo cáo tiến độ: Chi tiết các yêu cầu Giai đoạn 2 và điều chỉnh kế hoạch", "Hôm qua", true, colors.random()),
            Email("T", "Trung Kiên", "Kế hoạch ăn tối với nhóm tại nhà hàng mới để kỷ niệm hoàn thành dự án", "12:45 PM", false, colors.random()),
            Email("M", "Minh Hòa", "Dự toán ngân sách cho cuộc họp tài chính quý 3, bao gồm các khoản chi dự kiến", "9:00 AM", true, colors.random()),
            Email("L", "Linh Phương", "Theo dõi buổi brainstorming tuần trước về các ý tưởng dự án sắp tới", "11:15 AM", false, colors.random()),
            Email("H", "Huyền Trang", "Chi tiết hóa đơn cho các chi phí gần đây, bao gồm các khoản mục chi tiết", "Thứ Hai", true, colors.random()),
            Email("D", "Đức Long", "Thư mời tham gia hội nghị công nghệ hàng năm vào tháng sau", "Thứ Ba", false, colors.random()),
            Email("K", "Khánh Duy", "Cần phê duyệt cuối cùng cho tài liệu đề xuất gửi khách hàng sau các chỉnh sửa", "2:30 PM", false, colors.random()),
            Email("V", "Vân Anh", "Nhắc nhở: Sự kiện team building vào chiều thứ Sáu với các hoạt động đã được lên kế hoạch", "Thứ Tư", true, colors.random()),
            Email("P", "Phương Nam", "Xem lại mã và góp ý cho bản cập nhật dự án mới nhất từ nhóm phát triển", "Hôm qua", false, colors.random())
        )

        emailAdapter = EmailAdapter(this, emailList)
        recyclerView.adapter = emailAdapter
    }
}

