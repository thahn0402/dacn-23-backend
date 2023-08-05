package nlu.dacn23backend.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROL
Trình đơn chính

WikipediaBách khoa toàn thư mở
Tìm kiếm trên Wikipedia
Tìm kiếm
Tạo tài khoản
Đăng nhập

Công cụ cá nhân
Tính năng Tạo tài khoản · Hướng dẫn người mới · Quy định · Viết bài mới · Chỗ thử · Câu thường hỏi · Sách hướng dẫn · Dịch bài · Thêm chú thích · Thảo luận · Liên hệ quản lý
Tiêu chuẩn bài viết Đủ độ nổi bật, văn phong trung lập và có nguồn đáng tin cậy · Không spam quảng cáo · Không vi phạm bản quyền · Cẩm nang biên soạn
Đóng (mở lại bằng cách xóa cookie dismissASN1 trong trình duyệt)
Nội dung ẩn
Đầu
Một số loại văn bản
Chú thích
Văn bản

Bài viết
Thảo luận
Đọc
Sửa đổi
Sửa mã nguồn
Xem lịch sử

Công cụ
Bách khoa toàn thư mở Wikipedia
Bạn có tin nhắn mới từ một người dùng (thay đổi gần đây).
Văn bản là một loại hình phương tiện để ghi nhận, lưu giữ và truyền đạt các thông tin từ chủ thể này sang chủ thể khác bằng ký hiệu gọi là chữ viết. Nó gồm tập hợp các câu có tính trọn vẹn về nội dung, hoàn chỉnh về hình thức, có tính liên kết chặt chẽ và hướng tới một mục tiêu giao tiếp nhất định.[1][2][3][4] Hay nói khác đi, văn bản là một dạng sản phẩm của hoạt động giao tiếp bằng ngôn ngữ được thể hiện ở dạng viết trên một chất liệu nào đó (giấy, bia đá,...). Văn bản bao gồm các tài liệu, tư liệu, giấy tờ có giá trị pháp lý nhất định, được sử dụng trong hoạt động của các cơ quan Nhà nước, các tổ chức chính trị, chính trị - xã hội, các tổ chức kinh tế... như: các văn bản pháp luật, các công văn, tài liệu, giấy tờ.

Một số loại văn bản
Văn kiện
Văn bản quy phạm pháp luật: Luật, Nghị định, Nghị quyết, Pháp lệnh, Thông tư, Quyết định, Chỉ thị
Văn bản hành chính
Bia đá
Hợp đồng
Hóa đơn
Chứng chỉ, văn bằng (các loại bằng cấp)
Sec
Di chúc
Điều lệ chính trị
Tuyên ngôn độc lập
....................
Chú thích
^ “Văn bản là gì?”. Văn hóa Nghệ An. Bản gốc lưu trữ ngày 1 tháng 10 năm 2017. Truy cập ngày 1 tháng 10 năm 2017.
^ “Kỹ năng tạo lập văn bản bằng tiếng Việt” (PDF). Bản gốc (PDF) lưu trữ ngày 1 tháng 10 năm 2017. Truy cập ngày 1 tháng 10 năm 2017.
^ “Giáo trình Soạn thảo văn bản” (PDF). Bản gốc (PDF) lưu trữ ngày 1 tháng 10 năm 2017. Truy cập ngày 1 tháng 10 năm 2017.
^ “Một số vấn đề chung về Văn bản quản lý hành chính nhà nước”. Bộ Tài chính. Bản gốc lưu trữ ngày 1 tháng 10 năm 2017. Truy cập ngày 1 tháng 10 năm 2017.
Thể loại: Văn bản
Trang này được sửa đổi lần cuối vào ngày 9 tháng 5 năm 2022, 08:29.
Văn bản được phát hành theo Giấy phép Creative Commons Ghi công–Chia sẻ tương tự; có thể áp dụng điều khoản bổ sung. Với việc sử dụng trang web này, bạn chấp nhận Điều khoản Sử dụng và Quy định quyền riêng tư. Wikipedia® là thương hiệu đã đăng ký của Wikimedia Foundation, Inc., một tổ chức phi lợi nhuận.
Quy định quyền riêng tưGiới thiệu WikipediaLời phủ nhậnBộ Quy tắc Ứng xử ChungPhiên bản di độngLập trình viênThống kêTuyên bố về cookieWikimedia FoundationPowered by MediaWiki
Chuyển đổi chiều rộng nội dung giới hạnE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
